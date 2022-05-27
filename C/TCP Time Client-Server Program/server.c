/*TCP Time Server Program*/

#include<sys/socket.h>
#include<sys/types.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<time.h>
#include<string.h>
#include<stdio.h>
#include <unistd.h>
#include <stdlib.h>

struct sockaddr_in serv_addr, cli_addr;

int listenfd, connfd, r, w, val, cli_addr_len;

unsigned short serv_port = 25020; /*port number to be used by the server*/
char serv_ip[] = "127.0.0.1"; /*server's IP-address*/

char buff[256]; /*buffer for sending and receiving messages*/

time_t ticks;

int main()
{
	/*initializing server socket address structure with zero values*/
   bzero(&serv_addr, sizeof(serv_addr));
                                                                                                                            
   /*filling up the server socket address structure with appropriate values*/
   serv_addr.sin_family = AF_INET; /*address family*/
   serv_addr.sin_port = htons(serv_port); /*port number*/
   inet_aton(serv_ip, (&serv_addr.sin_addr)); /*IP-address*/

	printf("\nTCP TIME SERVER.\n");
                                                                                                                            
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

		/*calculate current time and write it to the buffer*/
		ticks = time(NULL);
		snprintf(buff, 256, "%s", ctime(&ticks));
                                                                                                                      
		/*send calculated time to client*/
		if((w = write(connfd, buff, 256)) < 0)
	        	printf("\nSERVER ERROR: Cannot send message to the client.\n");
		else
			printf("\nSERVER: Time sent to client %s.\n", 
         inet_ntoa(cli_addr.sin_addr));

	} /*for ends*/

} /*main ends*/
