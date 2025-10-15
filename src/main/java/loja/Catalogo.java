package loja;

import java.util.List;
import java.util.ArrayList;

import loja.produtos.*;

public class Catalogo {
  private List<Produto> listaDeProdutos = new ArrayList<>();

  public Catalogo() {
    this.listaDeProdutos.add(new Camisa(150, "Adidas Summer fest", "Camisa de algodão estampada"));
    this.listaDeProdutos.add(new Camisa(120, "Nike Air Max", "Camisa esportiva leve"));
    this.listaDeProdutos.add(new Camisa(200, "Polo Ralph Lauren", "Camisa polo clássica"));
    this.listaDeProdutos.add(new Camisa(180, "Levi's Denim", "Camisa jeans resistente"));

    this.listaDeProdutos.add(new Calca(250, "Calça Jeans Slim Fit", "Calça jeans azul escuro"));
    this.listaDeProdutos.add(new Calca(300, "Calça Chino Casual", "Calça chino bege"));
    this.listaDeProdutos.add(new Calca(280, "Calça de Moletom Conforto", "Calça de moletom cinza"));
    this.listaDeProdutos.add(new Calca(350, "Calça Social Slim", "Calça social preta"));

    this.listaDeProdutos.add(new Calcao(120, "Calção de Praia", "Calção leve para praia"));
    this.listaDeProdutos.add(new Calcao(150, "Calção Esportivo", "Calção para atividades físicas"));
    this.listaDeProdutos.add(new Calcao(130, "Calção Casual", "Calção confortável para o dia a dia"));
    this.listaDeProdutos.add(new Calcao(160, "Calção de Natação", "Calção resistente à água"));

    this.listaDeProdutos.add(new Moletom(200, "Moletom com Capuz", "Moletom confortável com capuz"));
    this.listaDeProdutos.add(new Moletom(220, "Moletom Sem Capuz", "Moletom clássico sem capuz"));
    this.listaDeProdutos.add(new Moletom(250, "Moletom Oversized", "Moletom estilo oversized"));
    this.listaDeProdutos.add(new Moletom(300, "Moletom com Estampa", "Moletom com estampa moderna"));

    this.listaDeProdutos.add(new Batedeira(500, "Batedeira Planetária", "Batedeira com múltiplas velocidades"));
    this.listaDeProdutos.add(new Batedeira(600, "Batedeira Compacta", "Batedeira pequena para uso doméstico"));
    this.listaDeProdutos.add(new Batedeira(700, "Batedeira Profissional", "Batedeira para uso profissional"));
    this.listaDeProdutos.add(new Batedeira(800, "Batedeira com Acessórios", "Batedeira com vários acessórios"));

    this.listaDeProdutos.add(new Liquidificador(400, "Liquidificador Potente", "Liquidificador com alta potência"));
    this.listaDeProdutos.add(new Liquidificador(350, "Liquidificador Compacto", "Liquidificador pequeno e eficiente"));
    this.listaDeProdutos
        .add(new Liquidificador(450, "Liquidificador com Função Pulsar", "Liquidificador com função pulsar"));
    this.listaDeProdutos.add(
        new Liquidificador(500, "Liquidificador com Copo de Vidro", "Liquidificador com copo resistente de vidro"));

    this.listaDeProdutos.add(new Microondas(800, "Micro-ondas Digital", "Micro-ondas com painel digital"));
    this.listaDeProdutos.add(new Microondas(750, "Micro-ondas Compacto", "Micro-ondas pequeno para cozinhas pequenas"));
    this.listaDeProdutos.add(new Microondas(900, "Micro-ondas com Grill", "Micro-ondas com função grill"));
    this.listaDeProdutos.add(new Microondas(1000, "Micro-ondas Inox", "Micro-ondas com acabamento em inox"));

    this.listaDeProdutos.add(new Geladeira(2000, "Geladeira Duplex", "Geladeira com freezer em cima"));
    this.listaDeProdutos.add(new Geladeira(2500, "Geladeira Side by Side", "Geladeira com portas lado a lado"));
    this.listaDeProdutos.add(new Geladeira(3000, "Geladeira Inox", "Geladeira com acabamento em inox"));
    this.listaDeProdutos.add(new Geladeira(3500, "Geladeira Frost Free", "Geladeira sem necessidade de descongelar"));
  }

  public void mostrarCatalogo() {
    System.out.println("--- BEM-VINDO À NOSSA LOJA ---");
    System.out.println("Produtos disponíveis:");
    for (Produto produto : this.listaDeProdutos) {
      System.out.println("--------------------");
      System.out.println(produto);
    }
  }

  public Produto buscarProdutoPorNome(String nome) {
    for (Produto produto : this.listaDeProdutos) {
      if (produto.getNome().equalsIgnoreCase(nome)) {
        return produto;
      }
    }
    return null; // Retorna null se o produto não for encontrado
  }
}
