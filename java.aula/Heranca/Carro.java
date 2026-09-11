public class Carro extends Veiculo  {
private int quantidadePortas;

    public Carro(String marca, String modelo, int quantidadePortas ) 
    {
        super(marca, modelo);  this.quantidadePortas = quantidadePortas;    
        }

        public void abrirPortamalas() {
            System.out.println("Porta-malas aberto.");   }

            public int getQuantidadePortas()
          {
         return quantidadePortas;
          }
    }


