public class desenvolvedor extends funcionario {
    private String linguagem;
    
    public desenvolvedor(String nome, double salario, String linguagem){
        super(nome, salario);
        this.linguagem=linguagem;
    }
    public String getLinguagem(){
        return linguagem;
    }
    public void programar(){
        System.out.println("O desenvolvedor " + getNome() + " esta programando em " + linguagem + ".");
    }
    }

