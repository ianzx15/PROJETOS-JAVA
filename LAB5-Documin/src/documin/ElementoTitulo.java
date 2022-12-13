package documin;

public class ElementoTitulo extends ElementosAbstract{
	
	private int nivel;
	private boolean linkavel;
	
	public ElementoTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		this.linkavel = linkavel;
		this.nivel = nivel;
	}

}
