package LULA;

import java.util.ArrayList;

public class CAD_COMITIVA {
	private String descricao;
	private int id;
	private int numPessoas;
	private int contato;
	
	public CAD_COMITIVA(int id, String descricao, int numPessoas, int contato) {
		this.id = id;
		this.descricao = descricao;
		this.numPessoas = numPessoas;
		this.contato = contato;
	}
	
	public int getId() {
		return this.id;
	}
	
	boolean verificaIdIgual(ArrayList<CAD_COMITIVA> comitivas) {
		for (CAD_COMITIVA elemento : comitivas) {
			if (elemento.getId() == this.getId()){
				return true;
			}
		} return false;
	}
	
	@Override
	public String toString() {
		return "\nID: " + this.contato + "\nComitiva: " + this.descricao
				+ "\nIntegrantes: " + this.numPessoas + "\nContato: " + this.contato + "\n";
	}
	
}
