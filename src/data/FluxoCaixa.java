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
    private List<Produto> produto;
    private List<Venda> venda;
    
    private int indice;
    
    public FluxoCaixa(int tamanho) {
	this.carrinho = new ArrayList<>(tamanho);
        this.produto = new ArrayList<>(tamanho);
        this.venda = new ArrayList<>(tamanho);
    }   

    @Override
    public int gerarCodVenda(){        
        int numGerado;        
        
        for(int indice = 0; indice < venda.size(); indice++){
            this.venda.get(indice);
        }
        
        numGerado = indice + 1;
        return numGerado;
    }    
    
    @Override
    public void adicionarCarrinho(int codProduto, double quantidade) {        
        
        if(checarEstoque(codProduto, quantidade) >= 0) {            
            boolean codigoExiste = false;
            
            int num = 0;
            double quant = 0;
            String nome = "";
            double precoVenda = 0;            
            
            for (indice = 0; indice < this.produto.size() && !codigoExiste; indice++) {
                Produto p = this.produto.get(indice);
                if (p.getCodigo() == codProduto) {
                    codigoExiste = true;
                    num = p.getCodigo();
                    nome = p.getNome();
                    quant = p.getQuantidade();
                    precoVenda = p.getPrecoVenda();
                }
            }  
            
            for(Pedido c : carrinho) {
                if(c.getCodPedido() == num){
                    double quantAtual = c.getQuantComprada();
                    c.setQuantComprada(quantAtual+num);
                    codigoExiste = true;
                }
            }
            if (!codigoExiste) {
                double subtotal = quant*precoVenda;
                Pedido x = new Pedido(num, nome, quant, subtotal);
            }  
            
            //O PROBLEMA ESTÁ AQUI, PQ TENHO Q INSTANCIAR O PEDIDO MAS SE EU CRIO ELE COMO 
            //PEDIDO C; TENHO Q DELCARAR ELE NULL, E TENTANDO INSTANCIAR COM O NEW N DA CERTO TBM
            //ESSE MESMO PROBLEMA ESTA EM INSTANCIAR A VENDA NO METODO POSVENDA MAS EM BAIXO.
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
        carrinho.clear();        
    }

    @Override
    public double calculoPedido() {
        double totalCarrinho = 0;
        
        for(Pedido itens : carrinho){
            totalCarrinho = totalCarrinho + itens.getValorSomaItens();
        }
        return totalCarrinho;
    }

    @Override
    @SuppressWarnings("UnusedAssignment")
    public int checarEstoque(int codigo, double quantidade) {
        boolean codigoExiste = false;
        int resultado = -1;
        for (indice = 0; indice < this.produto.size() && !codigoExiste; indice++) {
            Produto p = this.produto.get(indice);
            if (p.getCodigo() == codigo) {
                codigoExiste = true;
            }
            if (codigoExiste) {
                if (p.getQuantidade() == quantidade){
                    return resultado = indice;
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
        
        for(Pedido c : carrinho){                    
            numProduto = c.getCodPedido();
            quantRetirar = c.getQuantComprada();
            
            for(Produto p : produto){
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
        remocaoItens();
        carrinho.clear();
        //se quiser ter a lista de produtos ai tem q mudar a venda
        //pra receber os produtos e quantidades vendidas
        //a ideia aki é apagar o ArrayList do pedido no fim desse metodo
    }

    @Override
    public String listaCarrinho() {
     String resultado = "";
        for (Pedido c : this.carrinho) {
        resultado = resultado + "[Código: " + c.getCodPedido() + "] [Nome: " + c.getNomeProduto() + "] [Quantidade: "
                              + c.getQuantComprada() + "] [Preço Unitario: " + (c.getValorSomaItens()/c.getQuantComprada()) + "] [SubTotal: "
                              + c.getValorSomaItens() + "\n";
        }
        return resultado;
    }   
}