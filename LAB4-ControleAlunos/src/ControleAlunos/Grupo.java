package ControleAlunos;

/**
 * Controla a criação de grupos. Por meio dessa classe é possível
 * criar grupos com tema, tamanho e hashset de objetos 
 * do tipo Aluno.
 * @author Ian Evangelista Rodrigues
 */

import java.util.HashSet;
import java.util.Objects;

public class Grupo {
	private String tema;
	private HashSet <Aluno> alunosNoGrupo;
	private String tamanho;
	
	public Grupo (String tema, String tamanho) {
		this.tema = tema;
		this.alunosNoGrupo = new HashSet<Aluno>();	
		this.tamanho = tamanho;
		Validador.isArgumentoValido(tema);
	}
	
	
	public Grupo (String tema) {
		this.tema = tema;
		this.alunosNoGrupo = new HashSet<Aluno>();
		Validador.isArgumentoValido(tema);
	}
	@Override
	public String toString() {
			if (this.getTamanho() == 0) {
				return "- " + this.getTema() + " " + this.getaAlunos().size()
						+ "/...\n";
			}
			return "- " + this.getTema() + " " + this.getaAlunos().size()
					+ "/" + this.getTamanho() +  "\n";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tema);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(tema, other.tema);
	}

	
	public HashSet<Aluno> getaAlunos() {
		return this.alunosNoGrupo;
	}
	
	public int getTamanho() {
		if(this.tamanho != null) {
		return Integer.parseInt(this.tamanho);
		}
		return 0;
	}
	
	public String getTema() {
		return this.tema;
	}
	
	public void adicionaAoGrupo(Aluno aluno) {
		this.alunosNoGrupo.add(aluno);
	}
	
	
}
