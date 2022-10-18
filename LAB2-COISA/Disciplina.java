package lab2;

public class Disciplina {
//a
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
		return nomeDisciplina + " " + horasEstudo + " " + media + " [" + notas[0] + ", " + notas[1] + ", " + notas[2] + ", " + notas[3] + "]";
	}
}
