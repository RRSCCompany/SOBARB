<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
<link href="css/personalizar.css" rel="stylesheet">
<link rel="shortcut icon" href="Imagens/iconRRR.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark noBorder transparente">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Hotel Vitória Régia</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarsExample07">
            <ul class="navbar-nav mr-auto"> 
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Cadastros
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="nav-link ba" href="cadPessoa.jsp">Pessoas</a>
                            <a class="nav-link ba" href="cadCliente.jsp">Clientes</a>
                            <a class="nav-link ba" href="cadReserva.jsp">Reservas</a>
                            <a class="nav-link ba" href="cadTipoAcomod.jsp">Tipos de Acomodações</a>
                            <a class="nav-link ba" href="cadAcomodacao.jsp">Acomodações</a>
                            <a class="nav-link ba" href="cadSetor.jsp">Setores</a>
                            <a class="nav-link ba" href="cadEquipamento.jsp">Equipamentos</a>
                            <a class="nav-link ba" href="cadFuncionario.jsp">Funcionários</a>
                            <a class="nav-link ba" href="cadPeriodoReserva.jsp">Periodos de Reservas</a>
                            <a class="nav-link ba" href="cadAcomodPreco.jsp">Preço de Acomodações</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Listagens
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="nav-link ba" href="ServletPessoa?funcao=listar">Pessoas</a>
                            <a class="nav-link ba" href="ServletCliente?funcao=listar">Clientes</a>
                            <a class="nav-link ba" href="ServletReserva?funcao=listar">Reservas</a>
                            <a class="nav-link ba" href="ServletTipoAcomod?funcao=listar">Tipo de Acomodações</a>
                            <a class="nav-link ba" href="ServletAcomod?funcao=listar">Acomodações</a>
                            <a class="nav-link ba" href="ServletSetor?funcao=listar">Setores</a>
                            <a class="nav-link ba" href="ServletEquipamento?funcao=listar">Equipamentos</a>
                            <a class="nav-link ba" href="ServletFuncionario?funcao=listar">Funcionários</a>
                            <a class="nav-link ba" href="ServletPeriodoReserva?funcao=listar">Periodos de Reservas</a>
                            <a class="nav-link ba" href="ServletAcomodPreco?funcao=listar">Preço das Acomodações</a>
                        </div>
                    </div>
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
