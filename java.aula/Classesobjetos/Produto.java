public class Produto {
    private String nome;
    private double preco;
    private int quantidadeInicial;
    
    public Produto (String nome, double preco, int quantidadeInicial){
        this.nome = nome;
        this.preco = 10.8;
        this.quantidadeInicial = 100;
    }

    public void alterarPreco( double novoPreco) {
        if (novoPreco > 0){
            preco = novoPreco;
        }
    }
     public void adicionarEstoque (int quantidade) {
        if (quantidade > 0){
            quantidadeInicial += quantidade;
        }
     }
     public void retirarEstoque (int quantidade) {
        if (quantidade > 0 && quantidade <= quantidadeInicial){
            quantidadeInicial -= quantidade;
        }
     }

     public String getnome() {
        return nome;
     }
     public double getpreco() {
        return preco;
     }
     public int getquantidadeInicial() {
        return quantidadeInicial;
     }

     public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("quantidade em  estoque: " + quantidadeInicial);
}
}
