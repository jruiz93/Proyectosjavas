
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Hilo1 hilo1 = new Hilo1();
		//Hilo2 hilo2 = new Hilo2();
		Frame f= new Frame();
		Nodo n1 = new Nodo("A",50,50);
		Nodo n2 = new Nodo("B",80,10);
		
		Nodo n3 = new Nodo("C",100,55);
		Nodo n4 = new Nodo("D",130,20);
		
		Nodo n5 = new Nodo("E",150,65);
		Nodo n6 = new Nodo("F",80,80);
		
		Liga l1 = new Liga(n1,n2,10);
		Liga l2 = new Liga(n1,n6,20);
		Liga l3 = new Liga(n1,n3,7);
		
		Liga l4 = new Liga(n2,n4,8);
		Liga l5 = new Liga(n4,n5,16);
		
		Grafo gr = new Grafo();
		gr.addLiga(l1);
		gr.addLiga(l2);
		gr.addLiga(l3);
		gr.addLiga(l4);
		gr.addLiga(l5);
		
		gr.inicio("A");
		gr.recorrer();
		

	}

}
