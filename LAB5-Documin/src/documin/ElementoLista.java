package documin;

/**
 * Constrói um elemento do tipo lista a partir da herança
 * com a classe abstrata.
 * @author Ian Evangelista Rodrigues
 *
 */

public class ElementoLista extends ElementosAbstract{
	
	/**
	 * Indica a string que separa os termos da lista.
	 */
	private String separador;
	/**
	 * Indica a string que inicia a linha ao exibir a lista.
	 */
	private String charLista;
	
	/**
	 * Constrói uma lista a partir de um valor, prioridade, separador, e um carácter da lista.
	 * @param valor A string que representa o conteúdo da lista.
	 * @param prioridade A prioridade da lista.
	 * @param separador O separador dos termos da lista.
	 * @param charLista O iniciador das linhas da lista.
	 */
	public ElementoLista(String valor, int prioridade, String separador, String charLista) {
		super(valor, prioridade);
		this.separador = separador;
		this.charLista = charLista;
	}
	
	@Override
	public String toString() {
		String string = "";
		for (String item : super.getValor().split(separador)) {
			string += "-" + item + "\n";
		}
		return string;
	}
	
	/**
	 * Gera uma representação completa em string da lista.
	 * @return A string representando a lista.
	 */
	public String pegarRepresentacaoCompleta() {
		String string = "";
		for (String item : super.getValor().split(separador)) {
			string += "-" + item + "\n";
		}
		return string;
	}
	
	/**
	 * Gera uma representação resumida em string da lista.
	 * @return A string representando a lista.
	 */
	public String pegarRepresentacaoResumida() {
		String string = "";
		String[] lista = super.getValor().split(separador);
		int tamanhoLista = super.getValor().split(separador).length -1;
		for (int i = 0; i <= tamanhoLista; i++) {
			string += (i == tamanhoLista) ? lista[i] + "\n" : lista[i] + ", "  ;
		}
		return string;
	}
	
}
