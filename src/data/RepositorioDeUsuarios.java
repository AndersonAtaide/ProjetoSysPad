package data;

import model.Usuario;

public class RepositorioDeUsuarios implements IRepositorioDeUsuarios{
    private Usuario[] usuarios;
	private int posicao = 0;

	public RepositorioDeUsuarios(int tamanho) {
		this.usuarios = new Usuario[tamanho];
	}

	public Usuario[] getUsuario() {
		return usuarios;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

        @Override
	public void incluirUsuario(Usuario usuario) {
		while (this.usuarios[this.posicao] != null) {
			if (this.usuarios[posicao].getCpf()== usuario.getCpf()) {
				System.out.println("Usuario Já existe");
				return;
			}
			posicao += 1;
		}
		this.usuarios[posicao] = usuario;
	}

        @Override
	public void procurarUsuario(String cpf) {
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf().equals(cpf)) {
				System.out.println(usuario);
				break;
			}
		}
	}

        @Override
	public void excluirUsuario(String cpf) {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i].getCpf().equals(cpf)) {
				usuarios[i] = null;
				break;
			}
		}
	}

        @Override
	public void listarUsuarios() {
		for (Usuario user : usuarios) {
			if (user != null)
				System.out.print(user);
		}
	}
        
        @Override
	public boolean editarUsuario(String nome, String sobrenome, String cpf, int telefone) {
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf().equals(cpf)) {
				usuario.setNome(nome);
				usuario.setSobrenome(sobrenome);
				usuario.setCpf(cpf);
				usuario.setTelefone(telefone);
				return true;
			}
		}
		return false;
	}        
}
