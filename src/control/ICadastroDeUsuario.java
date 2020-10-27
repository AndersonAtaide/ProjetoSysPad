package control;

import model.Usuario;

public interface ICadastroDeUsuario {

	void incluirUsuario(Usuario user);

	void procurarUsuario(String cpf);

	void excluirUsuario(String cpf);

	void listarUsuarios();

	boolean editarUsuario(String nome, String sobrenome, String cpf, int telefone);
}