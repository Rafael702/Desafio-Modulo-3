package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoCliente {
    private static List<Cliente> clientes = new ArrayList<>();
    private static Cliente cliente;

    public static List<Cliente> getClientes() {
        return clientes;
    }


    public static Cliente cadastrarClientes(String nome, String cpf, String email) throws Exception {

        Cliente cliente = new Cliente(nome, cpf, email);
        validarCadastro(cpf);
        clientes.add(cliente);
        return cliente;
    }

    public static boolean validarCadastro(String cpf) {
        boolean cadastrado = false;
        if (clientes.isEmpty()) {
            System.out.println("Cadastrado com Sucesso!");
            cadastrado = true;
        } else {
            for (Cliente clienteReferencia : clientes) {
                if (clienteReferencia.getCpf().equals(cpf)) {
                    System.out.println("Cadastrado com Sucesso!");
                    cadastrado = true;
                } else {
                    System.out.println("Estou aqui com o " + clienteReferencia.getCpf());
                }
            }

        }
        return cadastrado;
    }

    public static void exibirListaCliente() {
        for (Cliente clientesReferencia : clientes) {
            System.out.println(clientesReferencia);
        }
    }
}
