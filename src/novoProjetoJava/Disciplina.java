package novoProjetoJava;

public class Disciplina {
	private String nomeDaDisciplina;
	private String codigo;
	private int cargaHoraria;
	
	Disciplina(String nomeDaDisciplina, String codigo, int cargaHoraria){
		this.nomeDaDisciplina = nomeDaDisciplina;
		this.codigo = codigo; 
		this.cargaHoraria = cargaHoraria;
	}
	
	public String  getNomeDaDisciplina() {
		return this.nomeDaDisciplina;
	}
	public String getCodigoDaDisciplina() {
		return this.codigo;
	}
	public int getCargaHorariaDaDisciplina(){
		return this.cargaHoraria;
	}

	@Override
	public String toString() {
		return " Dados da disciplina [nome da disciplina =" + nomeDaDisciplina + ", codigo =" + codigo + ", carga horaria ="
				+ cargaHoraria + "]";
	}	
}
