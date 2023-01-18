from tensorflow import keras


class ML_Model:
    def __init__(self,
                 hidden_layers=None,
                 optimizer_function: keras.optimizers = None,
                 loss_function: keras.losses = None,
                 model_type=None,
                 metrics=None):
        self.hidden_layers = hidden_layers
        self.optimizer_function = optimizer_function
        self.loss_function = loss_function
        self.keras_model_type = model_type
        self.metrics = metrics
        self.model_outputs = None
        self.model_inputs = None
        self.instance = None

    def create_model(self):
        if self.keras_model_type is None:
            raise "Model type must not be null!"
        self.instance = keras.Model(inputs=self.model_inputs, outputs=self.model_outputs,
                                    name=self.keras_model_type)

    def add_model_inputs(self, inputs):
        self.model_inputs = inputs

    def add_model_outputs(self, outputs):
        self.model_outputs = outputs

    def compile_model(self):
        if self.optimizer_function is None:
            raise "Model optimizer function must not be null!"
        self.instance.compile(optimizer=self.optimizer_function,
                              loss=self.loss_function,
                              metrics=self.metrics)

    def train_model(self, training_data_set, expected_training_return_values, training_iterations: int):
        self.instance.fit(training_data_set, expected_training_return_values, epochs=training_iterations)

    def predict(self, data_set_to_analyze):
        return self.instance.predict(data_set_to_analyze)
