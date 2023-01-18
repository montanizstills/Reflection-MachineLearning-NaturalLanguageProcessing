from tensorflow import keras

# 1. Define the model architecture:
model = keras.Sequential([
    keras.layers.Flatten(input_shape=(28, 28)),  # Flatten the input image to 1D array
    keras.layers.Dense(128, activation='relu'),  # Fully connected layer with 128 units and ReLU activation
    keras.layers.Dense(10, activation='softmax')  # Output layer with 10 units and softmax activation
])

# 2. Compile the model:
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 3. Load the training data:
(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()  # Load the MNIST dataset

# 4. Train the model:
model.fit(x_train, y_train, epochs=10)

# 5. Evaluate the model:
test_loss, test_acc = model.evaluate(x_test, y_test, verbose=2)
print('\nTest accuracy:', test_acc)

# 6. Use the model:
predictions = model.predict(x_test)
print(predictions)
