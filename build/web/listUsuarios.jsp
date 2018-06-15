<%-- 
    Document   : listUsuarios
    Created on : 15/06/2018, 08:16:36 AM
    Author     : jmedinac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>Id</th>
                            <th>Nombre Usuario</th>
                            <th>Email</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${usuarios}">
                        <tr>
                            <td><c:out value="${usuarios.id}"/></td>
                            <td><c:out value="${usuarios.nombre_usuario}"/></td>
                            <td><c:out value="${usuarios.email}"/></td>
                            <td>
                                <div class="btn-group">
                                    <a href="UsuarioController?action=edit&id=<c:out value="${usuarios.id}"/>" class="btn btn-outline-primary"><i class="fas fa-edit"></i></a>
                                    <a href="UsuarioController?action=delete&id=<c:out value="${usuarios.id}"/>" class="btn btn-outline-primary"><i class="fas fa-edit"></i></a>                                    
                                </div>
                            </td>    
                        </tr>                 
                        </c:forEach>                         
                    </tbody>
                </table>          
    </body>
</html>
