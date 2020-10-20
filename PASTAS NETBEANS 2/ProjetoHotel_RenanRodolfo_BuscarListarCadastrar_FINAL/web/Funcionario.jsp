<%-- 
   Document   : Pessoa
   Created on : 16/09/2020, 16:24:35
   Author     : presa
--%>

<%@page import="Entidades.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOFuncionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Pessoa"%>
<%@page import="Entidades.Setor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
        <title>Lista de Funcionários</title>
    </head>
    <body>
        <%@include file="Estrutura/cabecalho.jsp"%>

        <div class="jumbotron content transparente">
            <h2>Funcionários</h2><br>
            <%

                List<Funcionario> funcionarios = ( List<Funcionario> ) request.getAttribute("funcionarios");
                for (Funcionario c : funcionarios) {
                    out.println("<ul>");
                    out.println("<li><a href='ServletFuncionario?funcao=buscar&id=" + c.getPessoaIdPessoa()+ "'>" + "Id: "+c.getPessoaIdPessoa()+ "</a></li>");
                    out.println("</ul>");
                }

            %>
            <br>
            <a href="Pessoa_lista.jsp" class="btn btn-dark">Voltar</a>
        </div>

        <%@include file="Estrutura/rodape.jsp"%>
    </body>
</html>
