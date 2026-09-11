public class aluno {
    private String nome;
    private double primeiraNota;
    private double segundaNota;

    public aluno (String nome){
        this.nome= nome;
    
    }
    public void setPrimeiraNota(double nota) {
        if (nota >= 0 && nota<=10);   
        this.primeiraNota = nota;
    }

    public void setSegundaNota (double nota){
        if(nota >= 0 &&  nota<=10) ;
        this.segundaNota = nota;
        }
    
    
    public double getprimeiraNota(){
        return primeiraNota;
    }

    public double getsegundaNota(){
        return segundaNota;
    }
    
    public double calcularMedia(){
        return (primeiraNota + segundaNota) / 2.0;
    }

    public void mostrarDados(){
        System.out.println ("Nome: " + nome);
        System.out.println ("Primeira Nota: "+ primeiraNota);
        System.out.println ("Segunda Nota: "+ segundaNota);
        System.out.println ("Média: " + calcularMedia());
    }
}
