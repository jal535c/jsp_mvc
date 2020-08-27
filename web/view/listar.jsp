<%-- 
    Document   : listar
    Created on : 21-ago-2020, 19:11:32
    Author     : Juan
--%>

<%@page import="java.util.List"%>

<%@page import="model.Empleado"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
  </head>
  
  <body>
    <div class="container">
      <h1>Empleados</h1>
      <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo</a>
      <br>
      <br>
      <table class="table table-bordered">
        <thead>
          <tr>
            <th class="text-center">ID</th>
            <th class="text-center">NOMBRE</th>
            <th class="text-center">SALARIO</th>
            <th class="text-center">ACCION</th>
          </tr>
        </thead>
        <tbody>
          
          <%                                     
            List<Empleado> list = (List<Empleado>)request.getAttribute("rqTodos");    //recupera variable request
            for (Empleado emp : list) {
              
          %>
               
          <tr>
            <td class="text-center"><%= emp.getId()%></td>
            <td class="text-center"><%= emp.getNombre()%></td>
            <td class="text-center"><%= emp.getSalario()%></td>
            <td class="text-center">
              <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= emp.getId()%>">Editar</a>
              <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= emp.getId()%>">Borrar</a>
            </td>
          </tr>
        
          <%
            }         
          %>
        </tbody>
      </table>
    </div>
  </body>
</html>
