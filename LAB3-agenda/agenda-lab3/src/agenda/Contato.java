package agenda;

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	
	
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
		Agenda agenda;
		for (int i = 1; i < 101; i++) {
			contato = agenda.getContatos(i);
			if (agenda.getContatos(i) != null) {
					if(nome.equals(this.get[i].getNome()) &  sobrenome.equals(this.ListaContatos[i].getSobrenome())){
						return true;
					}
				  }
				}
		return false;
	}
	
}
