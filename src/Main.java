import control.CadastroDeFuncionarios;
import control.ICadastroDeFuncionarios;
import data.IRepositorioDeFuncionarios;
import model.Funcionario;
import model.Item;
import data.IRepositorioItem;
import control.CadastroItem;

public class Main {

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
        
        IRepositorioItem instaciaInterfaceItem = new data.RepositorioItem(100);
        CadastroItem item = new CadastroItem(instaciaInterfaceItem);
        
        item.cadastrarItem(new Item(1, "Arroz","UFRPE", "Integral", "unidade"));
	item.cadastrarItem(new Item(2, "Feijão","UFPE", "Preto", "unidade"));
	item.cadastrarItem(new Item(3, "Ovo","UPE", "Branco", "unidade"));
	item.cadastrarItem(new Item(4, "Pão","IFPE", "Francês", "kilo"));
	item.cadastrarItem(new Item(5, "Quejo","SoQueijos", "Coalho", "kilo"));
	item.cadastrarItem(new Item(6, "Quejo","SoQueijos", "Coalho", "kilo"));
        
        System.out.println("Consultar todos");
	item.listarItens();
	String resultado = item.listarItens();
        System.out.println();
        System.out.println(resultado);
        
        System.out.println("Atualizar");
	item.editarItem(5, "Bolo","SoQueijos", "Coalho", "kilo");
		
	System.out.println();
	resultado = item.listarItens();
	System.out.println(resultado);
        
        System.out.println("Deletar");
	item.removerItem(3);		
	resultado = item.listarItens();
	System.out.println();
	System.out.println(resultado);
        
        System.out.println("Comprar");
	item.comprarItem(1, 100, 2.25);
	resultado = item.listarItens();
	System.out.println();
	System.out.println(resultado);
        
        System.out.println("Alterar Preço Venda");
	item.mudarPrecoVenda(1, 7.25);
        item.mudarPrecoVenda(3, 7.25);
	resultado = item.listarItens();
	System.out.println();
	System.out.println(resultado);
    }
}
