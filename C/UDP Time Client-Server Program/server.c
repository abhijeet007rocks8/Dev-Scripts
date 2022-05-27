#include<sys/socket.h>
#include<sys/types.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<time.h>
#include <unistd.h>

int main()
{
  struct sockaddr_in serv_addr, cli_addr;
  	
  int skfd, r, s, cli_addr_len;
  
  int short serv_port = 25020; /*port number to be used by the server*/
  
  char serv_ip[] = "127.0.0.1"; /*server's IP-address*/
  
  char buff[256]; /*buffer for sending and receiving messages*/
  char sbuff[256];
  time_t ticks;
  /*initializing server socket address structure with zero values*/
  bzero(&serv_addr, sizeof(serv_addr));
  /*filling up the server socket address structure with appropriate values*/
  serv_addr.sin_family = AF_INET; /*address family*/
  serv_addr.sin_port = htons(serv_port); /*port number*/
  inet_aton(serv_ip, (&serv_addr.sin_addr)); /*IP-address*/
  printf("\nUDP TIME SERVER.\n");
  
  /*creating socket*/
  if((skfd = socket(AF_INET, SOCK_DGRAM, 0)) < 0)
  {
    printf("\nSERVER ERROR: Cannot create socket.\n");
    exit(1);
  }
  
  /*binding server socket address structure*/
  if((bind(skfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr))) < 0)
  {
    printf("\nSERVER ERROR: Cannot bind.\n");
    close(skfd);
    exit(1);
  }
  
  for( ; ; )
  {
    /*server waits, till client sends any message to be receivied*/
    printf("\nSERVER: Waiting for client...Press Cntrl + c to stop echo server.\n");
    cli_addr_len = sizeof(cli_addr);
      
    if((r = recvfrom(skfd, buff, 256, 0, (struct sockaddr*)&cli_addr, &cli_addr_len))
    < 0)
    {
      printf("\nSERVER ERROR: Cannot receive.\n");
      close(skfd);
      exit(1);
    }
    
    buff[r] = '\0';
    printf("\nSERVER: Time received from client %s: %s.\n",
    inet_ntoa(cli_addr.sin_addr), buff); 
    
    /*calculate current time and write it to the buffer*/
    ticks = time(NULL);
    snprintf(sbuff, 256, "%s", ctime(&ticks));
    if((s = sendto(skfd, sbuff, 256, 0, (struct sockaddr*)&cli_addr, cli_addr_len))<0)
    {
      printf("\nSERVER ERROR: Cannot send.\n");
      close(skfd);
      exit(1);
    }
    printf("\nSERVER: Message Time back to client %s.\n",
    inet_ntoa(cli_addr.sin_addr)); /*sent 's' bytes to client*/
  } /*for ends*/
} /*main ends*/


