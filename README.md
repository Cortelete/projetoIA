# projetoIA

**Trabalho Faculdade**

1. **População Inicial:** A população de cromossomos (possíveis soluções) é gerada aleatoriamente no método inicializarPopulacao.

2. **Avaliação (Fitness Function):** Cada cromossomo é avaliado com base no valor total dos produtos que ele seleciona e no volume total dos produtos selecionados, garantindo que o volume não ultrapasse o limite do furgão (avaliar).

3. **Seleção (Roleta Viciada):** O método selecaoPorRoleta é utilizado para escolher cromossomos da população, de acordo com suas aptidões (valores totais). Soluções com maior valor têm maior chance de serem selecionadas.

4. **Cruzamento (Recombinação):** O método cruzar combina genes de dois "pais" para gerar um novo "filho", promovendo a exploração de novas combinações de produtos.

5. **Mutação:** O método mutar altera alguns genes de forma aleatória com uma pequena probabilidade, o que ajuda a evitar que o algoritmo fique preso em máximos locais.

6. **Evolução (Reprodução):** A cada geração, a população é substituída por uma nova, composta por filhos dos cromossomos selecionados e modificados, repetindo o ciclo por 1000 gerações.

7. **Função encontrarMelhor:** Ao final, a melhor solução (maior valor total e volume dentro do limite) é exibida.

---------------------------------------------

**Passo a Passo:**

1. **Entendendo o Problema:**

    - O problema consiste em encontrar a melhor combinação de produtos para maximizar o valor.
    - O volume dos produtos selecionados não pode ultrapassar o limite do furgão.

    Temos vários produtos, cada um com um volume e preço, e queremos maximizar o valor total transportado por um furgão que tem espaço limitado (3.0 m³). Então, o objetivo é escolher a combinação de produtos que tenha o maior valor (preço total) sem ultrapassar o limite de volume.

2. **O que é um Algoritmo Genético?**

    - Um algoritmo genético é uma técnica de otimização inspirada na evolução.
    - Ele utiliza uma população de soluções (cromossomos) que são aval.

    Um algoritmo genético tenta resolver problemas simulando o processo de seleção natural (como na evolução das espécies). Ele gera uma "população" de possíveis soluções (diferentes combinações de produtos) e, em cada "geração", as melhores combinações são selecionadas, "cruzadas" (combinadas), e "mutadas" (modificadas) para gerar uma nova população.

3. **Componentes principais do Algoritmo Genético:**

    - Inicializar a População: Gerar 100 combinações de produtos aleatoriamente.
    - Avaliar: Calcular o valor total de cada combinação e verificar se cabe no furgão.
    - Seleção: Escolher combinações melhores com base no valor (usando roleta viciada).
    - Cruzamento: Combinar soluções para criar novas combinações.
    - Mutação: Fazer pequenas mudanças nas combinações.
    - Repetir: Repetir esse processo por 1000 gerações.

    **Cromossomo:** Representa uma solução (nesse caso, uma combinação de produtos).
        Vamos representar cada produto com 1 (se ele for escolhido) ou 0 (se não for escolhido).

    **População:** Um grupo de várias combinações diferentes de produtos.
        Teremos 100 combinações de produtos inicialmente (população inicial).

    **Função de Avaliação (Fitness):** Avalia o quão boa é uma solução.
        Vamos calcular o valor total dos produtos selecionados e verificar se eles cabem no furgão.

    **Seleção:** Escolher as melhores soluções para "reproduzir".
        Vamos usar a seleção por "roleta viciada", onde soluções com maior valor têm mais chances de serem escolhidas.

    **Cruzamento:** Combinar duas soluções para criar uma nova.
        Vamos pegar partes de duas soluções e misturá-las.

    **Mutação:** Fazer pequenas mudanças aleatórias.
        Vamos alterar produtos em algumas soluções (com 0,05% de chance de acontecer).

4. **Passos do Algoritmo:** 

    ***Compilar o código:***

        - Se estiver usando IntelliJ ou Eclipse, o código será compilado automaticamente ao salvar o arquivo.

        - Se estiver usando um editor de texto e terminal, navegue até o diretório do arquivo e compile-o manualmente: 
        
            javac AlgoritmoGenetico.java
    
    ***Executar o código:***

        - Em sua IDE, basta clicar no botão de Run (rodar) o código.

        - Se estiver no terminal, execute com o comando: 
        
            java AlgoritmoGenetico

---------------------------------------------

**Explicação do Código:**

-   **Classe Produto**: Representa um produto com volume e preço.
        Representa um produto, contendo três propriedades:
        Nome do produto (String nome)
        Volume ocupado no furgão (double volume)
        Preço ou valor do produto (double preco)

-   **Classe Cromossomo**: Representa uma combinação de produtos (solução).
        Representa uma solução, ou seja, uma combinação de produtos que o furgão pode carregar.
        Tem dois atributos principais:
        Um array de inteiros chamado genes, que define se um produto está no furgão (1) ou não (0).
        A função avaliar calcula:
        Valor total dos produtos selecionados.
        Volume total que os produtos ocupam no furgão.

-   **Inicializar População**: Gera 100 soluções aleatórias.
        Gera a população inicial do algoritmo genético, que são 100 combinações de produtos (definido no hyperparâmetro tamanhoPopulacao).
        Cada cromossomo da população é uma combinação de produtos, com valores de 0 ou 1 definidos aleatoriamente.

-   **Função Avaliar**: Calcula o valor e volume total de cada solução.
        Calcula o valor total e o volume total de um cromossomo (combinação de produtos).
        Se o volume ultrapassar o limite do furgão (3.0 m³), o valor total da combinação é desqualificado (ou seja, recebe valor 0).

-   **Seleção por Roleta Viciada**: Escolhe soluções melhores com maior probabilidade.
        Essa função utiliza o conceito de "roleta viciada", onde cromossomos com maior valor total têm mais chances de serem escolhidos para se reproduzir e gerar a próxima geração.

-   **Mutação**: Faz pequenas alterações nos genes com uma chance de 0,05%.
        Faz uma pequena mutação nos genes de um cromossomo, trocando 0 por 1 ou 1 por 0, com uma probabilidade muito baixa (0,05%).

-   **Evolução**: Seleção, cruzamento e mutação são aplicados em cada geração.
        Essa função executa todo o ciclo de evolução: seleção dos pais (usando roleta viciada), cruzamento, mutação, e geração de uma nova população.
9
-   **Função encontrarMelhor**: Ao final, a melhor solução (maior valor total e volume dentro do limite) é exibida.
        No final, após 1000 gerações, essa função identifica o cromossomo (combinação de produtos) que tem o maior valor total, garantindo que ele respeita o limite de volume.