package principal;

import java.util.Objects;

public class Acao {
	private String data;
	private int progresso;
	private int codigo;
	private int idDesafio;
	private String tituloDesafio;
	
	public Acao(int idDesafio, String data, int codigo, String tituloDesafio) {
		this.codigo = codigo;
		this.data = data;
		this.idDesafio = idDesafio;
		this.tituloDesafio = tituloDesafio;
	}
	
	public int getProgresso() {
		return this.progresso;
	}
	
	public int getId() {
		return this.idDesafio;
	}
	
	public String getTitulo() {
		return this.tituloDesafio;
	}
	public boolean progressoAcao() {
		if(this.progresso <= 100) {
		this.progresso += 10;
	} if(this.progresso > 100) {
		this.progresso = 0;
		return true;
	} return false;
	}
	
	
	public boolean progressoAcao(int valor) {
		if(this.progresso <= 100) {
			this.progresso += valor;
		} if(this.progresso > 100) {
			this.progresso = 0;
			return true;
		} return false;
	}

	public int getCodigo() {
		return this.codigo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acao other = (Acao) obj;
		return codigo == other.codigo;
	}
	
	
	@Override
	public String toString() {
		return "Acao " + this.codigo + " - " + this.data + " - " + this.tituloDesafio + " - " + this.progresso;
	}

	public String getData() {
		return this.data;
	}
	
	
}
