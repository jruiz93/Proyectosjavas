import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class CustonWindgetText extends JPanel{
	JTextArea text;
	
	public  CustonWindgetText()
	{
		setLayout(new BorderLayout());
		
		text= new JTextArea(3,1);
		
		add(text,BorderLayout.NORTH);
		
	}

}
