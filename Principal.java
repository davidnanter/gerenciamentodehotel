package gerenciamentodehotel;
import java.time.LocalDate;
import java.time.format.DateTimeParseException; 
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        int opcao;

        do {
            System.out.println("=== Sistema de Gerenciamento de Hotel ===");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Listar Quartos");
            System.out.println("3. Cadastrar Reserva");
            System.out.println("4. Listar Reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Número do Quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de Quarto (solteiro/casal/suite): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço Diário: ");
                    double preco = scanner.nextDouble();
                    hotel.cadastrarQuarto(numero, tipo, preco);
                    System.out.println("Quarto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("=== Lista de Quartos ===");
                    if (hotel.getQuartos().isEmpty()) {
                        System.out.println("Nenhum quarto cadastrado.");
                    } else {
                        for (Quartos quarto : hotel.getQuartos()) {
                            System.out.println("Número: " + quarto.getNumero() + 
                                               " | Tipo: " + quarto.getTipo() + 
                                               " | Preço: " + quarto.getPrecoDiario() + 
                                               " | Disponível: " + (quarto.isDisponivel() ? "Sim" : "Não"));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nome do Hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Tipo de Quarto (solteiro/casal/suite): ");
                    String tipoQuarto = scanner.nextLine();

                    LocalDate dataCheckIn = null;
                    while (dataCheckIn == null) {
                        try {
                            System.out.print("Data de Check-in (YYYY-MM-DD): ");
                            dataCheckIn = LocalDate.parse(scanner.nextLine());
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inválida. Por favor, insira novamente no formato YYYY-MM-DD.");
                        }
                    }

                    LocalDate dataCheckOut = null;
                    while (dataCheckOut == null) {
                        try {
                            System.out.print("Data de Check-out (YYYY-MM-DD): ");
                            dataCheckOut = LocalDate.parse(scanner.nextLine());
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inválida. Por favor, insira novamente no formato YYYY-MM-DD.");
                        }
                    }

                    System.out.print("Número de Quartos Reservados: ");
                    int numeroQuartos = scanner.nextInt();
                    hotel.cadastrarReserva(nomeHospede, tipoQuarto, dataCheckIn, dataCheckOut, numeroQuartos);
                    System.out.println("Reserva cadastrada com sucesso!");
                    break;

                case 4:
                    System.out.println("=== Histórico de Reservas ===");
                    if (hotel.getReservas().isEmpty()) {
                        System.out.println("Nenhuma reserva cadastrada.");
                    } else {
                        for (Reservas reserva : hotel.getReservas()) {
                            System.out.println("Hóspede: " + reserva.getNomeHospede() + 
                                               " | Check-in: " + reserva.getDataCheckIn() + 
                                               " | Check-out: " + reserva.getDataCheckOut() + 
                                               " | Tipo de Quarto: " + reserva.getTipoQuarto() + 
                                               " | Número de Quartos: " + reserva.getNumeroQuartos());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

