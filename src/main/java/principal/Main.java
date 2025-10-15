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
            break;

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
  }

}
