package novoProjetoJava;

public class Sala {
	private int  numero;
	private int capacidade;
	
	Sala(int numero, int capacidade){
		this.numero = numero;
		this.capacidade = capacidade;
	}
	
	public int getNumero() {
		return this.numero;
	}
	public int getCapacidade() {
		return this.capacidade;
		}

	@Override
	public String toString() {
		return "Sala [numero =" + numero + ", capacidade =" + capacidade + "]";
	}	
}
