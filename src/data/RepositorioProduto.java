package data;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class RepositorioProduto implements IRepositorioProduto {

    public static List<Produto> produto;
    private int indice;

    public RepositorioProduto(int tamanho) {
	RepositorioProduto.produto = new ArrayList<>(tamanho);
    }

    @Override
    public String listarProdutos() {   
        String resultado = "";
        for (Produto p : RepositorioProduto.produto) {
        resultado = resultado + "[Código: " + p.getCodigo() + "] [Nome: " + p.getNome() + "] [Unidade de Medida: " 
                              + p.getUnidadeMedida() + "] [Quantidade: " + p.getQuantidade() + "] [Preço: "
                              + p.getPrecoVenda() + "]" + "\n";
        }
        return resultado;
    }

    @Override
    public Produto procurarProduto(int codigo) {
    	boolean codigoExiste = false;
	indice = 0;
	for (indice = 0; indice < RepositorioProduto.produto.size() && !codigoExiste; indice++) {
            Produto p = RepositorioProduto.produto.get(indice);
		if (p.getCodigo() == codigo) {
                    codigoExiste = true;
		}
		if (codigoExiste) {
                    Produto j = RepositorioProduto.produto.get(indice);
                    return j;
		}
	}
	return null;
    }

    @Override
    public void cadastrarProduto(Produto m) {

        if (m != null) {
            int num = m.getCodigo();
            boolean codigoExiste = false;
            for (Produto interno : produto) {
                if (interno.getCodigo() == num) {
                    codigoExiste = true;
                }
            }
            if (!codigoExiste) {
                RepositorioProduto.produto.add(m);
            }
        }
    }

    @Override
    public void removerProduto(int codigo) {        
	boolean codigoExiste = false;
	indice = 0;
	for (indice = 0; indice < RepositorioProduto.produto.size() && !codigoExiste; indice++) {
            Produto p = RepositorioProduto.produto.get(indice);
            if (p.getCodigo() == codigo) {
                codigoExiste = true;
            }
	}
	if (codigoExiste) {
            RepositorioProduto.produto.remove(indice - 1);            
	}	
    }    

    @Override
    public void editarProduto(int codigo, String nome, String tipo, double precoVenda, double precoCompra, String unidadeMedida) {
        boolean codigoExiste = false;
        
	indice = 0;
        for (indice = 0; indice < RepositorioProduto.produto.size() && !codigoExiste; indice++) {
            Produto p = RepositorioProduto.produto.get(indice);
            if (p.getCodigo() == codigo) {
		codigoExiste = true;

		p.setNome(nome);
                p.setTipo(tipo);
		p.setPrecoVenda(precoVenda);
		p.setPrecoCompra(precoCompra);
		p.setUnidadeMedida(unidadeMedida);
            }
	}
    }    

    @Override
    public void comprarProduto(int codigo, double quantNova) {
        boolean codigoExiste = false;     
        double quantAtual;
        
        for (indice = 0; indice < RepositorioProduto.produto.size() && !codigoExiste; indice++) {
            Produto p = RepositorioProduto.produto.get(indice);
            if (p.getCodigo() == codigo) {
		codigoExiste = true;
                quantAtual = p.getQuantidade();
		p.setQuantidade(quantAtual + quantNova);
            } 
        }
    }
}