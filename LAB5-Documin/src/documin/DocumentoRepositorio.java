package documin;

import java.util.HashMap;

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
			}
		}
		
		 
}
