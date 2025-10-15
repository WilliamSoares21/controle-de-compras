package pagamento;

public class Compra {
  private String descricao;
  private double valor;

  public Compra(String descricao, double valor) {
    this.descricao = descricao;
    this.valor = valor;
  }

  public String getDescricao() {
    return descricao;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    // Usamos o String.format para criar uma representação bonita e organizada.
    return String.format("%s - R$ %.2f", this.getDescricao(), this.getValor());
  }

}
