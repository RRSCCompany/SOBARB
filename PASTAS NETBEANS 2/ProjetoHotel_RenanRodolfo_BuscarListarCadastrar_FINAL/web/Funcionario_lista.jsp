

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOFuncionario"%>
<%@page import="Entidades.Pessoa"%>
<%@page import="Entidades.Setor"%>
<%@page import="DAOs.DAOFuncionario"%>
<%@page import="Entidades.Funcionario"%>
<%--<%@page import="DAOs.DAOReserva"%>
<%@page import="Entidades.Reserva"%>--%>
<%@page import="java.util.ArrayList"%>

<%
    Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>
        <div class="jumbotron content transparente">


            <h2>Dados do funcionario: </h2><br>
            <ul>
                <li>
                    ID do funcionario: <%= funcionario.getPessoaIdPessoa()%>
                </li>
                <li>ID do setor:
                    <%=funcionario.getSetorIdSetor()%>
                </li>
                <li>Contato: <%=funcionario.getContato()%></li>
                <%
                    Date dtcontratacao = funcionario.getDataContratacao();
                    DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                    String dataformatada = dt.format(dtcontratacao);
                %>
                <li>Data de contratação: <%=dataformatada%></li>

            </ul> 
            <br>
            <a href="Funcionario_lista.jsp" class="btn btn-dark">Voltar</a><a href="ServletSetor?funcao=listar" class="btn btn-dark">Reservas</a>
        </div>
        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
