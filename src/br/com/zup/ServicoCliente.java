package br.com.zup;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ServicoCliente {
    private static List<Cliente> clientes = new ArrayList<>();
    private static Cliente cliente;

    public static List<Cliente> getClientes() {
        return clientes;
    }


    public static Cliente cadastrarClientes(String nome, String cpf, String email) throws Exception {

        Cliente cliente = new Cliente(nome, cpf, email);
        validarCadastroCliente(cpf, email, cliente);
        return cliente;
    }

    public static boolean validarCadastroParaVendas(String cpf) {
        boolean cadastrado = false;
        if (clientes.isEmpty()) {
            System.out.println("Cadastrado com Sucesso!");
            cadastrado = true;
        } else {
            for (Cliente clienteResponsavel : clientes) {
                if (clienteResponsavel.getCpf().equals(cpf)) {
                    System.out.println("Cadastrado com Sucesso!");
                    cadastrado = true;
                } else {
                    System.out.println("Estou aqui com o " + clienteResponsavel.getCpf());
                }
            }
        }
        return cadastrado;
    }

    public static List<Cliente> validarCadastroCliente(String novoCpf, String novoEmail, Cliente cliente) throws Exception {
        //Corrigir nulos
        try {
            if (clientes.isEmpty()) {
                adicionarNaLista(cliente);
                System.out.println("Cliente cadastrado com Sucesso!");
                System.out.println("");
            } else {
                for (Cliente clienteReferencia : clientes) {
                    if (!clienteReferencia.getCpf().equals(novoCpf) & !clienteReferencia.getEmail().equals(novoEmail)) {
                        adicionarNaLista(cliente);
                        System.out.println("Cliente cadastrado com Sucesso!");
                    } else {
                        throw new Exception("CPF ou Email Duplicado. Digite 4 e Confira os clientes Cadastrados.");
                    }
                }
            }
        } catch (ConcurrentModificationException cme) {
            System.out.println("");
        }
        return clientes;
    }

    public static void adicionarNaLista(Cliente cliente) {
        clientes.add(cliente);
    }


    public static void exibirListaCliente() {
        for (Cliente clientesReferencia : clientes) {
            System.out.println(clientesReferencia);
        }
    }
}
