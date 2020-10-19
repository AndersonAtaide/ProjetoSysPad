package control;

import model.Item;

public interface ICadastroItem {

    String listarItens();

    Item procurarItem(int codigo);

    void cadastrarItem(Item m);

    void removerItem(int codigo);

    void editarItem(int codigo, String nome, String fabricante, String tipo, String unidadeMedida);
}
