package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoVendedor {
    private static List<VendedorResponsavel> vendedores = new ArrayList<>();

    public static VendedorResponsavel cadastrarVendedor(String nome, String cpf, String email){

        VendedorResponsavel vendedor = new VendedorResponsavel(nome,cpf,email);
        vendedores.add(vendedor);
        return vendedor;
    }
}
