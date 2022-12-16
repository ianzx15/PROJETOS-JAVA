package principal;

import java.util.ArrayList;

public class DesafioRepositorio {
	private ArrayList <Desafio> desafios;
	
	
	public DesafioRepositorio() {
		this.desafios = new ArrayList<Desafio>();
	}
	
	
	public int addDesafio(String titulo) {
		Desafio el = new Desafio(titulo);
		if (!this.desafios.contains(el)) {
			this.desafios.add(el);
			return this.desafios.indexOf(el);
		}
		return -1;
	}
	
	public String exibeDesafio(int id) {
		if (id <= this.desafios.size() - 1) {
			return this.desafios.get(id).toString();
		}
		return "Elemento fora dos limites";
	}
	
	public String getTitulo(int id) {
		return this.desafios.get(id).getTitulo();
	}
	
	public void maisExecucao(int id) {
		this.desafios.get(id).maisExecucao();
	}


	public int getExecucoes(int id) {
		return this.desafios.get(id).getExecucoes();
	}


	
	
	
	
	
}
