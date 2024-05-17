<%-- 
    Document   : RegistrarVenta
    Created on : 5/05/2024, 2:04:19 p. m.
    Author     : plpin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <a href="RegistrarVenta.jsp"></a>
        <title>VENTAS</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display:none;
                }
            }
        </style>
        
    </head>
    <body>
        <div class="d_flex">
            <div class="col-sm-6 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigocliente" value="${cliente.getDni()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${cliente.getNombres()}" placeholder="Datos Cliente" class="form-control">
                                </div>
                            </div>
                            <!--DATOS DEL PRODUCTO-->
                            <div class="form-group">
                                <label>Datos producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoproducto" value="${producto.getIdProducto()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${producto.getNombres()}" placeholder="Datos Producto" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$/.0.00"> 
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cant" value="1" placeholder="" class="form-control">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock " class="form-control">
                                </div>
                            </div>
                            <!--BOTON AGREGAR PRODUCTO AL REGISTRO-->
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                                </div>
                            </div>
                        </div>
                    </form>    
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>Nro.Serie: </label>
                            <input  type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                        <tr>
                                            <td>${list.getItem()}</td>
                                            <td>${list.getIdproducto()}</td>
                                            <td>${list.getDescripcionP()}</td>
                                            <td>${list.getPrecio()}</td>
                                            <td>${list.getCantidad()}</td>
                                            <td>${list.getSubtotal()}</td>
                                            <td class="d-flex">
                                                <a href="Controlador?menu=NuevaVenta&accion=Editar&id=${list.getItem()}" class="btn btn-warning " style="margin-left: 10px">Editar</a>
                                                <a href="Controlador?menu=NuevaVenta&accion=Delete&id=${list.getItem()}" class="btn btn-danger" style="margin-left: 10px">Delete</a>
                                            </td>
                                        </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="row">
                            <div class="col-sm-6">
                                <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                            </div>
                            <div class="col-sm-6 ml-auto d-felx">
                                <label class="col-sm-6 text-right mt-2">Total a Pagar</label>
                                    <input type="text" name="txtTotal" value="$/. ${totalpagar}" class="form-control text-center ">
                            </div>
                        </div>
                    </div>               
                </div>
                
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    </body>
</html>
