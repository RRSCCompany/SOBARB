<%@page import="Entidades.Equipamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Equipamento f = (Equipamento) request.getAttribute("equipamento");
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
    function verific(){
        var ID = formularioPessoa.id.value;
        var nome_equipamento = formularioPessoa.equipamento_nome.value;

        if ((ID == "" || nome_equipamento == "" ||isNaN(ID))) {
            alert('Preencha corretamente.');
            return false;        
    }

}
</script>
  
<form name="formularioPessoa" method="post" action="ServletEquipamento" class="jumbotron transparente" >
  
    <div class="form-group container for-about">
    <label>id do equipamento:</label>
    <input type="text" class="form-control"  name="id" value ="<%=f.getIdEquipamento()%>"> 
  </div>
    <div class="form-group container for-about">
    <label>nome do equipamento:</label>
    <input type="text" class="form-control"  name="equipamento_nome" value ="<%=f.getNomeEquipamento()%>"> 
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