package lab2;

import java.util.Arrays;

/**
 * Cria uma disciplina e gerencia a nota e as horas de estudos dedicadas.
 * @author Ian Evangelista Rodrigues
 *
 */
public class Disciplina {
	
	/**
	 * Nome da disciplina. Inicia com valor null.
	 */
	private String nomeDisciplina;
	
	/**
	 * Horas de estduo. Inicia com valor 0.
	 */
	private int horasEstudo;
	
	/**
	 * Array com cada nota da disciplina.
	 */
	private double[] notas = new double[4];
	
	/**
	 * Constrói uma disciplina utilizando atribuindo um nome.
	 * @param nomeDisciplina o nome da disciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Atribui um valor inteiro à variável notas.
	 * @param horas horas estudadas para uma disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}
	
	/**
	 * Atribui o valor de uma nota por meio de um indice.
	 * @param nota indica a nota ou posição do array que receberá o valor.
	 * @param valorNota o valor a ser recebido pela nota.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Retorna a média das notas da disciplina.
	 * @return a média total da disciplina.
	 */
	private double calculaMedia () {
		double total = 0;
		for (int i = 0; i < 4; i++) {
			total += this.notas[i];
		}
		return total / 4;
	}
	
	/**
	 * Retorna se o aluno foi aprovado ou não a partir da sua média.
	 * @return true ou false dependendo do resultado da média.
	 */
	public boolean aprovado() {
		if (calculaMedia() >= 7.0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna uma string formatada com os valores de média, nome da disciplina, horas de estudo
	 * e cada nota da disciplina
	 * @return uma string com os principais valores formatados.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
	}
	
}