package documin;

public class ElementosRepositorio {
	//ESSE DOC NÃO É O MESMO QUE É CRIADO QUANDO SE CRIA UM DOCUMENTO
	//PORTANTO SEUS VALORES SAO SEMPRE NULOS.........
	DocumentoRepositorio doc = new DocumentoRepositorio();
	
	
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		ElementoTexto texto = new ElementoTexto(prioridade, valor);
		return doc.adicionarElemento(tituloDoc, texto);
	}
	
//	public int criarTitulo(String tituloDoc, String valor, int prioridade, String separador, String charLista ) {
//	}
//	
//	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
//	}
//	
//	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
//	}
//	
//	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
//	}
//	
//	public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
//	}
//	
//	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
//	}
//	
//	public void moverParaCima(String tituloDoc, int elementoPosicao) {
//	}
//	
//	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
//	}
	
}
