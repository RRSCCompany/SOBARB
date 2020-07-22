package Renan_4Bim_Usuario;
 
import java.util.Date; 
import javax.swing.JPasswordField;

public class UsuarioS { 
    
   
public String gettextpassword1(JPasswordField senha) {
        String senha2 = new String(senha.getPassword());
        return senha2;
}

private String Nick;
private String Nome;
private String Sobrenome;
private String Email;
private String Senha;

 public UsuarioS() {
} 

public UsuarioS(String Nick,String Nome,String Sobrenome,String Email,String Senha) { 

this.Nick = Nick;
this.Nome = Nome;
this.Sobrenome = Sobrenome;
this.Email = Email;
this.Senha = Senha;

}

public String getNick() { 
return Nick; 
} 

public void setNick(String Nick) { 
this.Nick = Nick; 
} 

public String getNome() { 
return Nome; 
} 

public void setNome(String Nome) { 
this.Nome = Nome; 
} 

public String getSobrenome() { 
return Sobrenome; 
} 

public void setSobrenome(String Sobrenome) { 
this.Sobrenome = Sobrenome; 
} 

public String getEmail() { 
return Email; 
} 

public void setEmail(String Email) { 
this.Email = Email; 
} 

public String getSenha() { 
return Senha; 
} 

public void setSenha(String Senha) { 
this.Senha = Senha; 
} 


@Override
public String toString() { 
    return Nick + ";" + Nome + ";" + Sobrenome + ";" + Email + ";" + Senha;
}


}
