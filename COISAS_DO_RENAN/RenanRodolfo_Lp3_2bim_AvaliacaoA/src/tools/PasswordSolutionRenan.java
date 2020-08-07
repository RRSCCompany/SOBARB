
package tools;

import javax.swing.JPasswordField;

/**
 *
 * @author radames
 */
public class PasswordSolutionRenan {
    private String cpf;
    private String senha;
    private String nome;
    private double salario;

    public PasswordSolutionRenan() {
    }

    public PasswordSolutionRenan(String cpf, String senha,String nome, double salario) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.salario = salario;
    }


    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
@Override
    public String toString() {
        return "Trabalhador{" + " cpf = " + cpf + ", nome = " + nome + ", salario = " + salario + ", senha = " + senha+  '}';
    }

    public String gettextpassword(JPasswordField senha) {
       char[] senha1 = senha.getPassword();
       String r = "";
        for (int i = 0; i < senha1.length; i++) {
            r += senha1[i];
        }
        return r;
    }
    
    
}
