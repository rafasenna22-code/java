public class funcionario {
    private String nome;
    private double salario;

    public funcionario(String nome, double salario){
        this.nome= nome;
        this.salario= salario;
    }
    public String getNome(){
        return nome;
    }
    public double getSalario(){
        return salario;
    }
    public void mostrarDados(){
        System.out.println("Nome: "+ nome);
        System.out.println("Salário: R$ " + salario);
    }
}


