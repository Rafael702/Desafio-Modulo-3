package br.com.zup;

public class Venda {
    private Cliente cliente;
    private VendedorResponsavel vendedorResponsavel;
    private String dataDeRegistro;
    private double valorASerPago;

    public Venda(Cliente cliente, VendedorResponsavel vendedorResponsavel, double valorASerPago, String dataDeRegistro) {
        this.cliente = cliente;
        this.vendedorResponsavel = vendedorResponsavel;
        this.valorASerPago = valorASerPago;
        this.dataDeRegistro = dataDeRegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public VendedorResponsavel getVendedorResponsavel() {
        return vendedorResponsavel;
    }

    public void setVendedorResponsavel(VendedorResponsavel vendedorResponsavel) {
        this.vendedorResponsavel = vendedorResponsavel;
    }

    public double getValorASerPago() {
        return valorASerPago;
    }

    public void setValorASerPago(double valorASerPago) {
        this.valorASerPago = valorASerPago;
    }

    public String getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(String dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public String toString(){
        StringBuilder retorno = new StringBuilder();
        retorno.append("Cliente - " + cliente);
        retorno.append("Vendedor Resposável - " + vendedorResponsavel);
        retorno.append("Data de Registro: " + dataDeRegistro );
        retorno.append("Valor A Ser Pago: " + valorASerPago);
        return retorno.toString();
    }
}
