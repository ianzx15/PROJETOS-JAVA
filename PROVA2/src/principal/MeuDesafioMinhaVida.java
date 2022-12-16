package principal;

public class MeuDesafioMinhaVida {
	private AcaoController acao;
	private DesafioController desafio;
	
	
	public MeuDesafioMinhaVida() {
		this.acao = new AcaoController();
		this.desafio = new DesafioController();
	}
	
	private void maisExecucao(int codigo) {
		int id = this.acao.getAcao(codigo).getId();
		this.desafio.maisExecucao(id);
	}
	
	public void addAcao(int idDesafio, String data, int codigo) {
		this.desafio.getTitulo(idDesafio);
		this.acao.addAcao(idDesafio, data, codigo, this.desafio.getTitulo(idDesafio));
	}
	
	public String listarAcao() {
		return this.acao.listarAcao();
	}
	
	public void progressoAcao(int codigo) {
		if(this.acao.progressoAcao(codigo)) {
			maisExecucao(codigo);
		}
	}
	
	public void progressoAcao(int codigo, int valor) {
		if(this.acao.progressoAcao(codigo, valor)) {
			maisExecucao(codigo);
		}
	}
	
	public int addDesafio(String titulo) {
		return desafio.addDesafio(titulo);
	}
	
	public String exibeDesafio(int id) {
		return desafio.exibeDesafio(id);
	}
	
	public String getTitulo(int id) {
		return desafio.getTitulo(id);
	}
	
	public int getProgresso(int codigo) {
		return acao.getProgresso(codigo);
	}
	
	public int getExecucoes(int codigo) {
		return desafio.getExecucoes(codigo);
	}


	
}
