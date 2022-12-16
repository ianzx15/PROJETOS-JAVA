package principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;

public class AcaoRepositorio {
	private HashMap<Integer, Acao> acoes;
	
	public AcaoRepositorio() {
		this.acoes = new HashMap<Integer, Acao>();
	}
	
	public void addAcao(int idDesafio, String data, int codigo, String titulo) {
		Acao novo = new Acao(idDesafio, data, codigo, titulo);
		this.acoes.put(codigo, novo);
	}
	
	public boolean progressoAcao(int codigo) {
			return this.acoes.get(codigo).progressoAcao();
	}
	
	public boolean progressoAcao(int codigo, int valor) {
			return this.acoes.get(codigo).progressoAcao(valor);
	}
	
	public Acao getAcao(int codigo) {
		return this.acoes.get(codigo);
	}

	public int getProgresso(int codigo) {
		return this.acoes.get(codigo).getProgresso();
	}
	
	public String listarAcao() {
		Collection<Acao> coleAcoes = acoes.values();
		ArrayList<Acao> listaAcoes = new ArrayList<Acao>(coleAcoes);
		listaAcoes.sort(Comparator.comparing(Acao::getProgresso));
		String string = "";
		for (int i = listaAcoes.size() -1; i >= 0; i--) {
			Acao acao = listaAcoes.get(i);
			string += acao.toString() + "\n";
		}
		return string;
	}
	
}
