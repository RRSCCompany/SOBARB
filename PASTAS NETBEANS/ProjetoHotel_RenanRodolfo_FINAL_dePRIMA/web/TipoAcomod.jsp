

<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>
<%@page import="Entidades.TipoAcomodacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    TipoAcomodacao tipoacomod = (TipoAcomodacao) request.getAttribute("tipoacomod");
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


            <h2>Dados dos tipos de acomodação: </h2><br>
            <ul>
                <li>
                    ID: <%= tipoacomod.getIdTipo()%>
                </li>
                <li>Tipo da acomodação: <%=tipoacomod.getNomeTipo()%></li>          
            </ul> 
            <form action="ServletTipoAcomod" method="post">
                <input type="hidden" name="id" value="<%=tipoacomod.getIdTipo()%>">
                <input type="submit" name="funcao" value="buscaalterar"/>
                <input type="submit" name="funcao" value="excluir"/>

            </form>
            <br>

        </div>
        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
