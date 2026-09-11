public class funcionario1 {
    public static void main(String[] args) {
        gerente gerente= new gerente("João Santos", 6700.00, "TI");
        
        desenvolvedor desenvolvedor= new desenvolvedor("Lucia Maria", 8600.00, "Java");
    
        System.out.println("---DADOS DO GERENTE---");
        gerente.mostrarDados();
        System.out.println("Setor: " + gerente.getSetor());
        gerente.realizarReuniao();

        System.out.println("\n---DADOS DO DESENVOLVEDOR----");
        desenvolvedor.mostrarDados();
        System.out.println("Linguagem: " + desenvolvedor.getLinguagem());
        desenvolvedor.programar();
    }
    
}
