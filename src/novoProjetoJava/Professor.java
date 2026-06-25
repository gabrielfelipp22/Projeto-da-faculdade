package novoProjetoJava;

public class Professor {
	private String nomeDoProfessor;
	private String matriculaDoProfessor;
	private Disciplina disciplina;
	
	Professor(String nomeDoProfessor, String matriculaDoProfessor, Disciplina disciplina){
		this.nomeDoProfessor = nomeDoProfessor;
		this.matriculaDoProfessor = matriculaDoProfessor;
		this.disciplina = disciplina;
	}
	public String getNomeDoProfessor() {
		return this.nomeDoProfessor;
	}
	public String getMatriculaDoProfessor() {
		return this.matriculaDoProfessor;
	}
	public Disciplina getDisciplinaDoProfessor() {
		return this.disciplina;
	}

	@Override
	public String toString() {
		return "Dados dos professores [Nome do professor = " + this.nomeDoProfessor + ", Matricula do professor = " + this.matriculaDoProfessor
				+ this.disciplina + "]";
	}
}
