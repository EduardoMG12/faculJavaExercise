import java.util.Random;
import java.util.Scanner;

public class PedraPapelTesoura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao jogo de Pedra, Papel e Tesoura!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Pedra");
        System.out.println("2. Papel");
        System.out.println("3. Tesoura");

        int escolhaUsuario = scanner.nextInt();

        int escolhaComputador = random.nextInt(3) + 1;

        System.out.println("Você escolheu: " + getNomeEscolha(escolhaUsuario));
        System.out.println("O computador escolheu: " + getNomeEscolha(escolhaComputador));

        int resultado = getResultado(escolhaUsuario, escolhaComputador);

        if (resultado == 1) {
            System.out.println("Você ganhou!");
        } else if (resultado == 2) {
            System.out.println("O computador ganhou!");
        } else {
            System.out.println("Empate!");
        }
    }

    private static String getNomeEscolha(int escolha) {
        switch (escolha) {
            case 1:
                return "Pedra";
            case 2:
                return "Papel";
            case 3:
                return "Tesoura";
            default:
                return "Opção inválida";
        }
    }

    private static int getResultado(int escolhaUsuario, int escolhaComputador) {
        if (escolhaUsuario == escolhaComputador) {
            return 0; // Empate
        }

        switch (escolhaUsuario) {
            case 1: // Pedra
                if (escolhaComputador == 2) { // Papel
                    return 2; // Computador ganha
                } else { // Tesoura
                    return 1; // Usuário ganha
                }
            case 2: // Papel
                if (escolhaComputador == 3) { // Tesoura
                    return 2; // Computador ganha
                } else { // Pedra
                    return 1; // Usuário ganha
                }
            case 3: // Tesoura
                if (escolhaComputador == 1) { // Pedra
                    return 2; // Computador ganha
                } else { // Papel
                    return 1; // Usuário ganha
                }
            default:
                return 0; // Opção inválida
        }
    }
}