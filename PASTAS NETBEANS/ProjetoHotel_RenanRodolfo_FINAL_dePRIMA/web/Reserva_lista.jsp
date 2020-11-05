<%-- 
    Document   : Cliente
    Created on : 28/08/2020, 18:24:00
    Author     : Renan
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidades.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOPessoa"%>
<%@page import="DAOs.DAOReserva"%>
<%@page import="Entidades.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Pessoa"%>

<%
    Reserva r = (Reserva) request.getAttribute("reserva");
%>

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
            <h2>Dados da reserva:</h2><br>
            <ul>
                <li>ID da reserva: <%=r.getIdReserva()%></li>
                <li>
                    <%
                        Cliente c = r.getClientePessoaIdPessoa();
                        int re2 = c.getPessoaIdPessoa();
                    %>
                    ID do cliente: <%= re2%>
                </li> 
                <%
                    Date dtreserva = r.getDataReserva();
                    DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                    String dataformatada = dt.format(dtreserva);
                %>
                <li>Data da Reserva: <%=dataformatada%></li>                               
            </ul>
            <form action="ServletReserva" method="post">
                <input type="hidden" name="id" value="<%=r.getIdReserva()%>">
                <input type="submit" name="funcao" value="buscaalterar"/>
                <input type="submit" name="funcao" value="excluir"/>

            </form>
            <br>

            <a href="ServletTipoAcomod?funcao=listar" class="btn btn-dark">Tipo de Acomodações</a>
        </div>
        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
