package control;

import model.Usuario;
import data.IRepositorioDeUsuarios;

public class CadastroDeUsuario implements ICadastroDeUsuario {

    private IRepositorioDeUsuarios repositorioDeUsuarios;

    public CadastroDeUsuario(IRepositorioDeUsuarios repositorioDeUsuarios) {
	this.repositorioDeUsuarios = repositorioDeUsuarios;
    }

    @Override
    public void incluirUsuario(Usuario user) {
	try {
            if (user != null && user.getCpf() != null) {
                this.repositorioDeUsuarios.incluirUsuario(user);
            }
	} catch (Exception e) {
            e.printStackTrace();
	}
    }

    @Override
    public void procurarUsuario(String cpf) {
	if (cpf != null)
            this.repositorioDeUsuarios.procurarUsuario(cpf);
    }

    @Override
    public void excluirUsuario(String cpf) {
        if (cpf != null)
            this.repositorioDeUsuarios.excluirUsuario(cpf);
    }

    @Override
    public void listarUsuarios() {
        repositorioDeUsuarios.listarUsuarios();
    }

    @Override
    public boolean editarUsuario(String nome, String sobrenome, String cpf, int telefone) {

        if (cpf != null && !nome.contains(" ") && !sobrenome.contains(" ") && cpf.length() == 11) {

            boolean resposta;

            char primeiraLetraDoNome = nome.toUpperCase().charAt(0);
            nome = primeiraLetraDoNome + nome.substring(1);

            char primeiraLetraDoSobrenome = sobrenome.toUpperCase().charAt(0);
            sobrenome = primeiraLetraDoSobrenome + sobrenome.substring(1);

            resposta = repositorioDeUsuarios.editarUsuario(nome, sobrenome, cpf, telefone);

            return resposta;
	} else {
            return false;
	}
    }
}
