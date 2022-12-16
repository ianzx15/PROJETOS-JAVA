package principal;

import java.util.Objects;

public class Desafio {
	private String titulo;
	private int execucoes;
	
	
	public Desafio(String titulo) {
		this.titulo = titulo;
	}
	
	public void maisExecucao() {
		this.execucoes += 1;
	}
	
	public int getExecucoes() {
		return this.execucoes;
	}
	
	
	public String getTitulo() {
		return this.titulo;
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
		Desafio other = (Desafio) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	@Override
	public String toString() {
		return "Título: " + titulo + "\n" + execucoes + " execuções";
	}
	
}
