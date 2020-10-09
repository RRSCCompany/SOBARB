<%-- 
    Document   : erro
    Created on : 03/09/2020, 16:46:34
    Author     : juuli
--%>

<% String msg = (String) request.getAttribute("msg");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
        <title>Deu ruim</title>
    </head>
    <body>
         <%@include file="includes/cabecalho.jsp" %>
            <!-- One -->
        <section id="One" class="wrapper style3">
            <div class="inner">
                <header class="align-center">
                    <p>Não se preocupe, tente de novo</p>
                    <h2>Deu ruim gente!</h2>
                </header>
            </div>
        </section>

        <!-- Two -->
        <section id="two" class="wrapper style2">
            <div class="inner">
                <div class="box">
                    <div class="content">
                        <header class="align-center">
                            <p>Desculpa, não deu certo.</p>
                            <h2>Erro</h2>
                        </header>
                        <p><%=msg%></p>
                    </div>
                </div>
            </div>
        </section>
         <%@include file="includes/rodape.jsp"%>
    </body>
</html>
