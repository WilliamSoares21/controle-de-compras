package loja;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import loja.produtos.*;

public class Catalogo {
  private Map<String, List<Produto>> produtosPorCategoria = new HashMap<>();

  public Catalogo() {
    List<Produto> vestuario = new ArrayList<>();
    vestuario.add(new Camisa(150, "Adidas Summer fest", "Camisa de algodão estampada"));
    vestuario.add(new Camisa(120, "Nike Air Max", "Camisa esportiva leve"));
    vestuario.add(new Camisa(200, "Polo Ralph Lauren", "Camisa polo clássica"));
    vestuario.add(new Camisa(180, "Levi's Denim", "Camisa jeans resistente"));

    vestuario.add(new Calca(250, "Calça Jeans Slim Fit", "Calça jeans azul escuro"));
    vestuario.add(new Calca(300, "Calça Chino Casual", "Calça chino bege"));
    vestuario.add(new Calca(280, "Calça de Moletom Conforto", "Calça de moletom cinza"));
    vestuario.add(new Calca(350, "Calça Social Slim", "Calça social preta"));

    vestuario.add(new Calcao(120, "Calção de Praia", "Calção leve para praia"));
    vestuario.add(new Calcao(150, "Calção Esportivo", "Calção para atividades físicas"));
    vestuario.add(new Calcao(130, "Calção Casual", "Calção confortável para o dia a dia"));
    vestuario.add(new Calcao(160, "Calção de Natação", "Calção resistente à água"));

    vestuario.add(new Moletom(200, "Moletom com Capuz", "Moletom confortável com capuz"));
    vestuario.add(new Moletom(220, "Moletom Sem Capuz", "Moletom clássico sem capuz"));
    vestuario.add(new Moletom(250, "Moletom Oversized", "Moletom estilo oversized"));
    vestuario.add(new Moletom(300, "Moletom com Estampa", "Moletom com estampa moderna"));

    List<Produto> eletrodomesticos = new ArrayList<>();
    eletrodomesticos.add(new Batedeira(500, "Batedeira Planetária", "Batedeira com múltiplas velocidades"));
    eletrodomesticos.add(new Batedeira(600, "Batedeira Compacta", "Batedeira pequena para uso doméstico"));
    eletrodomesticos.add(new Batedeira(700, "Batedeira Profissional", "Batedeira para uso profissional"));
    eletrodomesticos.add(new Batedeira(800, "Batedeira com Acessórios", "Batedeira com vários acessórios"));

    eletrodomesticos.add(new Liquidificador(400, "Liquidificador Potente", "Liquidificador com alta potência"));
    eletrodomesticos.add(new Liquidificador(350, "Liquidificador Compacto", "Liquidificador pequeno e eficiente"));
    eletrodomesticos
        .add(new Liquidificador(450, "Liquidificador com Função Pulsar", "Liquidificador com função pulsar"));
    eletrodomesticos.add(
        new Liquidificador(500, "Liquidificador com Copo de Vidro", "Liquidificador com copo resistente de vidro"));

    eletrodomesticos.add(new Microondas(800, "Micro-ondas Digital", "Micro-ondas com painel digital"));
    eletrodomesticos.add(new Microondas(750, "Micro-ondas Compacto", "Micro-ondas pequeno para cozinhas pequenas"));
    eletrodomesticos.add(new Microondas(900, "Micro-ondas com Grill", "Micro-ondas com função grill"));
    eletrodomesticos.add(new Microondas(1000, "Micro-ondas Inox", "Micro-ondas com acabamento em inox"));

    eletrodomesticos.add(new Geladeira(2000, "Geladeira Duplex", "Geladeira com freezer em cima"));
    eletrodomesticos.add(new Geladeira(2500, "Geladeira Side by Side", "Geladeira com portas lado a lado"));
    eletrodomesticos.add(new Geladeira(3000, "Geladeira Inox", "Geladeira com acabamento em inox"));
    eletrodomesticos.add(new Geladeira(3500, "Geladeira Frost Free", "Geladeira sem necessidade de descongelar"));

    // adiciona as listas ao mapa princpipal
    this.produtosPorCategoria.put("Vestuário", vestuario);
    this.produtosPorCategoria.put("Eletrodomésticos", eletrodomesticos);
  }

  public void mostratSetores() {
    System.out.println("======= SETORES DA LOJA =======");
    int i = 1;
    for (String setor : produtosPorCategoria.keySet()) {
      System.out.println(i + " - " + setor);
      i++;
    }
    System.out.println("-----------------------------");
  }

  public void mostrarProdutosDoSetor(String setor) {
    List<Produto> produtos = produtosPorCategoria.get(setor);
    if (produtos != null) {
      System.out.println("======= PRODUTOS DE " + setor.toUpperCase() + " =======");
      for (int i = 0; i < produtos.size(); i++) {
        System.out.println("------------------------------------");
        System.out.println("OPÇÃO " + (i + 1)); // Mostra Opção 1, 2, 3...
        System.out.println(produtos.get(i));
      }
    }
    System.out.println("------------------------------------");
  }

  public Produto getProduto(String setor, int indice) {
    List<Produto> produtos = produtosPorCategoria.get(setor);
    if (produtos != null && indice >= 0 && indice < produtos.size()) {
      return produtos.get(indice);
    }
    return null; // Retorna null se o produto não for encontrado
  }
}
