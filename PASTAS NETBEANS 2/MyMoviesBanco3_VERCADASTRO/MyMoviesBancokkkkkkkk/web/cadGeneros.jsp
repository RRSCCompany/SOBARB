<%-- 
    Document   : cadGeneros
    Created on : 19/09/2020, 19:46:27
    Author     : juuli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <%@include file="includes/head.jsp" %>
        <title>Cadastro de Generos</title>
    </head>
    <body>
        <%@include file="includes/cabecalho.jsp" %>
        <!-- One -->
        <section id="One" class="wrapper style3">
            <div class="inner">
                <header class="align-center">
                    <p>Inserindo novos mundos!</p>
                    <h2>Cadastro de Gêneros</h2>
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
                            <h2>Lorem ipsum dolor</h2>
                        </header>
                        <form action="GeneroServlet" method="post">
                            <label for="descricao"> Descricao do Gênero: </label>
                            <input type="text" name="descricao"/> 
                            <input type="submit" name="funcao" value="cadastrar"/>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="includes/rodape.jsp" %>
    </body>
</html>
