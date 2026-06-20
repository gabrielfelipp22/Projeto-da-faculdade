package novoProjetoJava;

public class Escola {
	Aluno alunos[];
	Professor professores[];
	Sala salas[];
	Turma turmas[];
	int totalAlunos;
	int totalProfessores;
	int totalSalas;
	int totalTurmas;
	String mensagemCadastroSucesso = "Cadastrado com sucesso";
	String mensagemDeErro = "Falha ao cadastrar";
	
	Escola(int capacidadeAlunos, int capacidadeProfessores, int capacidadeSalas, int capacidadeTurma ){
		alunos = new Aluno[capacidadeAlunos];
		professores = new Professor[capacidadeProfessores];
		salas = new Sala[capacidadeSalas];
		turmas = new Turma[capacidadeTurma]; 
		
		this.totalAlunos = 0;
		this.totalProfessores = 0;
		this.totalSalas = 0;
		this.totalTurmas = 0;
	}
	
	void mensagemDeSucessoOuErro(boolean isSucesso) {
		if(isSucesso) {
			System.out.println(mensagemCadastroSucesso);
		}else {
			System.out.println(mensagemDeErro);
		}
	}
	
	boolean cadastrarAluno(String nome, String matricula, String emailAcademico) {
		if(totalAlunos >= alunos.length) {
			mensagemDeSucessoOuErro(false);
			return false;
		}
		Aluno alunoExistente = procurarAlunoPorMatricula(matricula);
		
		if(alunoExistente != null) {
			mensagemDeSucessoOuErro(false);
			return false;
		
		}
		alunos[totalAlunos] = new Aluno(nome, matricula, emailAcademico);
		totalAlunos++;
		mensagemDeSucessoOuErro(true);
		return true;
	}
	
	boolean cadastrarProfessor(String nomeDoProfessor,  String matriculaDoProfessor, Disciplina disciplina) {
		if(totalProfessores >= professores.length) {
			mensagemDeSucessoOuErro(false);
			return false;
		}
		Professor professorExistente = procurarProfessorPorMatricula(matriculaDoProfessor);
		
		if(professorExistente != null) {
			mensagemDeSucessoOuErro(false);
			return false;
		}
		professores[totalProfessores] = new Professor(nomeDoProfessor, matriculaDoProfessor, disciplina);
		totalProfessores++;
		mensagemDeSucessoOuErro(true);
		return true;
	}
	
	boolean cadastrarSala(int numero, int capacidade) {
		if(totalSalas >= salas.length ) {
			mensagemDeSucessoOuErro(false);
			return false;
		}
		if(procurarSalaPorNumero(numero) != null) {
			mensagemDeSucessoOuErro(false);
			return false;
		}

		salas[totalSalas] = new Sala(numero, capacidade);
		totalSalas++;
		mensagemDeSucessoOuErro(true);
		return true;
	}
	
	boolean cadastrarTurma(String codigo, Professor professor, Sala sala, int capacidadeMaximaDeAlunos) {
		if(totalTurmas >= turmas.length) {
			mensagemDeSucessoOuErro(false);
			return false;
		}
		Turma turmaExistente = procurarTurmaPorCodigo(codigo);
		
		if(turmaExistente != null) {
			mensagemDeSucessoOuErro(false);
			return false;
		}
		turmas[totalTurmas] = new Turma(codigo, professor, sala, capacidadeMaximaDeAlunos);
		totalTurmas++;
		mensagemDeSucessoOuErro(true);
		return true;
	}
	
	boolean matricularAlunoNaTurma(String matriculaDoAluno, String codigoTurma) {	
		Aluno aluno = procurarAlunoPorMatricula(matriculaDoAluno);
		if(aluno == null) {
			return false;
		}
		Turma turma = procurarTurmaPorCodigo(codigoTurma);
		if(turma == null) {
			return false;
		}
		
		return turma.adicionarAlunoNaTurma(aluno);
	}
		
	Aluno procurarAlunoPorMatricula(String matriculaDoAluno) {
		for(int i = 0; i < totalAlunos; i++) {
			
			Aluno matriculaEncontrada = alunos[i];
			if(matriculaEncontrada.matricula.equalsIgnoreCase(matriculaDoAluno)) {
				return matriculaEncontrada;
			}
		}
		return null;
	}	
	
