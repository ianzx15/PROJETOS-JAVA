package documin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoRepositorio {
	private HashMap<String, Documento> documentos;
	
		public DocumentoRepositorio() {
			this.documentos = new HashMap<String, Documento>();
		}
		public boolean criarDocumento(String titulo) {
			if (this.documentos.containsKey(titulo)) {
				return false;
			}
			Documento doc = new Documento(titulo);
			this.documentos.put(titulo, doc);
			return true;
		}
		
		public boolean criarDocumento(String titulo, int tamanhoMaximo){ 
			if (this.documentos.containsKey(titulo)) {
				return false;
			}
			Documento doc = new Documento(titulo, tamanhoMaximo);
			this.documentos.put(titulo, doc);
			return true;
		}
		
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
