<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
        <%@include file="Estrutura/cabecalho.jsp" %>
        <div class="jumbotron content transparente">
            <h2>Dados da pessoa: <%=p.getNomePessoa()%></h2><br>
            <ul>
                <li>ID: <%=p.getIdPessoa()%></li>
                <li>Nome: <%=p.getNomePessoa()%></li>
                <li>CPF: <%=p.getCpfPessoa()%></li>
                <%
                    Date dtnascimento = p.getDataNascimento();
                    DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                    String dataformatada = dt.format(dtnascimento);
                %>
                <li>Data: <%=dataformatada%></li>
            </ul>
            <br>
            <form action="ServletPessoa" method="post">
                <input type="hidden" name="id" value="<%=p.getIdPessoa()%>">
                <input type="submit" name="funcao" value="buscaalterar"/>
                <input type="submit" name="funcao" value="excluir"/>
                    
            </form>
            <a href="ServletPessoa?funcao=listar" class="btn btn-dark">Voltar</a>
            <a href="ServletCliente?funcao=listar" class="btn btn-dark">Clientes</a>
            <a href="ServletSetor?funcao=listar" class="btn btn-dark">Setor</a>
            <a href="ServletEquipamento?funcao=listar" class="btn btn-dark">Equip</a>
  
        </div>
        <%@include file="Estrutura/rodape.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
