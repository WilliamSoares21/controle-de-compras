package pagamento;

import java.util.Random;

public class Cliente {
    private String nome;
    private Cartao cartaoDeCredito;
    private Dinheiro dinheiro;
    private Pix pix;

    public Cliente(String nome) {
        this.nome = nome;
        Random random = new Random();

        double limiteCartao = 1000 + random.nextDouble() * 4000;
        double saldoDinheiro = 200 + random.nextDouble() * 800;
        double saldoPix = 500 + random.nextDouble() * 2500;

        this.cartaoDeCredito = new Cartao(limiteCartao);
        this.dinheiro = new Dinheiro(saldoDinheiro);
        this.pix = new Pix(saldoPix);

    }

    public String getNome() {
        return nome;
    }
   
    public Cartao getCartaoDeCredito() {
        return cartaoDeCredito;
    }
    
    public Dinheiro getDinheiro() {
        return dinheiro;
    }
    public Pix getPix() {
        return pix;
    }

    public void mostrarSaldos() {
        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║             SALDOS DISPONÍVEIS            ║");
        System.out.println("╠═══════════════════════════════════════════╣");
        System.out.printf("║ Cartão de Crédito: R$ %.2f             ║\n", cartaoDeCredito.getSaldo());
        System.out.printf("║ Dinheiro: R$ %.2f                      ║\n", dinheiro.getSaldo());
        System.out.printf("║ PIX: R$ %.2f                           ║\n", pix.getSaldo());
        System.out.println("╚═══════════════════════════════════════════╝");
    }


    
}
