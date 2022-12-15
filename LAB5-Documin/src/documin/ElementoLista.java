package documin;


public class ElementoLista extends ElementosAbstract{

	private String separador;
	private String charLista;
	
	public ElementoLista(String valor, int prioridade, String separador, String charLista) {
		super(valor, prioridade);
		this.separador = separador;
		this.charLista = charLista;
	}
	
	@Override
	public String toString() {
		String string = "";
		for (String item : super.getValor().split(separador)) {
			string += "-" + item + "\n";
		}
		return string;
	}
	
	public String pegarRepresentacaoCompleta() {
		String string = "";
		for (String item : super.getValor().split(separador)) {
			string += "-" + item + "\n";
		}
		return string;
	}
	public String pegarRepresentacaoResumida() {
		String string = "";
		String[] lista = super.getValor().split(separador);
		int tamanhoLista = super.getValor().split(separador).length -1;
		for (int i = 0; i <= tamanhoLista; i++) {
			string += (i == tamanhoLista) ? lista[i] : lista[i] + ", "  ;
		}
		return string;
	}
	
}
