package documin;


public class DocumentoController {
	
	private DocumentoRepositorio doc = new DocumentoRepositorio();
	
	public boolean criarDocumento(String titulo) {
		return doc.criarDocumento(titulo);
	}
	
	public boolean criarDocumento(String titulo, int tamanho) {
		return doc.criarDocumento(titulo, tamanho);
	}
	
	public void removeDocumento(String titulo) {
		doc.removerDocumento(titulo);
	}
	
	public int numElementos(String titulo) {
		return doc.contarElementos(titulo);
	}
	
	public int criarTexto(String tituloDocumento, String valor, int prioridade) {
		return doc.criarTexto(tituloDocumento, valor, prioridade);
	}
	
	public int criarTitulo(String tituloDocumento, String valor, int prioridade) {
		return doc.criarTexto(tituloDocumento, valor, prioridade);
	}
	
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		return doc.moverParaAcima(tituloDoc, elementoPosicao);
	}
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		return doc.moverParaBaixo(tituloDoc, elementoPosicao);
	}

	
	
}
