
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entidades.Reserva"%>
<%@page import="DAOs.DAOReserva"%>
<%@page import="Entidades.PeriodoReserva"%>
<%@page import="DAOs.DAOPeriodoReserva"%>
<%@page import="DAOs.DAOAcomod"%>
<%@page import="Entidades.Acomodacao"%>
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
                var ID = formularioPeriodoReserva.id.value;
                var ID_RESERVA = formularioPeriodoReserva.idapartamento.value;
                var data = formularioPeriodoReserva.idreserva.value;
                if ((ID == "" || ID_RESERVA == "" || data == "") {
                    alert('Preencha corretamente.');
                    return false;
                }

            }
        </script>

        <form name="formularioPeriodoReserva" method="post" action="ServletPeriodoReserva" class="jumbotron transparente" >
            <div class="form-group container for-about">
                <label>Id:</label>
                <input type="text" class="form-control"  name="qtd_dias"> 
            </div>
            <div class="form-group container for-about">
                <label>Acomodação:</label>
                <select name="IdAcomodacao" id="id" size="10" multiple>

                    <%
                        DAOAcomod daoAcomod = new DAOAcomod();
                        List<Acomodacao> acomods = daoAcomod.list();

                        for (Acomodacao ad : acomods) {
                            out.println("<option value='" + ad.getIdAcomodacao() + "'>" + ad.getNomeAcomodacao() + "</option>");
                        }

                    %>
                </select>  
            </div>
            <div class="form-group container for-about">
                <label>Id da Reserva:</label>
                <select name="IdReserva" id="reserva" size="10" multiple>

                    <%                        DAOReserva daoReserva = new DAOReserva();
                        List<Reserva> reservas = daoReserva.list();

                        for (Reserva r : reservas) {
                            SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
                            String data_formatada = df.format(r.getDataReserva());
                            out.println("<option value='" + r.getIdReserva() + "'>"
                                    + data_formatada +"</option>");
                        }

                    %>
                </select> 
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