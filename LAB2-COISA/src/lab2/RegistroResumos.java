package lab2;

/**
 * Organização e registro dos resumos. Por meio desta classe é possível 
 * receber e guardar resumos relacionados com seus respectivos temas.
 * @author Ian Evangelista Rodrigues
 *
 */
public class RegistroResumos {
	
	private String[] resumos;
	private String[] temas;
	/**
	 * Total de resumos armazenados.
	 */
	private int total;
	
	/**
	 * Índice relacionado a cada resumo. Quando há mais resumos que o tamanho da lista
	 * reinicia-se a contagem.
	 */
	private int indice;
	private boolean existeResumo;
	
	/*
	 * Armazena os temas no formato "tema1 | tema2".
	 */
	private String stringTemas = "";
	
	/**
	 * Constrói um registro de resumos de um tamanho específico.
	 * @param numeroDeResumos o tamanho do array a ser formado.
	 */

	
	public RegistroResumos(int numeroDeResumos) {
		this.resumos = new String[numeroDeResumos];
		this.temas = new String[numeroDeResumos];
	}
	
	/**
	 * Atribui o valor tema e resumo, respectivamente, aos arrays temas e resumos.
	 * @param tema o tema do resumo.
	 * @param resumo o conteúdo do resumo.
	 */
	public void adiciona(String tema, String resumo) {
		if (indice >= resumos.length) {
			indice = 0;
		}
		
		if (total < resumos.length) {
			total ++;
		}
		
		temas[indice] = tema;
		resumos[indice] = resumo;
		indice ++;
	}
	
	/**
	 * Formata cada item dos arrays resumos e temas no formato "tema : resumo"
	 * e atribui ao novo array uniaoResumoTema.
	 * @return o novo array uniaoResumoTema.
	 */
	public String[] pegaResumos(){
		String[] uniaoResumoTema = new String[total];
		for (int i = 0; i < total; i++) {
			uniaoResumoTema[i] = temas[i] + ": " + resumos[i];
		}
		return uniaoResumoTema;
	}
	
	/**
	 * Concatena todos os elementos do array temas em uma única string
	 * no formato "tema1 | tema2". 
	 * @return a string stringTemas formatada 
	 */
	public String imprimeResumos() {
		for (int i = 0; i < total; i++) {
			if (i < total -1 ) {
			stringTemas += temas[i] + " | "; 
				
			} else { stringTemas += temas[i]; }
		}
		return "- " + total + " resumo(s) cadastrados(s) \n- " + stringTemas ; 
	}
	
	/**
	 * Retorna a contagem total de elementos presentes no array.
	 * @return o total de elementos.
	 */
	public int conta() {
		return total;
	}
	
	/**
	 * Retorna o valor que representa se há um resumo de um tema específico. 
	 * @param tema o tema que se deseja encontrar no array temas.
	 * @return a variavel existeResumo.

	 */
	public boolean temResumo(String tema) {
		for (int i = 0; i < total; i++) {
			if (tema.equals(temas[i])) {
				existeResumo = true;
				break;
			} else {
				existeResumo = false;
			}
		}
		return existeResumo;
	}
	
}