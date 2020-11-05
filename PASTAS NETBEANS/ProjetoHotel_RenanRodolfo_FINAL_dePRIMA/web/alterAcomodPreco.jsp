
<%@page import="DAOs.DAOAcomodacaoPreco"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entidades.AcomodacaoPreco"%>
<%@page import="Entidades.TipoAcomodacao"%>
<%@page import="DAOs.DAOTipoAcomod"%>
<%@page import="DAOs.DAOAcomod"%>
<%@page import="Entidades.Acomodacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AcomodacaoPreco f = (AcomodacaoPreco) request.getAttribute("acomodacaopreco");
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
                var ID = formularioAcomodPreco.dataentrada.value;
                var preco1 = formularioAcomodPreco.preco.value;
                var tipo1 = formularioAcomodPreco.idtipoacomod.value;
                if ((ID == "" || preco1 == "" || tipo1 == "") {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>

        <form name="formularioAcomodPreco" method="post" action="ServletAcomodPreco" class="jumbotron transparente">

            <div class="form-group container for-about">
                <%
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
                    String data_formatada = df.format(f.getAcomodacaoPrecoPK().getData());
                %>
                <label>Data de definição:</label>
                <input type="text" class="form-control"  name="dataentrada" value="<%=data_formatada%>"> 
            </div>
            <div class="form-group container for-about">
                <label>Preço:</label>
                <input type="text" class="form-control"  name="preco" value="<%=f.getPreco()%>"> 
            </div>
            <div class="form-group container for-about">
                <label>Tipo da Acomodação:</label>
                <select class="form-control" id="idtipoacomod" name="idtipoacomod" size="10" multiple>

                    <%
                        DAOAcomodacaoPreco daoAcomodacaoPreco = new DAOAcomodacaoPreco();
                        List<AcomodacaoPreco> acomodacoespreco = daoAcomodacaoPreco.list();

                        for (AcomodacaoPreco ap : acomodacoespreco) {
                            out.println("<option value='" + ap.getAcomodacaoPrecoPK().getData() + "'>" + ap.getAcomodacaoPrecoPK().getData() + "</option>");
                        }
                    %>                               

                </select> 
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