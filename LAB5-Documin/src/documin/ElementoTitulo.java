package documin;

public class ElementoTitulo extends ElementosAbstract{

	private String titulo;
	
	public ElementoTitulo(String titulo, String valor, int prioridade) {
		super(valor, prioridade);
		this.titulo = titulo;
	}
	
	
}
