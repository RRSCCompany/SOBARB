<%-- 
    Document   : home
    Created on : 02/09/2020, 02:59:23
    Author     : juuli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
        <title>Mundo dos Filmes</title>   
    </head>

    <body>
        <%@include file="includes/cabecalho.jsp" %>
        <!-- Banner -->
        <section class="banner full">
            <article>
                <img src="images/slide01.jpg" alt="" />
                <div class="inner">
                    <header>
                        <p>Uma saga épica. Veja mais em <a href="listFilmes.jsp">Todos os Filmes</a></p>
                        <h2>Vingadores</h2>
                    </header>
                </div>
            </article>
            <article>
                <img src="images/slide02.jpg" alt="" />
                <div class="inner">
                    <header>
                        <p>Uma saga épica. Veja mais em <a href="listFilmes.jsp">Todos os Filmes</a></p>
                        <h2>Star Wars</h2>
                    </header>
                </div>
            </article>
            <article>
                <img src="images/slide03.jpg"  alt="" />
                <div class="inner">
                    <header>
                        <p>Um filme incrível. Veja mais em <a href="listFilmes.jsp">Todos os Filmes</a></p>
                        <h2>A Colina Escarlate</h2>
                    </header>
                </div>
            </article>
            <article>
                <img src="images/slide04.jpg"  alt="" />
                <div class="inner">
                    <header>
                        <p>Uma saga épica. Veja mais em <a href="listFilmes.jsp">Todos os Filmes</a></p>
                        <h2>Piratas do Caribe</h2>
                    </header>
                </div>
            </article>
            <article>
                <img src="images/slide05.jpg"  alt="" />
                <div class="inner">
                    <header>
                        <p>Uma das melhores animações de todos os tempos. Veja mais em <a href="listFilmes.jsp">Todos os Filmes</a></p>
                        <h2>Frozen</h2>
                    </header>
                </div>
            </article>
        </section>

        <!-- One -->
        <section id="one" class="wrapper style2">
            <div class="inner">
                <div class="grid-style">
                    <div>
                        <div class="box">
                            <div class="image fit">
                                <img src="images/pic02.jpg" alt="" />
                            </div>
                            <div class="content">
                                <header class="align-center">
                                    <p>Ator de Pantera Negra falece devido ao Covid.</p>
                                    <h2>Chadwick Boseman</h2>
                                </header>
                                <p> Morreu ontem o ator norte-americano Chadwick Boseman, vítima de câncer. Ele tinha 43 anos e ficou conhecido por interpretar o Pantera Negra no cinema. Ele morreu em sua casa, em Los Angeles, nos Estados Unidos, e estava acompanhado de familiares.</p>
                                <footer class="align-center">
                                    <a href="listAtores.jsp" class="button alt">Learn More</a>
                                </footer>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="box">
                            <div class="image fit">
                                <img src="images/pic03.jpg" alt="" />
                            </div>
                            <div class="content">
                                <header class="align-center">
                                    <p>Uma lenda dos cinemas</p>
                                    <h2>Robert John Downey Jr</h2>
                                </header>
                                <p> Robert John Downey, Jr. (Nova Iorque, 4 de abril de 1965) é um ator, cantor, compositor e pianista[1] americano. Estreou como ator em 1970 aos 5 anos, no filme Pound, dirigido por seu pai, Robert Downey, Sr., e desde então tem atuado constantemente em trabalhos para televisão, cinema e ópera.</p>
                                <footer class="align-center">
                                    <a href="listAtores.jsp" class="button alt">Learn More</a>
                                </footer>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Two -->
        <section id="two" class="wrapper style3">
            <div class="inner">
                <header class="align-center">
                    <p>A fantasia e o imaginário andam juntos para tornar visível mundos que existem apenas em nossas mentes.</p>
                    <h2>O Cinema torna real o sonho que ainda nem sonhamos!</h2>
                </header>
            </div>
        </section>

        <!-- Three -->
        <section id="three" class="wrapper style2">
            <div class="inner">
                <header class="align-center">
                    <p class="special">Cada pedaço desse mundo é um universo a parte!</p>
                    <h2>Gêneros</h2>
                </header>
                <div class="gallery">
                    <div>
                        <div class="image fit">
                            <a href="GeneroServlet?funcao=listar"><img src="images/acao.jpg" alt="" /></a>
                        </div>
                    </div>
                    <div>
                        <div class="image fit">
                            <a href="GeneroServlet?funcao=listar"><img src="images/terror.jpg" alt="" /></a>
                        </div>
                    </div>
                    <div>
                        <div class="image fit">
                            <a href="GeneroServlet?funcao=listar"><img src="images/animacao.jpg" alt="" /></a>
                        </div>
                    </div>
                    <div>
                        <div class="image fit">
                            <a href="GeneroServlet?funcao=listar"><img src="images/romance.jpg" alt="" /></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="includes/rodape.jsp" %>
    </body>
</html>
