
<%@page import="DAOs.DAOTipoAcomod"%>
<%@page import="Entidades.TipoAcomodacao"%>
<%@page import="java.util.List"%>
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
                var ID = formularioAcomodPreco.id.value;
                var data = formularioAcomodPreco.dataentrada.value;
                var preco1 = formularioAcomodPreco.preco.value;
                if ((ID == "" || data == "" || preco1 == "") {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>

        <form name="formularioAcomodPreco" method="post" action="ServletAcomodPreco" class="jumbotron transparente" >

            <div class="form-group container for-about">
                <label>Id:</label>
                <input type="text" class="form-control"  name="id"> 
            </div>
            <div class="form-group container for-about">
                <label>Data Entrada:</label>
                <input type="text" class="form-control"  name="dataentrada"> 
            </div>
            <div class="form-group container for-about">
                <label>Preço:</label>
                <input type="text" class="form-control"  name="preco"> 
            </div>
            <select class="form-control" id="idtipoacomod" name="idtipoacomod">

                <%                                    
                    DAOTipoAcomod daoTipoAcomod = new DAOTipoAcomod();
                    List<TipoAcomodacao> tipoacomodacoes = daoTipoAcomod.list();

                    for (TipoAcomodacao ta : tipoacomodacoes) {
                        out.println("<option value='" + ta.getIdTipo() + "'>" + ta.getNomeTipo() + "</option>");
                    }

                %>                               

            </select> 
            <input type="submit" onclick="return verific()" class="btn btn-primary" name="funcao" value="Cadastrar">
        </form>
        <div class="content"></div>   
        <%@include file="Estrutura/rodape.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>