package LudoGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class LudoGame extends JFrame implements ActionListener 
{

	ImageIcon star,iplayer1_1,iplayer1_2,iplayer1_3,iplayer1_4,iplayer2_1,iplayer2_2,iplayer2_3,iplayer2_4,iplayer3_1,iplayer3_2,iplayer3_3,iplayer3_4,iplayer4_1,iplayer4_2,iplayer4_3,iplayer4_4;
	ImageIcon dice,blank;
	Timer timer;
	ImageIcon ifirst,isecond,ithird,iforth;
	
	private int randomnum;
	private int moves=0;
	private boolean player1=true;
	private boolean player2=false;
	private boolean player3=false;
	private boolean player4=false;
	private boolean player1_1=false;
	private boolean player1_2=false;
	private boolean player1_3=false;
	private boolean player1_4=false;
	private boolean player2_1=false;
	private boolean player2_2=false;
	private boolean player2_3=false;
	private boolean player2_4=false;
	private boolean player3_1=false;
	private boolean player3_2=false;
	private boolean player3_3=false;
	private boolean player3_4=false;
	private boolean player4_1=false;
	private boolean player4_2=false;
	private boolean player4_3=false;
	private boolean player4_4=false;
	private JButton dicebutton,runner1,runner2,runner3,runner4,newgame;
	Random random=new Random();
	private JLabel label,runnerlabel;
	private int pos11=0,pos12=0,pos13=0,pos14=0;
	private int pos21=0,pos22=0,pos23=0,pos24=0;
	private int pos31=0,pos32=0,pos33=0,pos34=0;
	private int pos41=0,pos42=0,pos43=0,pos44=0;
	private boolean win11=false,win12=false,win13=false,win14=false;
	private boolean win21=false,win22=false,win23=false,win24=false;
	private boolean win31=false,win32=false,win33=false,win34=false;
	
	private boolean win41=false,win42=false,win43=false,win44=false;
	String first="no",second="no",third="no",forth="no";
	private boolean start=false;
	private int player1xpos[]= {40, 80, 120,160,200,240,240,240,240,240,240,280,320,320,320,320,320,320,360,400,440,480,520,560,560,560,520,480,440,400,360,320,320,320,320,320,320,280,240,240,240,240,240,240,200,160,120, 80, 40,  0,  0, 40, 80,120,160,200,20};
	private int player1ypos[]= {280,280,280,280,280,240,200,160,120,80 ,40 ,40, 40, 80, 120,160,200,240,280,280,280,280,280,280,320,360,360,360,360,360,360,400,440,480,520,560,600,600,600,560,520,480,440,400,360,360,360,360,360,360,320,320,320,320,320,320,30};
	private int player2xpos[]= {320,320,320,320,320,360,400,440,480,520,560,560,560,520,480,440,400,360,320,320,320,320,320,320,280,240,240,240,240,240,240,200,160,120, 80, 40,  0,  0,  0, 40, 80,120,160,200,240,240,240,240,240,240,280,280,280,280,280,280,40};
	private int player2ypos[]= {80 ,120,160,200,240,280,280,280,280,280,280,320,360,360,360,360,360,360,400,440,480,520,560,600,600,600,560,520,480,440,400,360,360,360,360,360,360,320,280,280,280,280,280,280,240,200,160,120, 80, 40, 40, 80,120,160,200,240,50};
	private int player3xpos[]= {520,480,440,400,360,320,320,320,320,320,320,280,240,240,240,240,240,240,200,160,120, 80, 40,  0,  0,  0, 40, 80,120,160,200,240,240,240,240,240,240,280,320,320,320,320,320,320,360,400,440,480,520,560,560,520,480,440,400,360,60};
	private int player3ypos[]= {360,360,360,360,360,400,440,480,520,560,600,600,600,560,520,480,440,400,360,360,360,360,360,360,320,280,280,280,280,280,280,240,200,160,120, 80, 40, 40, 40, 80,120,160,200,240,280,280,280,280,280,280,320,320,320,320,320,320,70};
	private int player4xpos[]= {240,240,240,240,240,200,160,120, 80, 40,  0,  0,  0, 40, 80,120,160,200,240,240,240,240,240,240,280,320,320,320,320,320,320,360,400,440,480,520,560,560,560,520,480,440,400,360,320,320,320,320,320,320,280,280,280,280,280,280,80};
	private int player4ypos[]= {560,520,480,440,400,360,360,360,360,360,360,320,280,280,280,280,280,280,240,200,160,120, 80, 40, 40, 40, 80,120,160,200,240,280,280,280,280,280,280,320,360,360,360,360,360,360,400,440,480,520,560,600,600,560,520,480,440,400,90};
	ImageIcon img,img2;
	Font font;
	LudoGame(String title)
	
	{
		super(title);
		setBounds(200,10,900,640);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBackground(Color.white);
		
	
		setResizable(false);
	
	
		runner1=new JButton("1");
		runner2=new JButton("2");
		runner3=new JButton("3");
		runner4=new JButton("4");
		add(runner1);
		add(runner2);
		add(runner3);
		add(runner4);
		runner1.addActionListener(this);
		runner2.addActionListener(this);
		runner3.addActionListener(this);
		runner4.addActionListener(this);
		runner1.setBounds(620,400,120,40);
		runner2.setBounds(760,400,120,40);
		runner3.setBounds(620,450,120,40);
		runner4.setBounds(760,450,120,40);
		newgame=new JButton("New Game");
		
		newgame.setBounds(620,520, 260, 70);
		add(newgame);
		newgame.setBackground(Color.cyan);
		newgame.setForeground(Color.white);
		newgame.setFont(new Font("Algerian",Font.BOLD,40));
//		newgame.setIcon(new ImageIcon("Webp.net-resizeimage (23).png"));
		newgame.addActionListener(this);
		dicebutton=new JButton("DICE");
		add(dicebutton);
		dicebutton.setBounds(620,290,170,50);
		dicebutton.setIcon(new ImageIcon("dice.png"));
		dicebutton.addActionListener(this);
		
		label=new JLabel();
		add(label);

		label.setBounds(820-2,315-25,50,50);
		timer=new Timer(100,this);
		
		font=new Font("Candara",Font.BOLD,25);
		runner1.setFont(font);
		runner2.setFont(font);
		runner3.setFont(font);
		runner4.setFont(font);
		getRootPane().setDefaultButton(dicebutton);
		
	}
	
	public void paint(Graphics g)
	{
		

		blank=new ImageIcon("blankdice.png");
	
		img=new ImageIcon("Webp.net-resizeimage (1).jpg");
		
		if(!start)
		{
		img.paintIcon(this,g,0,0);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		for(int i=0; i<900; i+=40)
		{
			for(int j=0; j<700; j+=40)
			{
				blank.paintIcon(this, g,i,j);
			}
		}
		start=true;
		img2=new ImageIcon("Webp.net-resizeimage (3).jpg");
		img2.paintIcon(this,g,610,40);
//		
	}
	
	
	
			
		for(int i=0; i<player1xpos.length-1; i++)
		{
			blank.paintIcon(this, g, player1xpos[i], player1ypos[i]);
			blank.paintIcon(this, g, player2xpos[i],player2ypos[i]);
		}
	
		for(int i=0; i<=500; i+=40)
		{
			blank.paintIcon(this, g,i ,0);
		}
		star=new ImageIcon("star.png");
		star.paintIcon(this,g,240,120);
		star.paintIcon(this,g,480,280);
		star.paintIcon(this,g,80,360);
		star.paintIcon(this,g,80+240,360+160);
		
		
		//player 1 red 
		
		g.setColor(Color.red);
		g.fillRect(0, 40, 240, 240);
		g.setColor(Color.white);
		g.fillRect(40,80, 160, 160);
		//player 2 green
		g.setColor(Color.green);
	    g.fillRect(0+360, 40, 240, 240);
		g.setColor(Color.white);
		g.fillRect(40+360,80, 160, 160);
		//player 3 yellow
		g.setColor(Color.yellow);
		g.fillRect(0+360, 40+360, 240, 240);
		g.setColor(Color.white);
		g.fillRect(40+360,80+360, 160, 160);
		//player 4 blue
		g.setColor(Color.blue);
		g.fillRect(0, 40+360, 240, 240);
		g.setColor(Color.white);
		g.fillRect(40,80+360, 160, 160);
	
		//all lines
		g.setColor(Color.black);
		g.drawRect(0, 40,600,600);
		g.drawLine(240, 80, 360, 80);
		g.drawLine(240, 120, 360, 120);
		g.drawLine(240, 160, 360, 160);
		g.drawLine(240, 200, 360, 200);
		g.drawLine(240, 240, 360, 240);
		g.drawLine(240, 280, 360, 280);
		
		g.drawLine(240, 400, 360, 400);
		g.drawLine(240, 440, 360, 440);
		g.drawLine(240, 480, 360, 480);
		g.drawLine(240, 520, 360, 520);
		g.drawLine(240, 560, 360, 560);
		g.drawLine(240, 600, 360, 600);
		
		g.drawLine(0, 280, 0, 400);
		g.drawLine(40, 280, 40, 400);
		g.drawLine(80, 280, 80, 400);
		g.drawLine(120, 280, 120, 400);
		g.drawLine(160, 280, 160, 400);
		g.drawLine(200, 280, 200, 400);
		g.drawLine(240, 280, 240, 400);
		
		g.drawLine(360, 280, 360, 400);
		g.drawLine(400, 280, 400, 400);
		g.drawLine(440, 280, 440, 400);
		g.drawLine(480, 280, 480, 400);
		g.drawLine(520, 280, 520, 400);
		g.drawLine(560, 280, 560, 400);
		

		g.drawLine(240,40,240,280);
		g.drawLine(280,40,280,280);
		g.drawLine(320,40,320,280);
		g.drawLine(360,40,360,280);
		
		g.drawLine(240,400,240,640);
		g.drawLine(280,400,280,640);
		g.drawLine(320,400,320,640);
		g.drawLine(360,400,360,640);
		
		g.drawLine(0,280,240,280);
		g.drawLine(0,320,240,320);
		g.drawLine(0,360,240,360);
		g.drawLine(0,400,240,400);
		
		g.drawLine(360,280,600,280);
		g.drawLine(360,320,600,320);
		g.drawLine(360,360,600,360);
		g.drawLine(360,400,600,400);
		
		
		
		
		
		g.setColor(Color.green);
		g.fillRect(321,81,39,39);
		g.fillRect(281,81,39,39);
		g.fillRect(281,81+40,39,39);
		g.fillRect(281,81+80,39,39);
		g.fillRect(281,81+120,39,39);
		g.fillRect(281,81+160,39,39);
		
		g.setColor(Color.blue);
		g.fillRect(241,561,39,39);
		g.fillRect(281,561,39,39);
		g.fillRect(281,561-40,39,39);
		g.fillRect(281,561-80,39,39);
		g.fillRect(281,561-120,39,39);
		g.fillRect(281,561-160,39,39);
		
		g.setColor(Color.red);
		g.fillRect(41,281,39,39);
		g.fillRect(41,321,39,39);
		g.fillRect(41+40,321,39,39);
		g.fillRect(41+80,321,39,39);
		g.fillRect(41+120,321,39,39);
		g.fillRect(41+160,321,39,39);
		
		g.setColor(Color.yellow);
		g.fillRect(521,361,39,39);
		g.fillRect(521,321,39,39);
		g.fillRect(521-40,321,39,39);
		g.fillRect(521-80,321,39,39);
		g.fillRect(521-120,321,39,39);
		g.fillRect(521-160,321,39,39);
		

		Polygon triangle1=new Polygon();
		triangle1.addPoint(240+1,280);
		triangle1.addPoint(300, 340);
		triangle1.addPoint(240+1, 280+120);
		g.setColor(Color.red);
		g.fillPolygon(triangle1);
	
	g.fillOval(55, 95,60, 60);
		g.fillOval(130,95,60,60);
		g.fillOval(55, 165, 60, 60);
		g.fillOval(130, 165, 60, 60);

		Polygon triangle2=new Polygon();
		triangle2.addPoint(241,281);
		triangle2.addPoint(300, 340);
		triangle2.addPoint(359, 281);
		g.setColor(Color.green);
		g.fillPolygon(triangle2);
		g.fillOval(55+360, 95,60, 60);
		g.fillOval(130+360,95,60,60);
		g.fillOval(55+360, 165, 60, 60);
		g.fillOval(130+360, 165, 60, 60);
		

		Polygon triangle3=new Polygon();
		triangle3.addPoint(240+120,280);
		triangle3.addPoint(300, 340);
		triangle3.addPoint(360, 280+120);
		g.setColor(Color.yellow);
		g.fillPolygon(triangle3);
		g.fillOval(55+360, 95+360,60, 60);
		g.fillOval(130+360,95+360,60,60);
		g.fillOval(55+360, 165+360, 60, 60);
		g.fillOval(130+360, 165+360, 60, 60);
		
		
		Polygon triangle4=new Polygon();
		triangle4.addPoint(240,280+120);
		triangle4.addPoint(300, 340);
		triangle4.addPoint(360, 280+120);
		g.setColor(Color.blue);
		g.fillPolygon(triangle4);
		g.fillOval(55, 95+360,60, 60);
		g.fillOval(130,95+360,60,60);
		g.fillOval(55, 165+360, 60, 60);
		g.fillOval(130, 165+360, 60, 60);
		
	
		
		g.setColor(Color.black);
		g.drawLine(240, 280, 240+120,280+120);
		g.drawLine(360, 280, 240, 400);
		
		iplayer1_1=new ImageIcon("redplayer.png");
		iplayer1_2=new ImageIcon("redplayer.png");
		iplayer1_3=new ImageIcon("redplayer.png");
		iplayer1_4=new ImageIcon("redplayer.png");
		
		
	    
	//player 1 1
		if(player1_1==false)
		{

			
			iplayer1_1.paintIcon(this, g, 55+10, 95+10);	
		
		}
		else if(pos11<56)
		{

			iplayer1_1.paintIcon(this, g, player1xpos[pos11], player1ypos[pos11]);
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos11]-10, player1ypos[pos11]-10, 25, 25);
				g.setColor(Color.black);
				g.drawString("1", player1xpos[pos11], player1ypos[pos11]+5);
				}
		
		}
		else if(pos11>=56)
		{
			iplayer1_1.paintIcon(this, g, player1xpos[55]+40, player1ypos[55]-30);
			win11=true;
		}
		
		
		//player 1 2
		
		if(player1_2==false)
		{

			
			iplayer1_2.paintIcon(this, g, 130+10, 95+10);	
		}
		else  if(pos12<56)
		{
			iplayer1_2.paintIcon(this, g, player1xpos[pos12], player1ypos[pos12]);
			if(moves==1 && player1)
			{
			g.setColor(Color.orange);
			g.fillOval(player1xpos[pos12]-10, player1ypos[pos12]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("2", player1xpos[pos12], player1ypos[pos12]+5);
			}
		}
		else if(pos12>=56)
		{
			iplayer1_2.paintIcon(this, g, player1xpos[55]+40+20, player1ypos[55]);
			win12=true;
		}
		
		
		
		//player 1 3
		if(player1_3==false)
		{

		
			iplayer1_3.paintIcon(this, g, 55+10, 165+10);	
		}
		else  if(pos13<56)
		{
			iplayer1_3.paintIcon(this, g, player1xpos[pos13], player1ypos[pos13]);
			if(moves==1 && player1)
			{
			g.setColor(Color.orange);
			g.fillOval(player1xpos[pos13]-10, player1ypos[pos13]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("3", player1xpos[pos13], player1ypos[pos13]+5);
			}
		}
		else if(pos13>=56)
		{
			iplayer1_3.paintIcon(this, g, player1xpos[55]+40, player1ypos[55]);
			win13=true;
		}
		
		///player 1 4
	   if(player1_4==false)
		{

		
			iplayer1_4.paintIcon(this, g, 130+10, 165+10);	
		}
		else  if(pos14<56)
		{
			iplayer1_4.paintIcon(this, g, player1xpos[pos14], player1ypos[pos14]);
			if(moves==1 && player1)
			{
			g.setColor(Color.orange);
			g.fillOval(player1xpos[pos14]-10, player1ypos[pos14]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("4", player1xpos[pos14], player1ypos[pos14]+5);
			}
		}
		else if(pos14>=56)
		{
			iplayer1_4.paintIcon(this, g, player1xpos[55]+40, player1ypos[55]+25);
			win14=true;
		}
		if(player1 && moves==1 )
		{
			if(pos11==pos12&& player1_1 && player1_2 &&!win11)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos11]-15, player1ypos[pos11]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,2", player1xpos[pos11]-10, player1ypos[pos11]+5);
				}
			}
			if(pos11==pos13&& player1_1 && player1_3&&!win11)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos11]-15, player1ypos[pos11]-15,30, 30);
				g.setColor(Color.black);
				g.drawString("1,3", player1xpos[pos11]-10, player1ypos[pos11]+5);
				}
			}
			if(pos11==pos14&& player1_1 && player1_4&&!win11)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos11]-15, player1ypos[pos11]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,4", player1xpos[pos11]-10, player1ypos[pos11]+5);
				}
			}
			if(pos12==pos13&& player1_2 && player1_3&&!win12)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos12]-15, player1ypos[pos12]-15,30,30);
				g.setColor(Color.black);
				g.drawString("2,3", player1xpos[pos12]-10, player1ypos[pos12]+5);
				}
			}
			if(pos12==pos14&& player1_2 && player1_4&&!win12)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos12]-15, player1ypos[pos12]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("2,4", player1xpos[pos12]-10, player1ypos[pos12]+5);
				}
			}
			if(pos13==pos14&& player1_3 && player1_4&&!win13)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos13]-15, player1ypos[pos13]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("3,4", player1xpos[pos13]-10, player1ypos[pos13]+5);
				}
			}
			if(pos11==pos12 && pos11==pos13&& player1_1 && player1_2 && player1_3&&!win11)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos11]-20, player1ypos[pos11]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,2,3", player1xpos[pos11]-15, player1ypos[pos11]+3);
				}
			}
			if(pos11==pos12 && pos11==pos14&& player1_1 && player1_2 && player1_4&&!win11)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos11]-20, player1ypos[pos11]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,2,4", player1xpos[pos11]-15, player1ypos[pos11]+3);
				}
			}
			if(pos11==pos13 && pos14==pos13&& player1_1 && player1_4 && player1_3&&!win11)
			{

				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos13]-20, player1ypos[pos13]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,3,4", player1xpos[pos13]-15, player1ypos[pos13]+3);
				}
			}
			if(pos14==pos12 && pos14==pos13&& player1_4&& player1_2 && player1_3&&!win14)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos14]-20, player1ypos[pos14]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("2,3,4", player1xpos[pos14]-15, player1ypos[pos14]+3);
				}
			}
			if(pos14==pos12 && pos14==pos13 && pos14==pos11 && player1_1 && player1_4&& player1_2 && player1_3&&!win14)
			{
				if(moves==1 && player1)
				{
				g.setColor(Color.orange);
				g.fillOval(player1xpos[pos14]-25, player1ypos[pos14]-25, 43, 43);
				g.setColor(Color.black);
				g.drawString("1,2,3,4", player1xpos[pos14]-22, player1ypos[pos14]+3);
				}
			}
		}
		
		
		iplayer2_1=new ImageIcon("greenplayer.png");
		iplayer2_2=new ImageIcon("greenplayer.png");
		iplayer2_3=new ImageIcon("greenplayer.png");
		iplayer2_4=new ImageIcon("greenplayer.png");
		  
		//player 2 1
		if(player2_1==false)
		{

			
			iplayer2_1.paintIcon(this, g, 55+10+360, 95+10);	
		}
		else if(pos21<56)
		{
			iplayer2_1.paintIcon(this, g, player2xpos[pos21], player2ypos[pos21]);
			if(moves==1 && player2)
			{
			g.setColor(Color.orange);
			g.fillOval(player2xpos[pos21]-10, player2ypos[pos21]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("1", player2xpos[pos21], player2ypos[pos21]+5);
			}
		}
		else if(pos21>=56)
		{
			iplayer2_1.paintIcon(this, g, player2xpos[55]+30, player2ypos[55]+25);
			win21=true;
		}
		
		
		// player 2 2 
	if(player2_2==false)
		{

			
			iplayer2_2.paintIcon(this, g, 130+10+360, 95+10);	
		}
		else if(pos22<56)
		{
			iplayer2_2.paintIcon(this, g, player2xpos[pos22], player2ypos[pos22]);
			if(moves==1 && player2)
			{
			g.setColor(Color.orange);
			g.fillOval(player2xpos[pos22]-10, player2ypos[pos22]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("2", player2xpos[pos22], player2ypos[pos22]+5);
			}
		}
		else if(pos22>=56)
		{
			
				iplayer2_2.paintIcon(this, g, player2xpos[55], player2ypos[55]+25);
				win22=true;

		}
		//player 2 3
	
		if(player2_3==false)
		{

		
			iplayer2_3.paintIcon(this, g, 55+10+360, 165+10);	
		}
		else if(pos23<56)
		{
			iplayer2_3.paintIcon(this, g, player2xpos[pos23], player2ypos[pos23]);
			if(moves==1 && player2)
			{
			g.setColor(Color.orange);
			g.fillOval(player2xpos[pos23]-10, player2ypos[pos23]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("3", player2xpos[pos23], player2ypos[pos23]+5);
			}
		}
		else if(pos23>=56)
		{
			iplayer2_3.paintIcon(this, g, player2xpos[55], player2ypos[55]+50);
			win23=true;
		}
		// player 2 4
	
		
		if(player2_4==false)
		{

		
			iplayer2_4.paintIcon(this, g, 130+10+360, 165+10);	
		}
		else if(pos24<56)
		{
			iplayer2_4.paintIcon(this, g, player2xpos[pos24], player2ypos[pos24]);
			if(moves==1 && player2)
			{
			g.setColor(Color.orange);
			g.fillOval(player2xpos[pos24]-10, player2ypos[pos24]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("4", player2xpos[pos24], player2ypos[pos24]+5);
			}
		}
		else if(pos24>=56)
		{
			iplayer2_4.paintIcon(this, g, player2xpos[55]-25, player2ypos[55]+25);
			win24=true;
		}
		
		if(player2 && moves==1 )
		{
			if(pos21==pos22&& player2_1 && player2_2 &&!win21)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos21]-15, player2ypos[pos21]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,2", player2xpos[pos21]-10, player2ypos[pos21]+5);
				}
			}
			if(pos21==pos23&& player2_1 && player2_3&&!win21)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos21]-15, player2ypos[pos21]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,3", player2xpos[pos21]-10, player2ypos[pos21]+5);
				}
			}
			if(pos21==pos24&& player2_1 && player2_4&&!win21)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos21]-15, player2ypos[pos21]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,4", player2xpos[pos21]-10, player2ypos[pos21]+5);
				}
			}
			if(pos22==pos23&& player2_2 && player2_3&&!win22)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos22]-15, player2ypos[pos22]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("2,3", player2xpos[pos22]-10, player2ypos[pos22]+5);
				}
			}
			if(pos22==pos24&& player2_2 && player2_4&&!win22)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos22]-15, player2ypos[pos22]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("2,4", player2xpos[pos22]-10, player2ypos[pos22]+5);
				}
			}
			if(pos23==pos24&& player2_3 && player2_4&&!win23)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos23]-15, player2ypos[pos23]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("3,4", player2xpos[pos23]-10, player2ypos[pos23]+5);
				}
			}
			if(pos21==pos22 && pos21==pos23&& player2_1 && player2_2 && player2_3&&!win21)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos21]-20, player2ypos[pos21]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,2,3", player2xpos[pos21]-15, player2ypos[pos21]+3);
				}
			}
			if(pos21==pos22 && pos21==pos24&& player2_1 && player2_2 && player2_4&&!win21)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos21]-20, player2ypos[pos21]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,2,4", player2xpos[pos21]-15, player2ypos[pos21]+3);
				}
			}
			if(pos21==pos23 && pos21==pos23&& player2_1 && player2_3 && player2_4&&!win21)
			{

				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos23]-20, player2ypos[pos23]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,3,4", player2xpos[pos33]-15, player2ypos[pos23]+3);
				}
			}
			if(pos24==pos22 && pos24==pos23&& player2_4&& player2_2 && player2_3&&!win24)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos24]-20, player2ypos[pos24]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("2,3,4", player2xpos[pos24]-15, player2ypos[pos24]+3);
				}
			}
			if(pos24==pos22 && pos24==pos23 && pos24==pos21 && player2_1 && player2_4&& player2_2 && player2_3&&!win24)
			{
				if(moves==1 && player2)
				{
				g.setColor(Color.orange);
				g.fillOval(player2xpos[pos24]-25, player2ypos[pos24]-25, 43, 43);
				g.setColor(Color.black);
				g.drawString("1,2,3,4", player2xpos[pos24]-22, player2ypos[pos24]+3);
				}
			}
		}
		
		
		
		
		iplayer3_1=new ImageIcon("yellowplayer.png");
		iplayer3_2=new ImageIcon("yellowplayer.png");
		iplayer3_3=new ImageIcon("yellowplayer.png");
		iplayer3_4=new ImageIcon("yellowplayer.png");
		
		  
