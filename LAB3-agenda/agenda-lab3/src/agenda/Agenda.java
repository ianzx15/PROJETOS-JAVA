package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 101;
	
	private String[] ListaContatos; //apenas uma simplificacao de contato

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.ListaContatos = new String[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getListaContatos(int posicao) {
		return ListaContatos[posicao];
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
		this.ListaContatos[posicao] = contato.getNome() + "/" + contato.getSobrenome()+ "/" + contato.getTelefone();
	}

	public  boolean equals(String nome, String sobrenome) {
		for (int i = 1; i < this.ListaContatos.length; i++) {
			if (this.ListaContatos[i] != null) {
					if(nome.equals(this.ListaContatos[i].split("/")[0]) &  sobrenome.equals(this.ListaContatos[i].split("/")[1])){
						return true;
					}
				  }
				}
		return false;
	}
	
	public String imprimeContato(int posicao) {
		String[] contato = this.ListaContatos[posicao].split("/");
		
		return "\nDados do contato:\n\n" + contato[0] + " " + contato[1] + "\n" + contato[2] ;
	}
	
	public String toString(Agenda agenda) {
		String contato = "";
		String contatoFormatado = "";
		for (int i = 0; i < 101; i++) {
		contato = agenda.getListaContatos(i);
			if (contato != null) {
				contatoFormatado += "\n" + i + " - " + contato.split("/")[0] + contato.split("/")[1];
			}
	}
		return contatoFormatado;
}
}
