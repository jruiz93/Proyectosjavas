import javax.swing.JFrame;
public class MainWindows extends JFrame {
	private int altura;
	private int ancho;
	private String titulo="";
	public MainWindows (int ancho,int altura,String titulo)
	{
		this.setSize(ancho,altura);
		this.setTitle(titulo);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public MainWindows()
	{
		this.setSize(ancho,altura);
		this.setTitle(titulo);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setaltura(int altura)
	{
		this.altura=altura;
	}
	public void setancho(int ancho)
	{
		this.ancho=ancho;
	}
	public void settitulo(String titulo)
	{
		this.titulo=titulo;
	}
	public void mostrar()
	{
		this.setSize(this.ancho,altura);
		this.settitulo(this.titulo);
		this.setVisible(true);
		
		
	}

}
