package agenda;

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	
	public Contato() {
		
	}
	
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	@Override
	public  boolean equals(Object o) {
		if (o != null & o.getClass() == this.getClass()) {
		Contato contato = (Contato) o;
		return (this.nome.equals(contato.nome) & this.sobrenome.equals(contato.sobrenome));
		}
		return false;
		}
	
	@Override
	public String toString() {
		return  this.nome + " " + this.sobrenome;
	
    }
	
	public boolean existeIguais(Contato[] contatos) {
		for(Contato elemento : contatos) {
			if ( elemento != null && elemento.equals(this)) {
				return true;
			}
	}
		return false;
	}
}
