package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoVenda {
    private static List<Venda> vendas = new ArrayList<>();

    public static List<Venda> getVendas() {
        return vendas;
    }

    public static Venda cadastrarVendas(Cliente cliente, VendedorResponsavel vendedor, double valorASerPago, String dataDeRegistro) throws Exception {

        Venda venda = new Venda(cliente, vendedor, valorASerPago, dataDeRegistro);
        validarCadastrosCliente(cliente.getCpf(), venda);
        validarCadastrosVendedor(vendedor.getCpf(), venda);

        return venda;
    }

    public static Cliente cadastrarClientes(String nome, String cpf, String email) throws Exception {
        List<Cliente> vendasParaclientes = new ArrayList<>();
        Cliente cliente = new Cliente(nome, cpf, email);
        vendasParaclientes.add(cliente);
        return cliente;
    }

    public static VendedorResponsavel cadastrarVendedor(String nome, String cpf, String email) throws Exception {
        List<VendedorResponsavel> vendasDeVendedores = new ArrayList<>();
        VendedorResponsavel vendedor = new VendedorResponsavel(nome, cpf, email);
        vendasDeVendedores.add(vendedor);
        return vendedor;
    }

    public static boolean validarCadastrosCliente(String cpf, Venda venda) throws Exception {
        boolean cadastrado = false;
        if (ServicoCliente.getClientes().isEmpty()) {
            throw new Exception("Nenhum Cliente Cadastrado!");
        } else if (ServicoCliente.validarCadastroParaVendas(cpf)) {
            cadastrado = true;
        } else {
            throw new Exception("Cliente não cadastrado");
        }
        return cadastrado;
    }

    public static boolean validarCadastrosVendedor(String cpf, Venda venda) throws Exception {
        boolean cadastrado = false;
        if (ServicoVendedor.getVendedores().isEmpty()) {
            throw new Exception("Nenhum Vendedor Cadastrado!");
        } else if (ServicoVendedor.validarCadastro(cpf)) {
            cadastrado = true;
        } else{
            throw new Exception("Vendedor não cadastrado");
        }
        return cadastrado;
    }


    public static void exibirLista() {
        for (Venda vendasReferencia : vendas) {
            System.out.println(vendasReferencia);
        }
    }
}
