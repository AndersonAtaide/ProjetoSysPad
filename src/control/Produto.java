package control;

import data.IRepositorioItem;
import model.Item;

public class Produto {

	private IRepositorioItem repositorio;

	public Produto(IRepositorioItem instanciaInterface) {
		this.repositorio = instanciaInterface;
	}

	public void cadastrarItem(Item m) {
		this.repositorio.cadastrarItem(m);
	}

	public void removerItem(int codigo) {
		this.repositorio.removerItem(codigo);
	}

	public void editarItem(int codigo) {
		this.repositorio.editarItem(codigo);
	}

	public Item procurarItem(int codigo) {
		return this.repositorio.procurarItem(codigo);
	}

	public String listarItens() {
		return this.repositorio.listarItens();
	}

	public void comprarItem(int codigoItem, int quantComprada, double precoCompra) {
		Item item = this.repositorio.procurarItem(codigoItem);
		if (item != null) {
			item.aumentarQuantidade(quantComprada);
			item.definirPrecoCompra(precoCompra);
		}
	}

	public void retirarProdutoVendido(int codigoItem, int quantVendida) {
		Item item = this.repositorio.procurarItem(codigoItem);
		if (item != null) {
			item.diminuirQuantidadde(quantVendida);
		}
	}

	public void mudarPrecoVenda(int codigoItem, double novoPreco) {
		Item item = this.repositorio.procurarItem(codigoItem);
		if (item != null) {
			item.definirPrecoVenda(novoPreco);
		}
	}
}
