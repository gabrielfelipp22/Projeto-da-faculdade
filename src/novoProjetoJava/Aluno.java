package novoProjetoJava;

public class Aluno {
	String nome;
	String matricula;
	String emailAcademico;
	
	Aluno(String nome, String matricula, String emailAcademico){
		this.nome = nome;
		this.matricula = matricula;
		this.emailAcademico = emailAcademico;
	}

	@Override
	public String toString() {
		return "Dados do Aluno [nome = " + nome + ", matricula = " + matricula + ", email academico = " + emailAcademico + "]";
	}
}
