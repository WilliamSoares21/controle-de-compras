package pagamento;

public class Cartao {
  private double limite;
  private double saldo;

  public Cartao(double limite) {
    this.limite = limite;
    this.saldo = limite;
  }

  // um dia esse metodo já se chamou lanca compra mas alterei para pagar
  public boolean pagar(double valor) {
    if (this.saldo >= valor) {
      this.saldo -= valor;
      return true;
    }
    return false; // se o saldo for insuficiente
  }

  public double getLimite() {
    return limite;
  }

  public double getSaldo() {
    return saldo;
  }
}
