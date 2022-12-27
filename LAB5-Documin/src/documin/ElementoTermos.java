package documin;

/**
 * Constrói um elemento do tipo termos a partir da herança com 
 * a classe abstrata
 * @author Ian Evangelista Rodrigues.
 */

import java.util.Arrays;

public class ElementoTermos extends ElementosAbstract {

	
	/**
	 * Indica a string que separa os termos da lista.
	 */
	private String separador;
	
	/**
	 * Indica a ordem de organização dos termos, podendo ser
	 * sem ordem, ordem alfabética ou por tamanho do termo.
	 */
	private String ordem;
	
	/**
	 * Constrói uma lista a partir de um valor, prioridade, separador, e ordem dos termos.
	 * @param valor A string que representa os termos.
	 * @param prioridade A prioridade dos termos.
	 * @param separador O separador dos termos.
	 * @param ordem A ordem em que os termos estão organizados.
	 */
	public ElementoTermos(String valor, int prioridade, String separador, String ordem) {
		super(valor, prioridade);
		this.ordem = ordem;
		this.separador = separador;
	}
	
	/**
	 * Ordena os termos por ordem alfabética ou por tamanho dos termos.
	 * @param ordem O tipo de ordenação.
	 * @return A String dos termos ordenados.
	 */
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
	
	/**
	 * Gera uma representação completa em string dos termos.
	 * @return A string representando os termos.
	 */
	public String pegarRepresentacaoCompleta() {
		String string = "";
		String[] lista = ordenar(this.ordem);
		int tamanho = lista.length;
		for (int i = 0 ; i < tamanho; i++) {
			string += (i == tamanho -1) ? lista[i] : lista[i] + ", ";
		}
		return "Total termos: " + tamanho + "\n- " + string + "\n";
	}
	
	/**
	 * Gera uma representação resumida em string dos termos.
	 * @return A string representando os termos.
	 */
	public String pegarRepresentacaoResumida() {
		String string = "";
		String[] lista = ordenar(this.ordem);
		int tamanho = lista.length -1;
		for (int i = 0 ; i <= tamanho; i++) {
			string += (i == tamanho ) ? lista[i] : lista[i] + " " + separador + " ";
		}
		return string + "\n";
	}
}
