import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================================================");
        System.out.println("   SISTEMA DE RECOMENDAÇÃO INTERATIVO - TEORIA DOS CONJUNTOS           ");
        System.out.println("=========================================================================\n");

        // Lista unificada com todos os usuários e seus respectivos interesses
        String[] todosUsuarios = {"Ana", "Bia", "Caio"};
        String[][] todosInteresses = {
            {"rock", "dança", "esporte", "games"},           // Ana (Índice 0)
            {"dança","esporte","séries", "viagens"},      // Bia (Índice 1)
            {"games", "tecnologia", "esporte"}             // Caio (Índice 2)
        };

        // Exibe as opções disponíveis para o usuário escolher
        System.out.println("Usuários cadastrados no sistema:");
        for (int i = 0; i < todosUsuarios.length; i++) {
            System.out.println((i + 1) + ". " + todosUsuarios[i] + " -> " + 
                SistemaRecomendacaoPuro.formatarConjunto(todosInteresses[i], todosInteresses[i].length));
        }

        System.out.print("\nDigite o **número** ou o **nome** do usuário alvo que deseja analisar: ");
        String entrada = scanner.nextLine().trim();

        int indiceAlvo = -1;

        // Tenta identificar se o usuário digitou um número
        try {
            int numeroEscolhido = Integer.parseInt(entrada);
            if (numeroEscolhido >= 1 && numeroEscolhido <= todosUsuarios.length) {
                indiceAlvo = numeroEscolhido - 1;
            }
        } catch (NumberFormatException e) {
            // Se não for número, tenta buscar pelo nome digitado (ignorando maiúsculas/minúsculas)
            for (int i = 0; i < todosUsuarios.length; i++) {
                if (todosUsuarios[i].equalsIgnoreCase(entrada)) {
                    indiceAlvo = i;
                    break;
                }
            }
        }

        // Valida se a escolha foi válida
        if (indiceAlvo == -1) {
            System.out.println("\n[ERRO] Usuário não encontrado! Reinicie o programa e tente novamente.");
            scanner.close();
            return;
        }

        String nomeAlvo = todosUsuarios[indiceAlvo];
        String[] interessesAlvo = todosInteresses[indiceAlvo];

        System.out.println("\n----------------------------------------------------------------------------------");
        System.out.println("Usuário Alvo Selecionado: " + nomeAlvo);
        System.out.println("Conjunto de Interesses: " + SistemaRecomendacaoPuro.formatarConjunto(interessesAlvo, interessesAlvo.length) 
                + " (Cardinalidade = " + interessesAlvo.length + ")");
        System.out.println("----------------------------------------------------------------------------------\n");

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Par                          | Interseção (A ∩ B)        | União (A ∪ B)              | Jaccard  ");
        System.out.println("----------------------------------------------------------------------------------");

        String usuarioMaisAfin = "";
        double maiorJaccard = -1.0;

        // Processamento comparando o alvo com todos os OUTROS usuários
        for (int u = 0; u < todosUsuarios.length; u++) {
            // Pula a comparação do usuário com ele mesmo
            if (u == indiceAlvo) {
                continue;
            }

            String outroNome = todosUsuarios[u];
            String[] interessesOutro = todosInteresses[u];

            int[] tamIntersecao = new int[1];
            int[] tamUniao = new int[1];

            String[] intersecao = SistemaRecomendacaoPuro.calcularIntersecao(interessesAlvo, interessesOutro, tamIntersecao);
            String[] uniao = SistemaRecomendacaoPuro.calcularUniao(interessesAlvo, interessesOutro, tamUniao);

            double jaccard = SistemaRecomendacaoPuro.calcularJaccard(tamIntersecao[0], tamUniao[0]);

            String par = nomeAlvo + " e " + outroNome;
            String strIntersecao = SistemaRecomendacaoPuro.formatarConjunto(intersecao, tamIntersecao[0]) + " (" + tamIntersecao[0] + ")";
            String strUniao = SistemaRecomendacaoPuro.formatarConjunto(uniao, tamUniao[0]) + " (" + tamUniao[0] + ")";

            System.out.printf("%-28s | %-25s | %-26s | %.2f%n", par, strIntersecao, strUniao, jaccard);

            if (jaccard > maiorJaccard) {
                maiorJaccard = jaccard;
                usuarioMaisAfin = outroNome;
            }
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\n[RESULTADO DA RECOMENDAÇÃO]");
        System.out.println("Para " + nomeAlvo + ", a recomendação mais forte é " + usuarioMaisAfin 
                + ", pois possui o maior índice de afinidade (Jaccard = " 
                + String.format("%.2f", maiorJaccard) + ").");

        scanner.close();
    }
}