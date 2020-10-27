package data;

import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class RepositorioVenda {
    
    private static List<Venda> venda;
    
    public RepositorioVenda(int tamanho) {
	RepositorioVenda.venda = new ArrayList<>(tamanho);
    }
    
}
