<%-- 
    Document   : cadCliente
    Created on : 02/10/2020, 14:23:38
    Author     : presa
--%>


<%@page import="java.util.List"%>
<%@page import="Entidades.Pessoa"%>
<%@page import="Entidades.Setor"%>
<%@page import="DAOs.DAOPessoa"%>
<%@page import="DAOs.DAOSetor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                var IDPessoa = formularioPessoa.idPessoa.value;
                var IDSetor = formularioPessoa.idSetor.value;
                var contato = formularioPessoa.idSetor.value;
                var data_de_contratacao = formularioPessoa.data_de_cotratacao.value;
                if ((IDPessoa == "" || IDSetor == "" || data_de_contratacao == "" || contato == "" || isNaN(ID))) {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>

        <form name="formularioPessoa" method="post" action="ServletFuncionario" class="jumbotron transparente" >

            <div class="form-group container for-about">
                <label>Id do Funcionario:</label>
                <select class="form-control" id="idPessoa" name="idPessoa">

                    <%
                        DAOPessoa daoPessoa = new DAOPessoa();
                        List<Pessoa> pessoas = daoPessoa.list();

                        for (Pessoa g : pessoas) {
                            out.println("<option value='" + g.getIdPessoa() + "'>" + g.getIdPessoa() + "</option>");
                        }

                    %>                               

                </select>
            </div>
            <div class="form-group container for-about">      
                <label>Id do Setor:</label>
                <select class="form-control" id="idSetor" name="idSetor">

                    <%                                    DAOSetor daoSetor = new DAOSetor();
                        List<Setor> setores = daoSetor.list();

                        for (Setor g : setores) {
                            out.println("<option value='" + g.getIdSetor() + "'>" + g.getNomeSetor() + "</option>");
                        }

                    %>                               

                </select>        
            </div>

            <div class="form-group container for-about">
                <label>Contato:</label>
                <input type="text" class="form-control" id="contato" name="contato">
            </div>
            <div class="form-group container for-about">
                <label>Data de contratação:</label>
                <input type="Date" class="form-control" id="data_de_cadastro" name="data_de_contratacao" >
            </div>

            <input type="submit" onclick="return verific()" class="btn btn-primary" name="funcao" value="Cadastrar">
        </form>
        <div class="content"></div>   
        <%@include file="Estrutura/rodape.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>