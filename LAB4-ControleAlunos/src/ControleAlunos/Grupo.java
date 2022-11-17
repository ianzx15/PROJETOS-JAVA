package ControleAlunos;

import java.util.HashSet;

public class Grupo {
	private String tema;
	private HashSet <Aluno> alunos;
	private int tamanho;
	
	public Grupo (String tema, int tamanho) {
		this.tema = tema;
		this.alunos = new HashSet<Aluno>();	
		this.tamanho = tamanho;
	}
	
	public HashSet<Aluno> getaAlunos() {
		return this.alunos;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	public void adicionaAoGrupo(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	
}
