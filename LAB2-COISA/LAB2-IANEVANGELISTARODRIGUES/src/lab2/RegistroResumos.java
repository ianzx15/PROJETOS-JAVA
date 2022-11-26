package lab2;

/**
 * Organização e registro dos resumos. Por meio desta classe é possível 
 * receber e guardar resumos relacionados com seus respectivos temas.
 * @author Ian Evangelista Rodrigues
 *
 */
public class RegistroResumos {
	
	/**
	 * Declara o array resumos. Não o inicia.
	 */
	private String[] resumos;
	
	/**
	 * Declara o array temas. Não o inicia.
	 */
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
		if (this.indice >= this.resumos.length) {
			this.indice = 0;
		}
		
		if (this.total < resumos.length) {
			this.total ++;
		}
		
		this.temas[indice] = tema;
		this.resumos[indice] = resumo;
		this.indice ++;
	}
	
	/**
	 * Formata cada item dos arrays resumos e temas no formato "tema : resumo"
	 * e atribui ao novo array uniaoResumoTema.
	 * @return o novo array uniaoResumoTema.
	 */
	public String[] pegaResumos(){
		String[] uniaoResumoTema = new String[total];
		for (int i = 0; i < this.total; i++) {
			uniaoResumoTema[i] = this.temas[i] + ": " + this.resumos[i];
		}
		return uniaoResumoTema;
	}
	
	/**
	 * Concatena todos os elementos do array temas em uma única string
	 * no formato "tema1 | tema2". 
	 * @return a string stringTemas formatada 
	 */
	public String imprimeResumos() {
		for (int i = 0; i < this.total; i++) {
			if (i < this.total -1 ) {
			stringTemas += this.temas[i] + " | "; 
				
			} else { stringTemas += this.temas[i]; }
		}
		return "- " + this.total + " resumo(s) cadastrados(s) \n- " + this.stringTemas ; 
	}
	
	/**
	 * Retorna a contagem total de elementos presentes no array.
	 * @return o total de elementos.
	 */
	public int conta() {
		return this.total;
	}
	
	/**
	 * Retorna o valor que representa se há um resumo de um tema específico. 
	 * @param tema o tema que se deseja encontrar no array temas.
	 * @return true ou false.

	 */
	public boolean temResumo(String tema) {
		for (int i = 0; i < this.total; i++) {
			if (tema.equals(this.temas[i])) {
				return true;
			}
		}
		return false;
	}
	
}