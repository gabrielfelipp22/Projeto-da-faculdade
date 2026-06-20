package novoProjetoJava;

public class Sala {
	int  numero;
	int capacidade;
	
	Sala(int numero, int capacidade){
		this.numero = numero;
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return "Sala [numero =" + numero + ", capacidade =" + capacidade + "]";
	}	
}
