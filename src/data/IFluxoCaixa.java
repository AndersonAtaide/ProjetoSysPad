package data;

public interface IFluxoCaixa {     
    
    void adicionarCarrinho(int codProduto, double quantidade);

    int checarEstoque (int codigo, double quantidade);    
    
    boolean realizarVenda(double pagamento);

    void removerCarrinho(int codPedido);
    
    void cancelarPedido (int codPedido);    
    
    double calculoPedido ();
    
    int gerarCodVenda();
        
    void remocaoItens();
    
    void posVenda();
    
    String listaCarrinho();
}
