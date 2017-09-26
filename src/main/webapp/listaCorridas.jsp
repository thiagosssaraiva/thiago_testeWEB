<%-- 
    Document   : listaCorridas
    Created on : 26/09/2017, 16:19:17
    Author     : Thiago
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTA DE CORRIDAS</title>
          <link rel="stylesheet" href="css/formulario.css"/>
    </head>
    <body>
        <h1>Lista de Corridas</h1>
        <table class="table table-striped">
            <tr>
                <th>Motorista</th>
                <th>Passageiro</th> 
                <th>Valor</th>
            </tr>
             <c:forEach items="${lista}" var="c">
                <tr>
                    <td><c:out value="${c.Motorista}" /></td>
                    <td><c:out value="${c.Passageiro}" /></td> 
                    <td><c:out value="${c.Valor}" /></td> 
                </tr>
            </c:forEach> 
        </table>
        <a href="corrida.jsp">Agendar uma nova Corrida</a>
    </body>
</html>
