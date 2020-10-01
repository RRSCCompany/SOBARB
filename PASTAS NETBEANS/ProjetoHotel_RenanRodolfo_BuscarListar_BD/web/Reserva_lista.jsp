<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOPessoa"%>
<%@page import="DAOs.DAOReserva"%>
<%@page import="Entidades.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>
        <div class="jumbotron content transparente">
            <h2>Lista de Reservas</h2><br>
        <%
            DAOReserva daoreserva =new DAOReserva();
            List<Reserva> reservas = daoreserva.listInOrderId();
            for (Reserva r : reservas) {
                out.println("<ul>");
                out.println("<li>ID Reserva: " + r.getIdReserva()+ "</a></li>");
                out.println("<li>Data da Reserva: "+r.getDataReserva()+"</li>");
                out.println("<li>ID Cliente: "+r.getClientePessoaIdPessoa()+"</li>");
                out.println("</ul>");
                List<Pessoa> pessoas = r.getIdReserva();
                for (Pessoa p : pessoas){
                    out.println("<h4> -> ID: "+p.getIdPessoa()+"</h4>");
                }
                out.println("<br />");
             }
             
         %>
        </div>
         <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
