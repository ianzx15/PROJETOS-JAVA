package documin;

/**
 * Organização de um atalho de um documento.
 * @author Ian Evangelista Rodrigues
 */

public class Atalho extends ElementosAbstract{
	
	/**
	 * Objeto do tipo Documento
	 */
	private Documento doc;
	
	/**
	 * Constrói um objeto do tipo Atalho a partir de um
	 * objeto do tipo Documento, cujos atributos são o nome
	 * do documento e a média das prioridades dos elementos
	 * contidos nesse documento.
	 * @param doc O Objeto do tipo Documento.
	 */
	public Atalho(Documento doc) {
		super(doc.getTitulo(), doc.getMediaElementos());
		this.doc = doc;
	}
	/**
	 * Retorna a representação completa de todos os elementos
	 * de prioridade 4 e 5.
	 * @return String formatada das representações.
	 */
	@Override
	public String pegarRepresentacaoCompleta() {
		String string = "";
		for(ElementosAbstract el : doc.getElementos()) {
			if (el.getPrioridade() == 4 || el.getPrioridade() == 5) {
				string += el.pegarRepresentacaoCompleta();
			}
		}
		return string;
	}
	
	/**
	 * Retorna a representação resumida de todos os elementos
	 * de prioridade 4 e 5.
	 * @return String formatada das representações.
	 */
	@Override
	public String pegarRepresentacaoResumida() {
		String string = "";
		for(ElementosAbstract el : doc.getElementos()) {
			if (el.getPrioridade() == 4 || el.getPrioridade() == 5) {
				string += el.pegarRepresentacaoResumida();
			}
		}
		return string;
	}
}
