# 📊 Sistema de Recomendação Interativo por Teoria dos Conjuntos (Java Puro)

Este repositório contém uma aplicação desenvolvida em **Java** que implementa um **Sistema de Recomendação de Afinidade** baseado em **Teoria dos Conjuntos** e no **Coeficiente de Jaccard**, construído inteiramente com lógica matemática e vetores primitivos, **sem o uso de bibliotecas de terceiros ou Collections avançadas**.

---

## 🎯 Objetivo
Permitir que o usuário interaja com o sistema escolhendo dinamicamente um perfil de interesse (ex: hobbies, músicas, filmes) e calcule de forma automatizada o grau de similaridade e recomendação em relação aos demais perfis cadastrados.

---

## 📐 Decisões de Arquitetura e Tomada de Decisão

### 1. Separação de Responsabilidades (Classes)
* **`SistemaRecomendacaoPuro.java`**: Atua como uma biblioteca utilitária de matemática discreta. Concentra as operações puras de conjuntos (`pertence`, `calcularIntersecao`, `calcularUniao`, `calcularJaccard`) e a formatação textual matemática (`formatarConjunto`).
* **`Main.java`**: Gerencia a camada de interação via terminal (`Scanner`), tratamento de entradas, validações, loops de processamento e a exibição tabular dos resultados.

### 2. Uso Exclusivo de Arrays Primitivos (`String[]`)
* **Decisão:** O projeto evita estruturas dinâmicas prontas (`List`, `HashSet`), utilizando estritamente vetores de tamanho fixo em Java.
* **Solução de Engenharia:** Como arrays possuem tamanho fixo, os métodos alocam arrays temporários com o limite máximo necessário e utilizam um ponteiro de controle (`int k`) para computar os elementos válidos. O retorno da cardinalidade é feito por referência através de um vetor de apoio (`int[] tamanhoResultado`).

### 3. Interface Interativa Tolerante a Erros
* O programa exibe a listagem dos usuários cadastrados com seus respectivos interesses formatados.
* Utiliza uma entrada flexível combinada com blocos `try-catch` (`Integer.parseInt`) e validações de string (`equalsIgnoreCase`), permitindo que o usuário escolha o perfil alvo digitando **tanto o número** da lista quanto o **nome exato** (ex: `1` ou `"Ana"`).
* O loop de processamento filtra automaticamente a auto-comparação (`if (u == indiceAlvo)`), impedindo que o sistema calcule a afinidade de um usuário com ele mesmo.

### 4. Coeficiente de Jaccard
O cálculo estatístico de similaridade entre os conjuntos $A$ e $B$ utiliza a fórmula:
$$J(A, B) = \frac{\vert{}A \cap B\vert{}}{\vert{}A \cup B\vert{}}$$
* Implementa uma proteção contra divisão por zero (`if (cardinalidadeUniao == 0)`), garantindo estabilidade caso conjuntos vazios sejam comparados.

---


# Sistema de Recomendação por Teoria dos Conjuntos

Este documento apresenta os cenários de teste, cálculos manuais e logs de execução do sistema de recomendação baseado na Teoria dos Conjuntos e no Índice de Jaccard.

---

## Cenário 1: Execução Padrão (Usuário Alvo: Ana)

### Dados Iniciais
* **Ana:** `{"rock", "dança", "esporte", "games"}`
* **Bia:** `{"dança", "esporte", "séries", "viagens"}`
* **Caio:** `{"games", "tecnologia", "esporte"}`

### Cálculos Manuais (Ana comparada com Caio)
1. **Interseção ($A \cap C$):** Elementos em comum entre Ana e Caio.
   * Interseção = `{"games", "esporte"}` $\rightarrow$ **Cardinalidade = 2**
2. **União ($A \cup C$):** Todos os elementos combinados sem repetição.
   * União = `{"rock", "dança", "esporte", "games", "tecnologia"}` $\rightarrow$ **Cardinalidade = 5**
3. **Índice de Jaccard $J(A, C)$:**
   * $J = \frac{\vert{}A \cap C\vert{}}{\vert{}A \cup C\vert{}} = \frac{2}{5} = 0.40$

