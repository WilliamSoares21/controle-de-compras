package loja.produtos;

import pagamento.Compra;

public abstract class Produto implements Vitrine {
  private double preco;
  private String nome;
  private String descricao;

  public Produto() {
  }

  public Produto(double preco, String nome, String descricao) {
    this.preco = preco;
    this.nome = nome;
    this.descricao = descricao;
  }

  @Override
  public void consultarPreco() {
    this.preco = preco;
  }

  @Override
  public void consultarDescricao() {
  }

  @Override
  public void consultaDesconto(Compra compra) {
    double desconto = 20.0;
    double valor = compra.getValor();
    if (valor > 600) {
      double valorComDesconto = valor * (1 - desconto / 100.0);
      compra.setValor(valorComDesconto);
    } else {
      System.out.println("Não é elegivel para desconto");
    }
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public String toString() {
    return String.format("%s - R$ %.2f\n  Descrição: %s",
        this.getNome(), this.getPreco(), this.getDescricao());
  }
}
