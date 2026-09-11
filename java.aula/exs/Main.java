public class Main{
    public static void main (String[]args){
        Carro carro1 = new Carro();
        carro1.marca= "fiat";
        carro1.modelo = "uno";
        carro1.cor = "vermelho";
        carro1.velocidade = 0;
        carro1.ano = 2020;
        carro1.combustivel = "alcool";
        carro1.ligado = false;
        
        
        System.out.println ("Estado inicial:");
        carro1.mostrarDados();

        System.out.println("Ligado");
        carro1.ligar();
        carro1.mostrarDados();

        System.out.println("Acelerando...");
        carro1.acelerar();
        carro1.acelerar();
        carro1.acelerar();
        carro1.mostrarDados();

        System.out.println("biiii bi " );
        carro1.buzinar();
        carro1.mostrarDados();

        System.out.println("\n Freando...");
        carro1.frear();
        carro1.mostrarDados();
    }
}