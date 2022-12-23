package documin;

	
public class Facade {
	
	private DocumentoController documento;
	private ElementoController elemento;
		
	public Facade() {
		this.documento= new DocumentoController();
		this.elemento = new ElementoController();
	}
	
	public boolean criarDocumento(String titulo, int tamanho) {
		return this.documento.criarDocumento(titulo);
	}
	
	
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		return this.documento.adicionarElemento(tituloDoc, this.elemento.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel));
	}
	
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		return this.documento.adicionarElemento(tituloDoc, this.elemento.criarTexto(valor, prioridade));
	}
	
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		return this.documento.adicionarElemento(tituloDoc, this.elemento.criarLista(tituloDoc, valorLista, prioridade, separador, charLista));
	}
	
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		return this.documento.adicionarElemento(tituloDoc, this.elemento.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem));
	}
	
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		return this.documento.adicionarElemento(tituloDoc, this.elemento.criarAtalho(this.documento.getDocumento(tituloDocReferenciado)));
	}
	
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		return this.documento.getElemento(tituloDoc, elementoPosicao).pegarRepresentacaoCompleta();
	}
	
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		return this.documento.getElemento(tituloDoc, elementoPosicao).pegarRepresentacaoResumida();
	}
	
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		return this.documento.getDocumento(tituloDoc).apagarElemento(this.documento.getDocumento(tituloDoc).getElemento(elementoPosicao));
	}
	
	
	//TESTAR QUANDO O ELEMENTO É EMPURRADO PARA UMA POSICAO INEXISTENTE 
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		this.documento.getDocumento(tituloDoc).moverParaCima(elementoPosicao);
	}
	
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		this.documento.getDocumento(tituloDoc).moverParaBaixo(elementoPosicao);
	}
	
//	
//	public int criarVisaoCompleta(String tituloDoc) {
//	}
//	
//	public int criarVisaoResumida(String tituloDoc) {
//	}
//	
//	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
//	}
//	
//	public int criarVisaoTitulo(String tituloDoc) {
//	}
//	
//	public String[] exibirVisao(int visaoId) {
//	}
//	
}
