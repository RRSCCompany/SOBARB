

<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>
<%@page import="Entidades.Acomodacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Acomodacao acomodacao = (Acomodacao) request.getAttribute("acomodacao");
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


            <h2>Dados da acomodação: </h2><br>
            <ul>
                <li>
                   ID: <%= acomodacao.getIdAcomodacao()%>
                </li>
                <li>Nome da acomodação: <%=acomodacao.getNomeAcomodacao()%></li>   
                <li>Tipo da acomodação: <%=acomodacao.getTipoAcomodacaoIdTipo()%></li>
            </ul> 
            <form action="ServletAcomod" method="post">
                <input type="hidden" name="id" value="<%=acomodacao.getIdAcomodacao()%>">
                <input type="submit" name="funcao" value="buscaalterar"/>
                <input type="submit" name="funcao" value="excluir"/>
                    
            </form>
            <br>
        
        </div>
        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>

