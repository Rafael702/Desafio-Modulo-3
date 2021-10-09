package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoVenda {
    private static List<Venda> vendas = new ArrayList<>();

    public static List<Venda> getVendas() {
        return vendas;
    }

    public static Venda cadastrarVendas(Cliente cliente, double valorASerPago, String dataDeRegistro) throws Exception {

        Venda venda = new Venda(cliente, valorASerPago, dataDeRegistro);
        validarCadastrosCliente(cliente.getCpf(), venda);
        return venda;
    }

    public static Cliente cadastrarClientes(String nome, String cpf, String email) throws Exception {
        List<Cliente> vendasParaclientes = new ArrayList<>();
        Cliente cliente = new Cliente(nome, cpf, email);
        vendasParaclientes.add(cliente);
        return cliente;
    }

    public static void validarCadastrosCliente(String cpf, Venda venda) throws Exception {

        if (ServicoCliente.getClientes().isEmpty()) {
            throw new Exception("Nenhum Cliente Cadastrado!");
        } else if (ServicoCliente.validarCadastro(cpf) == true) {
            vendas.add(venda);
        } else {
            throw new Exception("Cliente não cadastrado");
        }
    }

    public static void exibirLista() {
        for (Venda vendasReferencia : vendas) {
            System.out.println(vendasReferencia);
        }
    }
}
