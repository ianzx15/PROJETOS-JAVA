package principal;

public class AcaoController {
	
	private AcaoRepositorio rep = new AcaoRepositorio();
	
	public void addAcao(int idDesafio, String data, int codigo, String titulo) {
		rep.addAcao(idDesafio, data, codigo, titulo);
	}
	
	public boolean progressoAcao(int codigo) {
		return rep.progressoAcao(codigo);
	}
	
	public boolean progressoAcao(int codigo, int valor) {
		return rep.progressoAcao(codigo, valor);
	}
	
	public Acao getAcao(int codigo) {
		return rep.getAcao(codigo);
	}

	public int getProgresso(int codigo) {
		return this.rep.getProgresso(codigo);
	}

	public String listarAcao() {
		return rep.listarAcao();
	}
	
}
