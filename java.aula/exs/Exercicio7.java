public class Exercicio7 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
    
        System.out.println ("Desenvolva um programa onde o valor de entrada de a = 10 e de b = 20 e depois inverta os valores com uma variavel aux.");
        System.out.println("Antes da troca: A = " + a + ", B = " + b);

        int aux = a;
        a = b;
        b = aux;

        System.out.println("Após a troca: A = " + a + ", B = " + b);

    }
}