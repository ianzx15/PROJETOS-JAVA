package principal;

import java.util.HashMap;

public class AcaoRepositorio {
	private HashMap<Integer, Acao> acao;
	
	public AcaoRepositorio() {
		this.acao = new HashMap<Integer, Acao>();
	}
	
	public void addAcao(int idDesafio, String data, int codigo) {
		Acao novo = new Acao(idDesafio, data, codigo);
		this.acao.put(codigo, novo);
	}
	
	public boolean progressoAcao(int codigo) {
			return this.acao.get(codigo).progressoAcao();
	}
	
	public boolean progressoAcao(int codigo, int valor) {
			return this.acao.get(codigo).progressoAcao(valor);
	}
	
	public Acao getAcao(int codigo) {
		return this.acao.get(codigo);
	}

	public int getProgresso(int codigo) {
		return this.acao.get(codigo).getProgresso();
	}
	
}
