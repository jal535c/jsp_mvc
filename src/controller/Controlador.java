package controller;

import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empleado;
import dao.EmpleadoDAO;


@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
    
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String listar = "view/listar.jsp";
    String insertar = "view/insertar.jsp";
    String editar = "view/editar.jsp";
    
    Empleado emp = new Empleado();
    EmpleadoDAO dao = new EmpleadoDAO();
    int id;
    
    String acceso="";
        
    String action=request.getParameter("accion");    
    if (action.equalsIgnoreCase("listar")) {
      acceso=listar;
      
    } else if (action.equalsIgnoreCase("add")) {
      acceso=insertar;
    
    } else if (action.equalsIgnoreCase("Agregar")) {  //boton submit del formulario insertar
      String nom = request.getParameter("txtNom");
      double sal = Double.parseDouble(request.getParameter("txtSal"));      
      emp.setNombre(nom);
      emp.setSalario(sal);      
      dao.insertar(emp);
      acceso=listar;
    
    } else if (action.equalsIgnoreCase("editar")) {      
      id = Integer.parseInt(request.getParameter("id"));    //recupera el id para mostrar ese empleado en el formulario
      emp = dao.list(id);
      request.setAttribute("rqEmp", emp);            //comparte datos con variable request
      acceso=editar;
    
    } else if (action.equalsIgnoreCase("Actualizar")) {   //boton submit del formulario editar
      id=Integer.parseInt(request.getParameter("txtId"));
      String nom = request.getParameter("txtNom");
      Double sal = Double.parseDouble(request.getParameter("txtSal"));      
      emp.setId(id);
      emp.setNombre(nom);
      emp.setSalario(sal);      
      dao.editar(emp);      //metodo para actualizar la base de datos
      acceso=listar;
      
    } else if (action.equalsIgnoreCase("eliminar")) {
      id = Integer.parseInt(request.getParameter("id"));      
      dao.eliminar(id);
      acceso=listar;
    }
    
    request.setAttribute("rqTodos", dao.listar());
    dao.desconectar();    
    
    RequestDispatcher vista = request.getRequestDispatcher(acceso);
    vista.forward(request, response);
    
  }
}
