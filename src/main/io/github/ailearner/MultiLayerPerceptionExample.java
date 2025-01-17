package io.github.ailearner;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.ArrayList;

public class MultiLayerPerceptionExample {


    INDArray prepareTrainingData(String file_path) {
        // {all letters from names.txt}
        ArrayList X = new ArrayList<>();
        // return X = unpack_text_data(file_path);
        return null;
    }

    public static void main(String[] args) {
        MultiLayerPerceptionExample mlp = new MultiLayerPerceptionExample();

        /**
         * Create a vector of embeddings:
         * We use random inits to help avoid linearity.
         * In Bengio et. 2003 (https://www.jmlr.org/papers/volume3/bengio03a/bengio03a.pdf):
         * we use 3 word embeddings, so we will use len(3) char-embeddings for our Bag of Words neural net impl (https://github.com/karpathy/makemore/blob/master/makemore.py)
         *
         * Forward Pass:
         * if we take all the data set, then the embedding vector looks like:
         * ( len(all_chars_x), dims_to_squeeze_x )
         *
         * Goal: For the given context we want to predict the next Y.
         *  Take C[X] and embed (fully-connected) in Layer1 (*hyper parameter); Or, C[X[i]];
         *  Take Layer2=tanh(Layer1), fully-connected (matrix) to C,
         *  softmax(Layer2) -> tokenOut; Or, yield(): sample/expected output; Or, P(w_i | context);
         *
         *  ** Note: Context comes in as stream. Y is the next expected char in the stream. Aka, MultiHeadAttention.
         *  The Block size is the size of context and is used to find the dimension of the embedding vector.
         *  The Block size is used to derive the dimension on the input layer into the neural net, the X vector.
         *  The Y vector of
         *  The second layer shape is (3,100) in Bengio et. 2003.
         *  Following this architecture, we will use 100 neurons in the second layer.
         *  The first vector will be squeezed to 2 dimensions, the length of the context and the number of input neurons to the second layer.
         *  This gives us the input to the second layer: (3X2, 100).
         *  Softmax output should by (27,1) for the 26 letters and an ending token.
         */

        Integer contextLength = 0; // amount of chars used to predict next one;
        /**
         * Hyper Parameters:
         *      * Train at different values to reduce loss;
         */
        Integer numberOfNeurons = 100; // we want to fully connect all first layer input neurons to this;

        // "first layer input" - input to model/neural-net
        // convert X into vector with dims: [len(all_chars_x), dims_to_squeeze_x]
        INDArray vectorX = mlp.prepareTrainingData("/file/path/names.txt"); // vectorX = Nd4j.createFromArray(X);

        // first layer output vector: in(contextLength) => out(numberOfSecondLayerInputNeurons)
        INDArray vectorY = Nd4j.rand(contextLength, numberOfNeurons);

        // embedding vector (first layer of our neural net)
//        INDArray C = Nd4j.create(new double[]{vectorX, vectorY}, vectorX.shape()[0], vectorY.shape()[1]); //.reshape(X.size(), vectorY);

//        INDArray emb_cX = C.get(vectorX); // get the embedding vector for the given context;




    }

    void run() {
        //Prepare Training Data
        prepareTrainingData("file/path/names.txt");
    }

}
