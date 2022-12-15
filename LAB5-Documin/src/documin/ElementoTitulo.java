package documin;

public class ElementoTitulo extends ElementosAbstract{
	
	private int nivel;
	private boolean linkavel;
	
	public ElementoTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		this.linkavel = linkavel;
		this.nivel = nivel;
	}
	
	public int getNivel() {
		return nivel;
	}

	
	public String pegarRepresentacaoCompleta() {
		String string = new String();
		if (this.linkavel == false) {
			return string += this.nivel + ". " + super.getValor();
		}
		return string += this.nivel + ". " + super.getValor() + "--\n" 
				+ this.nivel + "-" + super.getValor().toUpperCase().replace(" ", "");
	}
	
	public String pegarRepresentacaoResumida() {
		String string = new String();
			return string += this.nivel + ". " + super.getValor();
	}
}
