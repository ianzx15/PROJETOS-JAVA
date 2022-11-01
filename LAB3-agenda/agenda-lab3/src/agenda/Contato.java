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
	
	public  boolean equals(Contato contato) {
		if (this.nome.equals(contato.nome) && this.sobrenome.equals(contato.sobrenome)) {
			return true;
		}
		return false;
	}
	
	public String toString(Agenda agenda, boolean favoritos) {
		String contatoFormatado = "";
		Contato contato;
		if(favoritos) {
			for (int i = 0; i < 10; i++) {
			    contato = agenda.getContatoFavorito(i);
			    if (contato != null) {
			    contatoFormatado += "\n" + i + " - " + contato.nome + " " + contato.sobrenome;
		    	}
			}
		} else {
			for (int i = 0; i < 101; i++) {
				contato = agenda.getContato(i);
				if (contato != null) {
				contatoFormatado += "\n" + i + " - " + contato.nome + " " + contato.sobrenome;
				}
			}
		}
		return contatoFormatado;
	
    }
}
