<%-- 
   Document   : Pessoa
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>

<%@page import="java.util.List"%>
<%@page import="DAOs.DAOPessoa_Manual"%>
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
        <title>Lista Pessoas</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Pessoas</h2><br>
            <%

                List<Pessoa> pessoas = ( List<Pessoa> ) request.getAttribute("pessoas");
                for (Pessoa p : pessoas) {
                    out.println("<ul>");
                    out.println("<li><a href='ServletPessoa?funcao=buscar&id=" + p.getIdPessoa()+ "'>" + p.getNomePessoa()+ "</a></li>");
                    out.println("</ul>");
                }

            %>
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
