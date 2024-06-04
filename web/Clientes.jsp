<%-- 
    Document   : Clientes
    Created on : 5/05/2024, 2:03:42 p. m.
    Author     : plpin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%HttpSession obj=request.getSession();
if(obj !=null && obj.getAttribute("usuario")!=null){
    
%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<div class="d-flex">
    <div class="card col-sm-4">
        <div class="card-body">
            <form action="Controlador?menu=Cliente" method="POST">
                <div class="form-group">
                    <label>DNI</label>
                    <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                </div>
                <div class="form-group">
                    <label>Nombres</label>
                    <input type="text" value="${cliente.getNombres()}" name="txtNombres" class="form-control">
                </div>
                <div class="form-group">
                    <label>Dirección</label>
                    <input type="text" value="${cliente.getDireccion()}" name="txtDireccion" class="form-control">
                </div>
                <div class="form-group">
                    <label>Estado</label>
                    <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control">
                </div>
                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
            </form>
        </div>
    </div>
    <div class="col-sm-8">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>DNI</th>
                <th>NOMBRES</th>
                <th>DIRECCIÓN</th>
                <th>ESTADO</th>
                <th>ACCIONES</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.getIdCliente()}</td>
                    <td>${cliente.getDni()}</td>
                    <td>${cliente.getNombres()}</td>
                    <td>${cliente.getDireccion()}</td>
                    <td>${cliente.getEstado()}</td>
                    <td>
                        <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cliente.getIdCliente()}">Editar</a>
                        <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${cliente.getIdCliente()}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
<%}else{
         request.getRequestDispatcher("error.html").forward(request, response);
        }
%>
