package pagamento;

public class Pix implements FormaDePagamento {
    private double saldo;

    public Pix(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean pagar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    
    @Override
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public String getNome() {
        return "PIX";
    }
    
    @Override
    public String getMensagemDeSucesso() {
        return "Pagamento via PIX realizado com sucesso!";
    }
    
}
