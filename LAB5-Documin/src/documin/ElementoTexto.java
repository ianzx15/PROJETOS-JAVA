package documin;


public class ElementoTexto extends ElementosAbstract{

	
	public ElementoTexto(String valor, int prioridade) {
		super(valor, prioridade);
		
	}
	
	public String pegarRepresentacaoCompleta() {
		return super.getValor() + "\n";
	}
	
	public String pegarRepresentacaoResumida() {
		return super.getValor()+ "\n";
	}
	
}
