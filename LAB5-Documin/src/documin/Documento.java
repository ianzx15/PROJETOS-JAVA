package documin;

import java.util.ArrayList;
import java.util.Objects;

public class Documento {
	private String titulo;
	private int tamanho;
	private ArrayList<ElementosAbstract> elementos;
	
	public Documento(String titulo, int tamanho) {
		this.titulo = titulo;
		this.tamanho = tamanho;
		this.elementos = new ArrayList<ElementosAbstract>();
		Validador.isTamanhoValido(tamanho, 1);
		Validador.isTituloValido(titulo);
		Validador.isTituloNull(titulo);
	}
	
	public Documento (String titulo) {
		this.titulo = titulo;
		this.elementos = new ArrayList<ElementosAbstract>();
		Validador.isTituloValido(titulo);
		Validador.isTituloNull(titulo);
	}

	public int adicionarElemento(ElementosAbstract elemento) {
		this.elementos.add(elemento);
		return this.elementos.indexOf(elemento);
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
	
	public ArrayList<ElementosAbstract> getElementos() {
		return this.elementos;
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
	
	public int criarTexto(String valor, int prioridade) {
		ElementoTexto texto = new ElementoTexto(valor, prioridade);
		this.elementos.add(texto);
		return this.elementos.indexOf(texto);
	}
	
	public int criarTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
		ElementoTitulo titulo = new ElementoTitulo(valor, prioridade, nivel, linkavel);
		this.elementos.add(titulo);
		return this.elementos.indexOf(titulo);
	}
	
	public int criarLista(String valorLista, int prioridade, String separador, String charLista) {
		ElementoLista lista = new ElementoLista(valorLista, prioridade, separador, charLista);
		this.elementos.add(lista);
		return this.elementos.indexOf(lista);
	}
	
	public int criarTermos(String valorTermos, int prioridade, String separador, String ordem) {
		ElementoTermos termos = new ElementoTermos(valorTermos, prioridade, separador, ordem);
		this.elementos.add(termos);
		return this.elementos.indexOf(termos);
	}
	
	public String pegarRepresentacaoCompleta(int elementoPosicao) {
		ElementosAbstract elemento = this.elementos.get(elementoPosicao);
		String string = "";
		if(elemento instanceof ElementoTexto ) {
			return string += elemento.toString();
		} else if(elemento instanceof ElementoTitulo) {
			if (((ElementoTitulo) elemento).getLinkavel() == true) {
				return string += elemento.toString();
			}
			return string += ((ElementoTitulo) elemento).naoLinkavel();
		} else if(elemento instanceof ElementoLista) {
			return string += elemento.toString();
		} 
			return elemento.toString();
	}

	
//	public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
//	}
//	
//	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
//	}
//	



//	public void moverParaBaixo(int elementoPosicao) {
//	}
//
//	public void moverParaAcima(int elementoPosicao) {
//		this.elementos.so
//		
//	}
	
}
