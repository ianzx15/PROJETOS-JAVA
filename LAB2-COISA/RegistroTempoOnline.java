package lab2;

public class RegistroTempoOnline {
	private String nomeDisciplina;
	private int tempoOnlineEsperado = 120;
	private int tempoGasto;
	private boolean resultado;
	
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	public void adicionaTempoOnline(int tempo) {
		tempoGasto += tempo;
	}
	
	public  boolean atingiuMetaTempoOnline() {
		
		if (tempoGasto >= tempoOnlineEsperado) {
			resultado = true;
		}
		return resultado;
	}
	
	public  String toString() {
		return nomeDisciplina + " " + tempoGasto + "/" + tempoOnlineEsperado ;
	}
}
