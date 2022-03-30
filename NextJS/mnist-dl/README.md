### Hand Written Digit Recognition

This is a simple deep learning application for hand digits recognition in realtime.

<img src="/mnist.png" alt="img" width="100%"/>

### Deployed applications

1. [server](https://lenet-mnist.herokuapp.com/)
2. [client](https://mnist-next-client.vercel.app/)

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

This contain a `ipynb` notebook that was used for training the digit recognition classifier in `pytorch`.

### 📁 client

Client is nothing but a next.js application. This application will consume the api from the server and make predictions on the hand digits that will be sketched by the user on the canvas.

### Deploying and Hosting.

In this section we are going to walk through all deployment process of our server and client packages.

### Hosting our server

We are going to host the server on Heroku. We are going to follow the following step to host our site.

1. Make sure you have `Git` and `Python` installed on your computer
2. [Create or Sign In to Heroku](https://id.heroku.com/login)
3. [Install Heroku](https://devcenter.heroku.com/articles/heroku-cli#other-installation-methods)

#### Installing gunicorn

To install `gunicorn` we run the following command:

```shell
pip install gunicorn
```

##### Making required filed by Heroku

1. `requirements.txt`

Create a requirements.txt by running the following command:

```shell
pip freeze > requirements.txt
```

2. Create a _Procfile_

- [Procfile](https://devcenter.heroku.com/articles/procfile) is a Process file that is required for all Heroku applications. Procfile specifies the commands that are executed by the app on startup.
- Create _`Procfile`_ in the root of your project and add the following

```shell
web: gunicorn app:app
```

Here, the `app` is the name of your main (`.py`) file. In my case, it is `app.py`.

3. Create the `runtime.txt`

In this file we are going to put the version of python that we are using in my case i'm using version `3.8.5` so i will add the following in the `runtime.txt`:

```txt
python-3.8.5
```

#### Creating a heroku application

To create a heroku application we first going to login by running the following command:

```shell
heroku login
```

Create a new github repository and push your project using git commands

```shell
$ git init
$ git add .
$ git branch -M master
$ git remote add origin <repo url>
$ git commit -m "message-commit"
$ git push -u origin master
```

- Enter the credentials and run the following command to create a heroku application

```shell
heroku create < your_app_name >
# example
heroku create lenet-mnist
```

To deploy run the following command:

```shell
git push heroku main
```

### Deploying client to vercel

1. First create or login to [vercel.com](https://vercel.com/signup)
2. Authorize with a provider (i recommend github)

#### Pushing the client code to github

- Before importing the project to `vercel` we need to create a repository for our client app and push it to our github account so that we will have access to it in the vercel dashboard.

```shell
git init
git add .
git commit branch -M main
git remote add origin <repo url>
git commit -m "init-commit"
git push -u origin main
```

3. Look for the project that you want to deploy and click `import`
4. Select the project and click `deploy`

### Deployed version of the client

- [mnist-next-client](https://mnist-next-client.vercel.app/)

### Deployed version of the server

- [deployed version of the server](https://lenet-mnist.herokuapp.com/)
