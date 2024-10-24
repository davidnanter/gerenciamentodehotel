package gerenciamentodehotel;

import java.time.LocalDate; // Importar LocalDate aqui

public class Reservas {
    private String nomeHospede;
    private String tipoQuarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private int numeroQuartos;

    public Reservas(String nomeHospede, String tipoQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut, int numeroQuartos) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuartos = numeroQuartos;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }
}
