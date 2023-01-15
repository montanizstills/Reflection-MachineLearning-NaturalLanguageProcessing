Code samples on model fitting supervised machine learning using images, text, or numerical values
------------------
(additional resources:  arXiv.org and IEEE Xplore Digital Library)
The model is trained to deduce from images - the following:

- numbers
- animals
- shapes
- fruit
- colors - use CNNs, typically using a pre-trained model that was trained on large image datasets. This pre-trained model can be fine-tuned to perform color detection by training it on a dataset of images labeled with their dominant colors.
- types of currency

The model is trained to deduce from input text - the following:
- moods/sentiment analysis of the input text


Neural Networks:

Connected by 'synapses', these are the weights of the system. 
- Layers: a set of interconnected neurons that work together to perform a specific computation on the input data. In short, information is passed through these layers, transformed, and abstracted, until it reaches its final layer; where a prediction is made.Each layer in a neural network typically has a number of neurons, where each neuron in a layer is connected to all the neurons in the previous and next layers. Each connection between neurons has a weight, which represents the strength of the connection and the influence that the output of one neuron has on the input of another neuron. The weights are learned during the training process to optimize the performance of the network on a specific task. 
  - Input Layer: The first layer of the network, which takes the raw input data and feeds it into the network. This layer does not perform any computation; it simply passes the input data to the next layer.
  - Hidden Layer(s): The layers that come after the input layer and before the output layer. These layers perform computations on the input data, such as extracting features or making predictions. There can be one or multiple hidden layers in a neural network, depending on the complexity of the problem.
  - Output Layer:  The last layer of the network, which produces the final output of the network. This output could be a prediction, a feature representation or any other desired output.

Types of Neural Networks: 
- Feedforward Networks:  Are the simplest type of neural network. They consist of an input layer, one or more hidden layers, and an output layer. The information flows in one direction, from input to output, through the layers of neurons. They are used for tasks such as image classification and regression. In short, they are good for problems where the input data is independent of previous inputs
- Recurrent Networks:   (RNNs) are a type of neural network that are well-suited for sequence data, such as time series data or natural language. RNNs have a feedback connection, which allows information to flow in a circular loop, and the network can maintain a kind of memory of the previous inputs. They are used for tasks such as language processing and speech recognition.
  - Bidriectional Recurrent Neural Networks: (BRNNs) are a type of hybrid neural network that combines the strengths of both feedforward neural networks and RNNs. BRNNs use two recurrent layers, one processing the input sequence in the forward direction and the other processing it in the backward direction. They are commonly used in tasks such as natural language processing and speech recognition
- Convolutional Networks:  (CNNs) are a type of neural network that are particularly well-suited for image processing tasks. CNNs use convolutional layers, which scan the image with a small window, or kernel, and apply a mathematical operation to the window. This allows the network to learn spatial hierarchies of features, such as edges and shapes, in the image. They are used for tasks such as image classification, object detection and segmentation In short, they are good for problems where the input data is sequential.
  - U-Net Networks: A type of hybrid neural network that combines the strengths of both CNNs and RNNs. It is an encoder-decoder network that uses convolutional layers to extract features from the input, and recurrent layers to propagate those features through the network. They are commonly used in image segmentation tasks such as biomedical image segmentation.
  - Inception Networks: Are a variation of CNNs that were introduced to address the problem of computational efficiency in very deep networks. Inception networks use a combination of convolutional, pooling, and dimensionality reduction layers to extract features from the input image. They are commonly used in computer vision tasks such as image classification and object detection.
- Generative Adversarial Networks: (GANs) are a type of neural network that consist of two parts: a generator network and a discriminator network. The generator network creates new data, while the discriminator network tries to distinguish the generated data from real data. The two networks are trained together in an adversarial process, where the generator tries to create data that can fool the discriminator, and the discriminator tries to correctly identify the generated data. They are used for tasks such as image generation and style transfer.
- Autoencoder Networks: A type of neural network that are used for unsupervised learning tasks such as dimensionality reduction, denoising and anomaly detection. An autoencoder consists of an encoder that maps the input data to a hidden representation, and a decoder that maps the hidden representation back to the original data. The network is trained to minimize the difference between the input and the output, forcing the hidden representation to learn a compact and informative representation of the input data.
- Transformer Networks: A type of neural networks used for tasks such as natural language processing, specifically language understanding and generation. They are based on self-attention mechanisms and are known for their ability to process sequential data, like text, without the need for recurrence or convolution.
- Residual Neural Networks: (ResNets) are a variation of feedforward neural networks that were introduced to address the problem of vanishing gradients in very deep networks. ResNets add so-called "shortcut connections" between layers, allowing the gradients to flow more easily through the network during training. They are commonly used in computer vision tasks such as object detection and image classification.

Problems within neural networks:
- Vanishing gradients: As the number of layers in a network increases, the gradients (the values that indicate how the parameters of the network should be updated during training) can become very small, making it difficult for the network to learn.
- Exploding gradients: On the other hand, the gradients can also become very large, making the training process unstable.
- Computational efficiency: As the number of layers in a network increases, the computational cost of training and running the network also increases, making it infeasible to use very deep networks on large datasets or on devices with limited computational resources.
