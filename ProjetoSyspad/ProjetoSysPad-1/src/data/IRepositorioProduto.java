package data;

import model.Produto;

public interface IRepositorioProduto {

    void editarProduto(int codigo, String nome, String tipo, double precoVenda, double precoCompra, String unidadeMedida);

    void comprarProduto(int codigo, double quantidade);

    Produto procurarProduto(int codigo);
    
    void cadastrarProduto(Produto m);

    void removerProduto(int codigo);
    
    String listarProdutos();
}
