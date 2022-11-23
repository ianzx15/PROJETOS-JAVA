package ControleAlunos;

import java.util.HashSet;

public class Grupo {
	private String tema;
	private HashSet <Aluno> alunosNoGrupo;
	private String tamanho;
	
	public Grupo (String tema, String tamanho) {
		this.tema = tema;
		this.alunosNoGrupo = new HashSet<Aluno>();	
		this.tamanho = tamanho;
	}
	
	public Grupo (String tema) {
		this.tema = tema;
		this.alunosNoGrupo = new HashSet<Aluno>();
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
