package br.com.zup;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ServicoVendedor {
    private static List<VendedorResponsavel> vendedores = new ArrayList<>();

    public static List<VendedorResponsavel> getVendedores() {
        return vendedores;
    }

    public static VendedorResponsavel cadastrarVendedor(String nome, String cpf, String email) throws Exception {

        VendedorResponsavel vendedor = new VendedorResponsavel(nome, cpf, email);
        validarCadastroVendedor(cpf, email, vendedor);
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

    public static List<VendedorResponsavel> validarCadastroVendedor(String novoCpf, String novoEmail, VendedorResponsavel vendedor) throws Exception {
        //Corrigir nulos
        try {
            if (vendedores.isEmpty()) {
                adicionarNaLista(vendedor);
                System.out.println("Vendedores cadastrado com Sucesso!");
                System.out.println("");
            } else {
                for (VendedorResponsavel vendedorReferencia : vendedores) {
                    if (!vendedorReferencia.getCpf().equals(novoCpf) & !vendedorReferencia.getEmail().equals(novoEmail)) {
                        System.out.println("Cliente cadastrado com Sucesso!");
                        adicionarNaLista(vendedor);
                    } else {
                        throw new Exception("CPF ou Email Duplicado. Digite 4 e Confira os Vendedores Cadastrados.");
                    }
                }
            }
        } catch (ConcurrentModificationException cme) {
            System.out.println("");
        }
        return vendedores;
    }

    public static void adicionarNaLista(VendedorResponsavel novoVendedor) {
        vendedores.add(novoVendedor);
    }


    public static void exibirListaVendedor() {
        for (VendedorResponsavel vendedoresReferencia : vendedores) {
            System.out.println(vendedoresReferencia);
        }
    }
}
