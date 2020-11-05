

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidades.AcomodacaoPreco"%>
<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>
<%@page import="Entidades.Acomodacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    AcomodacaoPreco acomodacaopreco = (AcomodacaoPreco) request.getAttribute("acomodacaopreco");
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


            <h2>Dados sobre os preços de acomodações: </h2><br>
            <%
                Date dtcadastro = acomodacaopreco.getAcomodacaoPrecoPK().getData();
                DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                String dataformatada = dt.format(dtcadastro);
            %>
            <ul>
                <li>
                    Data de definição: <%=dataformatada%>
                </li>
                <li>Preço da acomodação: <%=acomodacaopreco.getPreco()%></li>   
                <li>Tipo da acomodação: <%= acomodacaopreco.getAcomodacaoPrecoPK().getTipoAcomodacaoIdTipo()%></li>
            </ul> 
            <form action="ServletAcomodPreco" method="post">
                <input type="hidden" name="id" value="<%=dataformatada%>">
                <input type="submit" name="funcao" value="buscaalterar"/>
                <input type="submit" name="funcao" value="excluir"/>

            </form>
            <br>

        </div>
        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>

