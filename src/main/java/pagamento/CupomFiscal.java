package pagamento;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class CupomFiscal {
    public static void gerarCupom(Cliente cliente, List<Compra> compras, FormaDePagamento formaPagamento, double valorTotal) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataHora = dateFormat.format(new Date());
        
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║               CUPOM FISCAL                ║");
        System.out.println("╠═══════════════════════════════════════════╣");
        System.out.printf("║ Cliente: %-32s ║\n", cliente.getNome());
        System.out.printf("║ Data/Hora: %-29s ║\n", dataHora);
        System.out.println("╠═══════════════════════════════════════════╣");
        System.out.println("║ ITEM                            VALOR     ║");
        System.out.println("╠═══════════════════════════════════════════╣");
        
        int itemNum = 1;
        for (Compra compra : compras) {
            System.out.printf("║ %d. %-27s R$ %6.2f ║\n", 
                  itemNum++, 
                  limitarTexto(compra.getDescricao(), 27), 
                  compra.getValor());
        }
        
        System.out.println("╠═══════════════════════════════════════════╣");
        System.out.printf("║ TOTAL:                       R$ %8.2f ║\n", valorTotal);
        System.out.println("╠═══════════════════════════════════════════╣");
        System.out.printf("║ Forma de pagamento: %-20s ║\n", formaPagamento.getNome());
        System.out.println("║                                           ║");
        System.out.printf("║ %s ║\n", limitarTexto(formaPagamento.getMensagemDeSucesso(), 43));
        System.out.println("╚═══════════════════════════════════════════╝");
    }
    
    private static String limitarTexto(String texto, int tamanhoMax) {
        if (texto.length() <= tamanhoMax) {
            return texto;
        } else {
            return texto.substring(0, tamanhoMax - 3) + "...";
        }
    }
}
