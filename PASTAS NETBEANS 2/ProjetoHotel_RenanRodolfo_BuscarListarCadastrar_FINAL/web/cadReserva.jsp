<%-- 
    Document   : cadCliente
    Created on : 02/10/2020, 14:23:38
    Author     : presa
--%>


<%@page import="Entidades.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOCliente"%>
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
                var idReserva = formularioPessoa.idReserva.value;
                var data_reserva = formularioPessoa.data_reserva.value;
                var ID_ClientePessoa = formularioPessoa.ID_ClientePessoa.value;
                if ((idReserva == "" || data_reserva == "" || ID_ClientePessoa == "" || isNaN(ID))) {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>
        <div class="jumbotron transparente">
            <form name="formularioPessoa" method="post" action="ServletReserva"  >

                <div class="form-group container for-about">
                    <label>ID</label>
                    <input type="text" class="form-control"  name="idReserva"> 
                </div>
                <div class="form-group container for-about">
                    <label>Data reserva</label>
                    <input type="text" class="form-control"  name="datareserva"> 
                </div>
                <div class="form-group container for-about">
                    <label>Id Cliente:</label>
                    <select class="form-control" id="idPessoa" name="idClientePessoa">

                        <%
                            DAOCliente daoCliente = new DAOCliente();
                            List<Cliente> clientes = daoCliente.list();

                            for (Cliente g : clientes) {
                                out.println("<option value='" + g.getPessoaIdPessoa() + "'>" + g.getPessoaIdPessoa() + "</option>");
                            }

                        %>                               

                    </select>
                </div>
                <input type="submit" onclick="return verific()" class="btn btn-primary" name="funcao" value="Cadastrar">
            </form>
        </div>
        <div class="content"></div>   
        <%@include file="Estrutura/rodape.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>