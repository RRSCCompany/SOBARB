
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
    function verific(){
        var ID = formularioPessoa.id.value;
        var nome_setor = formularioPessoa.setor_nome.value;

        if ((ID == "" || nome_setor == "" ||isNaN(ID))) {
            alert('Preencha corretamente.');
            return false;        
    }

}
</script>
  
<form name="formularioPessoa" method="post" action="ServletSetor" class="jumbotron transparente" >
  
    <div class="form-group container for-about">
    <label>id do setor:</label>
    <input type="text" class="form-control"  name="id"> 
  </div>
    <div class="form-group container for-about">
    <label>nome do setor:</label>
    <input type="text" class="form-control"  name="setor_nome"> 
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