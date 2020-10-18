package model;

public class Pedido {

    private int codigo;
    private double quantidade;
    private double preco;

    public Pedido(int codigo, int quantidade, double preco) {
	this.codigo = codigo;
	this.quantidade = quantidade;
	this.preco = preco;
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
	return preco;
    }

    public void setPreco(double preco) {
	this.preco = preco;
    }
}