<%-- 
    Document   : editar
    Created on : 23-jun-2020, 10:54:48
    Author     : Juan
--%>

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
    
    <%            
      Empleado emp = (Empleado)request.getAttribute("rqEmp");
    %>
    
    <div class="container">      
      <div class="col-lg-6">    
        <h1>Modificar Empleado</h1>
        <form action="Controlador">
          Nombre:<br>
          <input class="form-control" type="text" name="txtNom" value="<%= emp.getNombre()%>"><br>
          Salario:<br>
          <input class="form-control" type="text" name="txtSal" value="<%= emp.getSalario()%>"><br>
          <input type="hidden" name="txtId" value="<%= emp.getId()%>">      <!-- envio el id al controlador por campo hidden -->
          <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
          <a class="btn btn-info" href="Controlador?accion=listar">Volver</a>
        </form>
      </div>      
    </div>
    
  </body>
</html>
