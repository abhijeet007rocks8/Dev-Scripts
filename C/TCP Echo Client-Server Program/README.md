### TCP ECHO CLIENT-SERVER PROGRAM
This is a a basic implementation of client-server connection and communication using TCP protocol.There is a tcp_echo_server.c and a tcp_echo_client.c. The client will then try to bind with the server and send a message to the server(echo).The server will then echo back the same message as received back to the client.It shows networking concepts using C and Linux.

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
 Dev-Scripts/C/TCP Echo Client-Server Program
 
 Create two Linux terminals and type the following commands to run the program
 
 In terminal 1 i.e. server terminal
 ```
  gcc tcp_echo_server.c -o tcp_echo_server
  ./tcp_echo_server
 ```
 
 In terminal 2 i.e. client terminal
 ```
  gcc tcp_echo_client.c -o tcp_echo_client
  ./tcp_echo_client
 ```
 
 OR
 You can also run the two scripts simultaneously in a single Linux terminal using the following commands
 
 ```
  gcc tcp_echo_server.c -o tcp_echo_server
  gcc tcp_echo_client.c -o tcp_echo_client
  ./tcp_echo_server & ./tcp_echo_client
 ```
 #### Screenshots :
|![](https://user-images.githubusercontent.com/72400676/165903048-795dc19e-54ed-4f2d-860d-ff39974616e3.png)|![](https://user-images.githubusercontent.com/72400676/165898777-577c909e-a8f1-4386-b298-548e9450e076.png)|![](https://user-images.githubusercontent.com/72400676/165898834-ba6d23b6-a148-4c7c-ae89-7e2a391efde3.png)
|:---:|:---:|:---:|
|**SERVER**|**CLIENT**|**SERVER & CLIENT**|

 #### Sample video :
 
 https://user-images.githubusercontent.com/72400676/165905092-bfa7ad58-01d9-4c0f-aa3e-efa9c08271dc.mp4



