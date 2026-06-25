package novoProjetoJava;

import java.util.Scanner;

public class Main {
	static void menuDaEscola() {
		System.out.println("1 - Cadastrar aluno.");
		System.out.println("2 - Cadastrar professor.");
		System.out.println("3 - Cadastrar sala.");
		System.out.println("4 - Criar turma. ");
		System.out.println("5 - Remover aluno do sistema pela matricula. ");
		System.out.println("6 - Remover professor do sistema por matricula. ");
		System.out.println("7 - Procurar aluno por matricula. ");
		System.out.println("8 - Procurar professor por matricula. ");
		System.out.println("9 - Gerenciar turmas (listar/adicionar/remover alunos).");
		System.out.println("10 - lista todos os dados. ");
		System.out.println("0 - Sair.");
		System.out.println("Escolha uma opcão:  ");
	}
	
	static void menuDaTurma() {
		System.out.println("1 - Listar dados da turma.");
		System.out.println("2 - Remover aluno da turma.");
		System.out.println("3 - Adicionar novo aluno na turma.");
		System.out.println("4 - Voltar ao menu inicial");
	}
	public static void main(String[] args) {
       Scanner leitor = new Scanner(System.in);
       System.out.println("BEM VINDO AO SISTEMA ESCOLAR");
       //System.out.print("Digite a capacidade de alunos que a escola pode receber: ");
       int capacidadeAlunos = 100; //leitor.nextInt();
     //  leitor.nextLine();
       
      // System.out.print("Digite a capacidade de professores que a escola pode receber: ");
       int capacidadeProfessores = 10; //leitor.nextInt();
     //  leitor.nextLine();
       
       //System.out.print("Digite a capacidade de salas que a escola pode receber: ");
       int capacidadeSalas = 10;//leitor.nextInt();
      // leitor.nextLine();
       
      // System.out.print("Digite a capacidade de turmas que a escola pode ter: ");
       int capacidadeTurmas = 10;//leitor.nextInt();
     //  leitor.nextLine();
       
       Escola escola = new Escola(capacidadeAlunos, capacidadeProfessores, capacidadeSalas,capacidadeTurmas);
       
       int opcao;
	
       do {
    	   menuDaEscola();
    	   opcao = leitor.nextInt();
    	   leitor.nextLine();
    	   
    	   switch(opcao) {
    	   case 1:
    		   System.out.print("Digite o nome do aluno: ");
    		   String nomeAluno = leitor.nextLine();
    		   System.out.print("Digite a matricula do aluno: ");
    		   String matriculaAluno = leitor.nextLine();
    		   System.out.print("Digite o email academico do aluno: ");
    		   String emailAcademicoDoAluno = leitor.nextLine();
    		   escola.cadastrarAluno(nomeAluno, matriculaAluno, emailAcademicoDoAluno);
    		   break;
    	   case 2:
    		   System.out.print("Digite o nome do professor: ");
    		   String nomeProfessor = leitor.nextLine();
    		   System.out.print("Digite a matricula do professor: ");
    		   String matriculaProfessor = leitor.nextLine();
    		   System.out.print("Digite a disciplina do professor: ");
    		   String disciplinaDoProfessor = leitor.nextLine();
    		   System.out.print("Digite o codigo da disciplina: ");
    		   String codigoDaDisciplina = leitor.nextLine();
    		   System.out.print("Digite a carga horaria da disciplins: ");
    		   int cargaHoraria  = leitor.nextInt();
    		   leitor.nextLine();
    		   Disciplina disciplina = new Disciplina(disciplinaDoProfessor, codigoDaDisciplina, cargaHoraria);
    		   escola.cadastrarProfessor(nomeProfessor, matriculaProfessor, disciplina);
    		   break;
    	   case 3:
    		   System.out.println("Digite o numero da sala ");
    		   int numeroDaSala = leitor.nextInt();
    		   System.out.println("Digite a capacidaded de alunos que a sala pode receber: ");
    		   int capacidadeDeAlunosNaSala = leitor.nextInt();
    		   leitor.nextLine();
    		   escola.cadastrarSala(numeroDaSala, capacidadeDeAlunosNaSala);
    		   break;
    	   case 4:
    		   System.out.println(" Digite o codigo da turma: ");
    		   String codigoTurma = leitor.nextLine();
    		   
    		   System.out.println(" Matricula do professor responsavel:   ");
    		   Professor prof = escola.procurarProfessorPorMatricula(leitor.nextLine());
    		   if (prof == null) {
    			   System.out.println(" professor não encontrado ");
    			   break;
    		   }
    		   
    		   System.out.print("Número da sala: ");
               int numSala = leitor.nextInt();
               Sala sala = escola.procurarSalaPorNumero(numSala);
               if (sala == null) {
                   System.out.println("Sala não encontrada.");
                   break;
               }
               
               System.out.print("Capacidade máxima de alunos: ");
               int capacidadeTurma = leitor.nextInt();
               leitor.nextLine();
               boolean criou = escola.cadastrarTurma(codigoTurma, prof, sala, capacidadeTurma);
               if(criou) {
            	   System.out.println("turma criada com sucesso!");
               }else {
            	   System.out.println("Limite de turmas atingido.");
               }
               break;
    	   case 5:
    		   System.out.print("Matrícula do aluno a remover do sistema: ");
               String matriculaAlunoRemover = leitor.nextLine();
               boolean removidoAluno = escola.removerAlunoDoSistema(matriculaAlunoRemover);
               if (removidoAluno) {
            	   System.out.println("removido com sucesso! ");
               }else {
            	   System.out.println("aluno não encontrado: ");
               }
               break;
    	   case 6:
    		   System.out.print("Matrícula do professor a remover do sistema: ");
               String matriculaProfessorRemover = leitor.nextLine();
               boolean removidoProfessor = escola.removerProfessorDoSistema(matriculaProfessorRemover);
               if (removidoProfessor) {
            	   System.out.println("Professor removido com sucesso! ");
               }
               break;
    	   case 7: 
    		   System.out.print("Matrícula do professor para procura no sistema: ");
               String matriculaAlunoProcurar = leitor.nextLine();
               Aluno procurarAluno = escola.procurarAlunoPorMatricula(matriculaAlunoProcurar);
               if (procurarAluno == null) {
            	   System.out.println("aluno não encontrado ");
               }else {
            	   System.out.println(procurarAluno);
               }
               break;
    		   
    	   case 8:
    		   System.out.print("Matrícula do professor para procura no sistema: ");
               String matriculaProfessorProcurar = leitor.nextLine();
               Professor procurarProfessor = escola.procurarProfessorPorMatricula(matriculaProfessorProcurar);
               if (procurarProfessor==null) {
            	   System.out.println("Professor não encontrado  ");
               }else {
            	   System.out.println(procurarProfessor);
               }
               break;
    	   case 9:
    		   escola.listarTurmas();
               if (escola.totalTurmas == 0) {
            	   break;
            	   }

               System.out.print("Digite o código da turma que deseja gerenciar: ");
               String codTurma = leitor.nextLine();
               Turma turma = escola.procurarTurmaPorCodigo(codTurma);
               if (turma == null) {
                   System.out.println("Turma não encontrada.");
                   break;
               }

               int opTurma;
               do {
                   menuDaTurma();
                   opTurma = leitor.nextInt();
                   leitor.nextLine();

                   switch (opTurma) {
	                       case 1: 
	                    	   turma.listarTurma();
	                    	   break;
	
	                       
	
	                       case 2:
	                           System.out.print("Matrícula do aluno a remover da turma: ");
	                           String matrAluno = leitor.nextLine();
	                           boolean removido = turma.removerAlunoDaTurmaPorMatricula(matrAluno);
	                           if (removido) {
	                               System.out.println("Aluno removido da turma.");
	                           } else {
	                               System.out.println("Aluno não encontrado nesta turma.");
	                           }
	                           break;
	                       case 3:
	                           System.out.print("Matrícula do aluno a adicionar: ");
	                           String matrAlunoAdd = leitor.nextLine();
	                           Aluno aluno = escola.procurarAlunoPorMatricula(matrAlunoAdd);
	                           if (aluno == null) {
	                               System.out.println("Aluno não encontrado no sistema.");
	                           } else {
	                               boolean adicionou = turma.adicionarAlunoNaTurma(aluno);
	                               if (adicionou) {
	                                   System.out.println("Aluno adicionado à turma.");
	                               } else {
	                                   System.out.println("Turma lotada ou aluno já está na turma.");
	                               }
	                           }
	                           break;
	
	                       case 4:
	                    	   System.out.println("Voltando ao menu principal.");
	                    	   break;
	
	                       default:
	                    	   System.out.println("Opção inválida.");
	                    	   break;
	                   }
	               } while (opTurma != 4);
    	   case 10:
    		   escola.listarTurmas();
    		   escola.listarSalas();
    		   escola.listarProfessores();
    		   escola.listarAlunos();
    		   break;
    	   case 0:
    		   System.out.println("saindo....");
    		   break;
               
            default:
            	System.out.println("Opção inválida.");
            	break;
    		   
    	   }
    	   
    	   
       }while(opcao != 0);
	}
}