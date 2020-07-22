package Hotel;
 
import java.util.Date; 
public class Hotel { 

private String CPF;
private String Nome;
private String NumeroQuarto;
private Date DataEntrada;
private Date DataSaida;
private String Email;
private String Telefone;
private int Valor;
private int Consumo;


 public Hotel() {
} 

public Hotel(String CPF,String Nome,String NumeroQuarto,Date DataEntrada,Date DataSaida,String Email,String Telefone,int Consumo,int Valor) { 

this.CPF = CPF;
this.Nome = Nome;
this.NumeroQuarto = NumeroQuarto;
this.DataEntrada = DataEntrada;
this.DataSaida = DataSaida;
this.Email = Email;
this.Telefone = Telefone;
this.Consumo = Consumo;
this.Valor = Valor;
}


@Override
public String toString() { 
    return CPF + ";" + Nome + ";" + NumeroQuarto + ";" + DataEntrada + ";" + DataSaida + ";" + Email + ";" + Telefone + ";" + Consumo + ";" + Valor;
}

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getNumeroQuarto() {
        return NumeroQuarto;
    }

    public void setNumeroQuarto(String NumeroQuarto) {
        this.NumeroQuarto = NumeroQuarto;
    }

    public Date getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(Date DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    public Date getDataSaida() {
        return DataSaida;
    }

    public void setDataSaida(Date DataSaida) {
        this.DataSaida = DataSaida;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public int getConsumo() {
        return Consumo;
    }

    public void setConsumo(int Consumo) {
        this.Consumo = Consumo;
    }

    

}
