package agenda;

public class Agenda {
	
	private static final int TAMANHO_AGENDA = 101;
	private static final int TAMANHO_FAVORITOS = 12;
	
	private Contato[] ListaContatos;
	private Contato[] ListaFavoritos;
	
	public Agenda() {
		this.ListaContatos = new Contato[TAMANHO_AGENDA];
		this.ListaFavoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	public Contato[] getListaContatos() {
		return this.ListaContatos;
	}
	
	public Contato[] getListaFavoritos() {
		return this.ListaFavoritos;
	}

	public Contato getContatoFavorito(int posicao) {
		return this.ListaFavoritos[posicao];
	}
	
	public void removeFavorito(int posicao) {
		this.ListaFavoritos[posicao] = null;
	}
	
	
	public Contato getContato(int posicao) {
		return this.ListaContatos[posicao];
	}
	

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) throws IllegalArgumentException {
			
		
			Contato contato = new Contato(nome, sobrenome, telefone);
			this.ListaContatos[posicao] = contato;
	}
	
	public String imprimeContato(int posicao) throws RuntimeException {
		Contato contato = this.ListaContatos[posicao];
		
		if (posicao >= 101 || posicao < 1 || contato == null) {
			throw new RuntimeException("POSIÇÃO INVÀLIDA");
		}
			else {
		for(Contato elemento: this.ListaFavoritos) {
			if(elemento != null && elemento.equals(contato)) {
				return "\n" + "❤️ " + contato.getNome() 
						+ " " + contato.getSobrenome() 
						+ "\n" + contato.getTelefone() ;
			}
		}
		return "\n" + contato.getNome() 
				+ " " + contato.getSobrenome() + "\n" + contato.getTelefone();
		}
	
}
	
	public void adicionaFavorito(Contato contato, int posicao) {
		this.ListaFavoritos[posicao] = contato;
	}
	

	
	
}
