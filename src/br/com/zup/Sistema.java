package br.com.zup;

import java.util.Scanner;

public class Sistema {

    public static boolean executar() throws Exception {
        boolean continuarMenu = true;
        while (continuarMenu) {

            menuPrincipal();
            int opcao = capturarDados("Informe a sua opção escolhida:").nextInt();

            if (opcao == 1) {
                cadastrarVendas();
            } else if (opcao == 2) {
                cadastrarClientes();
            } else if (opcao == 3) {
                cadastrarVendedores();
            } else if (opcao == 4) {
                ServicoVenda.exibirLista();
                ServicoCliente.exibirListaCliente();
                ServicoVendedor.exibirListaVendedor();
            } else {
                continuarMenu = false;
            }
        }
        return continuarMenu;
    }


    private static Scanner capturarDados(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    private static void menuPrincipal() {
        System.out.println("Digite 1: Para Cadastrar uma Venda");
        System.out.println("Digite 2: Para Cadastrar um Cliente");
        System.out.println("Digite 3: Para Cadastrar um Vendedor");
        System.out.println("Digite 4: Para Mostrar as Vendas Cadastradas");
        System.out.println("Digite 5: Para Sair do Menu");
    }

    private static String informarNome() {
        String nome = capturarDados("Informe o nome: ").nextLine();
        return nome;
    }

    private static String informarEmail() {
        String email = capturarDados("Informe o email:").nextLine();
        return email;
    }

    private static String informarCpf() {
        String cpf = capturarDados("Informe o CPF:").nextLine();
        return cpf;
    }

    private static Cliente cadastrarClientes() throws Exception {
        System.out.println("-----------------------Cadastro-de-Clientes----------------------");
        return ServicoCliente.cadastrarClientes(informarNome(), informarCpf(), informarEmail());

    }

    private static VendedorResponsavel cadastrarVendedores() {
        System.out.println("-----------------------Cadastro-de-Vendedores---------------------");
        return ServicoVendedor.cadastrarVendedor(informarNome(), informarCpf(), informarEmail());
    }

    private static Venda cadastrarVendas() throws Exception {
        double valorASerPago = capturarDados("Informe o valor a ser pago:").nextDouble();
        String dataDeRegistro = capturarDados("Informe a Data De Registro da Venda: Ex dd/mm/AAAA").nextLine();
        Cliente cliente;
        VendedorResponsavel vendedor;
        cliente = ServicoVenda.cadastrarClientes(informarNome(), informarCpf(), informarEmail());
        vendedor = ServicoVenda.cadastrarVendedor(informarNome(), informarCpf(), informarEmail());

        return validacoesDeCadastros(cliente,vendedor,ServicoVenda.cadastrarVendas(cliente, vendedor, valorASerPago, dataDeRegistro));

    }

    private static Venda validacoesDeCadastros(Cliente cliente, VendedorResponsavel vendedor, Venda venda) throws Exception {
        if (ServicoVenda.validarCadastrosCliente(cliente.getCpf(), venda) & ServicoVenda.validarCadastrosVendedor(vendedor.getCpf(), venda)) {
            ServicoVenda.getVendas().add(venda);
        }
        return venda;
    }

}
