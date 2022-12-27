package documin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Controla a criação de documentos. Por meio dessa classe
 * é possível escolher o tamanho da lista de elementos.
 * 
 * @author Ian Evangelista Rodrigues
 *
 */

public class Documento {
	private String titulo;
	private int tamanho;
	
	/**
	 * Indica se o documento foi usado como atalho por outro 
	 * objeto do tipo Documento.
	 */
	private boolean isAtalho = false;
	
	/**
	 * ArrayList do tipo ElementosAbstract que permit armazenar
	 * diversos elementos desse super tipo. 
	 */
	private ArrayList<ElementosAbstract> elementos;
	
	
	/**
	 * Constrói um documento com titulo e tamanho específicos.
	 * @param titulo O título do documento.
	 * @param tamanho O tamanho da lista de elementos.
	 */
	public Documento(String titulo, int tamanho) {
		this.titulo = titulo;
		this.tamanho = tamanho;
		this.elementos = new ArrayList<ElementosAbstract>();
		Validador.isTamanhoValido(tamanho, 0);
		Validador.isTituloValido(titulo);
		Validador.isTituloNull(titulo);
	}
	
	/**
	 * Constrói um documento com titulo e tamanho indefinido.
	 * @param titulo O título do documento.
	 */
	public Documento (String titulo) {
		this.titulo = titulo;
		this.elementos = new ArrayList<ElementosAbstract>();
		Validador.isTituloValido(titulo);
		Validador.isTituloNull(titulo);
	}
	
	public boolean getIsAtalho() {
		return this.isAtalho;
	}
	
	public void setIsAtalho(boolean boo) {
		this.isAtalho = boo;
	}
	
	public ElementosAbstract getElemento(int indice) {
		return this.elementos.get(indice);
	}
	
	/**
	 * Remove o elemento especificado da lista de elementos.
	 * @param el O elemento a ser removido.
	 * @return True ou False.
	 */
	public boolean apagarElemento(ElementosAbstract el) {
		return this.elementos.remove(el);
	}
	
	/**
	 * Adiciona um elemento na lista de elementos.
	 * @param elemento O elemento a ser adicionado.
	 * @return O índice relacionando o objeto à sua posição
	 * na lista.
	 */
	public int adicionarElemento(ElementosAbstract elemento) {
		this.elementos.add(elemento);
		return this.elementos.indexOf(elemento);
	}
	
	/**
	 * Move um elemento uma posição acima.
	 * @param elementoPosicao A posição em que o elemento a ser
	 * movido está localizado.
	 */
	public void moverParaCima(int elementoPosicao) {
		Collections.swap(elementos, elementoPosicao, elementoPosicao + 1);
	}
	
	/**
	 * Move um elemento uma posição abaixo.
	 * @param elementoPosicao A posição em que o elemento a ser
	 * movido está localizado.
	 */
	public void moverParaBaixo(int elementoPosicao) {
		Collections.swap(elementos, elementoPosicao, elementoPosicao - 1);
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public int getTamanho() {
		if(this.elementos == null) {
			return 0;
		}
		return this.elementos.size();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(titulo, other.titulo);
	}

	/**
	 * Calcula a média das propriedades dos elementos.
	 * @return O valor relacionado à média das prioridades dos elementos.
	 */
	public double getMediaElementos() {
		double num = 0.0;
		for(ElementosAbstract el : this.elementos) {
			num += el.getPrioridade();
		}
		if (this.elementos.size() == 0) {
			return 0;
		}
		return num / this.elementos.size() ;
	}

	public ArrayList<ElementosAbstract> getElementos() {
		return this.elementos;
	}
	
}
