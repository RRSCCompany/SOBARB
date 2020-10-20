<%-- 
   Document   : Pessoa
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>


<%@page import="Entidades.TipoAcomodacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
        <title>Tipos de acomodações</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Tipos de acomodações</h2><br>
            <%
                List<TipoAcomodacao> tipoacomods = ( List<TipoAcomodacao> ) request.getAttribute("acomodacoes");
                for (TipoAcomodacao ta : tipoacomods) {
                    out.println("<ul>");
                    out.println("<li><a href='ServletTipoAcomod?funcao=buscar&id=" + ta.getIdTipo()+ "'>" +"Id: "+ ta.getIdTipo()+ "</a></li>");
                    out.println("</ul>");
                }
            %>
            <br>
          
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