	Professor procurarProfessorPorMatricula(String matriculaDoProfessorAserProcurada) {
		for(int i = 0; i < totalProfessores; i++) {
			
			Professor matriculaEncontrada = professores[i];
			if(matriculaEncontrada.matriculaDoProfessor.equalsIgnoreCase(matriculaDoProfessorAserProcurada)) {
				return matriculaEncontrada;
			}
		}
		return null;
	}	
	Turma procurarTurmaPorCodigo(String codigo) {
		for(int i = 0; i < totalTurmas; i++) {
			if(turmas[i].codigo.equalsIgnoreCase(codigo)) {
				return turmas[i];
			}
		}
		return null;
	}
	Sala procurarSalaPorNumero(int numeroASerProcurado) {
		for(int i = 0; i < totalSalas; i++) {
			if(salas[i].numero == numeroASerProcurado) {
				return salas[i];
			}
		}
		return null;
	}
	
	boolean removerAlunoDaTurma(String matriculaDoAluno, String codigoTurma) {
		Turma turma = procurarTurmaPorCodigo(codigoTurma);
		
		if(turma == null) {
			return false;
		}
		return turma.removerAlunoDaTurmaPorMatricula(matriculaDoAluno);
	}
	
	
	boolean removerAlunoDoSistema(String matriculaASerRemovida) {
		for(int i = 0; i < totalTurmas; i++) {
			turmas[i].removerAlunoDaTurmaPorMatricula(matriculaASerRemovida);
			}
		for(int i = 0; i < totalAlunos; i++) {
			if(alunos[i].matricula.equalsIgnoreCase(matriculaASerRemovida)) {
				for(int j = i; j < totalAlunos - 1; j++){
					alunos[j] = alunos[j+1];
				}
				alunos[totalAlunos-1] = null;
				totalAlunos--;
				return true;
			}
		}
		return false;
	}
	
	boolean removerProfessorDoSistema(String matriculaASerRemovida) {
		for(int i = 0; i < totalTurmas; i++) {
			if(turmas[i].professor.matriculaDoProfessor.equals(matriculaASerRemovida)) {
				System.out.println("Não é possivel remover\n professor matriculado em uma turma");
				return false;
			}
		}
		for(int j = 0; j < totalProfessores; j++ ) {
			if(professores[j].matriculaDoProfessor.equals(matriculaASerRemovida)) {
				for(int l = j; l < totalProfessores -1; l++) {
					professores[l] = professores[l+1];
				}
				professores[totalProfessores-1] = null;
				totalProfessores--;
				return true;
			}
		}
	  	System.out.println("Professor não encontrado.");
		return false;
	}
	
	void organizarAlunosEmOrdemAlfabetica() {
		for(int i = 0; i < totalAlunos-1; i++) {
			for(int j = 0; j < totalAlunos - 1; j++) {
				if(alunos[j].nome.compareTo(alunos[j+1].nome) > 0) {
					Aluno aux = alunos[j];
					alunos[j] = alunos[j+1];
					alunos[j+1] = aux;
				}
			}
		}
	}
	
	void organizarArrayEmOrdemAlfabeticaProfessores() {
		for(int i = 0; i < totalProfessores; i++) {
			for(int j = 0; j <totalProfessores - 1; j++) {
				if(professores[j].nomeDoProfessor.compareTo(professores[j+1].nomeDoProfessor) > 0) {
					Professor aux = professores[j];
					professores[j] = professores[j+1];
					professores [j+1] = aux;
				}
			}
		}
	}
	
	
	void listarTurmas() {
		for(int i =0;i<totalTurmas;i++ ) {
			System.out.println(turmas[i]);
		}
	}
	void listarAlunos() {
		organizarAlunosEmOrdemAlfabetica();
		for(int i = 0; i < totalAlunos; i++) {
			System.out.println(alunos[i]);
		}
	}
	void listarProfessores() {
		organizarArrayEmOrdemAlfabeticaProfessores();
		for (int i =0; i < totalProfessores ;i++) {
			System.out.println(professores[i]);

		}
	}
	void listarSalas() {
		for(int i = 0; i < totalSalas; i++) {
			System.out.println(salas[i]);
		}
	}
}

