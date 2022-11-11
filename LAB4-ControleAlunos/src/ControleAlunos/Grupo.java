package ControleAlunos;

import java.util.HashSet;

public class Grupo {
	private String tema;
	private HashSet<Aluno> grupo;
	
	public Grupo (String tema) {
		this.tema = tema;
		this.grupo = new HashSet<Aluno>();	
	}
	
	public void adicionaAoGrupo(Aluno aluno) {
		this.grupo.add(aluno);
	}
	
	
}
