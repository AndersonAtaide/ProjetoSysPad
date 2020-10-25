package model;

public class Produto {

    private int codigo;
    private String nome;
    private String unidadeMedida;
    private String tipo;
    private double quantidade;
    private double precoCompra;
    private double precoVenda;

    public Produto() {}

    public Produto(int codigo, String nome, String tipo, String unidadeMedida) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.unidadeMedida = unidadeMedida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getQuantidade() {
        return quantidade;
    }        
    
    public double getPrecoVenda() {
        return precoVenda;
    }        
    
    public int getCodigo() {
        return codigo;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }                

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
}
