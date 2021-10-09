package br.com.zup;

public class Cliente extends Pessoa {
    private Venda venda;

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "{" +
                super.toString() +
                "}";
    }
}
