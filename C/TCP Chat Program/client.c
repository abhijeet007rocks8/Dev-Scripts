/*TCP Chat Client Program*/

#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<string.h>
#include<stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <signal.h>

static void sig_io(int);

struct sockaddr_in serv_addr, cli_addr;

int skfd, r, w,val;

unsigned short serv_port = 25020; /*port number used by the server*/

char serv_ip[] = "127.0.0.1"; /*server's IP-address*/

/*buffer for sending and receiving messages*/
char rbuff[1024]; 
char sbuff[1024];

char check[]="end";

int main()
{
	/*initializing server socket address structure with zero values*/
	bzero(&serv_addr, sizeof(serv_addr));

	/*filling up the server socket address structure with appropriate values*/
   serv_addr.sin_family = AF_INET; /*address family*/
   serv_addr.sin_port = htons(serv_port); /*port number*/
   inet_aton(serv_ip, (&serv_addr.sin_addr)); /*IP-address*/
	
	printf("\nTCP CHAT CLIENT.\n");

	/*creating socket*/
  	if((skfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
	{
   	printf("\nCLIENT ERROR: Cannot create socket.\n");
      exit(1);
  	}

	/*request server for a connection*/
	if((connect(skfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr))) < 0)
	{
		printf("\nCLIENT ERROR: Cannot connect to the server.\n");
		close(skfd);
		exit(1);
	}
	printf("\nCLIENT: Connected to the server.\n");

	val=fcntl(skfd,F_GETFL,0);
  fcntl(skfd,F_SETFL,val|O_NONBLOCK|O_ASYNC);
  fcntl(skfd,F_SETOWN,getpid());
  signal(SIGIO,sig_io);
  printf("\n CLIENT: CHAT APPLICATION STARTED");

  for( ; ;){
    printf("\n CLIENT: CHAT PROMPT");
    fgets(sbuff,1024,stdin);
    
    if(strlen(sbuff)!=1){
      if((w = write(skfd, sbuff, 1024)) < 0)
	      printf("\nCLIENT ERROR: Cannot send message to the server.\n");

      if(!memcmp(sbuff,check,3)){
        printf("\n CLIENT: CHAT APPLICATION TERMINATED");
        close(skfd);
			  exit(1);
      }
    }
  }/*for ends*/
} /*main ends*/

static void sig_io(int signo){
  if((r = read(skfd, rbuff, 1024)) < 0)
	        	printf("\nCLIENT ERROR: Cannot receive message from the server.\n");
  else{
    if(r!=1){
      rbuff[r]='\0';
      printf("\n CLIENT: Message from server: %s\n Hit return for client prompt\n",rbuff);
    }
  }
}
