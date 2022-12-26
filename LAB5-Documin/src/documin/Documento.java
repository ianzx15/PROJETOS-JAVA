package documin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Documento {
	private String titulo;
	private int tamanho;
	private boolean isAtalho = false;
	private ArrayList<ElementosAbstract> elementos;
	
	public Documento(String titulo, int tamanho) {
		this.titulo = titulo;
		this.tamanho = tamanho;
		this.elementos = new ArrayList<ElementosAbstract>();
		Validador.isTamanhoValido(tamanho, 0);
		Validador.isTituloValido(titulo);
		Validador.isTituloNull(titulo);
	}
	
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
	
	public boolean apagarElemento(ElementosAbstract el) {
		return this.elementos.remove(el);
	}
	
	public int adicionarElemento(ElementosAbstract elemento) {
		this.elementos.add(elemento);
		return this.elementos.indexOf(elemento);
	}
	
	public void moverParaCima(int elementoPosicao) {
		Collections.swap(elementos, elementoPosicao, elementoPosicao + 1);
	}
	
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

	public int getMediaElementos() {
		int num = 0;
		for(ElementosAbstract el : this.elementos) {
			num += el.getPrioridade();
		}
		if (this.elementos.size() == 0) {
			return 0;
		}
		return num / this.elementos.size();
	}

	public ArrayList<ElementosAbstract> getElementos() {
		return this.elementos;
	}
	
}
