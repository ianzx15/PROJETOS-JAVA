package documin;

import java.util.ArrayList;
/**
 * Organiza os objetos do tipo visão.
 * @author Ian Evangelista Rodrigues.
 * 
 */

public class Visao {
	
	/**
	 * Representa uma lista composta de listas de strings.
	 */
	private ArrayList<String[]> visoes;
	
	/**
	 * Inicia o array de visões.
	 */
	public Visao() {
		this.visoes = new ArrayList<String[]>();
	}
	
	
	/**
	 * Exibe a visão escolhida.
	 * @param visaoId A posição na lista da visão.
	 * @return A representação da visão em uma lista de strings.
	 */
	public String[] exibirVisao(int visaoId) {
		return this.visoes.get(visaoId);
	}
	
	/**
	 * Cria uma representação completa de todos os elementos do documento.
	 * @param doc O documento que se quer representar.
	 * @return Um número inteiro representando a posição da visão na lista.
	 */
	public int criarVisaoCompleta(Documento doc) {
		Validador.isTituloValido(doc.getTitulo());
		Validador.isTituloNull(doc.getTitulo());
		ArrayList<ElementosAbstract> el = doc.getElementos();
		String[] string = new String[el.size()];
		for(int i = 0; i < el.size(); i ++){
			string[i] = el.get(i).pegarRepresentacaoCompleta();
		}
		this.visoes.add(string);
		return this.visoes.indexOf(string);
	}
	
	/**
	 * Cria uma representação resumida de todos os elementos do documento.
	 * @param doc O documento que se quer representar.
	 * @return Um número inteiro representando a posição da visão na lista.
	 */
	public int criarVisaoResumida(Documento doc) {
		Validador.isTituloValido(doc.getTitulo());
		Validador.isTituloNull(doc.getTitulo());
		ArrayList<ElementosAbstract> el = doc.getElementos();
		String[] string = new String[el.size()];
		for(int i = 0; i < el.size(); i ++){
			string[i] = el.get(i).pegarRepresentacaoResumida();
		}
		this.visoes.add(string);
		return this.visoes.indexOf(string);
	}
	
	/**
	 * Cria uma representação dos elementos com prioridade maior que a definida.
	 * @param doc O documento que se quer representar.
	 * @param prioridade A prioridade base para filtrar elementos.
	 * @return Um número inteiro representando a posição da visão na lista.
	 */
	public int criarVisaoPrioritaria(Documento doc, int prioridade) {
		Validador.isTituloValido(doc.getTitulo());
		Validador.isTituloNull(doc.getTitulo());
		ArrayList<ElementosAbstract> el = new ArrayList<>();
		for (ElementosAbstract item : doc.getElementos()) {
			if (item.getPrioridade() >= prioridade) {
				el.add(item);
			}
		}
		String[] string = new String[el.size()];
		for(int i = 0; i < el.size(); i ++){
			ElementosAbstract elemento = el.get(i);
			if (elemento.getPrioridade() >= prioridade && elemento != null ) {
				string[i] = elemento.pegarRepresentacaoCompleta();
			}
		}
		
		this.visoes.add(string);
		return this.visoes.indexOf(string);
	}
	
	/**
	 * Cria uma representação resumida de todos os elementos título do documento.
	 * @param doc O documento que se quer representar.
	 * @return Um número inteiro representando a posição da visão na lista.
	 */
	public int criarVisaoTitulo(Documento doc) {
		Validador.isTituloValido(doc.getTitulo());
		Validador.isTituloNull(doc.getTitulo());
		ArrayList<ElementosAbstract> el = new ArrayList<>();
		for (ElementosAbstract item : doc.getElementos()) {
			if (item.getClass().equals(ElementoTitulo.class)) {
				el.add(item);
			}
		}
		String[] string = new String[el.size()];
		for(int i = 0; i < el.size(); i ++){
			ElementosAbstract elemento = el.get(i);
			if (elemento.getClass().equals(ElementoTitulo.class) && elemento != null) {
				string[i] = elemento.pegarRepresentacaoResumida();
			}
		}
		this.visoes.add(string);
		return this.visoes.indexOf(string);
	}
	
}