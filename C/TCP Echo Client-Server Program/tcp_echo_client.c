/*TCP Echo Client Program*/
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

struct sockaddr_in serv_addr;

int skfd, r, s,serv_addr_len;

unsigned short serv_port = 25020; /*port number used by the server*/

char serv_ip[] = "127.0.0.1"; /*server's IP-address*/

char rbuff[256]; /*buffer for receiving messages*/

char sbuff[256]="Hello Server"; /*buffer for sending messages*/


int main()
{
  /*initializing server socket address structure with zero values*/
  bzero(&serv_addr, sizeof(serv_addr));
  
  /*filling up the server socket address structure with appropriate values*/
  serv_addr.sin_family = AF_INET; /*address family*/
  serv_addr.sin_port = htons(serv_port); /*port number*/
  inet_aton(serv_ip, (&serv_addr.sin_addr)); /*IP-address*/
  printf("\nTCP ECHO CLIENT.\n");
  
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
  
  /*sending message to the echo server*/
   if((s = sendto(skfd, sbuff, 128, 0, (struct sockaddr*)&serv_addr, 
   sizeof(serv_addr))) < 0)
   {
   	printf("\nCLIENT ERROR: Cannot send.\n");
      close(skfd);
      exit(1);
 	}
   printf("\nCLIENT: Message sent to the echo server.\n");/*sent 's' bytes to 
                                                            server*/
                                                                                                                            
	/*client waits, till server echoes back the message and then receivies 
     it*/
	serv_addr_len = sizeof(serv_addr);
	if((r = recvfrom(skfd, rbuff, 128, 0, (struct sockaddr*)&serv_addr, &serv_addr_len)) < 0)
	{
		printf("\nCLIENT ERROR: Cannot receive.\n");
		close(skfd);
		exit(1);
	}
	
	rbuff[r] = '\0';
	
	printf("\nCLIENT: Message echoed back from echo server: %s.\n", 
   rbuff);/*received 'r' bytes from server*/

	close(skfd); 
	exit(1);
} /*main ends*/
