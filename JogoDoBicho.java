package p2;

import java.util.*;

/**
 * Classe que simula um jogo de apostas em animais (Jogo do Bicho).
 * Os jogadores fazem uma aposta em uma lista de animais escolhidos aleatoriamente.
 */
public class JogoDoBicho {
    // Array de nomes dos bichos
    static String[] bichos = {"Avestruz", "Águia","Burro","Borboleta","Cachorro","Cabra",
            "Carneiro","Camelo", "Cobra", "Coelho","Cavalo", "Elefante",
            "Galo", "Gato","Jacaré", "Leão", "Macaco","Porco", "Pavão",
            "Peru","Touro","Tigre","Urso","Veado","Vaca"};

    // Tamanho da aposta
    static int tam = 5;

    /**
     * Método principal que executa o programa.
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        int[] ficha = new int[tam];
        fazAposta(ficha);
        Arrays.sort(ficha);
        imprimeAposta(ficha);
    }

    /**
     * Retorna o nome do bicho correspondente ao número fornecido.
     * @param num O número do bicho.
     * @return O nome do bicho ou uma string vazia se o número for inválido.
     */
    public static String pegaBicho(int num) {
        if (num > 0 && num <= 25) {
            return bichos[num - 1];
        } else {
            return "";
        }
    }

    /**
     * Verifica se um número está presente em um array.
     * @param array O array a ser verificado.
     * @param num O número a ser procurado.
     * @return true se o número estiver presente no array, caso contrário false.
     */
    public static boolean saoIguais(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Realiza uma aposta, preenchendo o array de fichas com números aleatórios que
     * correspondem aos bichos. Garante que não há números duplicados no array.
     * @param fichas O array que armazena os números sorteados.
     */
    public static void fazAposta(int[] fichas) {
        Random random = new Random();
        int sorteio;
        for (int i = 0; i < tam; i++) {
            do {
                sorteio = random.nextInt(bichos.length) + 1;
            } while (saoIguais(fichas, sorteio));
            fichas[i] = sorteio;
        }
    }

    /**
     * Imprime os nomes dos bichos apostados.
     * @param ficha O array contendo os números sorteados.
     */
    public static void imprimeAposta(int[] ficha) {
        for (int animal : ficha) {
            System.out.println(pegaBicho(animal));
        }
    }
}
