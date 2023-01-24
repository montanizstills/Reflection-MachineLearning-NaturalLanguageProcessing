import json
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

# # 6. Use the model:
# # Accepting input from the user
# input_image = input("Enter the path of the image: ")
# image = keras.preprocessing.image.load_img(input_image, target_size=(28, 28))
# image_array = keras.preprocessing.image.img_to_array(image)
# image_array = keras.applications.mobilenet.preprocess_input(image_array)
# image_array = np.expand_dims(image_array, axis=0)

# # Returning a prediction
# predictions = model.predict(image_array)
# print("Predicted number: ", np.argmax(predictions))

def lambda_handler(event, context):
    # TODO implement
    return {
        'statusCode': 200,
        'body': json.dumps(test_loss)
    }
