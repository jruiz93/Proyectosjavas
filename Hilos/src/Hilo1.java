import java.awt.Color;
import java.awt.Graphics;


public class Hilo1 extends Thread {
	Graphics g;

	public Hilo1(){
		this.g=g;
		this.start();// ejecutar el hilo 
	}
	
	// ejecuta lo su queremos que haga el hilo
	public void run (){
		
		this.paint(g);
		
		/*
		for (int i=0; i<5; i++){
			System.out.println("hilo1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
	
	public void paint (Graphics g){
		
	}
	
	
	
	
	
	
	
}
