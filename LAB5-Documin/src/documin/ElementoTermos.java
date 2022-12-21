package documin;

import java.util.Arrays;

public class ElementoTermos extends ElementosAbstract {

	private String separador;
	private String ordem;
	//PQ ESSA LISTA EXISTE????????
	private String[] lista;
	
	public ElementoTermos(String valor, int prioridade, String separador, String ordem) {
		super(valor, prioridade);
		this.ordem = ordem;
		this.separador = separador;
	}
	
	public void ordenar() {
		if (ordem.toUpperCase() == "TAMANHO") {
			String[] lista = super.getValor().split(separador);
			Arrays.sort(lista, (a, b)->Integer.compare(a.length(), b.length()));
		} 
		
	}
	
	public String pegarRepresentacaoCompleta() {
		String string = "";
		String[] lista = this.lista;
		int tamanho = lista.length;
		for (int i = 0 ; i < tamanho; i++) {
			string += (i == tamanho -1) ? lista[i] : lista[i] + ", ";
		}
		return "Total termos: " + tamanho + "\n- " + string;
	}
	
	public String pegarRepresentacaoResumida() {
		String string = "";
		String[] lista = super.getValor().split(separador);
		int tamanho = lista.length -1;
		for (int i = 0 ; i <= tamanho; i++) {
			string += (i == tamanho ) ? lista[i] : lista[i] + " " + separador + " ";
		}
		return string;
	}
}