//       player 3 1
		if(player3_1==false)
		{

			
			iplayer3_1.paintIcon(this, g, 55+10+360, 95+10+360);
		
		}
		else if(pos31<56)
		{
			iplayer3_1.paintIcon(this, g, player3xpos[pos31], player3ypos[pos31]);
			if(moves==1 && player3)
			{
			g.setColor(Color.orange);
			g.fillOval(player3xpos[pos31]-10, player3ypos[pos31]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("1", player3xpos[pos31], player3ypos[pos31]+5);
			}
		}
		else if(pos31>=56)
		{
				iplayer3_1.paintIcon(this, g, player3xpos[55]-30, player3ypos[55]+25);
				win31=true;
		}
	
		
		//player  3 2
		if(player3_2==false)
		{

			
			iplayer3_2.paintIcon(this, g, 130+10+360, 95+10+360);	
		}
		else if(pos32<56)
		{
			iplayer3_2.paintIcon(this, g, player3xpos[pos32], player3ypos[pos32]);
			if(moves==1 && player3)
			{
			g.setColor(Color.orange);
			g.fillOval(player3xpos[pos32]-10, player3ypos[pos32]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("2", player3xpos[pos32], player3ypos[pos32]+5);
			}
		}
		else if(pos32>=56)
		{
			iplayer3_2.paintIcon(this, g, player3xpos[55]-30, player3ypos[55]-5);
			win32=true;
		}
		
		//player 3 3
		
		if(player3_3==false)
		{

		
			iplayer3_3.paintIcon(this, g, 55+10+360, 165+10+360);	
		}
		else if(pos33<56)
		{
			iplayer3_3.paintIcon(this, g, player3xpos[pos33], player3ypos[pos33]);
			if(moves==1 && player3)
			{
			g.setColor(Color.orange);
			g.fillOval(player3xpos[pos33]-10, player3ypos[pos33]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("3", player3xpos[pos33], player3ypos[pos33]+5);
			}
		}
		else if(pos33>=56)
		{
			iplayer3_3.paintIcon(this, g, player3xpos[55]-30, player3ypos[55]-35);
			win33=true;
		}
		
		// player 3 4
		if(player3_4==false)
		{

		
			iplayer3_4.paintIcon(this, g, 130+10+360, 165+10+360);	
		}
		else if(pos34<56)
		{
			iplayer3_4.paintIcon(this, g, player3xpos[pos34], player3ypos[pos34]);
			if(moves==1 && player3)
			{
			g.setColor(Color.orange);
			g.fillOval(player3xpos[pos34]-10, player3ypos[pos34]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("4", player3xpos[pos34], player3ypos[pos34]+5);
			}
		}
		else if(pos34>=56)
		{
			iplayer3_4.paintIcon(this, g, player3xpos[55]-50, player3ypos[55]-5);
			win34=true;
		}
		if(player3 && moves==1 )
		{
			if(pos31==pos32&& player3_1 && player3_2 &&!win31)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos31]-15, player3ypos[pos31]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,2", player3xpos[pos31]-10, player3ypos[pos31]+5);
				}
			}
			if(pos31==pos33&& player3_1 && player3_3&&!win31)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos31]-15, player3ypos[pos31]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,3", player3xpos[pos31]-10, player3ypos[pos31]+5);
				}
			}
			if(pos31==pos34&& player3_1 && player3_4 &&!win31)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos31]-15, player3ypos[pos31]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,4", player3xpos[pos31]-10, player3ypos[pos31]+5);
				}
			}
			if(pos33==pos32&& player3_3 && player3_2 &&!win32)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos32]-15, player3ypos[pos32]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("2,3", player3xpos[pos32]-10, player3ypos[pos32]+5);
				}
			}
			if(pos34==pos32&& player3_4 && player3_2 &&!win32)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos32]-15, player3ypos[pos32]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("2,4", player3xpos[pos32]-10, player3ypos[pos32]+5);
				}
			}
			if(pos33==pos34&& player3_3 && player3_4 &&!win33)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos33]-15, player3ypos[pos33]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("3,4", player3xpos[pos33]-10, player3ypos[pos34]+5);
				}
			}
			if(pos31==pos32 && pos31==pos33&& player3_1 && player3_2 && player3_3&&!win31)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos31]-20, player3ypos[pos31]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,2,3", player3xpos[pos31]-15, player3ypos[pos31]+3);
				}
			}
			
			if(pos31==pos32 && pos31==pos34&& player3_1 && player3_2 && player3_4&&!win31)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos31]-20, player3ypos[pos31]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,2,4", player3xpos[pos31]-15, player3ypos[pos31]+3);
				}
			}
			if(pos31==pos33 && pos31==pos34&& player3_1 && player3_4 && player3_3&&!win31)
			{

				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos33]-20, player3ypos[pos33]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,3,4", player3xpos[pos33]-15, player3ypos[pos33]+3);
				}
			}
			if(pos33==pos32 && pos34==pos33&& player3_4 && player3_2 && player3_3&&!win32)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos32]-20, player3ypos[pos32]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("2,3,4", player3xpos[pos32]-15, player3ypos[pos32]+3);
				}
			}
			if(pos34==pos32 && pos34==pos33 && pos34==pos31 && player3_1 && player3_4&& player3_2 && player3_3&&!win34)
			{
				if(moves==1 && player3)
				{
				g.setColor(Color.orange);
				g.fillOval(player3xpos[pos34]-25, player3ypos[pos34]-25, 43, 43);
				g.setColor(Color.black);
				g.drawString("1,2,3,4", player3xpos[pos24]-22, player3ypos[pos24]+3);
				}
			}
		}
		
		

		iplayer4_1=new ImageIcon("blueplayer.png");
		iplayer4_2=new ImageIcon("blueplayer.png");
		iplayer4_3=new ImageIcon("blueplayer.png");
		iplayer4_4=new ImageIcon("blueplayer.png");
		  
