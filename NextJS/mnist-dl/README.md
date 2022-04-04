### Hand Written Digit Recognition

This is a simple deep learning application for hand digits recognition in realtime.

<img src="https://github.com/CrispenGari/Dev-Scripts/blob/mnist-dl/NextJS/mnist-dl/mnist.png" alt="img" width="100%"/>

This application is using a multi-repo approach with the following packages:

```
📁 mnist-dl
    📁 server
    📁 notebooks
    📁 client
```

### 📁 server

The server contains a machine learning rest api for image classification using artificial neural network. The model architecture that was used for this task is the modified version of the `LeNet` which looks as follows in code:

```py
class LeNet(nn.Module):
    def __init__(self, output_dim):
        super(LeNet, self).__init__()
        self.features = nn.Sequential(
            nn.Conv2d(in_channels=1, out_channels=6, kernel_size =5),
            nn.MaxPool2d(kernel_size=2),
            nn.ReLU(),
            nn.Conv2d(in_channels=6, out_channels=16, kernel_size =5),
            nn.MaxPool2d(kernel_size=2),
            nn.ReLU()
        )
        self.classifier = nn.Sequential(
            nn.Linear(16 * 4 * 4, 120),
            nn.ReLU(),
            nn.Linear(120, 84),
            nn.ReLU(),
            nn.Linear(84, output_dim)
        )

    def forward(self, x):
        x = self.features(x) # x = [batch size, 16, 4, 4]
        x = x.view(x.shape[0], -1) # x = [batch size, 16*4*4 = 256]
        x = self.classifier(x) # x = [batch size, output dim]
        return x
```

### 📁 notebooks

This contain a `.ipynb` notebook that was used for training the digit recognition classifier in `pytorch`. If you want to retrain the model you can run the notebook `/notebooks/MNIST_LeNet.ipyb`

### 📁 client

Client is nothing but a next.js application. This application will consume the api from the server and make predictions on the hand digits that will be sketched by the user on the canvas.

### Running the web application locally.

To run the web application locally first you need to clone this repository by running the following command:

```shell
https://github.com/CrispenGari/Dev-Scripts.git
```

You need to open two terminals the one for the server and the other one for the client.

### Client

To start the client server open a terminal or command prompt in the `Dev-Scripts` and navigate to the client package by running the following command:

```shell
cd NextJS/mnist-dl/client
```

Then run:

```shell
yarn install && yarn run dev
# OR

npm install && npm run dev
```

> If everything went well the server will start running on a default port of `3000` then you can visit http://localhost:3000 or http://127.0.0.1:3000

### server

Just like what we di on the client we need to install packages and start the server. First you need to navigate to the server folder by running the following command:

```shell
cd NextJS/mnist-dl/server
```

1. create a virtual environment

To create a virtual environment you run the following command:

```shell
virtualenv venv
```

2. activate the virtual environment

To activate the virtual environment you run the following command:

```shell
venv\Scripts\activate.bat
```

3. Install the packages

To install the packages run the following command:

```shell
pip install -r requirements.txt
```

4. Then start the server

To start the server (machine learning server) you need to run the following command:

```shell
cd app
#  Then
python app.py
```

> The machine learning server will start running on port `3001` in development.
