<%-- 
    Document   : Home
    Created on : 4/06/2024, 8:47:00 a. m.
    Author     : plpin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession obj=request.getSession();
if(obj !=null && obj.getAttribute("usuario")!=null){
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <style>
            body {
                background: linear-gradient(to top, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0)),
                    url('img/photo-1604361709763-44f7fc6dd075.jpg') no-repeat center center;
                background-size: cover;
                height: 100vh;
                margin: 0;
            }
        </style>
    </head>
    <body class="bg-light">
        <div class="container-fluid mt-5">
            <div class="jumbotron">
                <h1 class="display-4">Bienvenido</h1>
                <p class="lead">Aquí puedes explorar y gestionar las ventas.</p>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
<%}else{
         request.getRequestDispatcher("error.html").forward(request, response);
        }
%>