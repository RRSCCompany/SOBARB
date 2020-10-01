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
        <h2>Lista de Clientes</h2><br>
        <%
            DAOCliente daocliente = new DAOCliente();
            List<Cliente> clientes = daocliente.listInOrderId();
            for (Cliente c : clientes) {
                out.println("<ul>");
                out.println("<li>ID Pessoa: " + c.getPessoaIdPessoa()+ "</a></li>");
                out.println("<li>Cidade de Origem: " + c.getCidadeOrigem()+ "</a></li>");
                out.println("<li>Cidade de Destino "+c.getCidadeDestino()+"</li>");
                out.println("<li>Data de Cadastro: "+c.getDataCadastro()+"</li>");
                out.println("</ul>");
                List<Pessoa> pessoas = clientes.getPessoaIdPessoa();
                for (Pessoa p : pessoas){
                    out.println("<h4> -> ID: "+p.getIdPessoa()+"</h4>");
                }
                out.println("<br />");
             }
           
         %>
          </div>        
          <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
