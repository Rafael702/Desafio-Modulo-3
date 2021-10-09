package br.com.zup;

public class VendedorResponsavel extends Pessoa {
    private Venda venda;

    public VendedorResponsavel() {
    }

    public VendedorResponsavel(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    public VendedorResponsavel(String nome, String cpf, String email, Venda venda) {
        super(nome, cpf, email);
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "{\n"
                + super.toString() +
                venda +
                "\n}";
    }
}
