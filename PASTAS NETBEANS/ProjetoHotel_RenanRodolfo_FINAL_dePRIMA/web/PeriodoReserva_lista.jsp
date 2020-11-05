<%-- 
   Document   : Pessoa
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>


<%@page import="Entidades.PeriodoReservaPK"%>
<%@page import="Entidades.PeriodoReserva"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
        <title>Período de Reserva</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Períodos de Reservas</h2><br>
            <%
                List<PeriodoReserva> periods = ( List<PeriodoReserva> ) request.getAttribute("periodoreservas");
                for (PeriodoReserva a : periods) {
                    out.println("<ul>");
                    out.println("<li>Número de dias: "+a.getPeriodoReservaPK().getDataReserva()+";  Id da Reserva: "+ a.getPeriodoReservaPK().getReservaIdReserva()+";  Id da Acomodação: "+a.getPeriodoReservaPK().getApartamentoIdApartamento()+"</li>");
                    out.println("</ul>");
                }
            %>
            <br>
          
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
