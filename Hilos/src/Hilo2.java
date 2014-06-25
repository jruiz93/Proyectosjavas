
public class Hilo2 extends Thread{
	
	public Hilo2(){
		
		this.start();
		
	}
	public void run(){
		
		for (int i=0; i<5; i++){
			System.out.println("hilo2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
	}


