
public class Liga {
	private int peso;
	private Nodo Origen;
	private Nodo destino;
	
	public Liga(){
		
	}
	public Liga(Nodo Origen,Nodo destino,int peso){
		this.destino=destino;
		this.Origen=Origen;
		this.peso=peso;
		
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Nodo getOrigen() {
		return Origen;
	}

	public void setOrigen(Nodo origen) {
		Origen = origen;
	}

	public Nodo getDestino() {
		return destino;
	}

	public void setDestino(Nodo destino) {
		this.destino = destino;
	}
	
	

}
