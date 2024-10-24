package gerenciamentodehotel;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate; // Importar LocalDate aqui

public class Hotel {
    private List<Quartos> listaQuartos = new ArrayList<>();
    private List<Reservas> listaReservas = new ArrayList<>();

    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        Quartos quarto = new Quartos(numero, tipo, precoDiario);
        listaQuartos.add(quarto);
    }

    public List<Quartos> getQuartos() {
        return listaQuartos;
    }

    public void cadastrarReserva(String nomeHospede, String tipoQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut, int numeroQuartos) {
        Reservas reserva = new Reservas(nomeHospede, tipoQuarto, dataCheckIn, dataCheckOut, numeroQuartos);
        listaReservas.add(reserva);

        for (Quartos quarto : listaQuartos) {
            if (quarto.getTipo().equalsIgnoreCase(tipoQuarto) && quarto.isDisponivel()) {
                quarto.setDisponibilidade(false);
                break;
            }
        }
    }

    public List<Reservas> getReservas() {
        return listaReservas;
    }
}

