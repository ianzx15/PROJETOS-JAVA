package documin;


public class ElementoTermos extends ElementosAbstract {

	private String separador;
	private String ordem;
	
	public ElementoTermos(String valor, int prioridade, String separador, String ordem) {
		super(valor, prioridade);
		this.separador = separador;
		this.ordem = ordem;
	}

	@Override
	public String toString() {
		String string = "";
		String[] lista = super.getValor().split(separador);
		int tamanho = lista.length;
		for (int i = 0 ; i < tamanho; i++) {
			string += (i == tamanho -1) ? lista[i] : lista[i] + ", ";
			
//			if (i < lista.length) {
//				string += lista[i] + ", ";
//			} else {
//				string += lista[i];
//			}
		}
		return "Total termos: " + tamanho + "\n- " + string;
	}
}
