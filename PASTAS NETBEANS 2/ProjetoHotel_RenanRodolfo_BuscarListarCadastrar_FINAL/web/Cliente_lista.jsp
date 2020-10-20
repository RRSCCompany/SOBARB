
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>

<%@page import="java.util.List"%>
<%@page import="DAOs.DAOCliente"%>
<%@page import="Entidades.Pessoa"%>
<%@page import="DAOs.DAOCliente"%>
<%@page import="Entidades.Cliente"%>
<%@page import="DAOs.DAOReserva"%>
<%@page import="Entidades.Reserva"%>
<%@page import="java.util.ArrayList"%>

<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>
        <div class="jumbotron content transparente">


            <h2>Dados do cliente: </h2><br>
            <ul>
                <li>
                   ID: <%= cliente.getPessoaIdPessoa()%>
                </li>
                <li>Cidade de origem: <%=cliente.getCidadeOrigem()%></li>
                <li>Cidade de Destino: <%=cliente.getCidadeDestino()%></li>
                <%
                    Date dtcadastro = cliente.getDataCadastro();
                    DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                    String dataformatada = dt.format(dtcadastro);
                %>
                <li>Data de Cadastro: <%=dataformatada%></li>                
            </ul> 
            <br>
            
            <a href="ServletReserva?funcao=listar" class="btn btn-dark">Reservas</a>
        </div>
        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
