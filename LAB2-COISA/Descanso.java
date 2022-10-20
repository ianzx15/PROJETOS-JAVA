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
	 * Horas de descanso no total.
	 */
	private int horasDescanso;
	/**
	 * Semanas no total.
	 */
	private int numSemanas;
	/**
	 * Número resultante da divisão de horas de descanso
	 * pelo número de semanas, quando o número de semanas não for zero.
	 */
	private double descansoPorSemana;
<<<<<<< HEAD
=======
	//Status relacionado à condição do aluno.
>>>>>>> 594d54d90a957ad12bbed10f44225275ea474b34
	private String status = "cansado";
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
	 * @return a representação em String do valor atribuido ao atributo status.
	 */
	public String getStatusGeral() {
		if (numSemanas != 0) {
			descansoPorSemana = horasDescanso / numSemanas;
		}
		
		if (descansoPorSemana >= 26) {
			status = "descansado";
		}
		else {
			status = "cansado";
		}
		
		return status;
	}
	
}