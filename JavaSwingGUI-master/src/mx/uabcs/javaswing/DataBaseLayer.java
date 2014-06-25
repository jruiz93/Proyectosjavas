package mx.uabcs.javaswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseLayer {
	private String sql;
	private Connection conexionbase;
	 private Statement stm;
	 private ResultSet rs;
	
	 private String server="localhost:3306";
	 private String db="Programacion3";
	 private String user="root";
	 private String pwd="sugoi123";
	//constructor
	public DataBaseLayer(){
		
		try {
			//driver
			Class.forName("com.mysql.jdbc.Driver");
			//conexion
			conexionbase=DriverManager.getConnection("jdbc:mysql://"+server+"/"+db,user,pwd);
			stm=conexionbase.createStatement();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public boolean isConnected(){
		
		try {
			return !conexionbase.isClosed();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public void queryExec(String sql){
		try {
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public ArrayList<FormEvent> resultQueryExect(String sql){
		ArrayList<FormEvent> list = new ArrayList<FormEvent>();
		try {
			
			rs=stm.executeQuery(sql);
			while(rs.next()){
				FormEvent item = new FormEvent(this);
				item.setName(rs.getString("nombre"));
				item.getEmpleados();
				item.setEdad(rs.getInt("edad"));
				item.setGeneros(rs.getString("genero"));
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Nacionalidad> resultQueryExectNacionaloidad(String sql){
		ArrayList<Nacionalidad> list = new ArrayList<Nacionalidad>();
		try {
			
			rs=stm.executeQuery(sql);
			while(rs.next()){
				Nacionalidad item = new Nacionalidad(rs.getInt("id"),rs.getString("nacion"));
	
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<tipo_empleado> resultQueryExecttipo_empleado(String sql){
		ArrayList<tipo_empleado> list = new ArrayList<tipo_empleado>();
		try {
			
			rs=stm.executeQuery(sql);
			while(rs.next()){
				tipo_empleado item = new tipo_empleado(rs.getInt("idtipoEmpleado"),rs.getString("empleado"));
	
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
