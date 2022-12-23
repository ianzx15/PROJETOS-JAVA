package documin;

import java.util.HashMap;

public abstract class ElementosAbstract  {
	/**
	 * Valor que varia entre 1 e 5 indicando maior e menor prioriodade
	 */
	private int prioridade;
	private String valor;
	private HashMap<String, String> propriedades;
	
	public ElementosAbstract(String valor, int prioridade) {
		this.propriedades = new HashMap<>();
		this.valor = valor;
		this.prioridade = prioridade;
	}
	
	public abstract String pegarRepresentacaoCompleta();
	public abstract String pegarRepresentacaoResumida();

	public int getPrioridade() {
		return this.prioridade;
	}
	
	public String getValor() {
		return this.valor;
	}
	


}
