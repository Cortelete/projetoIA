# projetoIA
Trabalho Faculdade

1 - População Inicial: A população de cromossomos (possíveis soluções) é gerada aleatoriamente no método inicializarPopulacao.

2 - Avaliação (Fitness Function): Cada cromossomo é avaliado com base no valor total dos produtos que ele seleciona e no volume total dos produtos selecionados, garantindo que o volume não ultrapasse o limite do furgão (avaliar).

3 - Seleção (Roleta Viciada): O método selecaoPorRoleta é utilizado para escolher cromossomos da população, de acordo com suas aptidões (valores totais). Soluções com maior valor têm maior chance de serem selecionadas.

4 - Cruzamento (Recombinação): O método cruzar combina genes de dois "pais" para gerar um novo "filho", promovendo a exploração de novas combinações de produtos.

5 - Mutação: O método mutar altera alguns genes de forma aleatória com uma pequena probabilidade, o que ajuda a evitar que o algoritmo fique preso em máximos locais.

6 - Evolução (Reprodução): A cada geração, a população é substituída por uma nova, composta por filhos dos cromossomos selecionados e modificados, repetindo o ciclo por 1000 gerações.


