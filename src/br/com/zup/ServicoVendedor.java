package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoVendedor {
    private static List<VendedorResponsavel> vendedores = new ArrayList<>();

    public static List<VendedorResponsavel> getVendedores() {
        return vendedores;
    }

    public static VendedorResponsavel cadastrarVendedor(String nome, String cpf, String email) {

        VendedorResponsavel vendedor = new VendedorResponsavel(nome, cpf, email);
        validarCadastro(cpf);
        vendedores.add(vendedor);
        return vendedor;
    }

    public static boolean validarCadastro(String cpf) {
        boolean cadastrado = false;
        if (vendedores.isEmpty()) {
            System.out.println("Cadastrado com Sucesso!");
            cadastrado = true;
        } else {
            for (VendedorResponsavel vendedorResponsavel : vendedores) {
                if (vendedorResponsavel.getCpf().equals(cpf)) {
                    System.out.println("Cadastrado com Sucesso!");
                    cadastrado = true;
                } else {
                    System.out.println("Estou aqui com o " + vendedorResponsavel.getCpf());
                }
            }
        }
        return cadastrado;
    }

    public static void exibirListaVendedor() {
        for (VendedorResponsavel vendedoresReferencia : vendedores) {
            System.out.println(vendedoresReferencia);
        }
    }
}
