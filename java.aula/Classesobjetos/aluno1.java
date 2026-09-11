public class aluno1 {
    public static void main(String[] args) {
        // 5. Testando com notas válidas
        System.out.println("=== TESTE COM NOTAS VÁLIDAS ===");
        aluno aluno = new aluno("João");

        aluno.setPrimeiraNota(8.5);
        aluno.setSegundaNota(7.0);
        aluno.mostrarDados();
    }
}