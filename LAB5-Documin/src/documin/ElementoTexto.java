package documin;
	
/**
 * Constrói um elemento do tipo texto a partir da herança
 * com a classe abstrata.
 * @author Ian Evangelista Rodrigues
 *
 */

public class ElementoTexto extends ElementosAbstract{

	/**
	 * Constrói um texto a partir de um valor e prioridade.
	 * @param valor A string que representa o conteúdo do texto.
	 * @param prioridade A prioridade do texto.
	 */
	public ElementoTexto(String valor, int prioridade) {
		super(valor, prioridade);
		
	}
	
	/**
	 * Gera uma representação completa em string do texto.
	 * @return A string representando o texto.
	 */
	public String pegarRepresentacaoCompleta() {
		return super.getValor() + "\n";
	}
	
	/**
	 * Gera uma representação resumida em string do texto.
	 * @return A string representando o texto.
	 */
	public String pegarRepresentacaoResumida() {
		return super.getValor() + "\n";
	}
	
}
