public class SistemaRecomendacaoPuro {

    /**
     * Função matemática para verificar se um elemento pertence a um conjunto (x ∈ A).
     */
    public static boolean pertence(String elemento, String[] conjunto, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            if (conjunto[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula a Interseção entre dois conjuntos (A ∩ B).
     */
    public static String[] calcularIntersecao(String[] conjuntoA, String[] conjuntoB, int[] tamanhoResultado) {
        String[] temp = new String[conjuntoA.length];
        int k = 0;

        for (int i = 0; i < conjuntoA.length; i++) {
            if (pertence(conjuntoA[i], conjuntoB, conjuntoB.length)) {
                temp[k] = conjuntoA[i];
                k++;
            }
        }

        tamanhoResultado[0] = k; // Retorna a cardinalidade |A ∩ B|
        return temp;
    }

    /**
     * Calcula a União entre dois conjuntos (A ∪ B).
     */
    public static String[] calcularUniao(String[] conjuntoA, String[] conjuntoB, int[] tamanhoResultado) {
        String[] temp = new String[conjuntoA.length + conjuntoB.length];
        int k = 0;

        // Adiciona todos os elementos do Conjunto A
        for (int i = 0; i < conjuntoA.length; i++) {
            temp[k] = conjuntoA[i];
            k++;
        }

        // Adiciona elementos de B que NÃO estão em A
        for (int i = 0; i < conjuntoB.length; i++) {
            if (!pertence(conjuntoB[i], conjuntoA, conjuntoA.length)) {
                temp[k] = conjuntoB[i];
                k++;
            }
        }

        tamanhoResultado[0] = k; // Retorna a cardinalidade |A ∪ B|
        return temp;
    }

    /**
     * Cálculo do Índice de Jaccard: J(A, B) = |A ∩ B| / |A ∪ B|
     */
    public static double calcularJaccard(int cardinalidadeIntersecao, int cardinalidadeUniao) {
        if (cardinalidadeUniao == 0) {
            return 0.0;
        }
        return (double) cardinalidadeIntersecao / cardinalidadeUniao;
    }

    /**
     * Formata um conjunto para exibição em texto {elem1, elem2}.
     */
    public static String formatarConjunto(String[] conjunto, int tamanho) {
        if (tamanho == 0) return "{}";
        
        String resultado = "{";
        for (int i = 0; i < tamanho; i++) {
            resultado += conjunto[i];
            if (i < tamanho - 1) {
                resultado += ", ";
            }
        }
        resultado += "}";
        return resultado;
    }
}