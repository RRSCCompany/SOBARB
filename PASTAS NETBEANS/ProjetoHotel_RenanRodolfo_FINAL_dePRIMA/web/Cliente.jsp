<%-- 
   Document   : Pessoa
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>

<%@page import="Entidades.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
        <title>Lista Clientes</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Clientes</h2><br>
            <%

                List<Cliente> clientes = ( List<Cliente> ) request.getAttribute("clientes");
                for (Cliente c : clientes) {
                    out.println("<ul>");
                    out.println("<li><a href='ServletCliente?funcao=buscar&id=" + c.getPessoaIdPessoa()+ "'>" + "Id: "+c.getPessoaIdPessoa()+ "</a></li>");
                    out.println("</ul>");
                }

            %>
            <br>
         
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
