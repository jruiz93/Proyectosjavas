import javax.swing.JButton;// creacion de botones
import javax.swing.JFrame;// creacion de ventanas
public class MainWindows extends JFrame {
	private int altura=0;
	private int ancho=0;
	private String titulo="";
	JButton btn;
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
		btn = new JButton("hola mundo grafico");
		//add(btn);
		this.add(btn);
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
