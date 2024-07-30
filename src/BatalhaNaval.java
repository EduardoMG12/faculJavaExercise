import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {

    private static final int TAMANHO_TABULEIRO = 10;
    private static final int NUM_NAVIOS = 5;

    private char[][] tabuleiro;
    private int[] navios;
    private Random random;
    private Scanner scanner;

    public BatalhaNaval() {
        this.tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        this.navios = new int[NUM_NAVIOS];
        this.random = new Random();
        this.scanner = new Scanner(System.in);

        inicializarTabuleiro();
        posicionarNavios();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private void posicionarNavios() {
        for (int i = 0; i < NUM_NAVIOS; i++) {
            int x = random.nextInt(TAMANHO_TABULEIRO);
            int y = random.nextInt(TAMANHO_TABULEIRO);

            if (tabuleiro[x][y] == '-') {
                tabuleiro[x][y] = 'N';
                navios[i] = x * TAMANHO_TABULEIRO + y;
            } else {
                i--;
            }
        }
    }

    public void jogar() {
        while (true) {
            imprimirTabuleiro();
            System.out.print("Digite as coordenadas (x y) para atirar: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x < 0 || x >= TAMANHO_TABULEIRO || y < 0 || y >= TAMANHO_TABULEIRO) {
                System.out.println("Coordenadas inválidas!");
                continue;
            }

            if (tabuleiro[x][y] == 'N') {
                System.out.println("Você acertou um navio!");
                tabuleiro[x][y] = 'X';
                verificarVitoria();
            } else if (tabuleiro[x][y] == '-') {
                System.out.println("Você atirou na água!");
                tabuleiro[x][y] = 'O';
            } else {
                System.out.println("Você já atirou nessa posição!");
            }
        }
    }

    private void verificarVitoria() {
        for (int i = 0; i < NUM_NAVIOS; i++) {
            int x = navios[i] / TAMANHO_TABULEIRO;
            int y = navios[i] % TAMANHO_TABULEIRO;

            if (tabuleiro[x][y] != 'X') {
                return;
            }
        }

        System.out.println("Você venceu!");
        System.exit(0);
    }

    private void imprimirTabuleiro() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BatalhaNaval jogo = new BatalhaNaval();
        jogo.jogar();
    }
}