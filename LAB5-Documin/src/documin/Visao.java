package documin;

import java.util.ArrayList;

public class Visao {

	private ArrayList<String[]> visoes;
	
	public Visao() {
		this.visoes = new ArrayList<String[]>();
	}
	
	public int addVisao(String[] visao) {
		this.visoes.add(visao);
		return this.visoes.indexOf(visao);
	}
	
	public String[] exibirVisao(int visaoId) {
		
		return this.visoes.get(visaoId);
	}
	
}