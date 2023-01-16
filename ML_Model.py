class ML_Model:
    def __init__(self, hidden_layers: list = None, optimizer_function: str = None, loss_function: str = None,
                 metrics: list = None):
        self.hidden_layers = hidden_layers
        self.optimizer_function = optimizer_function
        self.loss_function = loss_function
        self.metrics = metrics
