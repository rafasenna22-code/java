public class Carro {
    String marca;
    String cor;
    String modelo;
    int velocidade;
    int ano;
    String combustivel;
    Boolean ligado;

    void buzinar(){
        System.out.println("BI BI BI");
    }
    void ligar(){
        ligado = true; 

    }
    void desligar(){
        ligado = false; 
    }

    void acelerar(){
        velocidade = velocidade + 10;
    }
    void frear (){
    velocidade = velocidade - 10;
    }
    void mostrarDados(){
        System.out.println("marca:"+ marca);
        System.out.println("cor:" + cor);
        System.out.println("modelo:" + modelo);
        System.out.println("velocidade:" + velocidade);
        System.out.println("ano:" + ano);
        System.out.println("combustivel:" + combustivel);
        System.out.println("ligado:" + ligado);
        System.out.println("desligado:" + !ligado);
        System.out.println();
    

    }
}
