package dao;

import dbconfig.Conexion;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO implements InterfazDAO {
  private Conexion cn;
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
      
  public EmpleadoDAO() {
    cn = new Conexion();    //se conecta al crear el objeto, desconectar en el "destructor" no en cada metodo
    con=null;
    ps=null;
    rs=null;
  }
  
  public void desconectar() {     //metodo llamado desde el controlador
    try {
      con.close();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  public List listar() {    //devuelve un arraylist con todas las filas de la tabla (cada elemento es un empleado)
    ArrayList<Empleado> lista = new ArrayList<>();
    String sql = "SELECT * FROM empleado";
    
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(sql);      
      rs = ps.executeQuery();
      
      while (rs.next()) {
        Empleado emp = new Empleado();        
        emp.setId(rs.getInt("Id"));     //campos de la tabla
        emp.setNombre(rs.getString("Nombre"));
        emp.setSalario(rs.getDouble("Salario"));        
        lista.add(emp);        
      }      
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    
    return lista;
  }
  
  public boolean insertar(Empleado emp) {
    String sql = "INSERT INTO empleado(Nombre, Salario) VALUES ('" + emp.getNombre() + "', '" + emp.getSalario()+ "')";
    
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(sql);
      ps.executeUpdate();       //inserta en la base de datos      
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    
    return false;
  }
 
  public Empleado list(int id) {     //listar un solo empleado, para el formulario edit
    Empleado emp = new Empleado();
    String sql = "SELECT * FROM empleado WHERE Id=" + id;
    
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      rs.next();      //un resultset empieza fuera, me posiciono en la primera
      emp.setId(rs.getInt("Id"));
      emp.setNombre(rs.getString("Nombre"));
      emp.setSalario(rs.getDouble("Salario"));      
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    
    return emp;
  }
  
  public boolean editar(Empleado emp) {
    String sql = "UPDATE empleado SET Nombre='" + emp.getNombre() + "',Salario='" + emp.getSalario() + "' WHERE Id=" + emp.getId();
    
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(sql);
      ps.executeUpdate();      //actualiza la base de datos
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return false;
  }
  
  public boolean eliminar(int id) {
    String sql = "DELETE FROM empleado WHERE Id=" + id;
    
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(sql);
      ps.executeUpdate();       //elimina de la base de datos      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return false;
  }  
}
