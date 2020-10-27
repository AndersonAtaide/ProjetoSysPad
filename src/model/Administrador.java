package model;

public class Administrador extends Funcionario {

	private int nivelHierarquico;

	public Administrador(String nome, String sobrenome, String cpf, int matricula, String login,
			String senha, int nivelHierarquico) {
		super(nome, sobrenome, cpf, matricula, login, senha);
		this.nivelHierarquico = nivelHierarquico;
	}

	public Administrador(String nome, String sobrenome, String cpf, int telefone, int matricula,
			String login, String senha, int nivelHierarquico) {
		super(nome, sobrenome, cpf, telefone, matricula, login, senha);
		this.nivelHierarquico = nivelHierarquico;
	}

	public int getNivelHierarquico() {
		return nivelHierarquico;
	}

	public void setNivelHierarquico(int nivelHierarquico) {
		this.nivelHierarquico = nivelHierarquico;
	}

	@Override
	public String toString() {
		String stringDaSuper = super.toString();
		String modificada = stringDaSuper.substring(12);

		return "Administrador\n" + modificada + ", nivelHierarquico=" + nivelHierarquico;
	}
}
