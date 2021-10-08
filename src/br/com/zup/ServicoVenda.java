package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoVenda {
    private static List<Venda> vendas = new ArrayList<>();

    public static Venda cadastrarVendas(VendedorResponsavel vendedorResponsavel, Cliente cliente, double valorASerPago, String dataDeRegistro) {

        Venda venda = new Venda(cliente, vendedorResponsavel, valorASerPago, dataDeRegistro);
        vendas.add(venda);
        return venda;
    }

}
