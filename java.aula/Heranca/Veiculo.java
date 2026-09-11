public class Veiculo{
    private String marca;
    private String modelo;
    private int velocidade;
    private boolean ligado;

      public Veiculo (String marca, String modelo)
      {
         this.marca = marca;
         this.modelo= modelo;
         this.velocidade = 0;
         this.ligado = false; 
         }

         public void ligar()
         {
            ligado = true;
         }

         public void desligar() {
            if (velocidade == 0) {
                ligado = false;
            } }
    public void acelerar() {
        if (ligado) {
            velocidade += 10;  
        }
    }
    public void frear() {
        if (velocidade >= 10) {
            velocidade -= 10;  }
            else {    velocidade = 0; }
       }
            


    public String getMarca() { return marca;}
    public String getModelo() {return modelo;}
    public int getVelocidade() {return velocidade;}
    public boolean isLigado() { return ligado;}
}