import control.CadastroDeFuncionarios;
import control.ControladorCaixa;
import control.ICadastroDeFuncionarios;
import data.IRepositorioDeFuncionarios;
import model.Funcionario;

import control.ControladorProduto;
import data.IRepositorioProduto;
import model.Produto;
import data.IFluxoCaixa;

public class Main2 {

    public static void main(String[] args) {
	Funcionario novoGerente = new Funcionario("Anderson", "Ataide", "04723649441", 996662744, 733465, true, "persel", "persel00");
	Funcionario novoFuncionario = new Funcionario("fabio", "nascimento", "05515905482", 3154796, false, "fabion", "fbnascimento");
	Funcionario novoFuncionario1 = new Funcionario("carlos", "cavalcanti", "05515905482", 3597415, false, "fabion", "fbnascimento");
	
		
	IRepositorioDeFuncionarios repositorioDeFuncionarios = new data.repositorioDeFuncionarios(100);
	ICadastroDeFuncionarios cadastrarFuncionario = new CadastroDeFuncionarios(repositorioDeFuncionarios);
		
	cadastrarFuncionario.incluirFuncionario(novoFuncionario);
	repositorioDeFuncionarios.incluirFuncionario(novoGerente);
	repositorioDeFuncionarios.incluirFuncionario(novoFuncionario1);

	System.out.println();

	repositorioDeFuncionarios.listarFuncionarios();
		
	System.out.println();
	System.out.println();

	repositorioDeFuncionarios.procurarFuncionario(3597415);
	
	System.out.println();
		
	repositorioDeFuncionarios.excluirFuncionario(733465);
		

	repositorioDeFuncionarios.listarFuncionarios();
		
	System.out.println();
	System.out.println();
		
	repositorioDeFuncionarios.editarFuncionario(3154796, novoFuncionario.getNome(), "da silva", novoFuncionario.getCpf(), novoFuncionario.getTelefone());
		
	repositorioDeFuncionarios.listarFuncionarios();
	
	System.out.println();

	System.out.println();

	Funcionario novoFuncionario4 = new Funcionario("carlos", "cavalcanti", "05515905482", 3597415, false, "fabion", "fbnascimento");		
		
	cadastrarFuncionario.incluirFuncionario(novoFuncionario4);
        
        IRepositorioProduto instaciaInterfaceItem = new data.RepositorioProduto(100);
        ControladorProduto produto = new ControladorProduto(instaciaInterfaceItem);
        
        produto.cadastrarProduto(new Produto(1, "Arroz", "Integral", "unidade"));
	produto.cadastrarProduto(new Produto(2, "Feijão", "Preto", "unidade"));
	produto.cadastrarProduto(new Produto(3, "Ovo", "Branco", "unidade"));
	produto.cadastrarProduto(new Produto(4, "Pão", "Francês", "kilo"));
	produto.cadastrarProduto(new Produto(5, "Quejo", "Coalho", "kilo"));
	produto.cadastrarProduto(new Produto(6, "Quejo", "Coalho", "kilo"));
        
        System.out.println("Consultar todos");
	String resultado = produto.listarProdutos();
        System.out.println();
        System.out.println(resultado);        
        
        System.out.println("Atualizar");
	produto.editarProduto(1, "Arroz", "Integral", 3.00, 7.00,"unidade");
	produto.editarProduto(2, "Feijão", "Preto", 5.00, 10.00, "unidade");
	produto.editarProduto(3, "Ovo", "Branco", 0.5, 1, "unidade");
        produto.editarProduto(4, "Pão", "Francês", 2.00, 8.00, "kilo");
	produto.editarProduto(5, "Bolo", "Chocolate", 2.50, 6.00, "kilo");        	
        produto.editarProduto(6, "Quejo", "Coalho", 3.00, 17.00, "kilo");
		
	System.out.println();
	resultado = produto.listarProdutos();
	System.out.println(resultado);
        
        System.out.println("Deletar");
	produto.removerProduto(3);		
	resultado = produto.listarProdutos();
	System.out.println();
	System.out.println(resultado);
        
        System.out.println("ComprarProduto");
        produto.comprarProduto(1, 200);
        produto.comprarProduto(2, 200);
        produto.comprarProduto(4, 200);
        produto.comprarProduto(5, 200);
        produto.comprarProduto(6, 200);
        
        resultado = produto.listarProdutos();
        System.out.println();
	System.out.println(resultado);
        
        
        IFluxoCaixa instaciaInterfaceCaixa = new data.FluxoCaixa(100);
        ControladorCaixa caixa = new ControladorCaixa(instaciaInterfaceCaixa);
             
        System.out.println("ADD carrinho");

        caixa.adicionarCarrinho(1, 5);
        caixa.adicionarCarrinho(2, 8);
        caixa.adicionarCarrinho(6, 10);
        
        String resultado2 = caixa.listaCarrinho();
        
        System.out.println();
	System.out.println(resultado2); 
        
        System.out.println("Receber Total de Compras");
        System.out.println(caixa.calculoPedido());
        
        System.out.println();
        System.out.println("ADD carrinho, produto repetido");
        caixa.adicionarCarrinho(1, 5);
        
        resultado2 = caixa.listaCarrinho();
        
        System.out.println();
	System.out.println(resultado2);
        
        System.out.println();
        System.out.println("Remover item do carrinho");
        caixa.removerCarrinho(6);
        
        System.out.println();
        resultado2 = caixa.listaCarrinho();
	System.out.println(resultado2);
        
        System.out.println();
        System.out.println("Receber Total de Compras Atualizado");
        System.out.println(caixa.calculoPedido());

        System.out.println();        
        System.out.println("Venda efetuada?");        
        System.out.println(caixa.realizarVenda(100));

        
    }
}
