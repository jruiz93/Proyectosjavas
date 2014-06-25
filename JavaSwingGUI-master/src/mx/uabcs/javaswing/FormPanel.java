package mx.uabcs.javaswing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JLabel jnacionalidad;
	
	private JTextField nameField;
	private JTextField occupationField;
	private JTextField tid;
	
	
	private JButton okBtn;
	private JButton elmBtn;
	private JButton jid;
	private JComboBox empCombo;//crear un cuadro de seleccion en graficos
	private JList ageList;// CREACION DE UNA LISTa
	private JCheckBox box;
	private JLabel namenacionalidad;
	private JTextField fieldnacionalidad;
	private JComboBox empnacion;
	
	private JCheckBox Nacionalidad;

	
	 private DataBaseLayer dbl;
	
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private JRadioButton otherRadio;
	private ButtonGroup genderGroup;

	
	
	private FormListener formListener;
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Nombre: ");
		occupationLabel = new JLabel("Ocupacion: ");
		jnacionalidad=new JLabel("Nacionalidad");
		jid = new JButton("Borrar");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		tid=new JTextField(10);
		//////
		empCombo= new JComboBox();
		empnacion=new JComboBox();
		////
		maleRadio= new JRadioButton("Masculino");
		maleRadio.setActionCommand("Masculino");
		femaleRadio= new JRadioButton("Femenino");
		femaleRadio.setActionCommand("Femenino");
		otherRadio= new JRadioButton("otros");
		otherRadio.setActionCommand("Otros");
		/////////
		namenacionalidad = new JLabel("Nacionalidad:");
		fieldnacionalidad=new JTextField(10);
		
		Nacionalidad= new JCheckBox("MEXICANO");
		box=new JCheckBox();
		
		namenacionalidad = new JLabel("Nacionalidad:");
		fieldnacionalidad=new JTextField(10);
		
		Nacionalidad.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(Nacionalidad.isSelected()){
					
			fieldnacionalidad.setEnabled(false);
				}
			else{
				fieldnacionalidad.setEnabled(true);
				}
					
				
				
				
				
				
				
			}
			
		});
		
		elmBtn = new JButton("Borrar");
		elmBtn.setEnabled(false);
		elmBtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
		//String sql = "delete from trabajador where idTrabajador="+modField.getText();
		//dbl.delQuery(sql);
		}

		});
		
		
		
		genderGroup= new ButtonGroup();
		maleRadio.setSelected(true);
		
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		genderGroup.add(otherRadio);
		
	
		
		
		
		ageList= new JList();//implementacion de la lista
		DefaultListModel ageModel=new DefaultListModel();//para dar valores determinados
		
		dbl = new DataBaseLayer();
		//agregar a las lista
		ageModel.addElement(new ageCategory(29,"18 - 35"));
		ageModel.addElement(new ageCategory(14,"36 - 45"));
		ageModel.addElement(new ageCategory(43,"46 y mas"));
		//////
		ageList.setModel(ageModel);
		ageList.setPreferredSize(new Dimension(110,70));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(0);
		///////////////
		
		DefaultComboBoxModel empModel = new DefaultComboBoxModel ();
		
		if(dbl.isConnected()){
		for(tipo_empleado e:dbl.resultQueryExecttipo_empleado("select * from tipoempleado")){
			empModel.addElement(new EmployeeCategory(e.getIdtipoEmpleado(),e.getEmpleado()));
			empModel.addElement(e);
			
		}
	}
	
		
		DefaultComboBoxModel empModel1 = new DefaultComboBoxModel ();
		
		for(Nacionalidad n: dbl.resultQueryExectNacionaloidad("select * from nacionalidad"))
			empModel1.addElement(new Nacionality(n.getId(),n.getNacion()));
		
		empnacion.setModel(empModel1);
		
		
		
		
		
		
		
		okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = nameField.getText();
				String occupation = occupationField.getText();
				
				//instanciar el objeto
				ageCategory ageCat = (ageCategory)ageList.getSelectedValue();
				tipo_empleado empCat=(tipo_empleado)empCombo.getSelectedItem();
				Nacionality empCat1=( Nacionality)empnacion.getSelectedItem();
			
				String namenacion=fieldnacionalidad.getText();
				String bnacionalidad=Nacionalidad.getText();
				String gender=genderGroup.getSelection().getActionCommand();
				//System.out.println(gender);
				
				int edad=ageCat.getid();
				String Empleados=empCat.toString();
				String generos=gender.toString();
				String pais=gender.toString();
				
				//int nacionalidad=ageCat.getid();
				
				
				
				
				
				
				
			//System.out.println(ageCat.getid());
			//System.out.println(empCat.getid());
				
				
				FormEvent ev = new FormEvent(this, name, occupation,empleados,generos,namenacion,empnacion.getSelectedIndex(),pais);
				
				if(formListener != null) {
					formListener.formEventOcurred(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Agregar Persona");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// acomodacion de los botones en el cuadro
		
		
		//////////// First row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		
		////////////Second row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);
		
		gc.gridy = 1;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);
		
	////////////Third row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridy = 18;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);
		
	////// four row//////////
		
			gc.weightx = 1;
			gc.weighty = 0.2;
			
			gc.gridy = 3;
			gc.gridx = 1;
			gc.anchor = GridBagConstraints.FIRST_LINE_START;
			gc.insets = new Insets(0, 0, 0, 0);
			add(ageList, gc);
			
		////// five row//////////
			
				gc.weightx = 1;
				gc.weighty = 0.2;
				
				gc.gridy = 4;
				gc.gridx = 1;
				gc.anchor = GridBagConstraints.FIRST_LINE_START;
				gc.insets = new Insets(0, 0, 0, 0);
				add(empCombo, gc);
			////// six row//////////
				    gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.05;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(maleRadio, gc);
				////// seven row//////////
				    gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.06;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(femaleRadio, gc);
					////// dose row//////////
				    gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.07;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(otherRadio, gc);
					
				////// eigth row//////////
				    gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.07;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(jid, gc);
				////// once row//////////
				    gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.07;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(tid, gc);
			
				////// eigth row//////////
				   /*
					gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.14;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(Nacionalidad,gc);
					*/
				////// eigth row//////////
				   /*
					gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.14;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(namenacionalidad,gc);
					*/
					////// eigth row//////////
					/*
				    gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.14;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(fieldnacionalidad,gc);
					*/
				////// nine row//////////
				    gc.gridy++;
					gc.weightx = 1;
					gc.weighty = 0.07;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(jnacionalidad, gc);
					
				////// teen row//////////
				    gc.gridy++;
					gc.weightx = 2;
					gc.weighty = 0.16;
					
					gc.gridx = 1;
					gc.anchor = GridBagConstraints.FIRST_LINE_START;
					gc.insets = new Insets(0, 0, 0, 0);
					add(empnacion,gc);
				
				
			
		
		
	}
	
	public void setFormListener(FormListener listener){
		this.formListener = listener;
	}
	
	
}
class ageCategory{			//consulta de base de datos
	
	private int id;
	private String text;
	
	public ageCategory(int id, String text){
		
		this.id=id;
		this.text=text;
	}
	
	
	public String toString(){
		return text;
	}
	
	public int getid(){
		return id;
	}
	
}









class EmployeeCategory{
	
	
	private int id;
	private String text;
	
	public EmployeeCategory(int id,String text){
		
		this.id=id;
		this.text=text;
	}
	public String toString(){
		return text;
	}
	public int getid(){
		return id;
	}
	
}


class Nacionality{
	
	
	private int id;
	private String text;
	
	public Nacionality(int id,String text){
		
		this.id=id;
		this.text=text;
	}
	public String toString(){
		return text;
	}
	public int getid(){
		return id;
	}
	
}
	
	



