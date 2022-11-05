package agenda;

/**
 * Controla a criação de contatos. Por meio dessa classe é possível
 * criar contatos com nome, sobrenome, e telefone específicos.
 * @author Ian Evangelista Rodrigues
 *
 */

public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Constrói um contato vazio.
	 */
	public Contato() {
		
	}
	
	/**
	 * Constrói um contato a partir do nome, sobrenome e telefone.
	 * @param nome o nome do contato.
	 * @param sobrenome o sobrenome do contato.
	 * @param telefone o telefone do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Retorna o nome do contato.
	 * @return o nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o sobrenome do contato.
	 * @return o sobrenome do contato.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Retorna o telefone do contato.
	 * @return o telefone do contato.
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	 * Compara dois objetos da classe Contato.
	 * @return true ou false
	 */
	@Override
	public  boolean equals(Object o) {
		if (o != null & o.getClass() == this.getClass()) {
		Contato contato = (Contato) o;
		return (this.nome.equals(contato.nome) & this.sobrenome.equals(contato.sobrenome));
		}
		return false;
		}
	
	/**
	 * Retorna a string que representa os atributos do contato.
	 * @return a string formatada de nome e sobrenome
	 */
	@Override
	public String toString() {
		return  this.nome + " " + this.sobrenome;
	
    }
	
	/**
	 * Verifica se existe um contato específico em uma lista de contatos.
	 * @param contatos a lista de contatos.
	 * @return true ou false.
	 */
	public boolean existeIguais(Contato[] contatos) {
		for(Contato elemento : contatos) {
			if ( elemento != null && elemento.equals(this)) {
				return true;
			}
	}
		return false;
	}
}
