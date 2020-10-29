package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Pedido;
import model.Produto;
import model.Venda;

public class FluxoCaixa implements IFluxoCaixa {
    
    private List<Pedido> carrinho;
    private List<Venda> venda;
    
    private int indice;    
    
    public FluxoCaixa(int tamanho) {
	this.carrinho = new ArrayList<>(tamanho);
        this.venda = new ArrayList<>(tamanho);
    }   

    @Override
    public int gerarCodVenda(){        
        int numGerado;        
        
        for(int indice = 0; indice < this.venda.size(); indice++){
            this.venda.get(indice);
        }
        
        numGerado = indice + 1;
        return numGerado;
    }    
    
    @Override
    public void adicionarCarrinho(int codProduto, double quantidade) {        
        
        if(checarEstoque(codProduto, quantidade)) {            
            boolean codigoExiste = false;
            boolean itemNovo = true;
            
            int cod = 0;
            double quant = 0;
            String nome = "";
            double precoVenda = 0;            
            
            for (indice = 0; indice < RepositorioProduto.produto.size() && !codigoExiste; indice++) {
                Produto p = RepositorioProduto.produto.get(indice);
                if (p.getCodigo() == codProduto) {
                    codigoExiste = true;
                    cod = p.getCodigo();
                    nome = p.getNome();
                    quant = quantidade;
                    precoVenda = p.getPrecoVenda();
                }
            }  
            
            for(Pedido e : this.carrinho) {
                if(e.getCodPedido() == cod){
                    double quantAtual = e.getQuantComprada();
                    e.setQuantComprada(quantAtual + quant);
                    double valorAtual = e.getValorSomaItens();
                    e.setValorSomaItens(valorAtual + (precoVenda*quant));
                    itemNovo = false;
                }
            }
            if (itemNovo) {
                double subtotal = quant*precoVenda;
                Pedido c = new Pedido(cod, nome, quant, precoVenda, subtotal);
                this.carrinho.add(c);
            }              
        }
    }

    @Override
    public void removerCarrinho(int codProduto) {
        boolean codigoExiste = false;
	indice = 0;
	for (indice = 0; indice < this.carrinho.size() && !codigoExiste; indice++) {
            Pedido c = this.carrinho.get(indice);
            if (c.getCodPedido() == codProduto) {
                codigoExiste = true;
            }
	}
	if (codigoExiste) {
            this.carrinho.remove(indice - 1);            
	}
    }

    @Override
    public void cancelarPedido(int codPedido) {
        this.carrinho.clear();        
    }

    @Override
    public double calculoPedido() {
        double totalCarrinho = 0;
        
        for(Pedido itens : this.carrinho){
            totalCarrinho = totalCarrinho + itens.getValorSomaItens();
        }
        return totalCarrinho;
    }

    @Override
    public boolean checarEstoque(int codigo, double quantidade) {
        boolean codigoExiste = false;
        boolean resultado = false;
        for (indice = 0; indice < RepositorioProduto.produto.size() && !codigoExiste; indice++) {
            Produto p = RepositorioProduto.produto.get(indice);
            if (p.getCodigo() == codigo) {
                codigoExiste = true;            
                if (p.getQuantidade() >= quantidade){
                    resultado = true;
                }
            }
	}        
        return resultado;        
    }        

    @Override
    public boolean realizarVenda(double pagamento){
        boolean pagAprovado = false;
        double conta = calculoPedido(); 
        if(pagamento >= conta){
            pagAprovado = true;
            posVenda();
        }
        return pagAprovado;
    }
    
    @Override
    public void remocaoItens(){
        int numProduto;
        double quantRetirar;
        double quantAtual;
        
        for(Pedido c : this.carrinho){                    
            numProduto = c.getCodPedido();
            quantRetirar = c.getQuantComprada();
            
            for(Produto p : RepositorioProduto.produto){
                if(p.getCodigo() == numProduto){
                    quantAtual = p.getQuantidade();            
                    p.setQuantidade(quantAtual - quantRetirar);
                }
            }
        }        
    }
    
    @Override
    @SuppressWarnings("null")
    public void posVenda() {
        Date dataHoje = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/aaaa");
        
        int codVenda = gerarCodVenda();
        double calculoPedido = calculoPedido();
        Venda v = new Venda(codVenda, calculoPedido, formato.format(dataHoje));
        this.venda.add(v);
        remocaoItens();
        this.carrinho.clear();        
    }

    @Override
    public String listaCarrinho() {
     String resultado = "";
        for (Pedido c : this.carrinho) {
        resultado = resultado + "[Código: " + c.getCodPedido() + "] [Nome: " + c.getNomeProduto() + "] [Quantidade: "
                              + c.getQuantComprada() + "] [Preço Unitario: " + c.getPrecoVenda() + "] [SubTotal: "
                              + c.getValorSomaItens() + "]\n";
        }
        return resultado;
    }   
}