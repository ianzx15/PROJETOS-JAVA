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

	/**
	 * Hashset de objetos do tipo Aluno que foram adicionados ao grupo.
	 */
	private HashSet <Aluno> alunosNoGrupo;
	private String tamanho;
	
	/**
	 * Constrói um grupo com tema e tamanho específicos.
	 * @param tema O tema do grupo.
	 * @param tamanho O tamanho do grupo.
	 */
	public Grupo (String tema, String tamanho) {
		this.tema = tema;
		this.alunosNoGrupo = new HashSet<Aluno>();	
		this.tamanho = tamanho;
		Validador.isArgumentoValido(tema);
	}
	
	/**
	 * Constrói um grupo com tema mas sem limite de tamanho.
	 * @param tema O tema do grupo.
	 */
	public Grupo (String tema) {
		this.tema = tema;
		this.alunosNoGrupo = new HashSet<Aluno>();
		Validador.isArgumentoValido(tema);
	}
	/**
	 * Formata os dados de um grupo específico.
	 * @return A string formatada com os dados do grupo.
	 */
	@Override
	public String toString() {
			if (this.getTamanho() == 0) {
				return "- " + this.getTema() + " " + this.getaAlunos().size()
						+ "/...\n";
			}
			return "- " + this.getTema() + " " + this.getaAlunos().size()
					+ "/" + this.getTamanho() +  "\n";
	}
	
	/**
	 * Retorna o hashcode do atribudo tema.
	 * @return O hashcode do atributo tema.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(tema);
	}

	/**
	 * Verifica se dois objetos são iguais, com base no tema.
	 * @return True ou false.
	 */
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
	
	/**
	 * Adiciona um objeto do tipo Aluno ao atributo hashSet alunosNoGrupo do grupo.
	 * @param aluno O aluno a ser adicionado.
	 */
	public void adicionaAoGrupo(Aluno aluno) {
		this.alunosNoGrupo.add(aluno);
	}
	
	
}
