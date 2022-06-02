import java.applet.Applet;
import java.awt.*;
import java.util.*;
/*<applet code="Clock.class" width="300" height="300">  
</applet>*/  
public class Clock extends Applet 
{
        public void init()
	{
		this.setSize(new Dimension(800, 400));
		setBackground(new Color(50, 50, 50));
		new Thread() {
			public void run()
			{
				while (true) {
					repaint();
					delayAnimation();
				}
			}
		}.start();
	}
	private void delayAnimation()
	{
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g)
	{
		Calendar time = Calendar.getInstance();
                int hour = time.get(Calendar.HOUR_OF_DAY);
		int minute = time.get(Calendar.MINUTE);
		int second = time.get(Calendar.SECOND);
		if (hour > 12) {
			hour -= 12;
		}
		g.setColor(Color.white);
		g.fillOval(300, 100, 200, 200);
		g.setColor(Color.black);
		g.drawString("12", 390, 120);
		g.drawString("9", 310, 200);
		g.drawString("6", 400, 290);
		g.drawString("3", 480, 200);
		double angle;
		int x, y;
		angle = Math.toRadians((15 - second) * 6);
		x = (int)(Math.cos(angle) * 100);
		y = (int)(Math.sin(angle) * 100);
		g.setColor(Color.red);
		g.drawLine(400, 200, 400 + x, 200 - y);
		angle = Math.toRadians((15 - minute) * 6);
		x = (int)(Math.cos(angle) * 80);
		y = (int)(Math.sin(angle) * 80);
		g.setColor(Color.blue);
		g.drawLine(400, 200, 400 + x, 200 - y);
		angle = Math.toRadians((15 - (hour * 5)) * 6);
		x = (int)(Math.cos(angle) * 50);
		y = (int)(Math.sin(angle) * 50);
		g.setColor(Color.black);
		g.drawLine(400, 200, 400 + x, 200 - y);
	}
}