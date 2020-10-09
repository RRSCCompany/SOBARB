<%-- 
    Document   : cadFilmes
    Created on : 18/09/2020, 11:15:43
    Author     : juuli
--%>

<%@page import="Entidades.Ator"%>
<%@page import="DAOs.DAOAtor"%>
<%@page import="DAOs.DAOGenero"%>
<%@page import="Entidades.Genero"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <%@include file="includes/head.jsp" %>
        <title>Cadastro de Filmes</title>
    </head>
    <body>
        <%@include file="includes/cabecalho.jsp" %>
        <!-- One -->
        <section id="One" class="wrapper style3">
            <div class="inner">
                <header class="align-center">
                    <p>Inserindo novos mundos!</p>
                    <h2>Cadastro de Filmes</h2>
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
                            <h2>Cadastro de Filmes</h2>
                        </header>
                        <form action="FilmeServlet" method="post">
                            <label for="nome"> Nome do Filme: </label>
                            <input type="text" id="nome" name="nome"/>
                            <br />
                            <label for="descricao"> Descricao: </label>
                            <input type="text" id = "descricao" name="descricao"/>
                            <br />
                            <label for="ano"> Ano: </label>
                            <input type="text" id="ano" name="ano"/> 
                            <br />
                            <label for="genero"> Gênero Principal: </label>
                            <select name="genero" id="genero">
                                
                                <%
                                    DAOGenero daoGenero = new DAOGenero();
                                    List<Genero> generos = daoGenero.list();
                                    
                                    for (Genero g: generos){
                                        out.println("<option value='"+g.getId()+"'>"+g.getDescricao()+"</option>");
                                    }
                                    
                                %>                               

                            </select>
                            <br />
                            <label for="atores"> Atores: </label>
                            <select name="atores" id="atores" size="10" multiple>
                                
                            <%
                                DAOAtor daoAtor = new DAOAtor();
                                List<Ator> atores = daoAtor.list();
                                
                                for (Ator a: atores){
                                    out.println("<option value='"+a.getId()+"'>"+a.getNome()+"</option>");
                                }
                            
                            %>
                            </select>
                            
                            <br />
                            <input type="submit" name="funcao" value="cadastrar"/>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="includes/rodape.jsp" %>
    </body>
</html>
