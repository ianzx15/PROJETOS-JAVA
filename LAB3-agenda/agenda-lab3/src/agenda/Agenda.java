package agenda;

/**
 * Organização de uma agenda telefônica. Por meio dessa classe é possível
 * guardar diversos contatos de telefone.
 * @author Ian Evangelista Rodrigues
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 101;
	private static final int TAMANHO_FAVORITOS = 11;

	
	/*
	 * Lista de contatos de tamanho fixo igual a 101. Embora apenas 100 espaços
	 * sejam utilizados do (1 - 100).
	 */
	private Contato[] ListaContatos;
	
	
	/**
	 * Lista de contatos favoritados de tamanho fixo igual a 11. Embora apenas
	 * 10 espaçoes sejam utilizados (1 - 10). 
	 */
	private Contato[] ListaFavoritos;
	
	
	/**
	 * Constrói uma agenda vazia.
	 * @param ListaContatos A lista de contatos.
	 * @param ListaFavoritos A lista de contatos favoritos.
	 */
	public Agenda() {
		this.ListaContatos = new Contato[TAMANHO_AGENDA];
		this.ListaFavoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	
	/**
	 * Retorna a lista de contatos.
	 * @return A lista de contatos da classe Agenda
	 */
	public Contato[] getListaContatos() {
		return this.ListaContatos;
	}
	
	
	/**
	 * Retorna a lista de contatos favoritos.
	 * @return A lista de contatos favoritos da classe Agenda.
	 */
	public Contato[] getListaFavoritos() {
		return this.ListaFavoritos;
	}

	
	/**
	 * Retorna um contato favoritado por meio de um valor 
	 * fornecido pelo usuário.
	 * @param posicao a posição do contato favoritado na lista de favoritos.
	 * @return o contato favoritado na posição escolhida pelo usuário.
	 */
	public Contato getContatoFavorito(int posicao) {
		return this.ListaFavoritos[posicao];
	}
	
	
	/**
	 * Remove um contato da lista de favoritos por meio de sua posição.
	 * @param posicao  a posição do contato na lista de contatos favoritos.
	 */
	public void removeFavorito(int posicao) {
		this.ListaFavoritos[posicao] = null;
	}
	
	
	/**
	 * Retorna um contato por meio de um valor fornecido pelo usuário.
	 * @param posicao A posição do contato na lista de contatos.
	 * @return O contato na posição escolhida pelo usuário.
	 */
	public Contato getContato(int posicao) {
		return this.ListaContatos[posicao];
	}
	

	/**
	 * Cadastra um contato em uma posição. 
	 * @param posicao a posição do contato na lista de contatos.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) throws IllegalArgumentException, IndexOutOfBoundsException {
		Contato contato = new Contato(nome, sobrenome, telefone);
			if (posicao > 100 || posicao < 1 ) {
				throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
			} if(nome.isBlank()) {
				throw new IllegalArgumentException("CONTATO INVÁLIDO");
			} if (contato.existeIguais(this.getListaContatos())){
				throw new IllegalArgumentException("CONTATO JÁ CADASTRADO");
			}
				this.ListaContatos[posicao] = contato;
			
	}
	
	
	/**
	 * Retorna a string com as informações do contato e, caso seja favorito,
	 * é adicionado um ❤️ à string.
	 * @param posicao A posição do contato a ser impresso.
	 * @return retorna A string formatada.
	 */
	public String imprimeContato(int posicao) throws IndexOutOfBoundsException, NullPointerException {
		Contato contato = this.ListaContatos[posicao];
		
		if (posicao >= 101 || posicao < 1) {
			throw new IndexOutOfBoundsException("CONTATO INVÁLIDO");
		} if (contato == null) {
			throw new NullPointerException("CONTATO INVÁLIDO");
		} 
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
	
	
	/**
	 * Copia um contato da lista de contatos
	 * na lista de favoritos.
	 * @param contato O contato a ser favoritado.
	 * @param posicao A posição do contato a ser favoritado.
	 */
	public void adicionaFavorito(Contato contato, int posicao) {
		this.ListaFavoritos[posicao] = contato;
	}
	}