//player 4 1
		if(player4_1==false)
		{

			
			iplayer4_1.paintIcon(this, g, 55+10, 95+10+360);	
			
		}
		else if(pos41<56)
		{
			
			iplayer4_1.paintIcon(this, g, player4xpos[pos41], player4ypos[pos41]);
			if(moves==1 && player4)
			{
			g.setColor(Color.orange);
			g.fillOval(player4xpos[pos41]-10, player4ypos[pos41]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("1", player4xpos[pos41], player4ypos[pos41]+5);
			}
		}
		else if(pos41>=56)
		{
			iplayer4_1.paintIcon(this, g, player4xpos[55]-25, player4ypos[55]-40);	
			win41=true;
		
			
		}
			//player 4 2
		if(player4_2==false)
		{

			
			iplayer4_2.paintIcon(this, g, 130+10, 95+10+360);	
		}
		else  if(pos42<56)
		{
			iplayer4_2.paintIcon(this, g, player4xpos[pos42], player4ypos[pos42]);
			if(moves==1 && player4)
			{
			g.setColor(Color.orange);
			g.fillOval(player4xpos[pos42]-10, player4ypos[pos42]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("2", player4xpos[pos42], player4ypos[pos42]+5);
			}
		}
		else if(pos42>=56)
		{
				iplayer4_2.paintIcon(this, g, player4xpos[55], player4ypos[55]-40);	
				win42=true;
		}
		
		if(player4_3==false)
		{

		
			iplayer4_3.paintIcon(this, g, 55+10, 165+10+360);	
		}
		else if(pos43<56)
		{
			iplayer4_3.paintIcon(this, g, player4xpos[pos43], player4ypos[pos43]);
			if(moves==1 && player4)
			{
			g.setColor(Color.orange);
			g.fillOval(player4xpos[pos43]-10, player4ypos[pos43]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("3", player4xpos[pos43], player4ypos[pos43]+5);
			}
		}
		else if(pos43>=56)
			{
					iplayer4_3.paintIcon(this, g, player4xpos[55]+30, player4ypos[55]-40);	
					win43=true;
			}
			
		if(player4_4==false)
		{

		
			iplayer4_4.paintIcon(this, g, 130+10, 165+10+360);	
		}
		else if(pos44<56)
		{
			iplayer4_4.paintIcon(this, g, player4xpos[pos44], player4ypos[pos44]);
			if(moves==1 && player4)
			{
			g.setColor(Color.orange);
			g.fillOval(player4xpos[pos44]-10, player4ypos[pos44]-10, 25, 25);
			g.setColor(Color.black);
			g.drawString("4", player4xpos[pos44], player4ypos[pos44]+5);
			}
		}
		else if(pos44>=56)
			{
					iplayer4_4.paintIcon(this, g, player4xpos[55], player4ypos[55]-70);	
					win44=true;
			}
		
		if(player4 && moves==1 )
		{
			if(pos41==pos42&& player4_1 && player4_2 &&!win41)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos41]-15, player4ypos[pos41]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,2", player4xpos[pos41]-10, player4ypos[pos41]+5);
				}
			}

			if(pos41==pos43&& player4_1 && player4_3 &&!win41)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos41]-15, player4ypos[pos41]-15, 30, 30);
				g.setColor(Color.black);
			
				g.drawString("1,3", player4xpos[pos41]-10, player4ypos[pos41]+5);
				}
			}

			if(pos41==pos44&& player4_1 && player4_4 &&!win41)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos41]-15, player4ypos[pos41]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("1,4", player4xpos[pos41]-10, player4ypos[pos41]+5);
				}
			}

			if(pos43==pos42&& player4_3 && player4_2 &&!win42)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos43]-15, player4ypos[pos43]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("2,3", player4xpos[pos43]-10, player4ypos[pos43]+5);
				}
			}
			if(pos44==pos42&& player4_4 && player4_2 &&!win42)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos44]-15, player4ypos[pos44]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("2,4", player4xpos[pos44]-10, player4ypos[pos44]+5);
				}
			}
			if(pos43==pos44&& player4_3 && player4_4 &&!win44)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos43]-15, player4ypos[pos43]-15, 30, 30);
				g.setColor(Color.black);
				g.drawString("3,4", player4xpos[pos43]-10, player4ypos[pos43]+5);
				}
			}
			if(pos41==pos42 && pos41==pos43&& player4_1 && player4_2 && player4_3&&!win41)
			{

				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos42]-20, player4ypos[pos42]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,2,3", player4xpos[pos42]-15, player4ypos[pos42]+3);
				}
			}
			if(pos41==pos43 && pos44==pos43&& player4_1 && player4_4 && player4_3&&!win41)
			{

				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos43]-20, player4ypos[pos43]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,3,4", player4xpos[pos41]-15, player4ypos[pos41]+3);
				}
			}
			if(pos41==pos42 && pos41==pos44&& player4_1 && player4_2 && player4_4&&!win41)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos42]-20, player4ypos[pos42]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("1,2,4", player4xpos[pos42]-15, player4ypos[pos42]+3);
				}
			}
			if(pos43==pos42 && pos44==pos43&& player4_2 && player4_3 && player4_4&&!win41)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos42]-20, player4ypos[pos42]-20, 35, 35);
				g.setColor(Color.black);
				g.drawString("2,3,4", player4xpos[pos42]-15, player4ypos[pos42]+3);
				}
			}
			if(pos44==pos32 && pos44==pos43 && pos44==pos41 && player4_1 && player4_4&& player4_2 && player4_3&&!win44)
			{
				if(moves==1 && player4)
				{
				g.setColor(Color.orange);
				g.fillOval(player4xpos[pos44]-25, player4ypos[pos44]-25, 43, 43);
				g.setColor(Color.black);
				g.drawString("1,2,3,4", player4xpos[pos44]-22, player4ypos[pos44]+3);
				}
			}
		}
		
		
			
