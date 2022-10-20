package lab2;

import java.util.Arrays;

public class Disciplina {
	private String nomeDisciplina;
	private int horasEstudo;
	private double[] notas = new double[4];
	private double media;
	
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public void cadastraHoras(int horas) {
		horasEstudo += horas;
	}
	
	public void cadastraNota(int nota, double valorNota) {
		notas[nota - 1] = valorNota;
	}
	
	public boolean aprovado() {
		double total = 0;
		for (int i = 0; i < 4; i++) {
			total += notas[i];
		}
		media = total / 4;
		if (media >= 7.0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return nomeDisciplina + " " + horasEstudo + " " + media + " " +Arrays.toString(notas);
<<<<<<< HEAD
=======
	}
	public static void main(String[] args) {
		Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
		prog2.cadastraHoras(4);
	      prog2.cadastraNota(1, 5.0);
	      prog2.cadastraNota(2, 6.0);
	      prog2.cadastraNota(3, 7.0);
	      System.out.println(prog2.aprovado());
	      prog2.cadastraNota(4, 10.0);
	      System.out.println(prog2.aprovado());
	      System.out.println(prog2.toString());
>>>>>>> 594d54d90a957ad12bbed10f44225275ea474b34
	}
	
}