package loja.produtos;

import java.util.HashMap;
import java.util.Map;

public class Calca extends Produto {

    Map<String, Double> calca = new HashMap<>();

    public Calca(){
        calca.put("Adidas professor",100.00 );
        calca.put("Nike run", 200.50);
        calca.put("Vans beach", 500.00 );
        calca.put("Blue jeans", 120.00 );

    }
    
}
