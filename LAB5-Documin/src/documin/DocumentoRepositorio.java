package documin;

/**
 * Organiza, trata e armazena os objetos do tipo documento.
 * @author Ian Evangelista Rodrigues
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoRepositorio {
	
	/**
	 * Armazena os documentos do sistema em uma estrutura
	 * chave/valor.
	 */
	private HashMap<String, Documento> documentos;
	
	
	/**
	 * Inicia o hashMap para armazenar documentos.
	 */
	public DocumentoRepositorio() {
		this.documentos = new HashMap<String, Documento>();
	}
	
	/**
	 * Constrói um documento a partir do título.
	 * @param titulo O título do documento.
	 * @return True ou false.
	 */
	public boolean criarDocumento(String titulo) {
		if (this.documentos.containsKey(titulo)) {
			return false;
		}
		Documento doc = new Documento(titulo);
		this.documentos.put(titulo, doc);
		return true;
	}
	
	/**
	 * Constrói um documento a partir do título e de um tamanho específico..
	 * @param titulo O título do documento.
	 * @param tamanhoMaximo O tamanho máximo de elementos suportados nesse documento.
	 * @return True ou false.
	 */
	public boolean criarDocumento(String titulo, int tamanhoMaximo){ 
		if (this.documentos.containsKey(titulo)) {
			return false;
		}
		Documento doc = new Documento(titulo, tamanhoMaximo);
		this.documentos.put(titulo, doc);
		return true;
	}
	
	/**
	 * Remove o objeto do tipo Documento do sistema.
	 * @param titulo O título indicando qual documento deve ser removido.
	 */
	public void removerDocumento(String titulo) {
		Validador.isTituloNull(titulo);
		Validador.isTituloValido(titulo);
		if (this.documentos.containsKey(titulo)) {
			this.documentos.remove(titulo);
		} else {
			throw new NoSuchElementException();
		}
		
	}
	
	public ElementosAbstract getElemento(String tituloDoc, int indice) {
		Validador.isTituloNull(tituloDoc);
		Validador.isTituloValido(tituloDoc);
		return this.documentos.get(tituloDoc).getElemento(indice);
	}
	
	/**
	 * Retorna o número inteiro de elementos dentro da lista de
	 * elementos em um documento.
	 * @param titulo O título do documento
	 * @return Um número inteiro representando o total de elementos
	 * contidos no documento.
	 */
	public int contarElementos(String titulo){
		Validador.isTituloNull(titulo);
		Validador.isTituloValido(titulo);
		if (!this.documentos.containsKey(titulo)) {
			throw new NoSuchElementException();
		}
		return this.documentos.get(titulo).getTamanho();
	}
	
	public Documento getDocumento(String tituloDoc){
		Validador.isTituloNull(tituloDoc);
		Validador.isTituloValido(tituloDoc);
		return this.documentos.get(tituloDoc);
	}
	
	/**
	 * Permite exibir os atributos dos elementos contidos em um documento.
	 * @param titulo O título do documento a ser exibidol.
	 * @return Uma lista de strings representando os elementos do documento.
	 */
	public String[] exibirDocumento(String titulo) {
		Validador.isTituloNull(titulo);
		Validador.isTituloValido(titulo);
		ArrayList<ElementosAbstract> el = this.documentos.get(titulo).getElementos();
		String[] string = new String[el.size()];
		for(int i = 0; i < el.size(); i ++){
			string[i] = el.get(i).pegarRepresentacaoResumida();
		}
		return string;
	}
	
	/**
	 * Adiciona um elemento a um documento.
	 * @param tituloDoc O título do documento.
	 * @param elemento O elemento a ser adicionado ao documento.
	 * @return Um número inteiro representando a posição do elemento na lista.
	 */
	public int adicionarElemento(String tituloDoc, ElementosAbstract elemento) {
		Validador.isTituloNull(tituloDoc);
		Validador.isTituloValido(tituloDoc);
		if (this.documentos.get(tituloDoc).getIsAtalho() == true) {
			throw new IllegalStateException();
		}
		Documento obj = this.documentos.get(tituloDoc);
		return obj.adicionarElemento(elemento);
		
	}


		

}
