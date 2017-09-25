<%-- 
    Document   : lista
    Created on : 23/09/2017, 20:38:35
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.teste.WEB.entities.Driver"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTA</title>
          <link rel="stylesheet" href="css/bootstrap.css"/>
    </head>
    <body>
        <h1>Lista de CONTATOS</h1>
        <table class="table table-striped">
            <tr>
                <th>Nome</th>
                <th>Data de nascimento</th> 
                <th>Telefone</th>
                <th>Email</th>
                <th>Data cadastro</th>
            </tr>
             <c:forEach items="${lista}" var="c">
                <tr>
                    <td><c:out value="${c.nome}" /></td>
                    <td><c:out value="${c.data_nascimento}" /></td> 
                    <td><c:out value="${c.telefone}" /></td> 
                    <td><c:out value="${c.email}" /></td> 
                    <td><c:out value="${c.data_cadastro}" /></td> 
                </tr>
            </c:forEach> 
        </table>
        <a href="createDriver.jsp">Cadastrar Novo Motorista</a>
    </body>
</html>
