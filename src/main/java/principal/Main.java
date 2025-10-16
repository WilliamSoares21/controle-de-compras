package principal;

import pagamento.*;
import loja.Catalogo;
import loja.produtos.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        exibirBanner("BEM-VINDO À LOJA VIRTUAL");
        
        System.out.print("Digite seu nome: ");
        String nomeCliente = scan.nextLine();
        
        //Cria o cliente com saldos aleatórios
        Cliente cliente = new Cliente(nomeCliente);
        System.out.println("\nOlá, " + nomeCliente + "! Bem-vindo à nossa loja virtual!");
        cliente.mostrarSaldos();
        
        Catalogo catalogo = new Catalogo();
        List<Compra> carrinhoDeCompras = new ArrayList<>();

        //Menu de compras
        int opcaoSetor = -1;
        while (opcaoSetor != 0) {
            exibirBanner("CATÁLOGO DE PRODUTOS");
            catalogo.mostratSetores();
            System.out.println("\nDigite o número do setor (ou 0 para finalizar a compra):");
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
                    exibirBanner("PRODUTOS - " + setorEscolhido);
                    catalogo.mostrarProdutosDoSetor(setorEscolhido);
                    System.out.println("\nDigite o número do produto (ou 0 para voltar aos setores):");
                    opcaoProduto = scan.nextInt();

                    if (opcaoProduto == 0)
                        break; // Sai do loop de produtos

                    Produto produtoComprado = catalogo.getProduto(setorEscolhido, opcaoProduto - 1);

                    if (produtoComprado != null) {
                        Compra novaCompra = new Compra(produtoComprado.getNome(), produtoComprado.getPreco());
                        carrinhoDeCompras.add(novaCompra);
                        System.out.println("\n✓ " + produtoComprado.getNome() + " adicionado ao carrinho!");
                    } else {
                        System.out.println("\n❌ Opção de produto inválida!");
                    }
                }
            } else {
                System.out.println("\n❌ Opção de setor inválida!");
            }
        }

        if (carrinhoDeCompras.isEmpty()) {
            System.out.println("\nCarrinho vazio. Até a próxima!");
            scan.close();
            return;
        }

        exibirBanner("RESUMO DA COMPRA");

        //Calcula o total do carrinho
        double totalDaCompra = 0.0;

        System.out.println("Itens no carrinho:");
        for (Compra compra : carrinhoDeCompras) {
            System.out.printf("• %-25s - R$ %.2f\n", compra.getDescricao(), compra.getValor());
            totalDaCompra += compra.getValor();
        }
        System.out.printf("\nValor total da compra: R$ %.2f\n", totalDaCompra);

        //Escolher forma de pagamento
        FormaDePagamento formaPagamentoEscolhida = escolherFormaPagamento(cliente, scan);
        
        if (formaPagamentoEscolhida == null) {
            System.out.println("\nOperação cancelada. Até a próxima!");
            scan.close();
            return;
        }

        // Aqui é onde validamos a compra
        if (formaPagamentoEscolhida.pagar(totalDaCompra)) {
            exibirBanner("PAGAMENTO APROVADO");
            
            //Ordena compras por valor
            carrinhoDeCompras.sort(java.util.Comparator.comparing(Compra::getValor));
            
            // Aqui Gera e exibe o cupom fiscal
            CupomFiscal.gerarCupom(cliente, carrinhoDeCompras, formaPagamentoEscolhida, totalDaCompra);
        } else {
            System.out.println("\n❌ Saldo insuficiente para realizar a compra!");
            System.out.println("Operação cancelada.");
        }
        
        scan.close();
    }
    
    private static FormaDePagamento escolherFormaPagamento(Cliente cliente, Scanner scan) {
        exibirBanner("FORMAS DE PAGAMENTO");
        System.out.println("1. Cartão de Crédito (Limite: R$ " + String.format("%.2f", cliente.getCartaoDeCredito().getSaldo()) + ")");
        System.out.println("2. Dinheiro (Saldo: R$ " + String.format("%.2f", cliente.getDinheiro().getSaldo()) + ")");
        System.out.println("3. PIX (Saldo: R$ " + String.format("%.2f", cliente.getPix().getSaldo()) + ")");
        System.out.println("0. Cancelar compra");
        
        System.out.print("\nEscolha a forma de pagamento: ");
        int opcao = scan.nextInt();
        
        switch (opcao) {
            case 1: return cliente.getCartaoDeCredito();
            case 2: return cliente.getDinheiro();
            case 3: return cliente.getPix();
            default: return null;
        }
    }
    
    private static void exibirBanner(String titulo) {
        int tamanho = Math.max(titulo.length() + 6, 40);
        StringBuilder linha = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            linha.append("═");
        }
        
        System.out.println("\n╔" + linha + "╗");
        System.out.println("║" + centralizar(titulo, tamanho) + "║");
        System.out.println("╚" + linha + "╝");
    }
    
    private static String centralizar(String texto, int largura) {
        int espacos = largura - texto.length();
        int espacoEsquerda = espacos / 2;
        int espacoDireita = espacos - espacoEsquerda;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < espacoEsquerda; i++) {
            sb.append(" ");
        }
        sb.append(texto);
        for (int i = 0; i < espacoDireita; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
