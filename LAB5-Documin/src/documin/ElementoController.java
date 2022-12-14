package documin;

public class ElementoController {
	
	public ElementoTexto criarTexto(String valor, int prioridade) {
		ElementoTexto texto = new ElementoTexto(valor, prioridade);
		return texto;
	}
	
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		return doc.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
	}
	
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		return doc.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
	}
	
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		return doc.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
	}
}
