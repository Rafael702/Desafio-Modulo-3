package br.com.zup;

import java.util.Scanner;

public class Sistema {

    private static Scanner capturarDados(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    private static void menuPrincipal() {
        System.out.println("Digite 1: Para Cadastrar uma Venda");
        System.out.println("Digite 2: Para Mostrar as Vendas Cadastradas");
        System.out.println("Digite 3: Para Sair do Menu");
    }

    private static Cliente cadastrarClientes() {
        String nome = capturarDados("Informe o nome do Cliente: ").nextLine();
        String cpf = capturarDados("Informe o CPF do " + nome + ":").nextLine();
        String email = capturarDados("Informe o email do " + nome + ":").nextLine();

        return ServicoCliente.cadastrarClientes(nome, cpf, email);
    }

    private static VendedorResponsavel cadastrarVendedores() {
        String nome = capturarDados("Informe o nome do Vendedor:").nextLine();
        String cpf = capturarDados("Informe o CPF do " + nome + ":").nextLine();
        String email = capturarDados("Informe o email do " + nome + ":").nextLine();

        return ServicoVendedor.cadastrarVendedor(nome, cpf, email);
    }

    private static Venda cadastrarVendas() {
        double valorASerPago = capturarDados("Informe o valor a ser pago:").nextDouble();
        String dataDeRegistro = capturarDados("Informe a Data De Registro da Venda: Ex dd/mm/AAAA").nextLine();
        Cliente cliente = cadastrarClientes();
        VendedorResponsavel vendedorResponsavel = cadastrarVendedores();

        return ServicoVenda.cadastrarVendas(vendedorResponsavel, cliente, valorASerPago, dataDeRegistro);
    }

    public static void executar() {
        boolean continuarMenu = true;
        Venda venda = new Venda();
        while (continuarMenu) {

            menuPrincipal();
            int opcao = capturarDados("Informe a sua opção escolhida:").nextInt();

            if(opcao == 1){
               venda = cadastrarVendas();
            }else if(opcao == 2){
                System.out.println(venda);
            }else {
                continuarMenu = false;
            }

        }
    }

}
