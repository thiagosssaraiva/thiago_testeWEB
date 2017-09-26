<%-- 
    Document   : createDriver
    Created on : 23/09/2017, 20:38:35
    Author     : Thiago
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Motorista</title>
        <link rel="stylesheet" href="css/formulario.css"/>
    </head> 
    <body>
        <c:url value="CreateDriver" var="urlFormulario" />
        <div class="form-contato">
            <form action="${urlFormulario}" method="post" enctype="application/x-www-form-urlencoded">
                <div class="form-group">
                    <label>Nome </label>
                    <input type="text" class="form-control" name="nome"/>
                </div>
                <div class="form-group">
                    <label>Data de nascimento </label>
                    <input type="date" class="form-control" name="dt_nasc"/>
                </div>
                <div class="form-group">
                    <label>CPF</label>
                    <input type="text"  class="form-control" class="form-control"name="cpf"/>
                </div>
                <div class="form-group">
                    <label>Modelo do Carro </label>
                    <input type="text"  class="form-control" class="form-control"name="modelCar"/>
                </div>
                <div class="form-group">
                    <label>Status </label>
                    <select class="form-control" class="form-control"  name="isActive">
                        <option value="0">Ativo</option>
                        <option value="1">Inativo</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Sexo </label>
                    <select class="form-control" class="form-control"  name="sexo">
                        <option value="Masculino">Masculino</option>
                        <option value="Feminino">Feminino</option>
                    </select>
                </div>
                <button type="submit"  class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </body>
</html>