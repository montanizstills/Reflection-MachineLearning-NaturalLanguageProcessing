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
my_model.train_model()
predictions = my_model.predict()
