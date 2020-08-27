package dao;

import java.util.List;
import model.Empleado;


public interface InterfazDAO {
  public List listar();
  public boolean insertar(Empleado emp);
  public Empleado list(int id);
  public boolean editar(Empleado emp);
  public boolean eliminar(int id);
}
