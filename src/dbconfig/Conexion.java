package dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
  private Connection con;
 
  public Conexion() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
    } catch (Exception e) {
      System.err.println("Error: "+e.getMessage());
    }
  }
  
  public Connection getConexion() {
    return con;
  }
}