public class Main{
    public static void main (String[]args){
        Carro carro1 = new Carro();
        carro1.marca= "fiat";
        carro1.modelo = "uno";
        carro1.cor = "vermelho";
        carro1.velocidade = 0;

        System.out.println ("Estado inicial:");
        carro1.mostrarDados();

        System.out.println("Acelerando...");
        carro1.acelerar();
        carro1.acelerar();
        carro1.acelerar();
    
        carro1.mostrarDados();

        System.out.println("\n Freando...");
        carro1.frear();

        carro1.mostrarDados();
    }
}