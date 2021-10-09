package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private VendedorResponsavel vendedor;
    private Cliente cliente;
    private String dataDeRegistro;
    private double valorASerPago;


    public Venda() {
    }

    public Venda(double valorASerPago, String dataDeRegistro) {
        this.valorASerPago = valorASerPago;
        this.dataDeRegistro = dataDeRegistro;
    }

    public Venda(Cliente clientes, double valorASerPago, String dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
        this.valorASerPago = valorASerPago;
        this.cliente = clientes;
//        this.vendedor = vendedor;
    }

    public VendedorResponsavel getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorResponsavel vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Cliente - " + cliente);
        retorno.append("\nVendedor Resposável - " + vendedor);
        retorno.append("\nData de Registro: " + dataDeRegistro);
        retorno.append("\nValor A Ser Pago: " + valorASerPago);
        return retorno.toString();
    }
}
