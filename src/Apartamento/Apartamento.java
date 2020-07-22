package Apartamento;
 
import java.util.Date; 

public class Apartamento { 

private String Apartamento;
private String Ar;
private String Hospede;

 public Apartamento() {
} 

public Apartamento(String Apartamento,String Hospede,String Ar) { 

this.Apartamento = Apartamento;
this.Hospede = Hospede;
this.Ar = Ar;

}




@Override
public String toString() { 
    return Apartamento + ";" + Hospede + ";" + Ar;
}

    public String getApartamento() {
        return Apartamento;
    }

    public void setApartamento(String Apartamento) {
        this.Apartamento = Apartamento;
    }

    public String getAr() {
        return Ar;
    }

    public void setAr(String Ar) {
        this.Ar = Ar;
    }

    public String getHospede() {
        return Hospede;
    }

    public void setHospede(String Hospede) {
        this.Hospede = Hospede;
    }

}
