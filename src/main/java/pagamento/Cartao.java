package pagamento;

public class Cartao implements FormaDePagamento {
  private double saldo;

  public Cartao(double limite) {
    this.saldo = limite;
  }

  // um dia esse metodo já se chamou lanca compra mas alterei para pagar
  @Override
  public boolean pagar(double valor) {
    if (valor <= saldo) {
      saldo -= valor;
      return true;
    }
    return false; // se o saldo for insuficiente
  }

  @Override
  public double getSaldo(){
    return saldo;
  }

  @Override
  public String getNome(){
    return "Cartão de Crédito";
  }

  @Override
  public String getMensagemDeSucesso(){
    return "Pagamento realizado com o cartão de crédito. Transação aprovada";
  }
}
