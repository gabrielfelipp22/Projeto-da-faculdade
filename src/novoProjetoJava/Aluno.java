package novoProjetoJava;

public class Aluno {
	private String nome;
	private String matricula;
	private String emailAcademico;
	
	Aluno(String nome, String matricula, String emailAcademico){
		this.nome = nome;
		this.matricula = matricula;
		this.emailAcademico = emailAcademico;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getMatricula() {
		return this.matricula;
	}
	public String getEmailAcademico() {
		return this.emailAcademico;
	}

	@Override
	public String toString() {
		return "Dados do Aluno [nome = " + nome + ", matricula = " + matricula + ", email academico = " + emailAcademico + "]";
	}
}
