package documin;

/**
 * Cria todos os tipos de elementos disponíveis.
 * @author Ian Evangelista Rodrigues.
 *
 */

public class ElementosRepositório {
	
	/**
	 * Constrói um texto a partir de um valor e prioridade.
	 * @param valor A string que representa o conteúdo do texto.
	 * @param prioridade A prioridade do texto.
	 * @return O elemento do tipo texto.
	 */
	public ElementoTexto criarTexto(String valor, int prioridade) {
		ElementoTexto texto = new ElementoTexto(valor, prioridade);
		return texto;
	}
	
	/**
	 * Constrói um título a partir de um valor, prioridade, nível e se é linkavel.
	 * @param valor A string que representa o conteúdo da lista.
	 * @param prioridade A prioridade da lista.
	 * @param nível O nível do título.
	 * @param linkavel Indica se permite ou não a criação de um link.
	 * @return O elemento do tipo título.
	 */
	public ElementoTitulo criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		ElementoTitulo titulo = new ElementoTitulo(valor, prioridade, nivel, linkavel);
		return titulo;
	}
	
	/**
	 * Constrói uma lista a partir de um valor, prioridade, separador, e um carácter da lista.
	 * @param valor A string que representa o conteúdo da lista.
	 * @param prioridade A prioridade da lista.
	 * @param separador O separador dos termos da lista.
	 * @param charLista O iniciador das linhas da lista.
	 * @return O elemento do tipo lista.
	 */
	public ElementoLista criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		ElementoLista lista = new ElementoLista(valorLista, prioridade, separador, charLista);
		return lista;
	}
	
	/**
	 * Constrói uma lista a partir de um valor, prioridade, separador, e ordem dos termos.
	 * @param valor A string que representa os termos.
	 * @param prioridade A prioridade dos termos.
	 * @param separador O separador dos termos.
	 * @param ordem A ordem em que os termos estão organizados.
	 * @return O elemento do tipo termos.
	 */
	public ElementoTermos criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		ElementoTermos termos = new ElementoTermos(valorTermos, prioridade, separador, ordem);
		return termos;
	}

	/**
	 * Constrói um objeto do tipo Atalho a partir de um
	 * objeto do tipo Documento, cujos atributos são o nome
	 * do documento e a média das prioridades dos elementos
	 * contidos nesse documento.
	 * @param doc O Objeto do tipo Documento.
	 * @return O elemento do tipo atalho.
	 */
	public ElementosAbstract criarAtalho(Documento tituloDocReferenciado) {
		for (ElementosAbstract el : tituloDocReferenciado.getElementos()) {
			if (el.getClass().equals(Atalho.class)){
				throw new IllegalStateException();
			}
		}
		tituloDocReferenciado.setIsAtalho(true);
		Atalho atalho = new Atalho(tituloDocReferenciado);
		return atalho;
	}

}
