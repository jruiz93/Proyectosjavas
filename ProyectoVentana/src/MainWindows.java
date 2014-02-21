import java.awt.BorderLayout;

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
		add(btn);
		this.setVisible(true);
	}	
	public MainWindows()
	{
		
		btn = new JButton("hola mundo grafico");
		setLayout(new BorderLayout());
		//BorderLayout border = new BorderLayout();
		//setLayout(border);
		this.add(btn);
		add(btn,BorderLayout.NORTH);
		add(new TextPanel(),BorderLayout.CENTER);
		add(new JButton("SUR"),BorderLayout.SOUTH);
		add(new JButton("ESTE"),BorderLayout.EAST);
		add(new JButton("OESTE"),BorderLayout.WEST);
		
		
		
		
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
