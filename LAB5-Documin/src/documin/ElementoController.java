package documin;

public class ElementoController {
	
	public ElementoTexto criarTexto(String valor, int prioridade) {
		ElementoTexto texto = new ElementoTexto(valor, prioridade);
		return texto;
	}
	
	public ElementoTitulo criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		ElementoTitulo titulo = new ElementoTitulo(valor, prioridade, nivel, linkavel);
		return titulo;
	}
	
	public ElementoLista criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		ElementoLista lista = new ElementoLista(valorLista, prioridade, separador, charLista);
		return lista;
	}
	
	public ElementoTermos criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		ElementoTermos termos = new ElementoTermos(valorTermos, prioridade, separador, ordem);
		return termos;
	}
	
}
