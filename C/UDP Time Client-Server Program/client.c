#include<sys/socket.h>
#include<sys/types.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<stdio.h>
#include<string.h>
#include <unistd.h>
#include<stdlib.h>
#include<time.h>

int main()
{
	struct sockaddr_in serv_addr;
  
  int skfd, r, s, serv_addr_len;
  
  time_t ticks;
  
  int short serv_port = 25020; /*port number used by the server*/
  
  char serv_ip[] = "127.0.0.1"; /*server's IP-address*/
  
  char rbuff[256]; /*buffer for receiving messages*/
  char sbuff[256]; /*buffer for sending messages*/
  
  /*initializing server socket address structure with zero values*/
  bzero(&serv_addr, sizeof(serv_addr));
  
  /*filling up the server socket address structure with appropriate values*/
  serv_addr.sin_family = AF_INET; /*address family*/
  serv_addr.sin_port = htons(serv_port); /*port number*/
  inet_aton(serv_ip, (&serv_addr.sin_addr)); /*IP-address*/
  printf("\nUDP TIME CLIENT.\n");
  
  ticks = time(NULL);
  snprintf(sbuff, 256, "%s", ctime(&ticks));
  
  /*creating socket*/
  if((skfd = socket(AF_INET, SOCK_DGRAM, 0)) < 0)
  {
    printf("\nCLIENT ERROR: Cannot create socket.\n");
    exit(1);
  } 
  
  /*sending message to the time server*/
  if((s = sendto(skfd, sbuff, 256, 0, (struct sockaddr*)&serv_addr,sizeof(serv_addr))) <
  0)
  {
    printf("\nCLIENT ERROR: Cannot send.\n");
    close(skfd);
    exit(1);
  }
  
  printf("\nCLIENT: Time sent to the server.\n");
  
  serv_addr_len = sizeof(serv_addr);
  if((r = recvfrom(skfd, rbuff, 256, 0, (struct sockaddr*)&serv_addr,&serv_addr_len)) <
  0)
  {
    printf("\nCLIENT ERROR: Cannot receive.\n");
    close(skfd);
    exit(1);
  }
  
  rbuff[r] = '\0';
  printf("\nCLIENT: Time echoed back from Time server: %s.\n",rbuff);/*received ' time from server*/
  close(skfd);
  exit(1);

} /*main ends*/
