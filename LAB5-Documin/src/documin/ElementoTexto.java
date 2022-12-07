package documin;


public class ElementoTexto implements Elementos{
	/**
	 * Valor que varia entre 1 e 5 indicando maior e menor prioriodade
	 */
	private int prioridade;
	private String valor;
	
	public ElementoTexto(int prioridade, String valor) {
		this.prioridade = prioridade;
		this.valor = valor;
	}
	
	@Override
	public void moverAcima() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverAbaixo() {
		// TODO Auto-generated method stub
		
	}
	
	
}
