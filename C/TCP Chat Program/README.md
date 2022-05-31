### TCP CHAT PROGRAM
This is an implementation of client-server connection and communication using TCP to show how to implement a two-way chat application..There is a server.c and a client.c. The client will then try to bind with the server.The remote server will connect and then continue a full-duplex conversation with the client.It shows networking concepts using Linux and C.

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
 Dev-Scripts/C/TCP Chat Program
 
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
 
 #### Screenshots :
|![](https://user-images.githubusercontent.com/72400676/170864892-54dd0ba4-8892-4d2d-b298-1ff38f5234c0.png)|![](https://user-images.githubusercontent.com/72400676/170865017-e355849d-7c72-47e9-ae08-e5c2b4137dbb.png)|
|:---:|:---:|
|**SERVER**|**CLIENT**|

 #### Sample video :
 
 

https://user-images.githubusercontent.com/72400676/170864875-4f0a6990-3303-4ff4-9be6-9d039d87dece.mp4


