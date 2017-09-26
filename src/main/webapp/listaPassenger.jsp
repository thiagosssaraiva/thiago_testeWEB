<%-- 
    Document   : listaPassenger
    Created on : 23/09/2017, 20:38:35
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.teste.WEB.entities.Passenger"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTA DE PASSAGERIOS</title>
          <link rel="stylesheet" href="css/formulario.css"/>
    </head>
    <body>
        <h1>Lista de Passagerios</h1>
        <table class="table table-striped">
            <tr>
                <th>Nome</th>
                <th>CPF</th> 
                <th>Data de Nascimento</th>
            </tr>
             <c:forEach items="${lista}" var="c">
                <tr>
                    <td><c:out value="${c.nome}" /></td>
                    <td><c:out value="${c.cpf}" /></td>
                    <td><c:out value="${c.dt_nasc}" /></td> 
                </tr>
            </c:forEach> 
        </table>
        <a href="createPassenger.jsp">Cadastrar Novo Passageiro</a>
    </body>
</html>

