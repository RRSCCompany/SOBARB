package Renan_4Bim_Animes;
 
import java.text.SimpleDateFormat;
import java.util.Date; 

public class Animes { 

private String Nome;
private Date Data;
private String Dia;
private int Numeroep;
private String Estado;
private String Sinopse;
private String Tema;
private boolean AddAnime;
private String Usuario;

 public Animes() {
} 

public Animes(String Nome,Date Data,String Dia,int Numeroep,String Estado,String Sinopse,String Tema,boolean AddAnime,String Usuario) { 

this.Nome = Nome;
this.Data = Data;
this.Dia = Dia;
this.Numeroep = Numeroep;
this.Estado = Estado;
this.Sinopse = Sinopse;
this.Tema = Tema;
this.AddAnime = AddAnime;
this.Usuario = Usuario;


}
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
@Override
public String toString() { 
    return Nome + ";" + String.valueOf(formato.format(Data)) + ";" + Dia + ";" + Numeroep + ";" + Estado + ";" + Sinopse + ";" + Tema + ";" + AddAnime + ";" + Usuario;
}

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public int getNumeroep() {
        return Numeroep;
    }

    public void setNumeroep(int Numeroep) {
        this.Numeroep = Numeroep;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getSinopse() {
        return Sinopse;
    }

    public void setSinopse(String Sinopse) {
        this.Sinopse = Sinopse;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String Tema) {
        this.Tema = Tema;
    }

    public boolean isAddAnime() {
        return AddAnime;
    }

    public void setAddAnime(boolean AddAnime) {
        this.AddAnime = AddAnime;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

}
