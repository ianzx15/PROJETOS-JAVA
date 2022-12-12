package documin;

import java.util.ArrayList;
import java.util.Objects;

public class Documento {
	private String titulo;
	private int tamanho;
	private ArrayList<Elementos> elementos;
	
	public Documento(String titulo, int tamanho) {
		this.titulo = titulo;
		this.tamanho = tamanho;
		this.elementos = new ArrayList<Elementos>();
		Validador.isTamanhoValido(tamanho, 1);
		Validador.isTituloValido(titulo);
		Validador.isTituloNull(titulo);
	}
	
	public Documento (String titulo) {
		this.titulo = titulo;
		this.elementos = new ArrayList<Elementos>();
		Validador.isTituloValido(titulo);
		Validador.isTituloNull(titulo);
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
	
	public ArrayList<Elementos> getElementos() {
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
	
//	public int criarTitulo(String tituloDoc, String valor, int prioridade, String separador, String charLista ) {
//	}
//	
//	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
//	}
//	
//	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
//	}
//	
//	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
//	}
//	
//	public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
//	}
//	
//	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
//	}
//	

	public void moverParaBaixo(int elementoPosicao) {
	}

	public void moverParaAcima(int elementoPosicao) {
		this.elementos.so
		
	}
	
}
