<%-- 
    Document   : cadCliente
    Created on : 02/10/2020, 14:23:38
    Author     : presa
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entidades.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Pessoa"%>
<%@page import="DAOs.DAOPessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cliente f = (Cliente) request.getAttribute("cliente");
%>
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
                var cidade_de_origem = formularioPessoa.cidade_de_origem.value;
                var cidade_de_destino = formularioPessoa.cidade_de_destino.value;
                var data_de_cadastro = formularioPessoa.data_de_cadastro.value;
                if ((IDPessoa == "" || cidade_de_cadastro == "" || cidade_de_destino == "" || data_de_cadastro == "" || isNaN(ID))) {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>

        <form name="formularioPessoa" method="post" action="ServletCliente" class="jumbotron transparente" >

            <div class="form-group container for-about">
                <label>id</label>
                <select class="form-control" id="idPessoa" name="idPessoa">

                    <%
                        DAOPessoa daoPessoa = new DAOPessoa();
                        List<Pessoa> pessoas = daoPessoa.list();

                        for (Pessoa g : pessoas) {

                            if (f.getPessoa().getIdPessoa() == g.getIdPessoa()) {
                                out.println("<option selected='selected' value='" + g.getIdPessoa() + "'>" + g.getIdPessoa() + "</option>");
                            } else {
                                out.println("<option value='" + g.getIdPessoa() + "'>" + g.getIdPessoa() + "</option>");
                            }

                        }

                    %>                             

                </select>
            </div>
            <div class="form-group container for-about">
                <label>cidade de origem</label>
                <input type="text" class="form-control" id="cidade_de_origem"  name="cidade_de_origem" value="<%=f.getCidadeOrigem()%>"> 
            </div>
            <div class="form-group container for-about">
                <label>cidade de destino</label>
                <input type="text" class="form-control" id="cidade_de_destino" name="cidade_de_destino" value="<%=f.getCidadeDestino()%>">
            </div>
            <div class="form-group container for-about">
                <%          SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
                    String data_formatada = df.format(f.getDataCadastro());
                %>
                <label>Data de Cadastro</label>
                <input type="Date" class="form-control" id="data_de_cadastro" name="data_de_cadastro" value="<%=data_formatada%>" >
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