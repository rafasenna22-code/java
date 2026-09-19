public abstract class Funcionario{
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario; 
    }

    public String getNome(){return nome;}
    public double getSalario(){return salario;}

    public void mostrarDados(){
    System.out.println("Nome: "+ nome);
    System.out.println("Salario: " + salario);
    }
    public abstract double calcularBonus();
}