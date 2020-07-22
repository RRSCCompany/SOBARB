package Genero;

import java.util.Date;

public class Tipo {

    private int idGenero;
    private String nomeGenero;

    public Tipo() {
    }

    public Tipo(int idGenero, String nomeGenero) {
        this.idGenero = idGenero;
        this.nomeGenero = nomeGenero;
    }

    public int getSabor() {
        return idGenero;
    }

    public void setSabor(int Sabor) {
        this.idGenero = Sabor;
    }

    public String getNomeProduto() {
        return nomeGenero;
    }

    public void setNomeProduto(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    @Override

    public String toString() {
        return idGenero + ";" + nomeGenero;
    }
}
