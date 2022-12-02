package documin;


public class ElementoTexto implements Elementos{
	/**
	 * Valor que varia entre 1 e 5 indicando maior e menor prioriodade
	 */
	private int prioridade;
	private String valor;
	public String completa() {
		String format = "";
		format += "Prioridade: " + this.prioridade + "\nValor: " + this.valor;
		return format;
	}
	
	public String resumida() {
		return "";
	}
	
	
}
