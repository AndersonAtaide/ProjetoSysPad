package model;

public class Item {

    private int codigo;
    private String nome;
    private String fabricante;
    private String tipo;
    private String unidadeMedida;
    private double quantidade;
    private double precoCompra;
    private double precoVenda;

    public Item() {
    }

    public Item(int codigo, String nome, String fabricante, String tipo, String unidadeMedida) {
        this.codigo = codigo;
        this.nome = nome;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.unidadeMedida = unidadeMedida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public void aumentarQuantidade(int quantComprada) {
        this.quantidade = this.quantidade + quantComprada;
    }

    public void definirPrecoCompra(double valor) {
        this.precoCompra = valor;
    }

    public void definirPrecoVenda(double valor) {
        this.precoVenda = valor;
    }

    public void diminuirQuantidadde(int quantVendida) {
        this.quantidade = this.quantidade - quantVendida;
    }
}
