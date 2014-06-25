package mx.uabcs.javaswing;

import java.util.EventObject;

public class FormEvent extends EventObject{

	private String name;
	private String occupation;
	private int ageCategory;
	private int edad;
	private int empleados;
	private String generos;
	private int nacionalidad;
	private String pais;
	
	
	
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public FormEvent(Object source, String name, String occupation,int edad,int empleados,int nacionalidad,
			String pais, int ageCategory, String generos){
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCategory=ageCategory;
		this.edad=edad;
		this.empleados=empleados;
		this.generos=generos;
		this.nacionalidad=nacionalidad;
		this.pais=pais;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(int ageCategory) {
		this.ageCategory = ageCategory;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEmpleados() {
		return empleados;
	}

	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

	public String getGeneros() {
		return generos;
	}

	public void setGeneros(String generos) {
		this.generos = generos;
	}

	public int getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(int nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	

	
	
	
	
	
	
	
}
