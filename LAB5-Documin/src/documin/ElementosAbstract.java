package documin;

import java.util.HashMap;

public abstract class ElementosAbstract implements Elementos {
	/**
	 * Valor que varia entre 1 e 5 indicando maior e menor prioriodade
	 */
	private int prioridade;
	private String valor;
	private HashMap<String, String> propriedades;
	
	public ElementosAbstract(String valor, int prioridade) {
		this.propriedades = new HashMap<>();
		this.valor = valor;
		this.prioridade = prioridade;
	}
	
	public void moverAcima() {
		// TODO Auto-generated method stub
		
	}

	public void moverAbaixo() {
		// TODO Auto-generated method stub
		
	}
	
	
}
