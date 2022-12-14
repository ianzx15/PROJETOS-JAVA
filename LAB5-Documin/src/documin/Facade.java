package documin;

	import documin.documento.DocumentoController
	
public class Facade {
	
	private DocumentoController documentoController;
		
	public Facade() {
		this.documentoController = new DocumentoController();
	}
	
	public boolean criarDocumento(String titulo) {
		this.documentoController.criarDocumento(titulo);
	}
	
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		this.documentoController.criarTexto(tituloDoc, valor, prioridade);
	}
	
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		this.documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
	}
	
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		this.documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
	}
	
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		this.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
	}
	
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
	
	}
	
	public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
	}
	
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
	}
	
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
	}
	
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
	}

	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
	}
	
	public int criarVisaoCompleta(String tituloDoc) {
	}
	
	public int criarVisaoResumida(String tituloDoc) {
	}
	
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
	}
	
	public int criarVisaoTitulo(String tituloDoc) {
	}
	
	public String[] exibirVisao(int visaoId) {
	}
	
}