//		//Dice 
//		g.setColor(Color.orange);
//		
//		g.fillRect(630,40,210,410);
//		Polygon shape=new Polygon();
//		shape.addPoint(660,50);
//		shape.addPoint(750, 50);
//		shape.addPoint(750, 60);
//		shape.addPoint(800, 60);
//		shape.addPoint(800, 110);
//		shape.addPoint(750, 110);
//		shape.addPoint(750, 120);
//		shape.addPoint(660,120);
//		g.setColor(Color.white);
//		g.fillPolygon(shape);
////		
////		
////		dice1=new ImageIcon("dice1.png");
////		dice1.paintIcon(this,g,680,60);
////		
//		
//		dice1button=new JButton();
//		dice1button.setIcon(new ImageIcon("blankdice.png"));
//		dice1button.setBounds(680,30,50,50);
//		add(dice1button);
////		iplayer1.paintIcon(this, g, 760, 70);
//		
		g.setFont(new Font("Serif",Font.BOLD,30));	
		g.setColor(Color.red);
		g.fillRect(620, 50, 260, 60);
		g.setColor(Color.white);
		g.drawString("Player 1", 670, 90);
	
		g.setColor(Color.green);
		g.fillRect(620, 50+65, 260, 60);
		g.setColor(Color.white);
		g.drawString("Player 2",670,90+65);
		
		g.setColor(Color.yellow);
		g.fillRect(620, 50+130, 260, 60);
		g.setColor(Color.white);
		g.drawString("Player 3",670,90+130);
		
		g.setColor(Color.blue);
		g.fillRect(620, 50+195, 260, 60);
		g.setColor(Color.white);
		g.drawString("Player 4",670,90+195);
	
	
		g.setColor(Color.black);
		g.drawRect(819,314,52,52);
		
		
