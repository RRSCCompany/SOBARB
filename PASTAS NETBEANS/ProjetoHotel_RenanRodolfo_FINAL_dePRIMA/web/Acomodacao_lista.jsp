<%-- 
   Document   : Pessoa
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>


<%@page import="Entidades.Acomodacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
        <title>Acomodações</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Acomodações</h2><br>
            <%
                List<Acomodacao> acomods = ( List<Acomodacao> ) request.getAttribute("acomodacoes");
                for (Acomodacao a : acomods) {
                    out.println("<ul>");
                    out.println("<li><a href='ServletAcomod?funcao=buscar&id=" + a.getIdAcomodacao()+ "'>" +"Id: "+ a.getNomeAcomodacao()+ "</a></li>");
                    out.println("</ul>");
                }
            %>
            <br>
          
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
