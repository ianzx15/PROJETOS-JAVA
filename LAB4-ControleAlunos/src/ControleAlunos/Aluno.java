package ControleAlunos;

/**
 * Controla a criação de alunos. Por meio dessa classe é possível
 * criar alunos com nome, matrícula e curso específicos.
 * @author Ian Evangelista Rodrigues.
 */

import java.util.Objects;

public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * Constrói um aluno a partir dos parâmetros matricula, nome e curso.
	 * @param matricula A matricula do aluno.
	 * @param nome O nome do aluno.
	 * @param curso O curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso  = curso;
		Validador.isArgumentoValido(curso);
		Validador.isArgumentoValido(nome);
		Validador.isArgumentoValido(matricula);
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCurso() {
		return this.curso;
	}

	/**
	 * Retorna os atributos matricula, nome e curso do aluno.
	 * @return A string formatada com os atributos do aluno.
	 */
	@Override
	public String toString() {
		return ". " + this.getMatricula() + " - " + this.getNome()
		+ " - " + this.getCurso() + "\n"; 
	}
	
	/**
	 * Retorna o hashcode do atribudo matricula.
	 * @return O hashcode do atributo matricula.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	/**
	 * Verifica se dois objetos são iguais, com base na matrícula.
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
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
}
