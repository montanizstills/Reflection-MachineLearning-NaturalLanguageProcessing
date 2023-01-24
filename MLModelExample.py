from ML_Model import ML_Model
from tensorflow import keras, metrics, optimizers, losses

my_model = ML_Model(
    hidden_layers=[
        keras.layers.Flatten(input_shape=(28, 28)),
        keras.layers.Dense(128, activation='relu'),
        keras.layers.Dense(10, activation='softmax')],
    optimizer_function=optimizers.Adam,
    loss_function=losses.SparseCategoricalCrossentropy,
    model_type=keras.models.Sequential,
    metrics=[metrics.Accuracy, metrics.Precision]
)
my_model.compile_model()
(x_train, y_train), (x_test, y_test) = keras.datasets.imdb.load_data()
my_model.train_model(
    training_data_set=(x_train, y_train),
    expected_training_return_values=(x_test, y_test),
    training_iterations=10
)
predictions = my_model.predict()
