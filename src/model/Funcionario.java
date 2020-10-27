package model;

public class Funcionario extends Usuario {

	private int matricula;
	private Login login;

        public Funcionario(){
            super();
        }
        
	public Funcionario(String nome, String sobrenome, String cpf, int telefone, int matricula, String login, String senha) {
		super(nome, sobrenome, cpf, telefone);
		this.matricula = matricula;
		this.login = new Login(login, senha);
	}

	public Funcionario(String nome, String sobrenome, String cpf, int matricula, String login, String senha) {
		super(nome, sobrenome, cpf);
		this.matricula = matricula;
		this.login = new Login(login, senha);
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Funcionario\n" + super.toString() + ", matricula=" + matricula + ", " + login.toString();
	}

}
