import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhaNumero {
    public static void main(String[] args) {
        int palpite = 0;
        int sorteado;
        int tentativas = 0;

        Scanner entrada = new Scanner(System.in);

        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(1000) + 1;
        System.out.println("Número entre 1 e 1000 sorteado!");

        do {
            System.out.printf("\n\n\n\n-----------------\n");
            System.out.println("Número de tentativas: " + tentativas);

            System.out.print("Qual seu palpite: ");
            palpite = entrada.nextInt();

            tentativas++;

            if (palpite > sorteado) {
                System.out.println("Seu palpite é maior que o número sorteado.");
            } else if (palpite < sorteado) {
                System.out.println("Seu palpite é menor que o número sorteado.");
            } else {
                System.out.println("Parabéns, você acertou! O número era " + sorteado);
                System.out.println("Você tentou " + tentativas + " vezes antes de acertar!");
            }
        } while (palpite != sorteado);
    }
}