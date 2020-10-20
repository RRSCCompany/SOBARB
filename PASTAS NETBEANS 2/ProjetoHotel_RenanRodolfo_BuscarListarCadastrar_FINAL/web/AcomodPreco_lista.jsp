<%-- 
   Document   : Pessoa
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>


<%@page import="Entidades.AcomodacaoPreco"%>
<%@page import="Entidades.AcomodacaoPrecoPK"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meap http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://sapckpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
        <title>Preço das acomodações</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Preço das acomodações</h2><br>
            <%
                List<AcomodacaoPrecoPK> precoacomods = ( List<AcomodacaoPrecoPK> ) request.getAttribute("precoacomods");
                for (AcomodacaoPrecoPK ap : precoacomods) {
                    out.println("<ul>");
                    out.println("<li><a href='ServletAcomodPreco?funcao=buscar&id=" + ap.getTipoAcomodacaoIdTipo()+ "'>" +"Id: "+ ap.getTipoAcomodacaoIdTipo()+ "</a></li>");
                    out.println("</ul>");
                }
            %>
            <br>
           
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
