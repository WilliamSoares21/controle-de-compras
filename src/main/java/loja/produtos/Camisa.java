package loja.produtos;

import java.util.HashMap;
import java.util.Map;

public class Camisa extends Produto {

    Map<String, Double> camisa = new HashMap<>();

    public Camisa(){
        camisa.put("Adidas Summer fest",150.00 );
        camisa.put("Nike blue ocean", 250.50);
        camisa.put("Vans isane vulcan", 400.00 );
        camisa.put("Santa Cruz california", 100.00 );
    }

    
}
