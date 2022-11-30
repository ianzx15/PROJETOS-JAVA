package documin;

import java.util.Objects;

public class Documento {
	private String titulo;
	private int tamanho;
	
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
	
	@Override
	public String toString() {
		return "\nTítulo: " + titulo + "\nTamanho: " + tamanho + "\n";
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
