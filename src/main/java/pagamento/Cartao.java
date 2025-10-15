package pagamento;

public class Cartao {
    private double limite;
    private double saldo;

    public Cartao(double limite, double saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }
}
