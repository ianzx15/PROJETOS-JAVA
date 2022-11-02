package agenda;

public class Validacao {
	
	public Validacao() {
		
	}
	
    public boolean validaPosicaoLista(int posicao, int limite) {
		if (posicao > limite || posicao < 1) {
			return false;
		}
		return true;
	}
	
	public boolean validaContato(Agenda agenda, Contato contato, boolean favoritos) {
	boolean iguais = false;
	Contato[] lista;
	if (favoritos) {
		lista = agenda.getListaFavoritos();
		
	} else {
		lista = agenda.getListaContatos();
	}
	for(Contato elemento : lista) {
		if ( elemento != null && elemento.equals(contato)) {
			iguais = true;
			break;
		}
	}
	return iguais;
 }
}
