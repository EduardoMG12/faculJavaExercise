import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    private String palavra;
    private char[] palavraOculta;
    private int tentativas;
    private boolean jogoGanho;

    public JogoDaForca(String palavra) {
        this.palavra = palavra;
        this.palavraOculta = new char[palavra.length()];
        this.tentativas = 6;
        this.jogoGanho = false;

        // Inicializa a palavra oculta com asteriscos
        for (int i = 0; i < palavraOculta.length; i++) {
            palavraOculta[i] = '*';
        }
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Você tem 6 tentativas para acertar a palavra.");

        while (tentativas > 0 && !jogoGanho) {
            System.out.println("Palavra oculta: " + new String(palavraOculta));
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().charAt(0);

            // Verifica se a letra está na palavra
            boolean acertou = false;
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == letra) {
                    palavraOculta[i] = letra;
                    acertou = true;
                }
            }

            // Se a letra não está na palavra, diminui as tentativas
            if (!acertou) {
                tentativas--;
                System.out.println("Tentativas restantes: " + tentativas);
            }

            // Verifica se o jogo foi ganho
            if (new String(palavraOculta).equals(palavra)) {
                jogoGanho = true;
                System.out.println("Parabéns! Você ganhou!");
            }
        }

        // Se as tentativas acabaram, mostra a palavra correta
        if (tentativas == 0) {
            System.out.println("Game over! A palavra correta era: " + palavra);
        }
    }

    public static void main(String[] args) {
        JogoDaForca jogo = new JogoDaForca("programacao");
        jogo.jogar();
    }
}