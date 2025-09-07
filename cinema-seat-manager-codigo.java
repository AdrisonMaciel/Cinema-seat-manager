import java.util.Scanner;
public class Main {
    private final boolean[][] assentos; // true = ocupado, false = livre
    private final int linhas = 5; 
    private final int colunas = 10; 
    private float valorNormal; // Float para ocupar menos espaço
    private float valorVIP; 
    private float totalArrecadado = 0; 
    public Main() {
        assentos = new boolean[linhas][colunas]; 
    }
    public void cadastrarValoresIngressos() {   // Método para cadastrar os valores dos ingressos
        Scanner scanner = new Scanner(System.in); // Scanner para ler os valores
        System.out.print("Digite o valor do ingresso normal: "); 
        valorNormal = scanner.nextFloat(); 
        System.out.print("Digite o valor do ingresso VIP: ");
        valorVIP = scanner.nextFloat();
    }
    public void reservarAssento(int linha, int coluna, boolean meia) { // Método para reservar um assento
        if (assentoValido(linha, coluna) && !assentos[linha][coluna]) { // Verifica se o assento é válido e está livre
            assentos[linha][coluna] = true; // Marca o assento como ocupado
            Float valor = meia ? (linha < 2 ? valorVIP : valorNormal) / 2 : (linha < 2 ? valorVIP :  valorNormal); // Calcula o valor do ingresso
            totalArrecadado += valor; // Adiciona o valor do ingresso ao total arrecadado
            System.out.printf("Assento marcado com sucesso! Valor: R$ %.2f%n", valor); 
        } else { // Se o assento não for válido ou estiver ocupado, exibe uma mensagem de erro
            System.out.println("Assento inválido ou já ocupado.");
        }
    }
    public void cancelarReserva(int linha, int coluna) { // Método para cancelar uma reserva
        if (assentoValido(linha, coluna) && assentos[linha][coluna]) { // Verifica se o assento é válido e está ocupado
            assentos[linha][coluna] = false; // Marca o assento como livre
            System.out.println("Reserva cancelada com sucesso!");
        } else { // Se o assento não for válido ou estiver livre, exibe uma mensagem de erro
            System.out.println("Assento inválido ou não reservado.");
        }
    }
    public void mostrarMapaAssentos() { // Método para mostrar o mapa de assentos
        for (boolean[] linha : assentos) { // Para cada linha de assentos
            for (boolean assento : linha) { // Para cada assento da linha
                System.out.print(assento ? "X " : "O "); // Se o assento estiver ocupado, exibe "X", senão exibe "O"
            }
            System.out.println(); 
        }
    }
    public void mostrarTotalAssentos() { // Método para mostrar o total de assentos e arrecadação
        int totalReservados = 0; // Variável para armazenar o total de assentos reservados
        for (boolean[] linha : assentos) { 
            for (boolean assento : linha) {
                if (assento) totalReservados++; // Se o assento estiver ocupado, incrementa o total de assentos reservados
            }
        }
        System.out.printf("Total de assentos cadastrados: %d | Total arrecadado: R$ %.2f%n", linhas * colunas, totalArrecadado); // Exibe o total de assentos e arrecadação
    }
    private boolean assentoValido(int linha, int coluna) { 
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas; 
    }
    public static void main(String[] args) { // Método main para testar a classe
        Main cinema = new Main(); // Cria um objeto da classe Cinema
        cinema.cadastrarValoresIngressos();  // Cadastra os valores dos ingressos
        Scanner scanner = new Scanner(System.in); // Scanner para ler a escolha do usuário
        int escolha; // Variável para armazenar a escolha do usuário
        do { // Menu de opções (utlizando do-while para garantir que o menu seja exibido pelo menos uma vez)
            System.out.println("1. Mostrar mapa de assentos\n2. Reservar assento\n3. Cancelar reserva\n4. Mostrar total de assentos e arrecadação\n5. Sair");
            escolha = scanner.nextInt(); 
            switch (escolha) { // Switch para tratar a escolha do usuário
                case 1: // Se a escolha for 1, mostra o mapa de assentos
                    cinema.mostrarMapaAssentos();
                    break;
                case 2: // Se a escolha for 2, reserva um assento
                    System.out.println("Digite a linha (0-4) e a coluna (0-9) do assento:");
                    int linha = scanner.nextInt();
                    int coluna = scanner.nextInt();
                    System.out.print("Tipo de ingresso (1- Inteira | 2 - Meia): ");
                    boolean meia = scanner.nextInt() == 2;
                    cinema.reservarAssento(linha, coluna, meia);
                    break;
                case 3: // Se a escolha for 3, cancela uma reserva
                    System.out.println("Digite a linha e coluna do assento a ser cancelado:");
                    linha = scanner.nextInt();
                    coluna = scanner.nextInt();
                    cinema.cancelarReserva(linha, coluna);
                    break;
                case 4: // Se a escolha for 4, mostra o total de assentos e arrecadação
                    cinema.mostrarTotalAssentos();
                    break;
                case 5: // Se a escolha for 5, sai do programa
                    System.out.println("Saindo...");
                    break;
                default: // Se a escolha for inválida, exibe uma mensagem de erro
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 5); // Repete o menu enquanto a escolha for diferente de 5
        scanner.close(); 
    }
}