package documin;

public class Validador {

	private static  void isValido(String valor, String msg) {
		if (valor.isBlank()) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	 private static void isNull(String valor, String msg) {
		 if (valor == null) {
			 throw new NullPointerException(msg);
		 }
	 }
	
	private static void isRangeValido(int valor, int limite, String msg) {
		if (limite > valor) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void isTamanhoValido(int tamanho, int limite) {
		isRangeValido(tamanho, limite, "Tamanho inválido");
	}
	
	public static void isTituloValido(String titulo) {
		isValido(titulo, "Título inválido");
	}
}
