package documin;

public class ElementoController {
	ElementosRepositorio rep = new ElementosRepositorio();
	
	public void criarTexto(String tituloDoc, String valor, int prioridade ) {
		rep.criarTexto(tituloDoc, valor, prioridade);
	}
}
