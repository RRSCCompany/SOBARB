<%-- 
    Document   : ator
    Created on : 03/09/2020, 15:59:23
    Author     : juuli
--%>

<%@page import="Entidades.Ator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Ator ator = (Ator) request.getAttribute("ator");
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
        <title>O Ator</title>
    </head>
    <body>
        <%@include file="includes/cabecalho.jsp" %>
        <!-- One -->
        <section id="One" class="wrapper style3">
            <div class="inner">
                <header class="align-center">
                    <p>Cada pedacinho desse filme aí</p>
                    <h2><%= ator.getNome()%></h2>
                </header>
            </div>
        </section>
         <!-- Two -->
        <section id="two" class="wrapper style2">
            <div class="inner">
                <div class="box">
                    <div class="content">
                        <header class="align-center">
                            <p>maecenas sapien feugiat ex purus</p>
                            <h2>Biografia</h2>
                        </header>
                        <p><%=ator.getBiografia()%></p>
                        
                    </div>
                </div>
                <div class="box">
                    <div class="content">
                        <header class="align-center">
                             <p>Conhecendo melhor <%=ator.getNome()%></p>
                            <h2>Informações</h2>
                        </header>
                        <p>Data de Nascimento: <%=ator.getDataNascimento()%></p> 
                        <p>Cidade Natal: <%=ator.getCidadeNatal()%></p> 
                        <p>Comida Favorita: <%=ator.getComidaFavorita()%></p> 
                    </div>
                </div>
            </div>
        </section>
        <%@include file="includes/rodape.jsp" %>
    </body>
</html>
