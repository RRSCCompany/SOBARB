<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
<link href="css/personalizar.css" rel="stylesheet">
<link rel="shortcut icon" href="Imagens/iconRRR.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark noBorder transparente">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Hotel Vit�ria R�gia</a>
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
                            <a class="nav-link ba" href="cadPessoa.jsp">CadPessoas</a>
                            <a class="nav-link ba" href="cadCliente.jsp">CadCliente</a>
                            <a class="nav-link ba" href="cadReserva.jsp">CadReserva</a>
                            <a class="nav-link ba" href="cadTipoAcomod.jsp">CadTipoAcomod</a>
                            <a class="nav-link ba" href="cadAcomodacao.jsp">CadAcomod</a>
                            <a class="nav-link ba" href="cadSetor.jsp">CadSetor</a>
                            <a class="nav-link ba" href="cadEquipamento.jsp">CadEquip</a>
                            <a class="nav-link ba" href="cadFuncionario.jsp">CadFunci</a>
                            <a class="nav-link ba" href="cadPeriodoReserva.jsp">CadPeriodoReserva</a>
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
                            <a class="nav-link ba" href="ServletTipoAcomod?funcao=listar">Tipo Acomoda��es</a>
                            <a class="nav-link ba" href="ServletAcomodacao?funcao=listar">Acomoda��es</a>
                            <a class="nav-link ba" href="cadSetor.jsp">Setores</a>
                            <a class="nav-link ba" href="cadEquipamento.jsp">Equipamentos</a>
                            <a class="nav-link ba" href="cadFuncionario.jsp">Funcion�rios</a>
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
