public class gerente extends funcionario {
    private String setor;

    public gerente(String nome,double salario,String setor){
        super(nome, salario);
        this.setor=setor;
    }
    public String getSetor(){
        return setor;
    }

public void realizarReuniao(){
    System.out.println("O gerente " + getNome() + " está realizando uma reunião do setor de " + setor + ".");

}
}