//	
//		g.setColor(Color.white);
//		g.fillRect(620,500,260,100);
//		g.setColor(Color.black);
//		String name=new String();
//		name="";
//		name=randomnum+name;
//		g.drawString(name, 660, 550);
		if(win11 && win12 && win13 && win14 && player1)
		{
			player1=false;
			player2=true;
			player3=false;
			player4=false;
			if(first=="no")
			{
				first="player1";
			}
			else if(second=="no"&&first!="player1")
			{
				second="player1";
			}
			else if(third=="no"&&second!="player1"&&first!="player1")
			{
				third="player1";
			}
			else if(forth=="no"&&third!="player1"&&second!="player1"&&first!="player1")
			{
				forth="player1";
			}
		}
		if(win21 && win22 && win23 && win24&& player2)
		{
			player1=false;
			player2=false;
			player3=true;
			player4=false;
			if(first=="no")
			{
				first="player2";
			}
			else if(second=="no"&&first!="player2")
			{
				second="player2";
			}
			else if(third=="no"&&second!="player2"&&first!="player2")
			{
				third="player2";
			}
			else if(forth=="no"&&third!="player2"&&second!="player2"&&first!="player2")
			{
				forth="player2";
			}
			
		}
		if(win31 && win32 && win33 && win34&& player3)
		{
			player1=false;
			player2=false;
			player3=false;
			player4=true;
			if(first=="no")
			{
				first="player3";
			}
			else if(second=="no"&&first!="player3")
			{
				second="player3";
			}
			else if(third=="no"&&second!="player3"&&first!="player3")
			{
				third="player3";
			}
			else if(forth=="no"&&third!="player3"&&second!="player3"&&first!="player3")
			{
				forth="player3";
			}
			
		}
		if(win41 && win42 && win43 && win44&&player4)
		{
			player1=true;
			player2=false;
			player3=false;
			player4=false;
			if(first=="no")
			{
				first="player4";
			}
			else if(second=="no"&&first!="player4")
			{
				second="player4";
			}
			else if(third=="no"&&second!="player4"&&first!="player4")
			{
				third="player4";
			}
			else if(forth=="no"&&third!="player4"&&second!="player4"&&first!="player4")
			{
				forth="player4";
			}
			
		}
		ifirst=new ImageIcon("1st.png");
		isecond=new ImageIcon("2nd.png");
		ithird=new ImageIcon("3rd.png");
		iforth=new ImageIcon("4th.png");
		if(first=="player1")
		{
			ifirst.paintIcon(this,g,780,50);
		}
		if(second=="player1")
		{
			isecond.paintIcon(this,g,805,50);
		}
		if(third=="player1")
		{
			ithird.paintIcon(this,g,750,10);	
		}
		if(forth=="player1")
		{
			iforth.paintIcon(this,g,805,60);
		}
		if(first=="player2")
		{
			ifirst.paintIcon(this,g,780,50+65);
		}
		if(second=="player2")
		{
			isecond.paintIcon(this,g,805,50+65);
		}
		if(third=="player2")
		{
			ithird.paintIcon(this,g,750,10+65);	
		}
		if(forth=="player2")
		{
			iforth.paintIcon(this,g,805,60+65);
		}
		if(first=="player3")
		{
			ifirst.paintIcon(this,g,780,50+130);
		}
		if(second=="player3")
		{
			isecond.paintIcon(this,g,805,50+130);
		}
		if(third=="player3")
		{
			ithird.paintIcon(this,g,750,10+130);	
		}
		if(forth=="player3")
		{
			iforth.paintIcon(this,g,805,60+130);
		}
		if(first=="player4")
		{
			ifirst.paintIcon(this,g,780,50+195);
		}
		if(second=="player4")
		{
			isecond.paintIcon(this,g,805,50+195);
		}
		if(third=="player4")
		{
			ithird.paintIcon(this,g,750,10+195);	
		}
		if(forth=="player4")
		{
			iforth.paintIcon(this,g,805,60+195);
		}
		g.setColor(Color.orange);
		g.fillRect(620,380,260,40);
		g.setColor(Color.white);
		g.drawString("Choose Runner", 650, 410);
	
	
		
		
		runnerlabel=new JLabel("throw");
		if(moves==1)
		{
			if(player1)
			{
				runner1.setBackground(Color.red);
				runner2.setBackground(Color.red);
				runner3.setBackground(Color.red);
				runner4.setBackground(Color.red);
				runner1.setForeground(Color.white);
				runner2.setForeground(Color.white);
				runner3.setForeground(Color.white);
				runner4.setForeground(Color.white);
				
			}if(player2)
			{
				runner1.setBackground(Color.green);
				runner2.setBackground(Color.green);
				runner3.setBackground(Color.green);
				runner4.setBackground(Color.green);
				runner1.setForeground(Color.white);
				runner2.setForeground(Color.white);
				runner3.setForeground(Color.white);
				runner4.setForeground(Color.white);
				
				
			}if(player3)
			{
				runner1.setBackground(Color.yellow);
				runner2.setBackground(Color.yellow);
				runner3.setBackground(Color.yellow);
				runner4.setBackground(Color.yellow);
				runner1.setForeground(Color.black);
				runner2.setForeground(Color.black);
				runner3.setForeground(Color.black);
				runner4.setForeground(Color.black);
				
			}if(player4)
			{
				runner1.setBackground(Color.blue);
				runner2.setBackground(Color.blue);
				runner3.setBackground(Color.blue);
				runner4.setBackground(Color.blue);
				runner1.setForeground(Color.white);
				runner2.setForeground(Color.white);
				runner3.setForeground(Color.white);
				runner4.setForeground(Color.white);
				
			}
		}
		else
		{
			runner1.setBackground(Color.white);
			runner2.setBackground(Color.white);
			runner3.setBackground(Color.white);
			runner4.setBackground(Color.white);
			runner1.setForeground(Color.black);
			runner2.setForeground(Color.black);
			runner3.setForeground(Color.black);
			runner4.setForeground(Color.black);
		}

		if(player1&&moves==0&&first!="player1" && second!="player1" &&third!="player1" && forth!="player1")
		{
		
			g.setColor(Color.white);
			g.fillRect(798,83,80,25);
			g.setColor(Color.black);
			g.drawString("throw",802,107);			
			
		}
		else if(player2&&moves==0 && first!="player2" && second!="player2" &&third!="player2" && forth!="player2")
		{
			g.setColor(Color.white);
			g.fillRect(798,83+65,80,25);
			g.setColor(Color.black);
			g.drawString("throw",802,107+65);
		}
		else if(player3&&moves==0&&first!="player3" && second!="player3" &&third!="player3" && forth!="player3")
		{
			g.setColor(Color.white);
			g.fillRect(798,83+130,80,25);
			g.setColor(Color.black);
			g.drawString("throw",802,107+130);
		}
		else if(player4&&moves==0&& first!="player4" && second!="player4" &&third!="player4" && forth!="player4")
		{
			g.setColor(Color.white);
			g.fillRect(798,83+65+130,80,25);
			g.setColor(Color.black);
			g.drawString("throw",802,107+65+130);
		}
