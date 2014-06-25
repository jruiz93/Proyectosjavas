package mx.uabcs.javaswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseLayer//capa de base de datos 
{
	private String sql;
	private Connection conn;
	private Statement stm;
	////
	private ResultSet rs;//objecto guardar resultado de la base de datos
	/////
	
	/*
	private ArrayList<FormEvent> lista=new ArrayList<FormEvent>();
	
	public ArrayList<FormEvent> getLista() {
		return lista;
	}
	*/
	
	private String server = "localhost";
	private String db = "programacion3";
	private String user="root";
	private String pwd="sugoi123";
	
	
	//contructor
	public DataBaseLayer()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");//driver
			conn= DriverManager.getConnection("jdbc:mysql://" + server + "/" +db,user,pwd);//conexion
			stm = conn.createStatement();
			if(conn!=null)
			{
				System.out.println("conexion establecida");
			}
			else
			{
				System.out.println("fallo conexion");
			}
		} catch (ClassNotFoundException e) {//driver
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//paquetes,
		 catch (SQLException e) {//conexion
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//adeonde conectar
		
	}
	
	
	public boolean isConnected(){//saber si la coenxion esta abierta o no esta abierta
		
		try {
			return !conn.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void queryExect(String sql){//pasar parametro a la base de datos
		try {
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/////////////
	
	/*
	public void resultQueryExec()//traer los datos de la base de datos
	{
		
		try {
			rs = stm.executeQuery("select * from trabajador");
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		try {
			
			while(rs.next()){				
				
				lista.add(new FormEvent(this,rs.getString("nombre"),
				rs.getString("ocupacion"),"80",rs.getString("tipo_empleado"),
				rs.getString("genero"),rs.getString("pais"), db));		
				
				
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
	}
	*/
	
	
	
	public ArrayList<FormEvent> resultQueryExec(String sql){//recorra la lista
	
		ArrayList<FormEvent> list = new ArrayList<FormEvent>();
		try {
			rs = stm.executeQuery(sql);
			while(rs.next()){
				FormEvent item = new FormEvent(this);
				//item.setId(rs.getInt("id"));
				item.setAgeCategory(rs.getString("tipo_empleado"));
				item.setName(rs.getString("nombre"));
				item.setOccupation(rs.getString("ocupacion"));
				item.setDefaNa(rs.getString("edad"));
				item.setGenero(rs.getString("genero"));
				item.setNacion(rs.getString("pais"));
				
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
