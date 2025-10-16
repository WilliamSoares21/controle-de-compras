package pagamento;

public class Dinheiro implements FormaDePagamento{
    private double saldo;

    public Dinheiro(double saldo) {
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
        return "Dinheiro";
    }
    
    @Override
    public String getMensagemDeSucesso() {
        return "Pagamento em dinheiro realizado com sucesso! Não esqueça seu troco.";
    }
}
