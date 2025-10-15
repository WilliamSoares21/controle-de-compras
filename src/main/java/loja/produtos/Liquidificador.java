package loja.produtos;

import java.util.HashMap;
import java.util.Map;

public class Liquidificador extends Produto {
    Map<String, Double> liquidificador = new HashMap<>();

    public Liquidificador(){
        liquidificador.put("Oster",.100 );
        liquidificador.put("Philips", 80.50);
        liquidificador.put("Britânia", 150.00 );
        liquidificador.put("Mondial", 130.00 );

    }

}
