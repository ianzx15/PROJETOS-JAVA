package documin;

import java.util.ArrayList;

public class VisaoController {
	private Visao visao = new Visao();
	
	public int criarVisaoCompleta(Documento doc) {
		Validador.isTituloValido(doc.getTitulo());
		Validador.isTituloNull(doc.getTitulo());
		ArrayList<ElementosAbstract> el = doc.getElementos();
		String[] string = new String[el.size()];
		for(int i = 0; i < el.size(); i ++){
			string[i] = el.get(i).pegarRepresentacaoCompleta();
		}
		return visao.addVisao(string);
	}
	
	public int criarVisaoResumida(Documento doc) {
		Validador.isTituloValido(doc.getTitulo());
		Validador.isTituloNull(doc.getTitulo());
		ArrayList<ElementosAbstract> el = doc.getElementos();
		String[] string = new String[el.size()];
		for(int i = 0; i < el.size(); i ++){
			string[i] = el.get(i).pegarRepresentacaoResumida();
		}
		return visao.addVisao(string);
	}
	
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
		return visao.addVisao(string);
	}
	
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
		return this.visao.addVisao(string);
	}
	
	public String[] exibirVisao(int visaoId) {
		return this.visao.exibirVisao(visaoId);
	}
	
}
