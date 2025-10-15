package loja.produtos;

import java.util.HashMap;
import java.util.Map;

public class Geladeira extends Produto{
    Map<String, Double> geladeira = new HashMap<>();
    public Geladeira(){
        geladeira.put("Eletrolux",2500.00 );
        geladeira.put("Brastemp", 1200.50);
        geladeira.put("Consul", 1000.00 );
        geladeira.put("Samsung", 4500.00 );
    }
}
