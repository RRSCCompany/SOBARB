<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>

<%@page import="DAOs.DAOPessoa"%>
<%@page import="Entidades.Pessoa"%>
<%@page import="java.util.ArrayList"%>
<%
    Pessoa p = (Pessoa) request.getAttribute("pessoa");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pessoa</title>
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark noBorder transparente">
            <div class="container">
                <a class="navbar-brand txt" href="index.jsp">Hotel Vitória Régia</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarsExample07">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">   
                            <a class="nav-link" href="Reserva_lista.jsp">Reserva</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Cliente_lista.jsp">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ServletPessoa?funcao=listar">Lista de Pessoas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cadPessoa.jsp">Cadastro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="SobreEmpresa.jsp">Sobre Empresa</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Contato.jsp">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="jumbotron content transparente">
            <h2>Dados -> <%=p.getNomePessoa()%></h2><br>
            <ul>
                <li>ID: <%=p.getIdPessoa()%></li>
                <li>Nome: <%=p.getNomePessoa()%></li>
                <li>CPF: <%=p.getCpfPessoa()%></li>
                <li>Data: <%=p.getDataNascimento()%></li>
            </ul>
        </div>
        <%@include file="Estrutura/rodape.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
