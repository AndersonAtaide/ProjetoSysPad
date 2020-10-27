/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

//import Classes.Usuarios;
import model.Usuario;

/**
 *
 * @author ander
 */
public class RepositorioDeUsuarios {
    private Usuario[] usuario;
	private int posicao = 0;

	public RepositorioDeUsuarios(int tamanho) {
		this.usuario = new Usuario[tamanho];
	}

	public Usuario[] getUsuario() {
		return usuario;
	}

	public void setFuncionarios(Usuario[] usuarios) {
		this.usuario = usuarios;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public void incluirUsuario(Usuario usuario) {
		while (this.usuario[this.posicao] != null) {
			if (this.usuario[posicao].getCpf()== usuario.getCpf()) {
				System.out.println("Usuario Já existe");
				return;
			}
			posicao += 1;
		}
		this.usuario[posicao] = usuario;
	}
/*
	public void procurarFuncionario(int matricula) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getMatricula() == matricula) {
				System.out.println(funcionario);
				break;
			}
		}
	}

	public void excluirFuncionario(int matricula) {
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i].getMatricula() == matricula) {
				funcionarios[i] = null;
				break;
			}
		}
	}
*/
	public void listarUsuarios() {
		for (Usuario user : usuario) {
			if (user != null)
				System.out.print(user);
		}
	}
/*
	public boolean editarFuncionario(int matricula, String nome, String sobrenome, String cpf, int telefone) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getMatricula() == matricula) {
				funcionario.setNome(nome);
				funcionario.setSobrenome(sobrenome);
				funcionario.setCpf(cpf);
				funcionario.setTelefone(telefone);
				return true;
			}
		}
		return false;
	}*/
}
