package br.com.zup;

public class Cliente extends Pessoa {

    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    @Override
    public String toString() {
        return "{" +
                super.toString() +
                "}";
    }
}
