### TCP TIME CLIENT-SERVER PROGRAM
This is an implementation of client-server connection and communication using TCPP to show how to retrieve the time of a remote server.There is a server.c and a client.c. The client will then try to bind with the server.The remote server will send the time(as per server) to the client, which the client will then display.It shows networking concepts using C and Linux.

### TECH USED:
 **1)** C
    simple function,client-server architecture, protocols and networking concept.

### STEPS TO USE
Start by making a fork the [**Dev-Scripts**](https://github.com/abhijeet007rocks8/Dev-Scripts) repository. Click on the <a href="https://github.com/abhijeet007rocks8/Dev-Scripts/fork"><img src="https://i.imgur.com/G4z1kEe.png" height="21" width="21"></a> symbol at the top right corner

**2.** Clone your new fork of the repository:
#### open git CMD
```bash
git clone https://github.com/<your-github-username>/Dev-Scripts
```

**3.** Navigate to the project directory:
 Dev-Scripts/C/TCP Time Client-Server Program

 Create two Linux terminals and type the following commands to run the program

 In terminal 1 i.e. server terminal
 ```
  gcc server.c -o server
  ./server
 ```

 In terminal 2 i.e. client terminal
 ```
  gcc client.c -o client
  ./client
 ```

 OR
 You can also run the two scripts simultaneously in a single Linux terminal using the following commands

 ```
  gcc server.c -o server
  gcc client.c -o client
  ./server & ./client
 ```
 #### Screenshots :
|![](https://user-images.githubusercontent.com/72400676/170298513-1c6df969-c807-48df-988a-b3af272521ec.png)|![](https://user-images.githubusercontent.com/72400676/170298165-3cfba981-ad0c-4099-9fa3-e08ca2f9c862.png)|![](https://user-images.githubusercontent.com/72400676/170298321-d889d357-9bfa-4986-a52e-fb3145b1a53b.png)
|:---:|:---:|:---:|
|**SERVER**|**CLIENT**|**SERVER & CLIENT**|

 #### Sample video :


https://user-images.githubusercontent.com/72400676/170394258-75867559-9931-4577-8431-1396472a015e.mp4


