import tensorflow as tf
from tensorflow import keras

# 1. Define the model architecture:
model = keras.Sequential([
    # hidden layers??
    # neurons connected by 'synapses' or weights? what is the relationship?
    keras.layers.Flatten(input_shape=(28, 28)), # Flatten the input image to 1D array
    keras.layers.Dense(128, activation='relu'), # Fully connected layer with 128 units and ReLU activation
    keras.layers.Dense(10, activation='softmax') # Output layer with 10 units and softmax activation
])

# 2. Compile the model:
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 3. Load the training data:
(x_train, y_train), (x_val, y_val) = keras.datasets.mnist.load_data() # Load the MNIST dataset

# 4. Train the model:
model.fit(x_train, y_train, epochs=10)

# 5. Evaluate the model:
test_loss, test_acc = model.evaluate(x_val,  y_val, verbose=2)
print('\nTest accuracy:', test_acc)

# 6. Use the model:
predictions = model.predict(x_val)



# TODO:
# Neural networks(layers),
    # How do I develop new networks?
    # Layer by layer vs cascading networks?
    # Problems with Deep networks?
        # Computational in-efficiency
    # What are layers? What kinds of layers exists? What is a reduction layer? convolutional, pooling, dimensionality reduction layers
# activation function,
# loss functions,
# optimizers,
# normalizing or one-hot encoding,
# gradient descent algorithm,

# What are the types of unsupervised learning models? What are the types of supervised learning models?