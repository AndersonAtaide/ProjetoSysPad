package model;

public class Pedido {

    private int codProduto;
    private String nomeProduto;
    private double quantComprada;
    private double precoVenda;
    private double valorSomaItens;
      
    public Pedido(){}
    
    public Pedido(int codProduto, String nomeProduto, double quantComprada, double precoVenda, double valorSomaItens) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.quantComprada = quantComprada; 
        this.precoVenda = precoVenda;
        this.valorSomaItens = valorSomaItens;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }    

    public double getQuantComprada() {
        return quantComprada;
    }

    public void setQuantComprada(double quantComprada) {
        this.quantComprada = quantComprada;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public int getCodPedido() {
        return codProduto;        
    }    

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorSomaItens() {
        return valorSomaItens;
    }
    
    public void setValorSomaItens(double valorSomaItens) {
        this.valorSomaItens = valorSomaItens;
    }        

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }      
}