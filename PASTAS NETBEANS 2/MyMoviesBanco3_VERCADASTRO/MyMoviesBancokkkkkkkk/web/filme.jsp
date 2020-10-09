<%-- 
    Document   : filme
    Created on : 03/09/2020, 15:24:38
    Author     : juuli
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Ator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Genero"%>
<%@page import="Entidades.Filme"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Filme filme = (Filme) request.getAttribute("filme");
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
        <title>O Filme em Detalhes</title>
    </head>
    <body>
        <%@include file="includes/cabecalho.jsp" %>
        <!-- One -->
        <section id="One" class="wrapper style3">
            <div class="inner">
                <header class="align-center">
                    <p>Cada pedacinho desse filme aí</p>
                    <h2><%= filme.getNome()%></h2>
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
                            <h2>A História</h2>
                        </header>
                        <p><%=filme.getDescricao()%></p>
                        
                    </div>
                </div>
                <div class="box">
                    <div class="content">
                        <header class="align-center">
                             <p>maecenas sapien feugiat ex purus</p>
                            <h2>Informações</h2>
                        </header>
                        <%
                            Date d = filme.getAno();
                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                            String data_format = df.format(d);
                            
                        %>
                        <p>Ano de Lançamento: <%=data_format%></p> 
                        
                        <%
                            Genero g = filme.getIdGenero();
                            String descricaoGenero = g.getDescricao();
                            //filme.getIdGenero().getDescricao();
                        %>
                        
                        <p>Gêneros:  <%= descricaoGenero%></p>
                      
                        <p> Atores:</p>
                       
                        <%    
                            List<Ator> listaAtores = filme.getAtorList();
                            
                            for (Ator a: listaAtores){
                                out.print("<p><a href='ServletAtor?id="+a.getId()+"'>" + a.getNome() + "</a></p>");
                            }

                        %>
                        
                            
                    </div>
                </div>
            </div>
        </section>
        <%@include file="includes/rodape.jsp" %>
    </body>
</html>