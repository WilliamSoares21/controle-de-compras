package principal;

import pagamento.Cartao;
import pagamento.Compra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import loja.produtos.*;
import loja.Catalogo;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Cartao cartao = new Cartao(1000.0);
    Catalogo catalogo = new Catalogo();
    List<Compra> carrinhoDeCompras = new ArrayList<>();

    int opcaoSetor = -1;
    while (opcaoSetor != 0) {
      catalogo.mostratSetores();
      System.out.println("Digite o número do setor (ou 0 para finalizar a compra):");
      opcaoSetor = scan.nextInt();

      if (opcaoSetor == 0)
        break;

      String setorEscolhido = "";
      if (opcaoSetor == 1)
        setorEscolhido = "Vestuário";
      if (opcaoSetor == 2)
        setorEscolhido = "Eletrodomésticos";

      if (!setorEscolhido.isEmpty()) {
        int opcaoProduto = -1;
        while (opcaoProduto != 0) {
          catalogo.mostrarProdutosDoSetor(setorEscolhido);
          System.out.println("\nDigite o número do produto (ou 0 para voltar aos setores):");
          opcaoProduto = scan.nextInt();

          if (opcaoProduto == 0)
            break; // Sai do loop de produtos

          Produto produtoComprado = catalogo.getProduto(setorEscolhido, opcaoProduto - 1);

          if (produtoComprado != null) {
            Compra novaCompra = new Compra(produtoComprado.getNome(), produtoComprado.getPreco());
            carrinhoDeCompras.add(novaCompra);
            System.out.println(">>> " + produtoComprado.getNome() + " adicionado ao carrinho! <<<\n");
          } else {
            System.out.println("!!! Opção de produto inválida. !!!\n");
          }
        }
      } else {
        System.out.println("!!! Opção de setor inválida. !!!\n");
      }
    }

    System.out.println("Finalizando a compra...");

    System.out.println("Finalizando a compra...");
    System.out.println("************************\n");

    // Calcula o total do carrinho
    double totalDaCompra = 0.0;

    for (Compra compra : carrinhoDeCompras) {
      System.out.println(compra);
      totalDaCompra += compra.getValor();
    }
    System.out.println("Valor total da compra: R$" + totalDaCompra);
    System.out.println("Saldo do cartão: R$" + cartao.getSaldo());
    System.out.println("\n************************");

    // Validar a compra com o cartão
    if (cartao.pagar(totalDaCompra)) {
      System.out.println("Compra realizada com sucesso!");
      System.out.println("************************");

      // Usando o comparator para ordenar a lista pelo valor de cada compra
      carrinhoDeCompras.sort(java.util.Comparator.comparing(Compra::getValor));

      System.out.println("Compras realizadas");
      for (Compra compra : carrinhoDeCompras) {
        System.out.println(compra.getDescricao() + " - R$" + compra.getValor());
      }
    } else {
      System.out.println("Saldo insuficiente no cartão para realizar a compra.");
    }
    System.out.println("\n************************");
    System.out.println("Saldo final do Cartão: R$" + cartao.getSaldo());
    System.out.println("************************");
    scan.close();

  }

}
