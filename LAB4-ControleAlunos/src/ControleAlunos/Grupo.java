package ControleAlunos;

import java.util.HashSet;

public class Grupo {
	private String tema;
	private HashSet <Aluno> alunosNoGrupo;
	private int tamanho;
	
	public Grupo (String tema, int tamanho) {
		this.tema = tema;
		this.alunosNoGrupo = new HashSet<Aluno>();	
		this.tamanho = tamanho;
	}
	
	public HashSet<Aluno> getaAlunos() {
		return this.alunosNoGrupo;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public String getTema() {
		return this.tema;
	}
	
	public void adicionaAoGrupo(Aluno aluno) {
		this.alunosNoGrupo.add(aluno);
	}
	
	
}
