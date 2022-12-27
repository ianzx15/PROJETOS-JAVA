package documin;

public class ElementoController {
	
	private ElementosRepositório el = new ElementosRepositório();
	
	public ElementoTexto criarTexto(String valor, int prioridade) {
		return el.criarTexto(valor, prioridade);
	}
	
	public ElementoTitulo criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		return el.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
	}
	
	public ElementoLista criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		return el.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
	}
	
	public ElementoTermos criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		return el.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
	}

	public ElementosAbstract criarAtalho(Documento tituloDocReferenciado) {
		return el.criarAtalho(tituloDocReferenciado);
	}

	
}
