package mx.uabcs.javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	DataBaseLayer dbl;
	
	
	private ArrayList<FormEvent> myList;
	
	public MainFrame() {
		super("Hello World");
		
		setLayout(new BorderLayout());
		myList = new ArrayList<FormEvent>();
		toolbar = new Toolbar();
		btn = new JButton("Click me");
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		dbl=new DataBaseLayer();
		
		//toolbar.setTextPanel(textPanel);
		toolbar.setArrayList(myList);
		
		toolbar.setStringListener(new StringListener(){
			@Override
			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				textPanel.appendText(text);
			}
		});
		
		toolbar.setArrayFormListener(new ArrayFormListener(){

			@Override
			public void arrayEmitted(ArrayList<FormEvent> lista) {
				// TODO Auto-generated method stub
				if(dbl.isConnected()){
					ArrayList<FormEvent>list = dbl.resultQueryExect("select * from trabajador");
					for(FormEvent f: list ){
						textPanel.appendText("nombre"+f.getName()+":"+"empleado"+f.getEmpleados()+":"+
								"ocupacion"+f.getOccupation()+":"+"edad"+f.getEdad()+":"+"genero"+f.getGeneros()+":"+"nacionalidad"+f.getNacionalidad()+"\n");
					}
					
				}
				
				
				/*for(FormEvent fe: lista){
					
					//System.out.println(fe.getName()+"\n"+fe.getOccupation()+"\n"+fe.getEdad());
					//textPanel.appendText(fe.getName()+"\n"+fe.getOccupation()+"\n"+fe.getEdad()+"\n"+fe.getEmpleados()+"\n"+fe.getGeneros()+"\n"+fe.getNamenacionalidad()+fe.getNacionalidad()+"\n");
				}*/
			}
		});
		
		formPanel.setFormListener(new FormListener(){
			
			@Override
			public void formEventOcurred(FormEvent e) {
				// TODO Auto-generated method stub
				myList.add(e);
				if(dbl.isConnected()){
					String sql="INSERT INTO trabajador(nombre,tipo_empleado_id,ocupacion,edad,genero,nacionalidad_id)"+
							"Values('"+e.getName()+"','"+e.getEmpleados()+"','"+e.getOccupation()+"','"+e.getEdad()+"','"+e.getGeneros()+"','"+e.getNacionalidad()+"')";
					dbl.queryExec(sql);
				}
				//String name = e.getName();
				//String occupation = e.getOccupation();
				//textPanel.appendText(name + ": " + occupation +"\n");
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello\n");
			}
		});
		
		//add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
