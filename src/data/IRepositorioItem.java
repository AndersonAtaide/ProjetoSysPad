package data;

import model.Item;

public interface IRepositorioItem {

	String listarItens();

	Item procurarItem(int codigo);

	void cadastrarItem(Item m);

	void removerItem(int codigo);

	void editarItem(int codigo);
}
