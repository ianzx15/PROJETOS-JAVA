package documin;

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
			if (this.documentos.containsKey(titulo)) {
				this.documentos.remove(titulo);
			} else {
				throw new NoSuchElementException();
			}
			
		}
		
		public int contarElementos(String titulo){
			if (!this.documentos.containsKey(titulo)) {
				throw new NoSuchElementException();
			}
			return this.documentos.get(titulo).getTamanho();
		}
		
		public Documento getDocumento(String tituloDoc){
			return this.documentos.get(tituloDoc);
		}
		
		public String[] exibirDocumento(String titulo) {
			Documento obj = this.documentos.get(titulo);
			String[] lista = new String[3];
			lista[0] = obj.getTitulo();
			lista[1] = Integer.toString(obj.getTamanho());
			return lista;
		}
		
		public int criarTexto(String tituloDoc, String valor, int prioridade) {
			return this.documentos.get(tituloDoc).criarTexto(valor, prioridade);
		}


		public void moverParaAcima(String tituloDoc, int elementoPosicao) {
			this.documentos.get(tituloDoc).moverParaAcima(elementoPosicao);
		}
		
}
