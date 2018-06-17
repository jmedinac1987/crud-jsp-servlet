<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <title>Conexión a Mysql</title>
    </head>
   
    <body>
        
        <nav class="navbar navbar-dark bg-primary">
                <a href="" class="navbar-brand">CRUD con JSP, Servlet y MySQL</a>
        </nav>
        
        <div class="container" style="padding-top: 20px; ">
            <h2 class="display-4">Eliminar</h2>
            <a id="return" href="#" class="btn btn-ligth"><i class="fa fa-backward"> Regresar</i></a>
        </div>
        
        <div class="container" style="padding-top: 20px; ">
            <div class="card">
                <div class="card-body">                    
                    <form method="POST" name="formCreateUser" class="needs-validation" novalidate>                                                
                        <input hidden="true" readonly="readonly" name="id" value="<c:out value="${user.id}"/>">
                        <div class="form-group">
                            <label for="nombre">Nombre Usuario: </label>
                            <input class="form-control" id="nombre_usuario" name="nombre_usuario" type="text" value="<c:out value="${user.nombre_usuario}"/>" placeholder="Ingrese su nombre de usuario" required  disabled="true">
                        </div>
                        <div class="form-group">
                            <label for="email">E-mail: </label>
                            <input class="form-control" id="email" name="email" type="email" value="<c:out value="${user.email}"/>" placeholder="example@example.com" required  disabled="true">
                        </div>
                        <br/>    
                        <div class="form-group">
                            <input type="submit" id="enviar" class="btn btn-outline-danger btn-block" name="eliminar" value="Eliminar">                            
                        </div>
                    </form>
                </div>
            </div>
       </div>                        
    </body>
    <br />
    <footer>
        <p class="text-center" style="color: black;">&copy; 2018 Proyecto con JSP IDE NetBeans</p>
    </footer>
    
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script>        
        (function() {
          'use strict';
          window.addEventListener('load', function() {        
            var forms = document.getElementsByClassName('needs-validation');        
            var validation = Array.prototype.filter.call(forms, function(form) {
              form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }
                form.classList.add('was-validated');
              }, false);
            });
          }, false);
        })();
        
        $('#return').click(function(){
           history.back(); 
           console.log("ingreso");
        });
    </script>
</html>
