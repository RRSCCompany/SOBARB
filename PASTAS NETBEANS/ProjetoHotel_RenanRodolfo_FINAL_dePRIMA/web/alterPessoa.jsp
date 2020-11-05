
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entidades.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Pessoa f = (Pessoa) request.getAttribute("pessoa");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
    </head>
    <body>

        <%@include file="Estrutura/cabecalho.jsp" %>


        <script>
            function verific() {
                var ID = formularioPessoa.id.value;
                var CPF = formularioPessoa.cpf.value;
                var nome = formularioPessoa.nome.value;
                var data_de_nascimento = formularioPessoa.data_de_nascimento.value;
                if ((ID == "" || CPF == "" || nome == "" || data_de_nascimento == "" || isNaN(ID))) {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>

        <form name="formularioPessoa" method="post" action="ServletPessoa" class="jumbotron transparente" >

            <div class="form-group container for-about">
                <label>id</label>
                <input type="text" class="form-control"  name="id" id="id" value="<%= f.getIdPessoa()%>"> 
            </div>
            <div class="form-group container for-about">
                <label>CPF</label>
                <input type="text" class="form-control"  name="cpf" id="cpf" value="<%= f.getCpfPessoa()%>"> 
            </div>
            <div class="form-group container for-about">
                <label>Nome</label>
                <input type="text" class="form-control" name="nome" id="nome" value="<%= f.getNomePessoa()%>">
            </div>
            <div class="form-group container for-about">
                <%
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
                    String data_formatada = df.format(f.getDataNascimento());
                %>
                <label>Data de Nascimento</label>
                <input type="Date" class="form-control" name="data_de_nascimento" id="data_de_nascimento" value="<%=data_formatada%>">
            </div>

            <input type="submit" onclick="return verific()" class="btn btn-primary" name="funcao" value="alterar">
        </form>
        <div class="content"></div>   
        <%@include file="Estrutura/rodape.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
