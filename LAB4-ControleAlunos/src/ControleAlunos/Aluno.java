package ControleAlunos;

import java.util.Objects;

public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

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
