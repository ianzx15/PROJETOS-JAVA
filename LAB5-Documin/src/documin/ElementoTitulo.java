package documin;

/**
 * Constrói um elemento do tipo título a partir da herança
 * com a classe abstrata.
 * @author Ian Evangelista Rodrigues
 *
 */
public class ElementoTitulo extends ElementosAbstract{
	/**
	 * Um inteiro representando o nível do título.
	 */
	private int nivel;
	
	/**
	 * Um boolean indicando se o título é linkavel.
	 */
	private boolean linkavel;
	
	/**
	 * Constrói um título a partir de um valor, prioridade, nível e se é linkavel.
	 * @param valor A string que representa o conteúdo da lista.
	 * @param prioridade A prioridade da lista.
	 * @param nível O nível do título.
	 * @param linkavel Indica se permite ou não a criação de um link.
	 */
	public ElementoTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		this.linkavel = linkavel;
		this.nivel = nivel;
	}
	
	public int getNivel() {
		return nivel;
	}

	/**
	 * Gera uma representação completa em string de um tiulo.
	 * @return A string representando o título.
	 */
	public String pegarRepresentacaoCompleta() {
		String string = new String();
		if (this.linkavel == false) {
			return string += this.nivel + ". " + super.getValor();
		}
		return string += this.nivel + ". " + super.getValor() + "--\n" 
				+ this.nivel + "-" + super.getValor().toUpperCase().replace(" ", "") + "\n";
	}
	/**
	 * Gera uma representação resumida em string de um tiulo.
	 * @return A string representando o título.
	 */
	public String pegarRepresentacaoResumida() {
		String string = new String();
			return string += this.nivel + ". " + super.getValor() + "\n";
	}
}
