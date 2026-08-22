public class Carro {
    String marca;
    String cor;
    String modelo;
    int velocidade;

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
        System.out.println();
    

    }
}
