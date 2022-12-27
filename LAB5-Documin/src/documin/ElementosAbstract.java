package documin;
/**
 * Super classe que permite a criação de Elementos de diversos
 * tipos.
 */


public abstract class ElementosAbstract  {
	/**
	 * Valor que varia entre 1 e 5 indicando maior e menor prioriodade
	 */
	private int prioridade;
	
	/**
	 * O conteúdo do Elemento
	 */
	private String valor;
	
	/**
	 * Constrói um elemento a partir do valor e da prioridade.
	 * @param Valor A String que representa o conteúdo da lista.
	 * @param prioridade A prioridade da lista.
	 */
	public ElementosAbstract(String valor, int prioridade) {
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
