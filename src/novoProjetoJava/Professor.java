package novoProjetoJava;

public class Professor {
	String nomeDoProfessor;
	String matriculaDoProfessor;
	Disciplina disciplina;
	
	Professor(String nomeDoProfessor, String matriculaDoProfessor, Disciplina disciplina){
		this.nomeDoProfessor = nomeDoProfessor;
		this.matriculaDoProfessor = matriculaDoProfessor;
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Dados dos professores [Nome do professor = " + this.nomeDoProfessor + ", Matricula do professor = " + this.matriculaDoProfessor
				+ this.disciplina + "]";
	}
}
