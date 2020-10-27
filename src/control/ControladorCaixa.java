package control;

import data.IFluxoCaixa;

public class ControladorCaixa implements IControladorCaixa {

    private IFluxoCaixa fluxoCaixa;
    
    public ControladorCaixa(IFluxoCaixa iFluxoCaixa){
        this.fluxoCaixa = iFluxoCaixa;
    }
    
    @Override
    public void adicionarCarrinho(int codProduto, double quantidade) {
        if (codProduto > 0 && quantidade > 0){
            this.fluxoCaixa.adicionarCarrinho(codProduto, quantidade);
        }
    }

    @Override
    public boolean checarEstoque(int codigo, double quantidade) {
        if (codigo > 0 && quantidade > 0){
            return this.fluxoCaixa.checarEstoque(codigo, quantidade);
        }        
        return false;
    }

    @Override
    public boolean realizarVenda(double pagamento) {
        if (pagamento > 0){
            return this.fluxoCaixa.realizarVenda(pagamento);
        }
        return false;
    }

    @Override
    public void removerCarrinho(int codPedido) {
        if (codPedido > 0){
            this.fluxoCaixa.removerCarrinho(codPedido);
        }        
    }

    @Override
    public void cancelarPedido(int codPedido) {
        if (codPedido > 0){
            this.fluxoCaixa.cancelarPedido(codPedido);
        }
    }

    @Override
    public double calculoPedido() {
        return this.fluxoCaixa.calculoPedido();    
    }

    @Override
    public int gerarCodVenda() {
        return this.fluxoCaixa.gerarCodVenda();        
    }

    @Override
    public void remocaoItens() {
        this.fluxoCaixa.remocaoItens();        
    }

    @Override
    public void posVenda() {
        this.fluxoCaixa.posVenda();
    }

    @Override
    public String listaCarrinho() {
        return this.fluxoCaixa.listaCarrinho();
    }    
}