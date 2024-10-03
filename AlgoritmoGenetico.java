import java.util.*;

class Produto {
    String nome;
    double volume;
    double preco;

    Produto(String nome, double volume, double preco) {
        this.nome = nome;
        this.volume = volume;
        this.preco = preco;
    }
}

class Cromossomo {
    int[] genes;  // 1 ou 0 para indicar se o produto está incluído
    double valorTotal;
    double volumeTotal;

    Cromossomo(int tamanho) {
        genes = new int[tamanho];
    }
}

public class AlgoritmoGenetico {

    static List<Produto> produtos = new ArrayList<>();
    static final double limiteVolume = 3.0;  // Capacidade do furgão
    static final int tamanhoPopulacao = 100;
    static final int numeroGeracoes = 1000;
    static final double taxaMutacao = 0.0005; // 0.05%

    public static void main(String[] args) {

        // Lista de produtos (nome, volume, preço)
        produtos.add(new Produto("Geladeira Dako", 0.751, 999.90));
        produtos.add(new Produto("Iphone 6", 0.0000899, 2911.12));
        produtos.add(new Produto("TV 55", 0.400, 4346.99));
        produtos.add(new Produto("TV 50", 0.290, 3999.90));
        produtos.add(new Produto("TV 42", 0.200, 2999.00));
        produtos.add(new Produto("Notebook Dell", 0.00350, 2499.90));
        produtos.add(new Produto("Ventilador Panasonic", 0.496, 199.90));
        produtos.add(new Produto("Microondas Eletrolux", 0.0424, 308.66));
        produtos.add(new Produto("Microondas LG", 0.0544, 429.90));
        produtos.add(new Produto("Microondas Panasonic", 0.0319, 299.29));
        produtos.add(new Produto("Geladeira Brastemp", 0.0635, 849.00));
        produtos.add(new Produto("Geladeira Consul", 0.870, 1199.90));
        produtos.add(new Produto("Notebook Lenovo", 0.498, 1999.90));
        produtos.add(new Produto("Notebook Asus", 0.0527, 3999.00));

        // Inicializa a população
        List<Cromossomo> populacao = inicializarPopulacao(tamanhoPopulacao, produtos.size());

        // Evolução
        for (int geracao = 0; geracao < numeroGeracoes; geracao++) {
            populacao = evoluir(populacao);
        }

        // Melhor solução encontrada
        Cromossomo melhor = encontrarMelhor(populacao);
        System.out.println("Melhor combinação de produtos:");
        for (int i = 0; i < melhor.genes.length; i++) {
            if (melhor.genes[i] == 1) {
                System.out.println(produtos.get(i).nome);
            }
        }
        System.out.printf("Valor total: R$ %.2f\n", melhor.valorTotal);
        System.out.printf("Volume total: %.3f m³\n", melhor.volumeTotal);
    }

    static List<Cromossomo> inicializarPopulacao(int tamanho, int numGenes) {
        List<Cromossomo> populacao = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            Cromossomo cromossomo = new Cromossomo(numGenes);
            for (int j = 0; j < numGenes; j++) {
                cromossomo.genes[j] = random.nextInt(2); // 0 ou 1 aleatoriamente
            }
            avaliar(cromossomo);
            populacao.add(cromossomo);
        }
        return populacao;
    }

    static void avaliar(Cromossomo cromossomo) {
        double valor = 0;
        double volume = 0;
        for (int i = 0; i < cromossomo.genes.length; i++) {
            if (cromossomo.genes[i] == 1) {
                valor += produtos.get(i).preco;
                volume += produtos.get(i).volume;
            }
        }
        if (volume > limiteVolume) {  // Se o volume ultrapassa o limite, desqualifica a solução
            valor = 0;
        }
        cromossomo.valorTotal = valor;
        cromossomo.volumeTotal = volume;
    }

    static List<Cromossomo> evoluir(List<Cromossomo> populacao) {
        List<Cromossomo> novaPopulacao = new ArrayList<>();
        Random random = new Random();

        // Seleção e cruzamento
        while (novaPopulacao.size() < tamanhoPopulacao) {
            Cromossomo pai1 = selecaoPorRoleta(populacao);
            Cromossomo pai2 = selecaoPorRoleta(populacao);
            Cromossomo filho = cruzar(pai1, pai2);
            mutar(filho);
            avaliar(filho);
            novaPopulacao.add(filho);
        }

        return novaPopulacao;
    }

    static Cromossomo selecaoPorRoleta(List<Cromossomo> populacao) {
        double somaAptidao = populacao.stream().mapToDouble(c -> c.valorTotal).sum();
        double limite = new Random().nextDouble() * somaAptidao;
        double acumulado = 0;
        for (Cromossomo cromossomo : populacao) {
            acumulado += cromossomo.valorTotal;
            if (acumulado >= limite) {
                return cromossomo;
            }
        }
        return populacao.get(0);  // fallback
    }

    static Cromossomo cruzar(Cromossomo pai1, Cromossomo pai2) {
        Cromossomo filho = new Cromossomo(pai1.genes.length);
        Random random = new Random();
        for (int i = 0; i < pai1.genes.length; i++) {
            filho.genes[i] = random.nextBoolean() ? pai1.genes[i] : pai2.genes[i];
        }
        return filho;
    }

    static void mutar(Cromossomo cromossomo) {
        Random random = new Random();
        for (int i = 0; i < cromossomo.genes.length; i++) {
            if (random.nextDouble() < taxaMutacao) {
                cromossomo.genes[i] = 1 - cromossomo.genes[i]; // inverte 0 para 1 ou 1 para 0
            }
        }
    }

    static Cromossomo encontrarMelhor(List<Cromossomo> populacao) {
        return populacao.stream().max(Comparator.comparingDouble(c -> c.valorTotal)).orElse(null);
    }
}
