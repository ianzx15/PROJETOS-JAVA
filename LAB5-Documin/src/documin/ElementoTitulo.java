package documin;

import java.util.HashMap;

public class ElementoTitulo extends ElementosAbstract{

	private String titulo;
	
	public ElementoTitulo(String titulo, String valor, int prioridade) {
		super(valor, prioridade);
		this.titulo = titulo;
	}
	

	@Override
	public void moverAcima() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moverAbaixo() {
		// TODO Auto-generated method stub
		
	}
}
