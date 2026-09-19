public class main {
    public static void main(String[] args){
        Funcionario f1=new Gerente("Marcos ",8000);
        Funcionario f2=new Desenvolvedor("Ana ",5000);

        f1.mostrarDados();
        System.out.println("Bônus: "+ f1.calcularBonus());
        f2.mostrarDados();
        System.out.println("Bônus: " + f2.calcularBonus());
    }
    
}
