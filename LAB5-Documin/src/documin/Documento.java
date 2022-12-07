package documin;

import java.util.ArrayList;
import java.util.Objects;

public class Documento {
	private String titulo;
	private int tamanho;
	private ArrayList<Elementos> elementos;
	
	public Documento(String titulo, int tamanho) {
		this.titulo = titulo;
		this.tamanho = tamanho;
		Validador.isTamanhoValido(tamanho, 1);
		Validador.isTituloValido(titulo);
	}
	
	public Documento (String titulo) {
		this.titulo = titulo;
		Validador.isTituloValido(titulo);
	}

	public String getTitulo() {
		return this.titulo;
	}
	
	public int getTamanho() {
		if(this.elementos == null) {
			return 0;
		}
		return this.elementos.size();
	}
	
	public ArrayList<Elementos> getElementos() {
		return this.elementos;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(titulo, other.titulo);
	}

	
}
