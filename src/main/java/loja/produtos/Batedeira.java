package loja.produtos;

import java.util.HashMap;
import java.util.Map;

public class Batedeira extends Produto {
    Map<String, Double> batedeira = new HashMap<>();

    public Batedeira(){
        batedeira.put("KitchenAid",.400 );
        batedeira.put("Arno", 350.50);
        batedeira.put("Oster", 400.00 );
        batedeira.put("Philco", 220.00 );
    }
}
