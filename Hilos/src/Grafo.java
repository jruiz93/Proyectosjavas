import java.util.ArrayList;


public class Grafo {
	
	ArrayList<Liga> ligas;
	Nodo n;
	
	public Grafo(){
		ligas=new ArrayList<Liga>();
	}
	public void star(String d){
		
	}
	public void addLiga(Liga n){
		ligas.add(n);
	}
	
	public void inicio(String dato){
		for(Liga l: ligas){
			if(n==null && l.getOrigen().getDato()==dato){
				n=l.getOrigen();
				
			}
		}
		
	}
	
	
	public void recorrer(){
		ArrayList<Liga>Adyacentes = new ArrayList<Liga>();
		for(Liga l: ligas){
			
			if(l.getOrigen().getDato()== n.getDato() && l.getDestino().isVisitado()){
				Adyacentes.add(l);
			}
		}
		for(Liga l : ligas){
			if(l.getOrigen().getDato()== n.getDato() && l.getDestino().isVisitado()){
				l.getOrigen().setVisitado(true);
			}
		}
		
		n= pesoMenor(Adyacentes);
		if(Adyacentes.size()>0 && n!=null) {
			this.recorrer();
		}
	}
	
	
	
	
	public Nodo pesoMenor(ArrayList<Liga>coleccion){
		Liga auxL=null;
		for(Liga l: coleccion){
			if(auxL==null){auxL=l;}
		
			if(l.getPeso()<auxL.getPeso()){
			auxL=l;
			
		}
		
	}
	// validacion mientras el destino sea null o no tenga adyacentes	
	if(auxL!=null){
		System.out.println(auxL.getPeso());
		return auxL.getDestino();
	}
	else{
		return null;
	}
}
	
	public void dibujarLiga(Liga l){
		
	}

}
