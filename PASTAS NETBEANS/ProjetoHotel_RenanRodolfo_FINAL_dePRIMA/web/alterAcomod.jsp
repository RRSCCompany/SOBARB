
<%@page import="Entidades.TipoAcomodacao"%>
<%@page import="DAOs.DAOTipoAcomod"%>
<%@page import="DAOs.DAOAcomod"%>
<%@page import="Entidades.Acomodacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Acomodacao f = (Acomodacao) request.getAttribute("acomodacao");
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
                var ID = formularioAcomod.id.value;
                var nometipo1 = formularioAcomod.nomeacomod.value;
                var tipo1 = formularioAcomod.tipoacomod.value;
                if ((ID == "" || nometipo1 == "" || tipo1 == "") {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>

        <form name="formularioAcomod" method="post" action="ServletAcomod" class="jumbotron transparente" >

            <div class="form-group container for-about">
                <label>Id</label>
                <input type="text" class="form-control"  name="id" value="<%=f.getIdAcomodacao()%>"> 
            </div>
            <div class="form-group container for-about">
                <label>Nome da acomodação</label>
                <input type="text" class="form-control"  name="nomeacomod" value="<%=f.getNomeAcomodacao()%>"> 
            </div>
            <div class="form-group container for-about">
                <label>Tipo da acomodação</label>
                <select name="idtipo" id="acomod" size="10" multiple>

                    <%
                        DAOTipoAcomod daoTipoAcomod = new DAOTipoAcomod();
                        List<TipoAcomodacao> tipoAcomodacoes = daoTipoAcomod.list();

                        for (TipoAcomodacao g : tipoAcomodacoes) {

                            if (f.getTipoAcomodacaoIdTipo().getIdTipo() == g.getIdTipo()) {
                                out.println("<option selected='selected' value='" + g.getIdTipo() + "'>" + g.getIdTipo() + "</option>");
                            } else {
                                out.println("<option value='" + g.getIdTipo() + "'>" + g.getIdTipo() + "</option>");
                            }

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