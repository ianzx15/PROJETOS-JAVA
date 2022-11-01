package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 101;
	private static final int TAMANHO_FAVORITOS = 11;
	
	private Contato[] ListaContatos; //apenas uma simplificacao de contato
	private Contato[] ListaFavoritos;
	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.ListaContatos = new Contato[TAMANHO_AGENDA];
		this.ListaFavoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	public Contato[] getListaContatos() {
		return this.ListaContatos.clone();
	}
	
	public Contato[] getListaFavoritos() {
		return this.ListaFavoritos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return this.ListaContatos[posicao];
	}
	public Contato getContatoFavorito(int posicao) {
		return this.ListaFavoritos[posicao];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
			Contato contato = new Contato(nome, sobrenome, telefone);
			this.ListaContatos[posicao] = contato;
	}
	
	public void cadastraContato(int posicao, Contato contato) {
		this.ListaContatos[posicao] = contato;
}
	
	public String imprimeContato(int posicao) {
		return "\nDados do contato:\n\n" + this.ListaContatos[posicao].getNome() 
				+ " " + this.ListaContatos[posicao].getSobrenome() + "\n" + this.ListaContatos[posicao].getTelefone() ;
	}
	public void adicionaListaFavorito(Contato contato, int posicao) {
		this.ListaFavoritos[posicao] = contato;
	}
	
}
