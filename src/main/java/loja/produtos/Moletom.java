package loja.produtos;

import java.util.HashMap;
import java.util.Map;

public class Moletom extends Produto{

    Map<String, Double> Moletom = new HashMap<>();

    public Moletom(){
        Moletom.put("Element",350.00 );
        Moletom.put("Trasher", 250.50);
        Moletom.put("Game Cube", 120.00 );
        Moletom.put("Cisco aftersun", 135.00 );
    }
    
}
