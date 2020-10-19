package control;

import data.IRepositorioItem;
import model.Item;

public class CadastroItem implements ICadastroItem{

    private IRepositorioItem repositorioItem;

    public CadastroItem(IRepositorioItem instanciaInterfaceItem) {
	this.repositorioItem = instanciaInterfaceItem;
    }
    
    public void cadastrarItem(Item m) {
	this.repositorioItem.cadastrarItem(m);
}

    public void removerItem(int codigo) {
	this.repositorioItem.removerItem(codigo);
    }

    public void editarItem(int codigo, String nome, String fabricante, String tipo, String unidadeMedida) {
	this.repositorioItem.editarItem(codigo, nome, fabricante, tipo, unidadeMedida);
    }

    public Item procurarItem(int codigo) {
        return this.repositorioItem.procurarItem(codigo);
    }

    public String listarItens() {
	return this.repositorioItem.listarItens();
    }

    public void comprarItem(int codigoItem, int quantComprada, double precoCompra) {
	Item item = this.repositorioItem.procurarItem(codigoItem);
	if (item != null) {
            item.aumentarQuantidade(quantComprada);
            item.definirPrecoCompra(precoCompra);
	}
    }

    public void retirarProdutoVendido(int codigoItem, int quantVendida) {
	Item item = this.repositorioItem.procurarItem(codigoItem);
        if (item != null) {
            item.diminuirQuantidadde(quantVendida);
	}
    }

    public void mudarPrecoVenda(int codigoItem, double novoPreco) {
	Item item = this.repositorioItem.procurarItem(codigoItem);
	if (item != null) {
            item.definirPrecoVenda(novoPreco);
	}
    }
}
