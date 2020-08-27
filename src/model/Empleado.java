package model;


public class Empleado {
  private int id;
  private String nombre;
  private double salario;
  
  public Empleado() {
    id=1;    
    nombre="";
    salario=0;
  }

  public Empleado(String nombre, double salario) {
    id = 1;
    this.nombre = nombre;
    this.salario = salario;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
}