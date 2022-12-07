package documin;

import java.util.HashMap;

public class ElementoTitulo implements Elementos {

	private String titulo;
	private int prioridade;
	private String valor;
	private HashMap<String, String> propriedades;
	
	
	public ElementoTitulo(String titulo) {
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
