package ControleAlunos;

public class Validador {
	private static void isValido(String valor, String msg) {
		if (valor == null) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void matriculaInvalida(String valor) {
		isValido(valor, "MATRÍCULA INVÁLIDA");
	}
}
