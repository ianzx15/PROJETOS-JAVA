package ControleAlunos;

import java.util.HashSet;

public class Grupo {
	private String tema;
	private HashSet<Aluno> grupo;
	private int tamanho;
	
	public Grupo (String tema, int tamanho) {
		this.tema = tema;
		this.grupo = new HashSet<Aluno>();	
		this.tamanho = tamanho;
	}
	
	public HashSet<Aluno> getaAlunos() {
		return this.grupo;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	//PROBLEMA 1 - NÃO LANÇA EXCEÇÃO
	public void adicionaAoGrupo(Aluno aluno) {
		if (this.grupo.size() > this.tamanho) {
			throw new IndexOutOfBoundsException("GRUPO CHEIO!");
		}
		this.grupo.add(aluno);
	}
	
	
}
