<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Hotel Vitória Régia</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens/iconRRR.png">
    </head>
    <body class="transparente">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark noBorder">
            <div class="container">
                <a class="navbar-brand txt" href="">Hotel Vitória Régia</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarsExample07">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">

                            <a class="nav-link" href="Reserva_lista.jsp">Reserva</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Cliente_lista.jsp">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ServletPessoa?funcao=listar">Lista de Pessoas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cadPessoa.jsp">Cadastro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="SobreEmpresa.jsp">Sobre Empresa</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Contato.jsp">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="jumbotron content">
            <div class="text-center">
                <h1> Página de erro de DW II</h1>
                <br>
                <br>
                <p>
                    Alunos: Renan Guensuke Aoki Sakashita<br>RA:1903934<br>
                    Rodolfo Antonio Presa da Silva<br>RA:1903942<br>
                </p>

                <p>
                    Acompanhe nosso projeto: <a href="https://www.google.com.br">https://www.R&RSolutions.com.br</a>
                </p>
            </div>
        </div>
        <%@include file="Estrutura/rodape.jsp" %>

        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>

</html>
