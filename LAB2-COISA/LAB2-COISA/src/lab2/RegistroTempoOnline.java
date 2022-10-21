package lab2;

/**
 * Gerencia o tempo online esperado gasto em uma disciplina específica e o tempo online
 * gasto de fato.
 * @author Ian Evangelista Rodrigues
 *
 */
public class RegistroTempoOnline {
	
	/**
	 * Nome da disciplina. Inicia com valor null.
	 */
	private String nomeDisciplina;
	
	
	private int tempoOnlineEsperado = 120;
	private int tempoGasto;
	
	/**
	 * Constrói uma disciplina a partir do nome passado pelo usuário. 
	 * O tempo online esperado inicia com o valor 120.
	 * @param nomeDisciplina nome da disciplina a ser criada.
	 */
	public RegistroTempoOnline (String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Constrói uma disciplina a partir de do nome e do temp online esperado
	 * para essa disciplina.
	 * @param nomeDisciplina nome da disciplina a ser criada.
	 * @param tempoOnlineEsperado valor do tempo online esperado da disciplina.
	 */
	public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Adiciona tempo gasto online à variável tempoGasto.
	 * @param tempo tempo online gasto pelo aluno.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoGasto += tempo;
	}
	
	/**
	 * Retorna se a meta de tempo online foi atingida ou não, comparando
	 * o tempo gasto com o tempo esperado.
	 * @return true ou false.
	 */
	public  boolean atingiuMetaTempoOnline() {
		
		if (this.tempoGasto >= this.tempoOnlineEsperado) {
			return true;
		}
		return false;
	}
	
	/**Retorna o nome da disciplina, tempo online espeado e o tempo online gasto.
	 * @return os valores formatados de nome e tempo gasto e esperado.
	 */
	public  String toString() {
		return this.nomeDisciplina + " " + this.tempoGasto + "/" + this.tempoOnlineEsperado ;
	}
}
