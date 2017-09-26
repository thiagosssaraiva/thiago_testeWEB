<%-- 
    Document   : corrida
    Created on : 26/09/2017, 15:46:13
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    <html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agendar Corridas</title>
    <link rel="stylesheet" href="css/formulario.css"/>
</head> 
<body>
    <c:url value="CorridaDriver" var="urlFormulario" />
    <div class="form-contato">
        <form action="${urlFormulario}" method="post" enctype="application/x-www-form-urlencoded">          
            <div class="form-group">
                <label>Motorista </label>
                <input type="text"  class="form-control" class="form-control" name="motorista" id="motorista"/>
            </div>
            <div class="form-group">
                <label>Passageiro </label>
                <input type="text"  class="form-control" class="form-control" name="passageiro" id="passageiro"/>
            </div>
            <div class="form-group">
                <label>Valor da Corrida</label>
                <input type="text"  class="form-control" class="form-control" name="valor" id="valor"/>
            </div>
            <button type="submit"  class="btn btn-primary">Agendar Corrida</button>
        </form>
    </div>
</body>
</html>