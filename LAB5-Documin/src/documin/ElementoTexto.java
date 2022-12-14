package documin;


public class ElementoTexto extends ElementosAbstract{

	
	public ElementoTexto(String valor, int prioridade) {
		super(valor, prioridade);
		
	}
	
	@Override
	public String toString() {
		return super.getValor();
	}
	
}
