package Produto;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPasswordField;

public class Pizza {

    
    private int id;
    private String nomeProduto;
    private int fk;

    private Date Data;
    private boolean ativo;

    public Pizza() {
    }

    public Pizza(int id, String Sabor, int fk,  Date Data, boolean ativo) {
        this.id = id;
        this.nomeProduto = Sabor;
        this.fk = fk;
        this.Data = Data;
        this.ativo = ativo;
    }

    public int getId() {
       
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getSabor() {
        return nomeProduto;
    }

    public void setSabor(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getBtnomeTipo() {
        return fk;
    }

    public void setBtnomeTipo(int fk) {
        this.fk = fk;
    }

    

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

   

    @Override

    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return id + ";" + nomeProduto + ";" + fk + ";"  +formato.format(Data) + ";"+ativo;
    }
}
