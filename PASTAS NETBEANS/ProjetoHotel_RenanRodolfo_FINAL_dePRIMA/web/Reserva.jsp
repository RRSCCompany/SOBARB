<%-- 
   Document   : Pessoa
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>


<%@page import="Entidades.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOReserva"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
        <title>Lista Reservas</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Reserva</h2><br>
            <%

                List<Reserva> reservas = ( List<Reserva> ) request.getAttribute("reservas");
                for (Reserva r : reservas) {
                    out.println("<ul>");
                    out.println("<li><a href='ServletReserva?funcao=buscar&id=" + r.getIdReserva()+ "'>" +"Id: "+ r.getIdReserva()+ "</a></li>");
                    out.println("</ul>");
                }

            %>
            <br>
         
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
