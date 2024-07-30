import java.util.Random;
import java.util.Scanner;

public class WordScramble {
    private static final String[] PALAVRAS = {"casa", "carro", "arvore", "computador", "java"};
    private static final int TENTATIVAS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String palavra = PALAVRAS[random.nextInt(PALAVRAS.length)];
        char[] letras = palavra.toCharArray();
        char[] letrasEmbaralhadas = embaralharLetras(letras);

        System.out.println("Bem-vindo ao Word Scramble!");
        System.out.println("Você tem " + TENTATIVAS + " tentativas para acertar a palavra.");

        for (int i = 0; i < TENTATIVAS; i++) {
            System.out.println("Palavra embaralhada: " + new String(letrasEmbaralhadas));
            System.out.print("Digite uma letra: ");
            String letra = scanner.next().toLowerCase();

            if (letra.length() != 1) {
                System.out.println("Por favor, digite apenas uma letra.");
                continue;
            }

            char letraChar = letra.charAt(0);
            if (contemLetra(letras, letraChar)) {
                System.out.println("Letra correta!");
                letrasEmbaralhadas = revelarLetra(letrasEmbaralhadas, letraChar, letras);
            } else {
                System.out.println("Letra incorreta!");
            }

            if (new String(letrasEmbaralhadas).equals(palavra)) {
                System.out.println("Parabéns! Você acertou a palavra: " + palavra);
                return;
            }
        }

        System.out.println("Você não acertou a palavra. A palavra correta era: " + palavra);
    }

    private static char[] embaralharLetras(char[] letras) {
        Random random = new Random();
        char[] letrasEmbaralhadas = new char[letras.length];

        for (int i = 0; i < letras.length; i++) {
            int indice = random.nextInt(letras.length);
            letrasEmbaralhadas[i] = letras[indice];
        }

        return letrasEmbaralhadas;
    }

    private static boolean contemLetra(char[] letras, char letra) {
        for (char c : letras) {
            if (c == letra) {
                return true;
            }
        }
        return false;
    }

    private static char[] revelarLetra(char[] letrasEmbaralhadas, char letra, char[] letras) {
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == letra) {
                letrasEmbaralhadas[i] = letra;
            }
        }
        return letrasEmbaralhadas;
    }
}