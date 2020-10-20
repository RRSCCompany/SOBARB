<%@page import="Entidades.Equipamento"%>

<%@page import="DAOs.DAOEquipamento"%>

<%@page import="java.util.ArrayList"%>
<%
    Equipamento e = (Equipamento) request.getAttribute("equipamento");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipamento</title>
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp" %>
        <div class="jumbotron content transparente">
            <h2>Dados do equipamento: <%=e.getIdEquipamento()%></h2><br>
            <ul>
                <li>ID: <%=e.getIdEquipamento()%></li>
                <li>Nome: <%=e.getNomeEquipamento()%></li>

            </ul>
            <br>
          
  
        </div>
        <%@include file="Estrutura/rodape.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