//		
		if(randomnum==1)
		{
		
			
			label.setIcon(new ImageIcon("dice1.png"));
			
			
		}
		else if(randomnum==2)
		{
			label.setIcon(new ImageIcon("dice2.png"));
			
			
		}
		else if(randomnum==3)
		{
			label.setIcon(new ImageIcon("dice3.png"));
			
		}
			
		else if(randomnum==4)
		{
			label.setIcon(new ImageIcon("dice4.png"));

		}
			
		else if(randomnum==5)
		{
			label.setIcon(new ImageIcon("dice5.png"));
			
		}
			
		else if(randomnum==6)
		{
			label.setIcon(new ImageIcon("dice6.png"));
			
		}
		if(moves==0)
		{

			
			if(player2&&(player1_1||player1_2||player1_3||player1_4))
			{
			label.setIcon(new ImageIcon("blankdice.png"));
			}
			else if(player3&&(player2_1||player2_2||player2_3||player2_4))
			{
			label.setIcon(new ImageIcon("blankdice.png"));
			}
			else if(player4&&(player3_1||player3_2||player3_3||player3_4))
			{
			label.setIcon(new ImageIcon("blankdice.png"));
			}
			else if(player1&&(player4_1||player4_2||player4_3||player4_4))
			{
			label.setIcon(new ImageIcon("blankdice.png"));
			}
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==newgame)
		{
			player1_1=false;
			player1_2=false;
			player1_3=false;
			player1_4=false;
			player2_1=false;
			player2_2=false;
			player2_3=false;
			player2_4=false;
			player3_1=false;
			player3_2=false;
			player3_3=false;
			player3_4=false;
			player4_1=false;
			player4_2=false;
			player4_3=false;
			player4_4=false;
			player1=true;
			player2=false;
			player3=false;
			player4=false;
			pos11=0;
			pos12=0;
			pos13=0;
			pos14=0;
			pos21=0;
			pos22=0;
			pos23=0;
			pos24=0;
			
			pos31=0;
			pos32=0;
			pos33=0;
			pos34=0;
			pos41=0;
			pos42=0;
			pos43=0;
			pos44=0;
			win11=false;
			win12=false;
			win13=false;
			win14=false;
			win21=false;
			win22=false;
			win23=false;
			win24=false;
			win31=false;
			win32=false;
			win33=false;
			win34=false;
			win41=false;
			win42=false;
			win43=false;
			win44=false;
			moves=0;
			first="no";
			second="no";
			third="no";
			forth="no";
			
			
			repaint();
			
		}
		
		if(e.getSource()==dicebutton&&moves==0)
		{
			
			
		randomnum=random.nextInt(6)+1;
//		randomnum=6;
//
//		if(pos41>50 && pos41<=55)
//		{
//			randomnum=1;
//		}
//
//		if(pos42>50 && pos42<=55)
//		{
//			randomnum=1;
//		}
//
//		if(pos43>50 && pos43<=55)
//		{
//			randomnum=1;
//		}
//
//		if(pos44>50 && pos44<=55)
//		{
//			randomnum=1;
//		}
//		
//		
		

	
		moves=1;
		if(randomnum!=6)
		{
			
			
			if((!player1_1 &&!player1_2 && !player1_3 &&!player1_4)&&player1)
			{
				moves=0;
								
			}
			else if((!player2_1 &&!player2_2 &&!player2_3 &&!player2_4)&&player2)
			{
				moves=0;
			
			}
			else if((!player3_1 &&!player3_2 &&!player3_3 &&!player3_4)&&player3)
			{
				moves=0;
	
				
			}
			else if((!player4_1 &&!player4_2 && !player4_3 &&!player4_4)&&player4)
			{
				moves=0;
	
			}
			
		}
		repaint();
		
		
		}
	
		
		if(e.getSource()==runner1&&moves==1)
		{
			
			if(player1)
			{
				
				if(player1_1)
				{
					pos11=pos11+randomnum;
					
					if(randomnum!=6)
					{
					player1=false;
					player2=true;
					player3=false;
					player4=false;
					}
					moves=0;
					
				
						
					if(pos11>56)
					{
						
						moves=0;
						pos11=pos11-randomnum;
						if(player1_2==true || player1_3==true ||player1_4==true)
						{
							moves=1;
							player1=true;
							player2=false;
							player3=false;
							player4=false;
						}
						else
						{
							player1=false;
							player2=true;
							player3=false;
							player4=false;
							moves=0;
								
						}
						if(win12&&win13&&win14)
						{
							moves=0;
						}
					
					
						
						
					}
				
					if(!win11 &&pos11!=8 && pos11 !=21 &&pos11!=34 &&pos11!=47 &&pos11!=0 &&pos11!=13 && pos11!=26 &&pos11!=39  &&pos11<56)
					
					{
					if(!win11 &&player1xpos[pos11]==player2xpos[pos21] &&player1ypos[pos11]==player2ypos[pos21] )
					{
						player2_1=false;
						pos21=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player2xpos[pos22] &&player1ypos[pos11]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player2xpos[pos23] &&player1ypos[pos11]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player2xpos[pos24] &&player1ypos[pos11]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player3xpos[pos31] &&player1ypos[pos11]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player3xpos[pos32] &&player1ypos[pos11]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player3xpos[pos33] &&player1ypos[pos11]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player3xpos[pos34] &&player1ypos[pos11]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player4xpos[pos41] &&player1ypos[pos11]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player4xpos[pos42] &&player1ypos[pos11]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player4xpos[pos43] &&player1ypos[pos11]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(!win11 &&player1xpos[pos11]==player4xpos[pos44] &&player1ypos[pos11]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					}
				
				}
				else if(randomnum==6 )
				{
					player1_1=true;
					
					moves=0;
					
				}
				else
				{
				moves=1;	
				}
				
				
			}
			else if(player2)
			{
				if(player2_1)
				{
					pos21=pos21+randomnum;
					
					if(randomnum!=6)
					{
					player1=false;
					player2=false;
					player3=true;
					player4=false;
					}
					moves=0;
					
					if(pos21>56)
					{
						
						moves=0;
						pos21=pos21-randomnum;
						if(player2_2==true || player2_3==true ||player2_4==true)
						{
							moves=1;
							player1=false;
							player2=true;
							player3=false;
							player4=false;
						}
						if(win22&&win23&&win24)
						{
							moves=0;
						}
					
						
						
					}
					if(!win21 &&pos21!=8 && pos21 !=21 &&pos21!=34 &&pos21!=47 &&pos21!=0 &&pos21!=13 && pos21!=26 &&pos21!=39 && pos21<56)
					
					{
					if(!win21 && player2xpos[pos21]==player1xpos[pos11] &&player2ypos[pos21]==player1ypos[pos11] )
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player1xpos[pos12] &&player2ypos[pos21]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player1xpos[pos13] &&player2ypos[pos21]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player1xpos[pos14] &&player2ypos[pos21]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player3xpos[pos31] &&player2ypos[pos21]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player3xpos[pos32] &&player2ypos[pos21]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player3xpos[pos33] &&player2ypos[pos21]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player3xpos[pos34] &&player2ypos[pos21]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player4xpos[pos41] &&player2ypos[pos21]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player4xpos[pos42] &&player2ypos[pos21]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player4xpos[pos43] &&player2ypos[pos21]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(!win21 && player2xpos[pos21]==player4xpos[pos44] &&player2ypos[pos21]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					}
					
				}
				
				
				
				else if(randomnum==6)
				{
					player2_1=true;
					
					moves=0;

				}
				else
				{
				moves=1;	
				}
				
			
//				
			}
			else if(player3)
			{
				if(player3_1)
				{
					pos31=pos31+randomnum;
					
				if(randomnum!=6)
				{
					player1=false;
					player2=false;
					player3=false;
					player4=true;
				}
				moves=0;
					
					if(pos31>56)
					{
						
						moves=0;
						pos31=pos31-randomnum;
						if(player3_2==true || player3_3==true ||player3_4==true)
						{
							moves=1;
							player1=false;
							player2=false;
							player3=true;
							player4=false;
						}
						if(win32&&win33&&win34)
						{
							moves=0;
						}
					
						
						
						
					}
		
					if(!win31 && pos31!=8 && pos31 !=21 &&pos31!=34 &&pos31!=47 &&pos31!=0 &&pos31!=13 && pos31!=26 &&pos31!=39 &&pos31<56)
					{
					if(!win31 &&player3xpos[pos31]==player1xpos[pos11] &&player3ypos[pos31]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player1xpos[pos12] &&player3ypos[pos31]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player1xpos[pos13] &&player3ypos[pos31]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player1xpos[pos14] &&player3ypos[pos31]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player2xpos[pos21] &&player3ypos[pos31]==player2ypos[pos21])
					{
						player2_1=false;
						pos21=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player2xpos[pos22] &&player3ypos[pos31]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player2xpos[pos23] &&player3ypos[pos31]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player2xpos[pos24] &&player3ypos[pos31]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player4xpos[pos41] &&player3ypos[pos31]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player4xpos[pos42] &&player3ypos[pos31]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player4xpos[pos43] &&player3ypos[pos31]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(!win31 &&player3xpos[pos31]==player4xpos[pos44] &&player3ypos[pos31]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					
					}
				}
				else if(randomnum==6)
				{
					player3_1=true;
					
					moves=0;

				}
				else
				{
				moves=1;	
				}
				
				
			}
			else if(player4)
			{
				if(player4_1)
				{
					pos41=pos41+randomnum;
					
					if(randomnum!=6)
					{
					player1=true;
					player2=false;
					player3=false;
					player4=false;
					}
					moves=0;
					if(pos31>56)
					{
						
						moves=0;
						pos31=pos31-randomnum;
						if(player3_2==true || player3_3==true ||player3_4==true)
						{
							moves=1;
							player1=false;
							player2=false;
							player3=true;
							player4=false;
						}
						if(win32&&win33&&win34)
						{
							moves=0;
						}
					
						
						
						
					}
				
					if(!win14 && pos41!=8 && pos41 !=21 &&pos41!=34 &&pos41!=47 &&pos41!=0 &&pos41!=13 && pos41!=26 &&pos41!=39&&pos41<56)
					{
					if(!win14 && player4xpos[pos41]==player1xpos[pos11] &&player4ypos[pos41]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player1xpos[pos12] &&player4ypos[pos41]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player1xpos[pos13] &&player4ypos[pos41]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player1xpos[pos14] &&player4ypos[pos41]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player2xpos[pos21] &&player4ypos[pos41]==player2ypos[pos21])
					{
						player2_1=false;
				
						pos21=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player2xpos[pos22] &&player4ypos[pos41]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player2xpos[pos23] &&player4ypos[pos41]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player2xpos[pos24] &&player4ypos[pos41]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player3xpos[pos31] &&player4ypos[pos41]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player3xpos[pos32] &&player4ypos[pos41]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player3xpos[pos33] &&player4ypos[pos41]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(!win14 && player4xpos[pos41]==player3xpos[pos34] &&player4ypos[pos41]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					}
				}
				else if(randomnum==6)
				{
					player4_1=true;
					
					moves=0;

				}
				else
				{
				moves=1;	
				}
				
			
			}
		
		repaint();
		}
		else if(e.getSource()==runner2&&moves==1)
		{
			
			if(player1)
			{
				if(player1_2)
				{
					pos12=pos12+randomnum;
				
					if(randomnum!=6)
					{
					player1=false;
					player2=true;
					player3=false;
					player4=false;
					}
					moves=0;
					if(pos12>56)
					{
						
						moves=0;
						pos12=pos12-randomnum;
						if(player1_1==true || player1_3==true ||player1_4==true)
						{
							moves=1;
							player1=true;
							player2=false;
							player3=false;
							player4=false;
						}
						if(win11&&win13&&win14)
						{
							moves=0;
						}
					
					
						
						
					}
					if(!win12 && pos12!=8 && pos12 !=21 &&pos12!=34 &&pos12!=47 &&pos12!=0 &&pos12!=13 && pos12!=26 &&pos12!=39 && pos12<56)
					{
					if(player1xpos[pos12]==player2xpos[pos21] &&player1ypos[pos12]==player2ypos[pos21])
					{
						player2_1=false;
						pos21=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player2xpos[pos22] &&player1ypos[pos12]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player2xpos[pos23] &&player1ypos[pos12]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player2xpos[pos24] &&player1ypos[pos12]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player3xpos[pos31] &&player1ypos[pos12]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player3xpos[pos32] &&player1ypos[pos12]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player3xpos[pos33] &&player1ypos[pos12]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;	
					}
					if(player1xpos[pos12]==player3xpos[pos34] &&player1ypos[pos12]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player4xpos[pos41] &&player1ypos[pos12]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player4xpos[pos42] &&player1ypos[pos12]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player4xpos[pos43] &&player1ypos[pos12]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos12]==player4xpos[pos44] &&player1ypos[pos12]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					}
				}
				else  if(randomnum==6)
				{
					player1_2=true;
					
					moves=0;

				}
				else
				{
				moves=1;	
				}
				
				
			}
			else if(player2)
			{
				if(player2_2)
				{
					pos22=pos22+randomnum;
					if(randomnum!=6)
					{
					player1=false;
					player2=false;
					player3=true;
					player4=false;
					}
					moves=0;
					if(pos22>56)
					{
						
						moves=0;
						pos22=pos22-randomnum;
						if(player2_1==true || player2_3==true ||player2_4==true)
						{
							moves=1;
							player1=false;
							player2=true;
							player3=false;
							player4=false;
						}
						if(win21&&win23&&win24)
						{
							moves=0;
						}
					
						
						
						
					}
					if(!win22 && pos22<56 && pos22!=8 && pos22 !=21 &&pos22!=34 &&pos22!=47 &&pos22!=0 &&pos22!=13 && pos22!=26 &&pos22!=39)
					{
					if(player2xpos[pos22]==player1xpos[pos11] &&player2ypos[pos21]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player1xpos[pos12] &&player2ypos[pos22]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player1xpos[pos13] &&player2ypos[pos22]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player1xpos[pos14] &&player2ypos[pos22]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player3xpos[pos31] &&player2ypos[pos22]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player3xpos[pos32] &&player2ypos[pos22]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player3xpos[pos33] &&player2ypos[pos22]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player3xpos[pos34] &&player2ypos[pos22]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player4xpos[pos41] &&player2ypos[pos22]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player4xpos[pos42] &&player2ypos[pos22]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player4xpos[pos43] &&player2ypos[pos22]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos22]==player4xpos[pos44] &&player2ypos[pos22]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					}
					
				}
				else if(randomnum==6)
				{
					player2_2=true;
					
					moves=0;

				}else
				{
				moves=1;	
				}
				
				
				
			}
			else if(player3)
			{
				if(player3_2)
				{
					pos32=pos32+randomnum;
				if(randomnum!=6)
				{
					player1=false;
					player2=false;
					player3=false;
					player4=true;
				}
					moves=0;
					if(pos32>56)
					{
						
						moves=0;
						pos32=pos32-randomnum;
						if(player3_1==true || player3_3==true ||player3_4==true)
						{
							moves=1;
							player1=false;
							player2=false;
							player3=true;
							player4=false;
						}
						if(win31&&win33&&win34)
						{
							moves=0;
						}
					
					
						
						
					}
					if(!win32 && pos32<56 && pos32!=8 && pos32 !=21 &&pos32!=34 &&pos32!=47 &&pos32!=0 &&pos32!=13 && pos32!=26 &&pos32!=39)
					{
					if(player3xpos[pos32]==player1xpos[pos11] &&player3ypos[pos32]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player1xpos[pos12] &&player3ypos[pos32]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player1xpos[pos13] &&player3ypos[pos32]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player1xpos[pos14] &&player3ypos[pos32]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player2xpos[pos21] &&player3ypos[pos32]==player2ypos[pos21])
					{
						player2_1=false;
						pos21=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player2xpos[pos22] &&player3ypos[pos32]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player2xpos[pos23] &&player3ypos[pos32]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player2xpos[pos24] &&player3ypos[pos32]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player4xpos[pos41] &&player3ypos[pos32]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player4xpos[pos42] &&player3ypos[pos32]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player4xpos[pos43] &&player3ypos[pos32]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos32]==player4xpos[pos44] &&player3ypos[pos32]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					
					}
				}
				else if(randomnum==6)
				{
					player3_2=true;
					
					moves=0;

				}
				else
				{
				moves=1;	
				}
				
			}
			else if(player4)
			{
				if(player4_2)
				{
					pos42=pos42+randomnum;
				if(randomnum!=6)
				{
					player1=true;
					player2=false;
					player3=false;
					player4=false;
				}
					moves=0;
					if(pos42>56)
					{
						
						moves=0;
						pos31=pos31-randomnum;
						if(player4_1==true || player4_3==true ||player4_4==true)
						{
							moves=1;
							player1=false;
							player2=false;
							player3=false;
							player4=true;
						}
						if(win41&&win43&&win44)
						{
							moves=0;
						}
					

						
						
					}
					if(!win42 && pos42<56 && pos42!=8 && pos42!=21 &&pos42!=34 &&pos42!=47 &&pos42!=0 &&pos42!=13 && pos42!=26 &&pos42!=39)
				
					{
					if(player4xpos[pos42]==player1xpos[pos11] &&player4ypos[pos42]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player1xpos[pos12] &&player4ypos[pos42]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player1xpos[pos13] &&player4ypos[pos42]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player1xpos[pos14] &&player4ypos[pos42]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player2xpos[pos21] &&player4ypos[pos42]==player2ypos[pos21])
					{
						player2_1=false;
				
						pos21=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player2xpos[pos22] &&player4ypos[pos42]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player2xpos[pos23] &&player4ypos[pos42]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player2xpos[pos24] &&player4ypos[pos42]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player3xpos[pos31] &&player4ypos[pos42]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player3xpos[pos32] &&player4ypos[pos42]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos42]==player3xpos[pos33] &&player4ypos[pos42]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					
					if(player4xpos[pos42]==player3xpos[pos34] &&player4ypos[pos42]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					}
				}
				else if(randomnum==6)
				{
					player4_2=true;
					moves=0;

				}
				else
				{
				moves=1;	
				}
				
				
			}
		
			repaint();
			
		}
		else if(e.getSource()==runner3&&moves==1)
		{
			
			if(player1)
			{
				if(player1_3)
				{
					pos13=pos13+randomnum;
				if(randomnum!=6)
				{
					
					player1=false;
					player2=true;
					player3=false;
					player4=false;
				}
					moves=0;
					if(pos13>56)
					{
						
						moves=0;
						pos13=pos13-randomnum;
						if(player1_1==true || player1_2==true ||player1_4==true)
						{
							moves=1;
							player1=true;
							player2=false;
							player3=false;
							player4=false;
						}
						if(win11&&win12&&win14)
						{
							moves=0;
						}
					
						
						
					}
					if(!win13 && pos13<56 && pos13!=8 && pos13 !=21 &&pos13!=34 &&pos13!=47 &&pos13!=0 &&pos13!=13 && pos13!=26 &&pos13!=39)
					{
					if(player1xpos[pos13]==player2xpos[pos21] &&player1ypos[pos13]==player2ypos[pos21])
					{
						player2_1=false;
						pos21=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player2xpos[pos22] &&player1ypos[pos13]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player2xpos[pos23] &&player1ypos[pos13]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player2xpos[pos24] &&player1ypos[pos13]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player3xpos[pos31] &&player1ypos[pos13]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player3xpos[pos32] &&player1ypos[pos13]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player3xpos[pos33] &&player1ypos[pos13]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player3xpos[pos34] &&player1ypos[pos13]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player4xpos[pos41] &&player1ypos[pos13]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player4xpos[pos42] &&player1ypos[pos13]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player4xpos[pos43] &&player1ypos[pos13]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos13]==player4xpos[pos44] &&player1ypos[pos13]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					}
					
				}
				else  if(randomnum==6)
				{
					player1_3=true;
					moves=0;
				

				}
				else
				{
				moves=1;	
				}
				
				
			}
			else if(player2)
			{
				if(player2_3)
				{
					pos23=pos23+randomnum;
				if(randomnum!=6)
				{
					player1=false;
					player2=false;
					player3=true;
					player4=false;
				}
					moves=0;
				
					if(pos23>56)
					{
						
						moves=0;
						pos23=pos23-randomnum;
						if(player2_1==true || player2_2==true ||player2_4==true)
						{
							moves=1;
							player1=false;
							player2=true;
							player3=false;
							player4=false;
						}
						if(win21&&win22&&win24)
						{
							moves=0;
						}
					
						
						
					}
					if(!win23 && pos23<56 && pos23!=8 && pos23 !=21 &&pos23!=34 &&pos23!=47 &&pos23!=0 &&pos23!=13 && pos23!=26 &&pos23!=39)
					{
					if(player2xpos[pos23]==player1xpos[pos11] &&player2ypos[pos23]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player1xpos[pos12] &&player2ypos[pos23]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player1xpos[pos13] &&player2ypos[pos23]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player1xpos[pos14] &&player2ypos[pos23]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					
					if(player2xpos[pos23]==player3xpos[pos31] &&player2ypos[pos23]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player3xpos[pos32] &&player2ypos[pos23]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player3xpos[pos33] &&player2ypos[pos23]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player3xpos[pos34] &&player2ypos[pos23]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player4xpos[pos41] &&player2ypos[pos23]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player4xpos[pos42] &&player2ypos[pos23]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player4xpos[pos43] &&player2ypos[pos23]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos23]==player4xpos[pos44] &&player2ypos[pos23]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
				}
				}
				else if(randomnum==6)
				{
					player2_3=true;
					moves=0;

				}
			
				else
				{
				moves=1;	
				}
				
			}
			else if(player3)
			{
				if(player3_3)
				{
					pos33=pos33+randomnum;
				if(randomnum!=6)
				{
					player1=false;
					player2=false;
					player3=false;
					player4=true;
				}
					moves=0;
					if(pos33>56)
					{
						
						moves=0;
						pos32=pos32-randomnum;
						if(player3_1==true || player3_2==true ||player3_4==true)
						{
							moves=1;
							player1=false;
							player2=false;
							player3=true;
							player4=false;
						}
						if(win31&&win32&&win34)
						{
							moves=0;
						}
					
						
						
					}
					if(!win33 && pos33<56 && pos33!=8 && pos33 !=21 &&pos33!=34 &&pos33!=47 &&pos33!=0 &&pos33!=13 && pos33!=26 &&pos33!=39)
					{
					if(player3xpos[pos33]==player1xpos[pos11] &&player3ypos[pos33]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player1xpos[pos12] &&player3ypos[pos33]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player1xpos[pos13] &&player3ypos[pos33]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player1xpos[pos14] &&player3ypos[pos33]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player2xpos[pos21] &&player3ypos[pos33]==player2ypos[pos21])
					{
						player2_1=false;
						pos21=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player2xpos[pos22] &&player3ypos[pos33]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player2xpos[pos23] &&player3ypos[pos33]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player2xpos[pos24] &&player3ypos[pos33]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player4xpos[pos41] &&player3ypos[pos33]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player4xpos[pos42] &&player3ypos[pos33]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player4xpos[pos43] &&player3ypos[pos33]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos33]==player4xpos[pos44] &&player3ypos[pos33]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					
					}
				}
				else if(randomnum==6)
				{
					player3_3=true;
					moves=0;

				}
				else
				{
				moves=1;	
				}
				
			}
			else if(player4)
			{
				if(player4_3)
				{
					pos43=pos43+randomnum;
					if(randomnum!=6)
					{
					player1=true;
					player2=false;
					player3=false;
					player4=false;
					}
					moves=0;
					if(pos43>56)
					{
						
						moves=0;
						pos43=pos43-randomnum;
						if(player4_1==true || player4_2==true ||player4_4==true)
						{
							moves=1;
							player1=false;
							player2=false;
							player3=false;
							player4=true;
						}
						if(win41&&win42&&win44)
						{
							moves=0;
						}
					
						
						
					}	
					if(!win43 && pos43<56 && pos43!=8 && pos43 !=21 &&pos43!=34 &&pos43!=47 &&pos43!=0 &&pos43!=13 && pos43!=26 &&pos43!=39)
					{
					if(player4xpos[pos43]==player1xpos[pos11] &&player4ypos[pos43]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player1xpos[pos12] &&player4ypos[pos43]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player1xpos[pos13] &&player4ypos[pos43]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player1xpos[pos14] &&player4ypos[pos43]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player2xpos[pos21] &&player4ypos[pos43]==player2ypos[pos21])
					{
						player2_1=false;
				
						pos21=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player2xpos[pos22] &&player4ypos[pos43]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player2xpos[pos23] &&player4ypos[pos43]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player2xpos[pos24] &&player4ypos[pos43]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player3xpos[pos31] &&player4ypos[pos43]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player3xpos[pos32] &&player4ypos[pos43]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player3xpos[pos33] &&player4ypos[pos43]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos43]==player3xpos[pos34] &&player4ypos[pos43]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					}
				}
				else if(randomnum==6)
				{
					player4_3=true;
					moves=0;

				}
				else
				{
				moves=1;	
				}
				
			}
			
	
			repaint();
		
		}
		else if(e.getSource()==runner4&&moves==1)
		{
			
			if(player1)
			{
				if(player1_4)
				{
					pos14=pos14+randomnum;
					if(randomnum!=6)
					{
					player1=false;
					player2=true;
					player3=false;
					player4=false;
					}
					moves=0;
					if(pos14>56)
					{
						
						moves=0;
						pos13=pos13-randomnum;
						if(player1_1==true || player1_2==true ||player1_3==true)
						{
							moves=1;
							player1=true;
							player2=false;
							player3=false;
							player4=false;
						}
						if(win11&&win12&&win13)
						{
							moves=0;
						}
					
						
						
					}
					if(!win14 && pos14<56 && pos14!=8 && pos14 !=21 &&pos14!=34 &&pos14!=47 &&pos14!=0 &&pos14!=13 && pos14!=26 &&pos14!=39)
					{
					if(player1xpos[pos14]==player2xpos[pos21] &&player1ypos[pos14]==player2ypos[pos21])
					{
						player2_1=false;
						pos21=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player2xpos[pos22] &&player1ypos[pos14]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player2xpos[pos23] &&player1ypos[pos14]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player2xpos[pos24] &&player1ypos[pos14]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player3xpos[pos31] &&player1ypos[pos14]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player3xpos[pos32] &&player1ypos[pos14]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player3xpos[pos33] &&player1ypos[pos14]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player3xpos[pos34] &&player1ypos[pos14]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player4xpos[pos41] &&player1ypos[pos14]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player4xpos[pos42] &&player1ypos[pos14]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player4xpos[pos43] &&player1ypos[pos14]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
					if(player1xpos[pos14]==player2xpos[pos44] &&player1ypos[pos14]==player2ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=true;
						player2=false;
						player3=false;
						player4=false;
					}
				

					}
				}
				else  if(randomnum==6)
				{
					player1_4=true;
					moves=0;

					
				}
				else
				{
				moves=1;	
				}
				
			}
			else if(player2)
			{
				if(player2_4)
				{
					pos24=pos24+randomnum;
				if(randomnum!=6)
				{
					player1=false;
					player2=false;
					player3=true;
					player4=false;
				}
					moves=0;
					if(pos24>56)
					{
						
						moves=0;
						pos24=pos24-randomnum;
						if(player2_1==true || player2_3==true ||player2_3==true)
						{
							moves=1;
							player1=false;
							player2=true;
							player3=false;
							player4=false;
						}
						if(win21&&win22&&win23)
						{
							moves=0;
						}
					
						
						
					}
					if(!win24 && pos24 <56 && pos24!=8 && pos24!=21 &&pos24!=34 &&pos24!=47 &&pos24!=0 &&pos24!=13 && pos24!=26 &&pos24!=39)
					{
					if(player2xpos[pos24]==player1xpos[pos11] &&player2ypos[pos24]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player1xpos[pos12] &&player2ypos[pos24]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player1xpos[pos13] &&player2ypos[pos24]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player1xpos[pos14] &&player2ypos[pos24]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player3xpos[pos31] &&player2ypos[pos24]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player3xpos[pos32] &&player2ypos[pos24]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player3xpos[pos33] &&player2ypos[pos24]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player3xpos[pos34] &&player2ypos[pos24]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player4xpos[pos41] &&player2ypos[pos24]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player4xpos[pos42] &&player2ypos[pos24]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player4xpos[pos43] &&player2ypos[pos24]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					if(player2xpos[pos24]==player2xpos[pos44] &&player2ypos[pos24]==player2ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=false;
						player2=true;
						player3=false;
						player4=false;
					}
					
				}
				}
				else if(randomnum==6)
				{
					player2_4=true;
					moves=0;

				}
				else
				{
				moves=1;	
				}
					
			}
			else if(player3)
			{
				if(player3_4)
				{
					pos34=pos34+randomnum;
					if(randomnum!=6)
					{
					player1=false;
					player2=false;
					player3=false;
					player4=true;
					}
					moves=0;
					if(pos34>56)
					{
						
						moves=0;
						pos32=pos32-randomnum;
						if(player3_1==true || player3_3==true ||player3_2==true)
						{
							moves=1;
							player1=false;
							player2=false;
							player3=true;
							player4=false;
						}
						if(win31&&win33&&win32)
						{
							moves=0;
						}
					
						
						
					}
					if(!win34 && pos34 <56 && pos34!=8 && pos34!=21 &&pos34!=34 &&pos34!=47 &&pos34!=0 &&pos34!=13 && pos34!=26 &&pos34!=39)
					{
					if(player3xpos[pos34]==player1xpos[pos11] &&player3ypos[pos34]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player1xpos[pos12] &&player3ypos[pos34]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player1xpos[pos13] &&player3ypos[pos34]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player1xpos[pos14] &&player3ypos[pos34]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player2xpos[pos21] &&player3ypos[pos34]==player2ypos[pos21])
					{
						player2_1=false;
						pos21=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player2xpos[pos22] &&player3ypos[pos34]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player2xpos[pos23] &&player3ypos[pos34]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player2xpos[pos24] &&player3ypos[pos34]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player4xpos[pos41] &&player3ypos[pos34]==player4ypos[pos41])
					{
						player4_1=false;
						pos41=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player4xpos[pos42] &&player3ypos[pos34]==player4ypos[pos42])
					{
						player4_2=false;
						pos42=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player4xpos[pos43] &&player3ypos[pos34]==player4ypos[pos43])
					{
						player4_3=false;
						pos43=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;
					}
					if(player3xpos[pos34]==player4xpos[pos44] &&player3ypos[pos34]==player4ypos[pos44])
					{
						player4_4=false;
						pos44=0;
						player1=false;
						player2=false;
						player3=true;
						player4=false;	player1=false;
						player2=false;
						player3=false;
						player4=true;
						
						 repaint();
						
					}
					}

				}
				else if(randomnum==6)
				{
					player3_4=true;
					moves=0;

				}
				else
				{
				moves=1;	
				}
					
			}
			else if(player4)
			{
				if(player4_4)
				{
					pos44=pos44+randomnum;
				if(randomnum!=6)
				{
					
					player1=true;
					player2=false;
					player3=false;
					player4=false;
				}
					moves=0;
					if(pos44>56)
					{
						
						moves=0;
						pos44=pos44-randomnum;
						if(player4_1==true || player4_2==true ||player4_3==true)
						{
							moves=1;
							player1=false;
							player2=false;
							player3=false;
							player4=true;
						}
						if(win41&&win42&&win43)
						{
							moves=0;
						}
					
						
						
					}
					if(!win44 && pos44<56 && pos44!=8 && pos44!=21 &&pos44!=34 &&pos44!=47 &&pos44!=0 &&pos44!=13 && pos44!=26 &&pos44!=39)
					{
					if(player4xpos[pos44]==player1xpos[pos11] &&player4ypos[pos44]==player1ypos[pos11])
					{
						player1_1=false;
						pos11=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player1xpos[pos12] &&player4ypos[pos44]==player1ypos[pos12])
					{
						player1_2=false;
						pos12=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player1xpos[pos13] &&player4ypos[pos44]==player1ypos[pos13])
					{
						player1_3=false;
						pos13=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player1xpos[pos14] &&player4ypos[pos44]==player1ypos[pos14])
					{
						player1_4=false;
						pos14=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player2xpos[pos21] &&player4ypos[pos44]==player2ypos[pos21])
					{
						player2_1=false;
				
						pos21=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player2xpos[pos22] &&player4ypos[pos44]==player2ypos[pos22])
					{
						player2_2=false;
						pos22=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player2xpos[pos23] &&player4ypos[pos44]==player2ypos[pos23])
					{
						player2_3=false;
						pos23=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player2xpos[pos24] &&player4ypos[pos44]==player2ypos[pos24])
					{
						player2_4=false;
						pos24=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player3xpos[pos31] &&player4ypos[pos44]==player3ypos[pos31])
					{
						player3_1=false;
						pos31=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player3xpos[pos32] &&player4ypos[pos44]==player3ypos[pos32])
					{
						player3_2=false;
						pos32=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player3xpos[pos33] &&player4ypos[pos44]==player3ypos[pos33])
					{
						player3_3=false;
						pos33=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					if(player4xpos[pos44]==player3xpos[pos34] &&player4ypos[pos44]==player3ypos[pos34])
					{
						player3_4=false;
						pos34=0;
						player1=false;
						player2=false;
						player3=false;
						player4=true;
					}
					}
				}
				else if(randomnum==6)
				{
					player4_4=true;
					moves=0;

				}
			
				else
				{
				moves=1;	
				}
				
			}
		
			
			repaint();
			
		}

		
		
		if(player1&&moves==0&&e.getSource()==dicebutton)
		{
			
			player1=false;
			player2=true;
			player3=false;
			player4=false;
			
			 repaint();
		
		}
		else if(player2&&moves==0&&e.getSource()==dicebutton)
		{
			player1=false;
			player2=false;
			player3=true;
			player4=false;

			 repaint();
		
		}
		else if(player3&&moves==0&&e.getSource()==dicebutton)
		{
			player1=false;
			player2=false;
			player3=false;
			player4=true;
			
			 repaint();
			
		
		}
		else if(player4&&moves==0&&e.getSource()==dicebutton)
		{
			player1=true;
			player2=false;
			player3=false;
			player4=false;
		
		
		    repaint();
		}
		
		

	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		LudoGame l=new LudoGame("LudoGame");
	
	}

}
