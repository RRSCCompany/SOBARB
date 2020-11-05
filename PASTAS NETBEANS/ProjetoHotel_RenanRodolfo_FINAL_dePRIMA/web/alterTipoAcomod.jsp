
<%@page import="Entidades.TipoAcomodacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    TipoAcomodacao f = (TipoAcomodacao) request.getAttribute("tipoacomod");
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="css/personalizar.css" rel="stylesheet">
    </head>
    <body>

        <%@include file="Estrutura/cabecalho.jsp" %>


        <script>
            function verific() {
                var ID = formularioTipoAcomod.id.value;
                var nometipo1 = formularioTipoAcomod.nometipo.value;
                if ((ID == "" || nometipo1 == "") {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>

        <form name="formularioTipoAcomod" method="post" action="ServletTipoAcomod" class="jumbotron transparente" >

            <div class="form-group container for-about">
                <label>Id</label>
                <input type="text" class="form-control"  name="id" value ="<%=f.getIdTipo()%>"> 
            </div>
            <div class="form-group container for-about">
                <label>Tipo da Acomodação</label>
                <input type="text" class="form-control"  name="nometipo" value ="<%=f.getNomeTipo()%>"> 
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