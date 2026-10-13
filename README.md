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