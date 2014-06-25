import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainWindows extends JFrame{
	private JButton btn;
	private TextPanel textPanel;
	private Teclado teclado;
	private int altura;
	private int ancho;
	private String titulo="";
	
	public MainWindows(int altura,int ancho,String titulo){
		this.setSize(ancho,altura);
		this.setTitle(titulo);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public MainWindows(){
		
	
		setLayout(new BorderLayout());
		
		teclado = new Teclado();
		btn = new JButton();
		textPanel = new TextPanel();
		
		teclado.setStringListener(new StringListener(){

			@Override
			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				textPanel.appendText(text);
			}
			
		});
		
		
		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textPanel.appendText("CALCULADORA");
				
			}
			
		});
		
		add(teclado,BorderLayout.CENTER);
		add(textPanel,BorderLayout.NORTH);
		//add(btn,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void Mostrar (){
		
		this.setSize(this.ancho,altura);
		this.setTitle(this.titulo);
		this.setVisible(true);
	}
	
	

}
