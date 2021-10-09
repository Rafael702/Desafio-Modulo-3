package br.com.zup;

import java.util.Scanner;

public class Sistema {

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

    private static String informarNomeCliente() {
        String nome = capturarDados("Informe o nome do Cliente: ").nextLine();
        return nome;
    }

    private static String informarEmailCliente() {
        String email = capturarDados("Informe o email do :").nextLine();
        return email;
    }

    private static String informarCpf() {
        String cpf = capturarDados("Informe o CPF:").nextLine();
        return cpf;
    }


    private static Cliente cadastrarClientes() throws Exception {

        return ServicoCliente.cadastrarClientes(informarNomeCliente(),informarCpf(), informarEmailCliente());

    }

    private static VendedorResponsavel cadastrarVendedores() {
        String nome = capturarDados("Informe o nome do Vendedor:").nextLine();
        String cpf = capturarDados("Informe o CPF do " + nome + ":").nextLine();
        String email = capturarDados("Informe o email do " + nome + ":").nextLine();
        return ServicoVendedor.cadastrarVendedor(nome, cpf, email);
    }

    private static Venda cadastrarVendas() throws Exception {
        double valorASerPago = capturarDados("Informe o valor a ser pago:").nextDouble();
        String dataDeRegistro = capturarDados("Informe a Data De Registro da Venda: Ex dd/mm/AAAA").nextLine();
//        VendedorResponsavel vendedor = cadastrarVendedores();
        Cliente cliente;
        cliente = ServicoVenda.cadastrarClientes(informarNomeCliente(),informarCpf(),informarEmailCliente());

        return ServicoVenda.cadastrarVendas(cliente,valorASerPago, dataDeRegistro);
    }

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
                System.out.println("\n");
            } else {
                continuarMenu = false;
            }
        }
        return continuarMenu;
    }

}
