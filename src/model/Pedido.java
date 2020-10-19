package model;

public class Pedido {

    private int codigo;
    private double quantidade;
    private double total;

    public Pedido(int codigo, int quantidade, double total) {
	this.codigo = codigo;
	this.quantidade = quantidade;
	this.total = total;
    }

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
    }

    public double getPreco() {
	return total;
    
    }    
}