### Log de Saída Esperado
```text
=========================================================================
   SISTEMA DE RECOMENDAÇÃO INTERATIVO - TEORIA DOS CONJUNTOS          
=========================================================================

Usuários cadastrados no sistema:
1. Ana -> {rock, dança, esporte, games}
2. Bia -> {dança, esporte, séries, viagens}
3. Caio -> {games, tecnologia, esporte}

Digite o número ou o nome do usuário alvo que deseja analisar: 1

----------------------------------------------------------------------------------
Usuário Alvo Selecionado: Ana
Conjunto de Interesses: {rock, dança, esporte, games} (Cardinalidade = 4)
----------------------------------------------------------------------------------

----------------------------------------------------------------------------------
Par                            | Interseção (A ∩ B)        | União (A ∪ B)              | Jaccard  
----------------------------------------------------------------------------------
Ana e Bia                    | {dança, esporte} (2)      | {rock, dança, esporte, games, séries, viagens} (6) | 0.33
Ana e Caio                   | {games, esporte} (2)      | {rock, dança, esporte, games, tecnologia} (5) | 0.40
----------------------------------------------------------------------------------

[RESULTADO DA RECOMENDAÇÃO]
Para Ana, a recomendação mais forte é Caio, pois possui o maior índice de afinidade (Jaccard = 0.40).

Cenário 2: Casos de Teste (Conjuntos Iguais e Disjuntos)Para testar este cenário, você pode alterar temporariamente a matriz todosInteresses no código para simular comportamentos extremos.A. Conjuntos Iguais (Ex: Ana e uma "Ana Copia")Conjunto A: {"rock", "games"}Conjunto B: {"rock", "games"}Cálculo Manual:Interseção = {"rock", "games"} (Cardinalidade = 2)União = {"rock", "games"} (Cardinalidade = 2)Jaccard = $2 / 2 = 1.00$ (Afinidade máxima / 100% de similaridade)B. Conjuntos Disjuntos (Nenhum elemento em comum)Conjunto A: {"rock"}Conjunto B: {"viagens"}Cálculo Manual:Interseção = {} (Cardinalidade = 0)União = {"rock", "viagens"} (Cardinalidade = 2)Jaccard = $0 / 2 = 0.00$ (Nenhuma afinidade)Cenário 3: Conjunto Vazio e Tratamento de ExceçõesA. Conjunto VazioSe um usuário cadastrado não tiver nenhum interesse ({}):Comportamento do código: A função formatarConjunto retorna "{}". O cálculo da união funcionará, mas se a união total for vazia (cardinalidade = 0), a função calcularJaccard protege o sistema contra divisão por zero retornando 0.0 automaticamente:Javaif (cardinalidadeUniao == 0) {
    return 0.0;
}
B. Elementos Repetidos na EntradaCaso a entrada contenha elementos duplicados (ex: {"rock", "rock", "esporte"}):Comportamento do código: O método pertence e as rotinas de união operam diretamente sobre o array bruto. Para garantir que conjuntos matemáticos puros não tenham duplicadas na exibição ou cardinalidade, recomenda-se que a entrada seja tratada previamente ou que o sistema filtre duplicatas. No estado atual, o array aceita o texto inserido, mas o cálculo de união via !pertence evita que o mesmo elemento de B seja duplicado ao se juntar com A.

### Dicas de como fazer isso no projeto:
1. **Para testar no console:** Execute o programa (`Main.java`), digite `1` (para Ana) ou digite o nome `Bia` / `Caio` diretamente quando solicitado.
2. **Para validar os cenários avançados (como conjuntos vazios ou iguais):** Basta alterar temporariamente os valores da variável `todosInteresses` dentro da classe `Main` e rodar novamente para ver o resultado gerado pelo terminal bater com o cálculo manual.

Cenário A: Testar Conjuntos Iguais
Se você quiser que a Ana e a Bia tenham exatamente os mesmos gostos para ver o Índice de Jaccard dar 1.00:

Altere a linha da Bia para ficar igual à da Ana:

Java
String[][] todosInteresses = {
    {"rock", "dança", "esporte", "games"},          // Ana (Índice 0)
    {"rock", "dança", "esporte", "games"},          // Bia (Índice 1 - IDÊNTICO)
    {"games", "tecnologia", "esporte"}              // Caio (Índice 2)
};

 Cenário B: Testar Conjunto Vazio ({})
Se você quiser testar o comportamento do programa quando um usuário não tem nenhum interesse cadastrado:

Substitua os interesses de um dos usuários por colchetes vazios "" sem palavras dentro:

Java
String[][] todosInteresses = {
    {"rock", "dança", "esporte", "games"},          // Ana (Índice 0)
    {},                                             // Bia (Índice 1 - VAZIO)
    {"games", "tecnologia", "esporte"}              // Caio (Índice 2)
};

 Cenário C: Testar Conjuntos Disjuntos (Nenhum em comum)
Se você quiser colocar interesses totalmente diferentes para ver o Jaccard dar 0.00:

Mude as palavras para que não haja nenhuma coincidência entre o usuário alvo e os outros:

Java
String[][] todosInteresses = {
    {"rock", "musica"},                             // Ana (Índice 0)
    {"viagens", "praia"},                           // Bia (Índice 1)
    {"computacao", "livros"}                        // Caio (Índice 2)
};