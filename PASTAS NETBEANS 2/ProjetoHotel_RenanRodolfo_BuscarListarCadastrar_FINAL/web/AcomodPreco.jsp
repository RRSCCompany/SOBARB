

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidades.AcomodacaoPrecoPK"%>
<%@page import="Entidades.AcomodacaoPreco"%>
<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>
<%@page import="Entidades.TipoAcomodacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    AcomodacaoPreco acomodprecoP = (AcomodacaoPreco) request.getAttribute("acomodprecoP");
    AcomodacaoPrecoPK acomodprecoID = (AcomodacaoPrecoPK) request.getAttribute("acomodprecoID");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Preço da acomodação</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>
        <div class="jumbotron content transparente">


            <h2>Preço da acomodação: </h2><br>
            <ul>
                <li>
                   ID: <%= acomodprecoID.getTipoAcomodacaoIdTipo() %>
                </li>
                <%
                    Date dtentrada = acomodprecoID.getData();
                    DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                    String dataformatada = dt.format(dtentrada);
                %>
                <li>
                    Data Entrada: <%=dataformatada%>
                </li>  
                <li>
                    Preço: <%=acomodprecoP.getPreco() %>
                </li>
            </ul> 
            <br>
      
        </div>
        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
