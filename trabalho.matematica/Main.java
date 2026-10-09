public class Main {

    public static void main(String[] args) {
        System.out.println("=========================================================================");
        System.out.println("   SISTEMA DE RECOMENDAÇÃO SIMPLES - TEORIA DOS CONJUNTOS (SEM LIBS)    ");
        System.out.println("=========================================================================\n");

        // Definição dos perfis de usuários e conjuntos de interesses (conforme documento)
        String[] nomesUsuarios = {"Bia", "Caio"};
        String[][] interessesOutros = {
            {"jazz", "cinema", "séries", "viagens"}, // Bia
            {"games", "tecnologia", "cinema"}         // Caio
        };

        String nomeAlvo = "Ana";
        String[] interessesAna = {"rock", "jazz", "cinema", "games"};

        System.out.println("Usuário Alvo: " + nomeAlvo);
        System.out.println("Conjunto de Interesses de " + nomeAlvo + ": " 
                + SistemaRecomendacaoPuro.formatarConjunto(interessesAna, interessesAna.length) 
                + " (Cardinalidade = " + interessesAna.length + ")\n");

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Par          | Interseção (A ∩ B)        | União (A ∪ B)              | Jaccard  ");
        System.out.println("----------------------------------------------------------------------------------");

        String usuarioMaisAfin = "";
        double maiorJaccard = -1.0;

        // Processamento de cada par de comparação
        for (int u = 0; u < nomesUsuarios.length; u++) {
            String outroNome = nomesUsuarios[u];
            String[] interessesOutro = interessesOutros[u];

            int[] tamIntersecao = new int[1];
            int[] tamUniao = new int[1];

            // Chamada dos métodos da classe de recomendação
            String[] intersecao = SistemaRecomendacaoPuro.calcularIntersecao(interessesAna, interessesOutro, tamIntersecao);
            String[] uniao = SistemaRecomendacaoPuro.calcularUniao(interessesAna, interessesOutro, tamUniao);

            double jaccard = SistemaRecomendacaoPuro.calcularJaccard(tamIntersecao[0], tamUniao[0]);

            String par = nomeAlvo + " e " + outroNome;
            String strIntersecao = SistemaRecomendacaoPuro.formatarConjunto(intersecao, tamIntersecao[0]) + " (" + tamIntersecao[0] + ")";
            String strUniao = SistemaRecomendacaoPuro.formatarConjunto(uniao, tamUniao[0]) + " (" + tamUniao[0] + ")";

            System.out.printf("%-12s | %-25s | %-26s | %.2f%n", par, strIntersecao, strUniao, jaccard);

            if (jaccard > maiorJaccard) {
                maiorJaccard = jaccard;
                usuarioMaisAfin = outroNome;
            }
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\n[RESULTADO ESPERADO DA RECOMENDAÇÃO]");
        System.out.println("Para a " + nomeAlvo + ", a recomendação mais forte é o " + usuarioMaisAfin 
                + ", pois possui o maior índice de afinidade (Jaccard = " 
                + String.format("%.2f", maiorJaccard) + ").");
    }
}