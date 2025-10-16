package loja;
import java.util.ArrayList;
import java.util.List;
import loja.produtos.Produto;

public class Secao {
    private String nome;
    private List<Produto> produtos;

    public Secao(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public void mostrarProdutos() {
        System.out.println("\n━━━━━━━━━━ " + nome + " ━━━━━━━━━━");
        int i = 1;
        for (Produto produto : produtos) {
            System.out.printf("%d. %-20s - R$ %.2f\n", i++, produto.getNome(), produto.getPreco());
        }
    }
    
}
