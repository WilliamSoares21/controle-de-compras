package loja.produtos;

import java.util.HashMap;
import java.util.Map;

public class Microondas extends Produto{
    Map<String, Double> microondas = new HashMap<>();
    public Microondas(){
        microondas.put("Samsung",.450 );
        microondas.put("Panasonic", 250.50);
        microondas.put("Brastemp", 400.00 );
        microondas.put("Electrolux", 180.00 );
    }
    

}
