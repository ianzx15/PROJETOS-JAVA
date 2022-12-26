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
	
	public int contarElementos(String titulo) {
		return doc.contarElementos(titulo);
	}
	
	public int adicionarElemento(String titulo, ElementosAbstract elemento) {
		return doc.adicionarElemento(titulo, elemento);
	}
	
	public Documento getDocumento(String tituloDoc) {
		return doc.getDocumento(tituloDoc);
	}
	
	public ElementosAbstract getElemento(String tituloDoc, int indice) {
		return doc.getElemento(tituloDoc, indice);
	}

	public String[] exibirDocumento(String titulo) {
		return doc.exibirDocumento(titulo);
		
	}

}
