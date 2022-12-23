package documin;

import java.util.Arrays;
import java.util.Comparator;

public class ElementoTermos extends ElementosAbstract {

	private String separador;
	private String ordem;
	
	public ElementoTermos(String valor, int prioridade, String separador, String ordem) {
		super(valor, prioridade);
		this.ordem = ordem;
		this.separador = separador;
	}
	
	private String[] ordenar(String ordem) {
		String[] lista = null;
		if (ordem.toUpperCase() == "TAMANHO") {
			lista = super.getValor().replace(this.separador, " ").split(" ");
			Arrays.sort(lista, (a, b)->Integer.compare(a.length(), b.length()));
			return lista;
		} else if(ordem.toUpperCase() == "ALFABÉTICA") {
			lista = super.getValor().replace(this.separador, " ").split(" ");
			Arrays.sort(lista);
			return lista;
		}
		return lista = super.getValor().split(this.separador);
	}
	public String pegarRepresentacaoCompleta() {
		String string = "";
		String[] lista = ordenar(this.ordem);
		int tamanho = lista.length;
		for (int i = 0 ; i < tamanho; i++) {
			string += (i == tamanho -1) ? lista[i] : lista[i] + ", ";
		}
		return "Total termos: " + tamanho + "\n- " + string;
	}
	
	public String pegarRepresentacaoResumida() {
		String string = "";
		String[] lista = ordenar(this.ordem);
		int tamanho = lista.length -1;
		for (int i = 0 ; i <= tamanho; i++) {
			string += (i == tamanho ) ? lista[i] : lista[i] + " " + separador + " ";
		}
		return string;
	}
}
