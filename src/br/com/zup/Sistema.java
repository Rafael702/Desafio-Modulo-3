package br.com.zup;

import java.util.Scanner;

public class Sistema {

    private static Scanner capturarDados(String mensagem){
        System.out.println(mensagem);
        return new Scanner(System.in);
    }


    private static Cliente cadastrarClientes(){
        String nome = capturarDados("Informe o nome do Cliente: ").nextLine();
        String cpf = capturarDados("Informe o CPF do " + nome + ":").nextLine();
        String email = capturarDados("Informe o email do " + nome + ":").nextLine();

        return ServicoCliente.cadastrarClientes(nome,cpf,email);
    }

    private static VendedorResponsavel cadastrarVendedores(){
        String nome = capturarDados("Informe o nome do Vendedor: ").nextLine();
        String cpf = capturarDados("Informe o CPF do " + nome + ":").nextLine();
        String email = capturarDados("Informe o email do " + nome + ":").nextLine();

        return ServicoVendedor.cadastrarVendedor(nome,cpf,email);
    }
}
