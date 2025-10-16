package pagamento;

public interface FormaDePagamento {
    boolean pagar(double valor);
    double getSaldo();
    String getNome();
    String getMensagemDeSucesso();
}
