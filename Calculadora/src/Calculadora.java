import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Calculadora {

	JFrame frame = new JFrame ("calculadora");
	JPanel panel = new JPanel (new FlowLayout());// para agrupar los botones
	
	JTextArea text = new JTextArea (1,20);
	
	JButton bot1= new JButton("1");
	JButton bot2= new JButton("2");
	JButton bot3= new JButton("3");
	JButton bot4= new JButton("4");
	JButton bot5= new JButton("5");
	JButton bot6= new JButton("6");
	JButton bot7= new JButton("7");
	JButton bot8= new JButton("8");
	JButton bot9= new JButton("9");
	JButton bot0= new JButton("0");
	
	JButton botsum = new JButton ("+");
	JButton botrest = new JButton ("-");
	JButton botmult = new JButton ("*");
	JButton botdiv = new JButton ("/");
	JButton botigual = new JButton ("=");
	
	public void Calculadora()
	{
		frame.setVisible(true);
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.add(text);
		panel.add(bot1);
		panel.add(bot2);
		panel.add(bot3);
		panel.add(bot4);
		panel.add(bot5);
		panel.add(bot6);
		panel.add(bot7);
		panel.add(bot8);
		panel.add(bot9);
		panel.add(bot0);
		
		panel.add(botsum);
		panel.add(botrest);
		panel.add(botmult);
		panel.add(botdiv);
		panel.add(botigual);
		
	}


	
	
	
	
}
