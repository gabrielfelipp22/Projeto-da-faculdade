package novoProjetoJava;

public class Turma {
	private String codigo;
	private Professor professor;
	private Sala sala;
	private Aluno[] alunos;
	private int quantidadeAlunos;
	
	Turma(String codigo, Professor professor, Sala sala, int capacidadeMaximaDeAlunos){
		this.codigo = codigo;
		this.professor = professor;
		this.sala = sala;
		alunos = new Aluno[capacidadeMaximaDeAlunos];
		this.quantidadeAlunos = 0;
	}
	
	public String getCodigoDaTurma() {
		return this.codigo;
	}
	public Professor getProfessor() {
		return this.professor;
	}
	public Sala getSala() {
		return this.sala;
	}
	public Aluno[] getAluno() {
		return this.alunos;
	}
	public int getQuantidadeDeAlunos() {
		return this.quantidadeAlunos;
	}
	
	boolean adicionarAlunoNaTurma(Aluno aluno) {
		if(quantidadeAlunos >= alunos.length) {
			return false;
		}
		alunos[quantidadeAlunos] = aluno;
		quantidadeAlunos++;
		return true;
	}
	
	boolean adicionarProfessorNaTurma(Professor professor) {
		if(professor == null) {
			this.professor = professor;
			return true;
		}
		return false;
	}
	
	boolean removerAlunoDaTurmaPorMatricula(String matricula) {
		for(int i = 0; i < quantidadeAlunos; i++) {
			if(alunos[i].getMatricula().equalsIgnoreCase(matricula)) {
				for(int j = i; j< quantidadeAlunos-1; j++ ) {
					alunos[j] = alunos[j+1];
				}
				alunos[quantidadeAlunos-1] = null;
				quantidadeAlunos--;
				return true;
			}
		}
		return false;
	}
	void organizarArrayEmOrdemAlfabeticaAluno() {
		for(int i = 0; i < quantidadeAlunos; i++) {
			for(int j = 0; j < quantidadeAlunos - 1; j++) {
				if(alunos[j].getNome().compareTo(alunos[j+1].getNome()) > 0) {
					Aluno aux = alunos[j];
					alunos[j] = alunos[j+1];
					alunos[j+1] = aux;
				}
			}
		}
	}
	void listarTurma() {
		System.out.println(sala);
		
		System.out.println(professor);
		
		organizarArrayEmOrdemAlfabeticaAluno();
		for(int i = 0; i < quantidadeAlunos; i++) {
			System.out.println(alunos[i]);
		}
	}
	@Override
	public String toString() {
		return "codigo da turma: "+ codigo;
	}
	
}