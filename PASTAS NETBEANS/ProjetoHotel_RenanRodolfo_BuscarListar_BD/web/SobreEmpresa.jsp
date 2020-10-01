<%-- 
    Document   : SobreEmpresa
    Created on : 05/09/2020, 17:51:03
    Author     : Hotel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sobre a Empresa</title>
    <link href="css/personalizar.css" rel="stylesheet">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/carousel.css" rel="stylesheet">   
    <link href="css/personalizar.css" rel="stylesheet">
    <link href="css/SplitPage.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous"> <%--procabeçalho--%>
    <link rel="shortcut icon" href="Imagens/iconRRR.png">
</head>

<body>
    <%@include file="Estrutura/cabecalho.jsp" %>
   
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
	<ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
	</ol>
	<div class="carousel-inner" role="listbox">
            <div class="item active">
                <img class="first-slide" src="Imagens/slide1.png" alt="First slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1 class="sombra"><b>Atendimento de Qualidade</b></h1>
                        </div>
                    </div>
            </div>
            <div class="item">
                <img class="second-slide" src="Imagens/slide2.png" alt="Second slide">
                    <div class="container">
			<div class="carousel-caption">
                            <h1 class="sombra"><b>E os preços mais acessíveis</b></h1>
			</div>
                    </div>
            </div>				
	</div>
	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
	</a>
    </div>
        
    <div class="jumbotron transparente">    
        <h2 class="text-center">Sobre nós</h2>
        <p class="text-center">
           Fundado nos anos 90, o Hotel tem sido um dos mais completos a receber pessoas em Engenheiro Beltrão. 
           <br>Diversos artistas e empresários já estiveram hospedados 
           e sempre amaram ter se hospedado aqui. 
        </p>
        </div>
       
    <%@include file="Estrutura/rodape.jsp" %>
    <script src="js/jquery.min.js"></script>		
    <script src="js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>