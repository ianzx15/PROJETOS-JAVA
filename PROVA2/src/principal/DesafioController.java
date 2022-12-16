package principal;


public class DesafioController {
	DesafioRepositorio rep = new DesafioRepositorio();
	
	public int addDesafio(String titulo) {
		return rep.addDesafio(titulo);
	}
	
	public String exibeDesafio(int id) {
		return rep.exibeDesafio(id);
	}
	
	public String getTitulo(int id) {
		return rep.getTitulo(id);
	}
	
	public void maisExecucao(int id) {
		rep.maisExecucao(id);
	}
	
	public int getExecucoes(int id) {
		return rep.getExecucoes(id);
	}

	

	
}
