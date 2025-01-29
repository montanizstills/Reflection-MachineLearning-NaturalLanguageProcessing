package io.github.ailearner;

import io.github.ailearner.utils.FileHandler;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.NDArrayIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiLayerPerceptionExample {
    /**
     * Create our X-input and Y-output vectors for Training;
     *
     * @param file_path the file to read data from;
     * @return a Pair consisting of X,Y values;
     */
    INDArray[] prepareTrainingData(String file_path) {
        Integer blockSize = 3;
        INDArray tensorX = Nd4j.zeros(1, blockSize);
        INDArray tensorY = Nd4j.zeros(1, 1);

        Map<String, Integer> charToIntegerAlphabet = IntStream.rangeClosed('a', 'z')
                .boxed() //.mapToObj(c -> c), difference?
                .collect(Collectors.toMap(
                        // not a fan of  this logic for map; not easily readable;
                        c -> String.valueOf((char) c.intValue()), c -> c - 'a' + 1) // 'a' is ASCII value, subtract from c, convert to int, add 1.
                );
        // create map of idx to alphanumeric char
        charToIntegerAlphabet.put(".", 0);

        Map<Integer, String> integerToCharAlphabet = charToIntegerAlphabet.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        // read all words from names.txt
        FileHandler fh = new FileHandler();

        fh.readWordsFromFile(file_path).forEach(word -> {
            System.out.println("=============");
            System.out.printf("Word: %s\n", word);

            // add array of len(context) to X for each letter in "word", where: len(context) == blockSize
            Arrays.stream(word.toString().split("")).forEach(letter -> {
                Integer idx = charToIntegerAlphabet.get(letter);  // not a fan of this impl;
                System.out.printf("Curr Y: %d, %s\n", idx, letter);

                // we want to stack [[0,0,0],[0,0,5],[0,5,13]...[13,1,0]], like: INDArray context = tensorX[1:]+[0, 0, idx]
                // all context up to position context[blockSize], because blockSize is the amount of context we are considering;

                // so lets start with a new context vector each iter;
                INDArray slice = Nd4j.zeros(1, 3);

                // OPTION 1:
                // slice.putScalar(new int[]{0, blockSize - 1}, 0); // first elem
                // slice.putScalar(new int[]{1, blockSize - 1}, 0); // second elem
                // slice.putScalar(new int[]{2, blockSize - 1}, idx); // third elem

                // OPTION 2:
                // OR first and second elem can be appended in one operation;
                // slice.get(slice_index).put(both_values);
                // slice.putScalar(new int[]{2, blockSize - 1}, idx); // third elem

                // OPTION 3:
                // OR take slice of last row then dup and change dup val for positions: [0],[1],[2] -> [0,0,idx];
                INDArray tensorXSlice = tensorX
                        .get(
                                NDArrayIndex.point(0), // rows of INDArray
                                NDArrayIndex.all() // cols of INDArray
                        ); // .put(indices, newINDArray); // get(row,col);

                slice.dup().putRow();

                INDArray updatedContext = null;
                tensorX.addiRowVector(updatedContext);

                System.out.printf("Context: %s\n", context);
                System.out.printf("Context: %s\n", slice);
                System.exit(1);


                // then we will update a partial-slice on this vector
                // INDArray slice = tensorX.get(NDArrayIndex.interval(1, blockSize - 1)); // slice of tensorX or tensorX[0:n-1]

                // but how do we update only the (1,3) pos. on this 1x3 array, or the very last pos in the vector;
                // REMEMBER: indexing starts at 0! So, 1st pos. = 0, last pos. = n-1
                INDArray ex = tensorX.putScalar(new int[]{0, blockSize - 1}, idx);

                // now we will combine the two vectors TensorX and Context along the first dim: 1x3
                // tensorX = Nd4j.concat(blockSize - 1, tensorX, context);


                // Nd4j.hstack(tensorX, slice); // ultimate goal;


                context.putScalar(1, 1, idx);

                // append newContextVector to currContextVector; Nd4j.hstack(col1,col2);
                // get "moving array" / slice, aka n-most recent;
                // add new context slice to context vector; //TODO - correct this math;
                // append updates to each matrix in same order (x1,y1) + (x2,y2) ->
                // Ex: a_1x+=aI_x; b1x+=bI_x; Or, Nd4j.vstack(row1,row2)

                System.out.printf("Context: %s\n", context);

                // if context0 = [0,0,0], then context1 = [context[1:],'e'], -> contextN = [context[1:],letter]
//                tensorX.addi(context.get(NDArrayIndex.all(), NDArrayIndex.interval(1, blockSize - 1))); // shift upperbound index;
//                System.out.printf("Context: %s\n", context);
//
//                INDArray newOutputVector = tensorY.addi(idx);
//                tensorY.addiColumnVector(newOutputVector);
            });
            System.exit(1);
        });
        return null;
    }

    public static void main(String[] args) {
        MultiLayerPerceptionExample mlp = new MultiLayerPerceptionExample();
        mlp.prepareTrainingData(System.getProperty("user.dir") + "/src/main/java/resources/names.txt");
    }


    void train() {
        //Prepare Training Data
        prepareTrainingData("file/path/names.txt");
        // this.run(training = true, sampleSize = 10000); // if training==true, sampleSize = epochs;
        // loss function and backpropagation
        // loss = Nd4j.nn().lossFunction(layer2, vectorY);
        // Nd4j.loss().softmaxCrossEntropy(null,vectorY, 0.1);

        /**
         * Goal: For the given context we want to predict the next Y.
         *
         * Forward Pass:
         * 1. Take C[X] and embed (fully-connected) in Layer1 (*hyper parameter); Or, C[X[i]];
         *  Create a vector of embeddings:
         *              In Bengio et. 2003, the designers uses 3 word embeddings.
         *              (https://www.jmlr.org/papers/volume3/bengio03a/bengio03a.pdf)
         *              (https://github.com/karpathy/makemore/blob/master/makemore.py)
         *
         *              If we take all the data set (as potential samples of f(x)),
         *              Then the lookup matrix, C, looks like:
         *                  C.shape() = (len(all_chars_x)+'.', 1) or ('a,...,z,<.>', 1)
         *              And, the embedding vector for the given context looks like: C[X];
         *              If we want a specific char, say 'a', then the embedding vector looks like: C[X[i]] = C['a'];
         *
         *
         * 2. Take Layer2=tanh(Layer1), fully-connected (matrix) to C,
         *  Take Layer2=tanh(Layer1), fully-connected (matrix) to C for non-linearity;
         *
         *
         *
         * 3. Take Softmax(Layer2) -> tokenOut; Or, yield(): sample/expected output; Or, P(w_i | context);
         *
         *
         * **Note:
         *  Context comes in as stream. Y is the next expected char in the stream. Aka, MultiHeadAttention.
         *  Hyper Parameters: Train at different values to reduce loss;
         *  We use random vector inits to help avoid linearity.
         */

        Integer contextLength = 3; // amount of chars used to predict next one;
        Integer numberOfNeurons = 100; // we want to fully connect all first layer input neurons to this;
        Integer dimsToSqueeze = 2; // squeeze the first layer input to this dimension;

        // get all chars from the names.txt file;
        ArrayList allCharsX = null; //mlp.prepareTrainingData("/file/path/names.txt");

        // "first layer input" - input to model/neural-net
        // is a vectorX with dims: [len(all_chars_x), hyper_parameter]
        // and, should start with as zero tensor; then we will fill it with the context;

        INDArray vectorX = Nd4j.zeros(allCharsX.size(), dimsToSqueeze);

        // first layer output vector: in(contextLength) => out(numberOfSecondLayerInputNeurons)
        INDArray vectorY = Nd4j.rand(contextLength, numberOfNeurons);

        // embedding vector (first layer of our neural net)
        INDArray C = Nd4j.create(1);

        // get the embedding vector for the given context;
        // Nd4j.create(allCharsX.size()).putScalar(index, 1).mmul(C); //F.one_hot(vectorX, num_classes=len(all_chars_x)).mmuli(C);
        // INDArray emb_cX = vectorX.mmuli(C);
        INDArray emb_cX = C.get(vectorX);

        // second layer of our neural net, fully connected to C[X[i]];
        INDArray layer1 = Nd4j.rand((int) vectorX.shape()[0], numberOfNeurons);
        INDArray layer2 = Nd4j.nn().tanh(layer1); // fully connected to C;

        // softmax output
        INDArray tokenOut = Nd4j.nn().softmax(layer2); // P(w_i | context);

        /**
         * Training:
         * We need to calc the Negative Log Likelihood. # Manual Impl
         * This is: the prob(x|i)/prob(x), i.e, prob of "x" follows "i" divided by gaussian prob of any letter follow "x".
         * This is easy in works in our case since we are only predicting the next English letter given some other English Letter.
         * Does not scale if {x: x in A} is a large array.
         * <p>
         * OR
         * <p>
         * We need to calc the cross_entropy. # Handles large inputs better
         * <p>
         * Backpropagation:
         * Do gradient descent calculus.
         * <p>
         * //Mini Batching??
         * <p>
         * //Sample
         * /*
         * * Start with seed for predictable results during testing and sampling; do not release into wild with seed.
         * * Forward Pass
         * * Return Sample
         */

    }

    void sample(Integer sampleSize) {
        // Sample from the model
        // this.run(training = false, sampleSize); // if training == false, sampleSize = blockSize;
    }

}
