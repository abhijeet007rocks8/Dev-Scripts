### UDP ECHO CLIENT-SERVER PROGRAM
This is a a basic implementation of client-server connection and communication using UDP protocol.There is a server.c and a client.c. The client will then try to bind with the server and send a message to the server(echo).The server will then echo back the same message as received back to the client.It shows networking concepts using C and Linux.

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
 Dev-Scripts/C/UDP Echo Client-Server Program
 
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
|![](https://user-images.githubusercontent.com/72400676/165731785-4d2045e4-d4e3-4eb7-a5e4-a7b3ed24d351.png)|![](https://user-images.githubusercontent.com/72400676/165731830-90221395-e1c3-4233-9e96-bee5d8d3027c.png)|![](https://user-images.githubusercontent.com/72400676/165734560-22f9c1a4-471c-4df2-bb7e-4a4efdd15ac0.png)
|:---:|:---:|:---:|
|**SERVER**|**CLIENT**|**SERVER & CLIENT**|

 #### Sample video :
 
https://user-images.githubusercontent.com/72400676/165734663-43f51bdf-9988-49bc-b8a0-e21ef4b3f8cb.mp4


