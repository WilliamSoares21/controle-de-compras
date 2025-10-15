package loja.produtos;

import pagamento.Compra;

public interface Vitrine {
    void consultarPreco();
    void consultarDescricao();
    void consultaDesconto(Compra compra);
}
