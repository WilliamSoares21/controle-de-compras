package loja.produtos;

import java.util.HashMap;
import java.util.Map;

public class Calcao extends Produto {

    Map<String, Double> calcao = new HashMap<>();

    public Calcao(){
        calcao.put("Smoldem classic",140.00 );
        calcao.put("Pena beach sun", 150.50);
        calcao.put("Cyclone camurça", 300.00 );
        calcao.put("Maresia surf", 80.00 );
    }
}
