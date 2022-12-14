package documin;

public class ElementoTitulo extends ElementosAbstract{
	
	private int nivel;
	private boolean linkavel;
	
	public ElementoTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		this.linkavel = linkavel;
		this.nivel = nivel;
	}
	
	public boolean getLinkavel() {
		return this.linkavel;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	@Override
	public String toString() {
		String string = new String();
		return string += this.nivel + ". " + super.getValor() + "--\n" 
				+ this.nivel + "-" + super.getValor().toUpperCase().replace(" ", "");
	}
	
	public String naoLinkavel() {
		String string = new String();
		return string += this.nivel + ". " + super.getValor();
	}
	
}
