package novoProjetoJava;

public class Disciplina {
	String nomeDaDisciplina;
	String codigo;
	int cargaHoraria;
	
	Disciplina(String nomeDaDisciplina, String codigo, int cargaHoraria){
		this.nomeDaDisciplina = nomeDaDisciplina;
		this.codigo = codigo; 
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return " Dados da disciplina [nome da disciplina =" + nomeDaDisciplina + ", codigo =" + codigo + ", carga horaria ="
				+ cargaHoraria + "]";
	}	
}
