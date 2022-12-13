package documin;


public class ElementoLista extends ElementosAbstract{

	private String separador;
	private String charLista;
	
	public ElementoLista(String valor, int prioridade, String separador, String charLista) {
		super(valor, prioridade);
		this.separador = separador;
		this.charLista = charLista;
	}
	
}
