#include<sys/socket.h>
#include<sys/types.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<time.h>
#include<string.h>
#include<stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include <fcntl.h>

static void sig_io(int);

struct sockaddr_in serv_addr, cli_addr;

int listenfd, connfd, r, w, val, cli_addr_len,flag=1;

unsigned short serv_port = 25020; /*port number to be used by the server*/
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

	printf("\nTCP CHAT SERVER.\n");
                                                                                                                            
  	/*creating socket*/
   if((listenfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
	{
   	printf("\nSERVER ERROR: Cannot create socket.\n");
      exit(1);
  	}
                                                                                                                            
  	/*binding server socket address structure*/
   if((bind(listenfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr))) < 0)
   {
   	printf("\nSERVER ERROR: Cannot bind.\n");
      close(listenfd);
      exit(1);
	}

	/*listen to client connection requests*/
	if((listen(listenfd, 5)) < 0)
	{
		printf("\nSERVER ERROR: Cannot listen.\n");
   	close(listenfd);
      exit(1);
	}

	cli_addr_len = sizeof(cli_addr);


	for( ; ;)
	{
		printf("\nSERVER: Listenning for clients...Press Cntrl + c to stop echo server.\n");
		
		/*accept client connections*/	
		if((connfd = accept(listenfd, (struct sockaddr*)&cli_addr, &cli_addr_len)) < 0)
		{
			printf("\nSERVER ERROR: Cannot accept client connections.\n");
			close(listenfd);
			exit(1);
		}
		printf("\nSERVER: Connection fron client %s accepted.\n", 
      inet_ntoa(cli_addr.sin_addr));

		val=fcntl(connfd,F_GETFL,0);
    fcntl(connfd,F_SETFL,val|O_NONBLOCK|O_ASYNC);
    fcntl(connfd,F_SETOWN,getpid());
    signal(SIGIO,sig_io);
    printf("\n SERVER: CHAT APPLICATION STARTED");

    for( ; ;){
      if(flag==0){
        flag=1;
        break;
      }

      printf("\n SERVER: CHAT PROMPT");
      fgets(sbuff,1024,stdin);
      
      if(!memcmp(sbuff,check,3)){
        printf("\n SERVER: CHAT APPLICATION TERMINATED");
        close(connfd);
        close(listenfd);
			  exit(1);
      }

      if(strlen(sbuff)!=1){
        if((w = write(connfd, sbuff, 1024)) < 0)
	        	printf("\nSERVER ERROR: Cannot send message to the client.\n");
      }
      
    }                                                                         

	} /*for ends*/

} /*main ends*/

static void sig_io(int signo){
  if((r = read(connfd, rbuff, 1024)) < 0)
	        	printf("\nSERVER ERROR: Cannot receive message from the client.\n");
  else{
    rbuff[r]='\0';
    if(!memcmp(rbuff,check,3)){
        printf("\n SERVER: client %s terminated the chat.Hit return to     continue..\n",inet_ntoa(cli_addr.sin_addr));
        flag=0;
      }
    else{
      printf("\n SERVER: From%s: %s \n Hit return for server prompt.\n",inet_ntoa(cli_addr.sin_addr),rbuff);
    }
  }
}
