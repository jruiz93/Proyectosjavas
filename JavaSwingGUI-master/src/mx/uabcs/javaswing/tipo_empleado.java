package mx.uabcs.javaswing;

public class tipo_empleado {
	private int idtipoEmpleado;
	private String empleado;
	
	public tipo_empleado(int idtipoEmpleado,String empleado){
		this.idtipoEmpleado=idtipoEmpleado;
		this.empleado=empleado;
		
	}

	public int getIdtipoEmpleado() {
		return idtipoEmpleado;
	}

	public void setIdtipoEmpleado(int idtipoEmpleado) {
		this.idtipoEmpleado = idtipoEmpleado;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	
	public String toString(){
		return this.empleado;
	}
	

}
