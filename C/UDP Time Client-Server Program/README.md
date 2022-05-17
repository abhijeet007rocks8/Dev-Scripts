### UDP TIME CLIENT-SERVER PROGRAM
This is a an implementation of client-server connection and communication using UDP to show how to retrieve the time of a remote server.There is a server.c and a client.c. The client will then try to bind with the server.The remote server will send the time(as per server) to the client, which the client will then display.It shows networking concepts using C and Linux.

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
 Dev-Scripts/C/UDP Time Client-Server Program
 
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
|![](https://user-images.githubusercontent.com/72400676/168792428-f7acd9e4-ebc2-48a7-b12f-2446dc70ded3.png)|![](https://user-images.githubusercontent.com/72400676/168792523-f07509e2-84d8-400c-97a0-fa6728e5c69a.png)|![](https://user-images.githubusercontent.com/72400676/168793706-737e36e3-d63e-4a49-b9e1-bc126f5ce7cc.png)
|:---:|:---:|:---:|
|**SERVER**|**CLIENT**|**SERVER & CLIENT**|

 #### Sample video :
 
