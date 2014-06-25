import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;



public class Frame extends JFrame implements Runnable{
	public int x=50;
	public int y=50;
	//public static Graphics g2;
	
	public Frame(){
		
		this.setSize(400,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread h= new Thread(this);
		h.start();
		
		
		
	}

	public void paint(Graphics g){
		g.drawLine(50, 50, x, y);
		
		
		
		
		
		
		
		/*
		try {
			for(int p=50;p<=200;p+=10)
			{
				g.drawLine(50,50,p,p);
				Thread.sleep(500);
				
			}
				
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int p=50;p<=200;p+=1)
			{
				x=p;
				y=p;
				repaint();
				System.out.println(p);
				Thread.sleep(30);
			}
				
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
		
	

}
