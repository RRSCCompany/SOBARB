<%-- 
    Document   : erro
    Created on : 11/09/2020, 11:05:01
    Author     : juuli
--%>

<%@page import="Entidades.Erro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% String msg = (String) request.getAttribute("msg");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
        <link rel="stylesheet" href="css/personalizar.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp" %>
        <div class="jumbotron transparente content text-center">
        <h2>Sentimos muito pelo transtorno.</h2><br>
        <h3>Erro:</h3>
        <h4><%=msg%></h4>
        </div>
        <%@include file="Estrutura/rodape.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
