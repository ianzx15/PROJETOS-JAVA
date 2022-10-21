package lab2;

/**
 * Organização da rotina de um aluno específico. Por meio dessa classe é
 * possível dizer se o aluno está descansado ou não. 
 * 
 * @author Ian Evangelista Rodrigues
 *
 */
public class Descanso {
	
	/**
	 * Horas de descanso no total. Inicia com o valor 0.
	 */
	private int horasDescanso;
	
	/**
	 * Semanas no total. Inicai com o valor 0.
	 */
	private int numSemanas;
	
	/**
	 * Número resultante da divisão de horas de descanso
	 * pelo número de semanas, quando o número de semanas não for zero.
	 */
	private double descansoPorSemana;
	
	/**
	 * Atribui o número de horas de descanso definido pelo usuário
	 * ao atributo horasDescanso.
	 * @param horasDescanso horas de descanso definidas pelo usuário.
	 */
	public void defineHorasDescanso(int horasDescanso) {
		this.horasDescanso = horasDescanso;
	}
	
	/**
	 * Atribui o número de semanas definidas pelo usuário
	 * ao atribudo numSemanas.
	 * @param numSemanas número de semanas definidas pelo usuário.
	 */
	public void defineNumeroSemanas(int numSemanas) {
		this.numSemanas = numSemanas;
	}
	
	/**
	 * Retorna a String que representa a condição do aluno. Podendo assumir
	 * o valor "cansado" ou "descansado".
	 * 
	 * @return o status do aluno naquele instante.
	 */
	public String getStatusGeral() {
		if (this.numSemanas != 0) {
			this.descansoPorSemana = this.horasDescanso / this.numSemanas;
		} else {
			return "cansado";
		}
		
		if (this.descansoPorSemana >= 26) {
			return "descansado";
		}
		return "cansado";
	}
	
}