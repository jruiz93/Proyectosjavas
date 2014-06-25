
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;


public class Teclado extends JPanel implements ActionListener  {
	
	private JButton uno;
	private JButton dos;
	private JButton tres;
	private JButton cuatro;
	private JButton cinco;
	private JButton seis;
	private JButton siete;
	private JButton ocho;
	private JButton nueve;
	private JButton suma;
	private JButton resta;
	private JButton multi;
	private JButton division;
	private JButton igual;
	private JButton punto;
	private JButton cero;
	
	private StringListener textListener;
	private int i=0;
	private String num="";
	String arreglo[]= new String[10];
	
	
	public Teclado (){
		this.setLayout(new GridLayout(4,4,3,3));
	
		siete = new JButton("7");
		ocho = new JButton("8");
		nueve = new JButton("9");
		division = new JButton("/");
		cuatro = new JButton("4");
		cinco = new JButton("5");
		seis = new JButton("6");
		multi = new JButton("*");
		uno = new JButton("1");
		dos = new JButton("2");
		tres = new JButton("3");
		resta = new JButton("-");
		cero = new JButton("0");
		punto = new JButton(".");
		igual = new JButton("=");
		suma = new JButton("+");
		; 
		
		
		
		siete.addActionListener(this);
		ocho.addActionListener(this);
		nueve.addActionListener(this);
		division.addActionListener(this);
		cuatro.addActionListener(this);
		cinco.addActionListener(this);
		seis.addActionListener(this);
		multi.addActionListener(this);
		uno.addActionListener(this);
		dos.addActionListener(this);
		tres.addActionListener(this);
		resta.addActionListener(this);
		cero.addActionListener(this);
		punto.addActionListener(this);
		igual.addActionListener(this);
		suma.addActionListener(this);
		
		
		
		add(siete);
		add(ocho);
		add(nueve);
		add(division);
		add(cuatro);
		add(cinco);
		add(seis);
		add(multi);
		add(uno);
		add(dos);
		add(tres);
		add(resta);
		add(cero);
		add(punto);
		add(suma);
		add(igual);
		
		
		
		
		
		
		
		
		
	}
	public void setStringListener(StringListener listener){
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton Cliked = (JButton) e.getSource();
		
		if(Cliked == uno){
			if(textListener!= null){
				textListener.textEmitted("1");
				 num += ("1");
				
			}
		}
		else if(Cliked==dos){
			if(textListener!= null){
				textListener.textEmitted("2");
				 num += ("2");
				
			}
		}
		else if(Cliked == tres){
			if(textListener!= null){
				textListener.textEmitted("3");
				 num += ("3");
				
			}
		}
		else if(Cliked == cuatro){
			if(textListener!=null){
				textListener.textEmitted("4");
				 num += ("4");
				
			}
		}
		else if(Cliked == cinco){
			if(textListener!= null){
				textListener.textEmitted("5");
				 num += ("5");
				
			}
		}
		else if(Cliked == seis){
			if(textListener!= null){
				textListener.textEmitted("6");
				 num += ("6");
			}
		}
		else if(Cliked == siete){
			if(textListener!= null){
				textListener.textEmitted("7");
				 num += ("7");
			}
		}
		else if(Cliked==ocho){
			if(textListener!=null){
				textListener.textEmitted("8");
				 num += ("8");
			}
		}
		else if(Cliked==nueve){
			if(textListener!=null){
				textListener.textEmitted("9");
				 num += ("9");
			}
		}
		else if(Cliked==cero){
			if(textListener!=null){
				textListener.textEmitted("0");
				 num += ("0");
			}
			else if(Cliked==punto){
				if(textListener!=null){
					textListener.textEmitted(".");
					num +=(".");
				}
			}
			else if(Cliked==suma){
				if(textListener!=null){
					textListener.textEmitted("+");
					arreglo[i]=num;
					i++;
					arreglo[i]="+";	
					i++;
					num="";
				}
			}
			else if(Cliked==resta){
				if(textListener!=null){
					textListener.textEmitted("-");
					arreglo[i]=num;
					i++;
					arreglo[i]="-";	
					i++;
					num="";
				}
			}
			else if(Cliked==multi){
				if(textListener!=null){
					textListener.textEmitted("*");
					arreglo[i]=num;
					i++;
					arreglo[i]="*";	
					i++;
					num="";
				}
			}
			else if(Cliked==division){
				if(textListener!=null){
					textListener.textEmitted("/");
					arreglo[i]=num;
					i++;
					arreglo[i]="/";	
					i++;
					num="";
				}
			}
			else if(Cliked==igual)
			{
				
					arreglo[i]=num;
					String operador;	
					int resultado=0;
					
					
					i=0;
					while(i<arreglo.length){
						
						double num1=0.0;
						double num2=0.0;
						
						//revela la posicion del operador en el arreglo
						int i2=1;
						int ipor=0,iDiv=0,iMas=0,iMenos=0;
						
						while(ipor<arreglo.length && arreglo[ipor]!="*")
							ipor++;
						while(iDiv<arreglo.length && arreglo[iDiv]!="/")
							iDiv++;
						while(iMas<arreglo.length && arreglo[iMas]!="+")
							iMas++;
						while(iMenos<arreglo.length && arreglo[iMenos]!="-")
							iMenos--;
						
						//if(ipor<iDiv)
					}
					
					
			}
			
			
}
		
	
		
		
		
}



	
	
	
	
	

}
