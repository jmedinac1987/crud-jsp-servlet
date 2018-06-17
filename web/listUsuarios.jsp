<%-- 
    Document   : listUsuarios
    Created on : 15/06/2018, 08:16:36 AM
    Author     : jmedinac
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css">
        <title>CRUD con JSP, Servlet and MySQL</title>
    </head>
    <body>
                
        <nav class="navbar navbar-dark bg-primary">
                <a href="#" class="navbar-brand">CRUD con JSP, Servlet y MySQL</a>
        </nav>	
                
        <div class="container" style="padding-top: 20px;">
            <a href="UsuarioController?action=create" class="btn btn-outline-primary" style="margin-bottom: 25px;">Crear usuario</a>
            <div class="table-responsive">
                <table class="table" id="crud">
                    <thead class="thead-dark" style="text-align: center;">
                        <tr>
                            <th>Id</th>
                            <th>Nombre Usuario</th>
                            <th>Email</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody style="text-align: center;">
                        <c:forEach var="user" items="${usuarios}">
                        <tr>
                            <td><c:out value="${user.id}"/></td>
                            <td><c:out value="${user.nombre_usuario}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td>
                                <div class="btn-group">
                                  <a href="UsuarioController?action=edit&id=<c:out value="${user.id}"/>" class="btn btn-outline-primary"><i class="fas fa-edit"></i></a>
                                  <a href="UsuarioController?action=delete&id=<c:out value="${user.id}"/>" class="btn btn-outline-danger"><i class="far fa-trash-alt"></i></a>          
                                </div>
                            </td>
                        </tr>                
                        </c:forEach>
                    </tbody>
                </table>          
            </div>
        </div>
        <br />
        
        <footer>
            <p class="text-center" style="color: black;">&copy; 2018 Proyecto con JSP IDE NetBeans</p>
        </footer>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
        <script>
            $(document).ready( function () {
                $('#crud').DataTable({
                    language: {
                                "decimal": "",
                                "emptyTable": "No hay información",
                                "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
                                "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
                                "infoFiltered": "(Filtrado de _MAX_ total entradas)",
                                "infoPostFix": "",
                                "thousands": ",",
                                "lengthMenu": "Mostrar _MENU_ Entradas",
                                "loadingRecords": "Cargando...",
                                "processing": "Procesando...",
                                "search": "Buscar:",
                                "zeroRecords": "Sin resultados encontrados",
                    "paginate": {
                                "first": "Primero",
                                "last": "Ultimo",
                                "next": "Siguiente",
                                "previous": "Anterior"
                                }
                    }
                });
            } );
        </script>
</body>
</html>
