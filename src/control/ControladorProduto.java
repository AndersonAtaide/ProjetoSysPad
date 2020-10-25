package control;

import data.IRepositorioProduto;
import model.Produto;

public class ControladorProduto implements IControladorProduto{

    private IRepositorioProduto repositorioProduto;

    public ControladorProduto(IRepositorioProduto instanciaInterfaceItem) {
	this.repositorioProduto = instanciaInterfaceItem;
    }
    
    @Override
    public void cadastrarProduto(Produto p) {
	this.repositorioProduto.cadastrarProduto(p);
}

    @Override
    public void removerProduto(int codigo) {
	this.repositorioProduto.removerProduto(codigo);
    }

    @Override
    public void editarProduto(int codigo, String nome, String tipo, double precoVenda, double precoCompra, String unidadeMedida) {
	this.repositorioProduto.editarProduto(codigo, nome, tipo, precoVenda, precoCompra, unidadeMedida);
    }

    @Override
    public Produto procurarProduto(int codigo) {
        return this.repositorioProduto.procurarProduto(codigo);
    }

    @Override
    public String listarProdutos() {
	return this.repositorioProduto.listarProdutos();
    }   

    @Override
    public void comprarProduto(int codigo, double quantidade) {
        this.repositorioProduto.comprarProduto(codigo, quantidade);
    }
}
