<%-- 
   Document   : Setor
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>

<%@page import="java.util.List"%>
<%@page import="DAOs.DAOSetor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Setor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
        <title>Lista Setores</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Setores</h2><br>
            <%
                List<Setor> setores = ( List<Setor> ) request.getAttribute("setores");
                for (Setor p : setores) {
                    out.println("<ul>");
                    out.println("<li><a href='ServletSetor?funcao=buscar&id=" + p.getIdSetor()+ "'>" + p.getNomeSetor()+ "</a></li>");
                    out.println("</ul>");
                }
            %>
            <br>
        
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
