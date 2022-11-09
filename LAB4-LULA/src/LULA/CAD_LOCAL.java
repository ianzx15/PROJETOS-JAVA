package LULA;

import java.util.ArrayList;

public class CAD_LOCAL {

	
	private String nome;
	private String identificador;
	private int ramal;
	
	public CAD_LOCAL(String identificador, String nome, int ramal) {
		this.identificador = identificador;
		this.nome = nome;
		this.ramal = ramal;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && this.getClass() == o.getClass()) {
			CAD_LOCAL obj = (CAD_LOCAL) o;
			return (this.getIdentificador().equals(obj.getIdentificador()));
		}
		return false;
	}
	
	 boolean verificaIdentificadorIgual(ArrayList<CAD_LOCAL> locais) {
		for (CAD_LOCAL elemento : locais) {
			if (elemento.equals(this)){
				return true;
			}
		} return false;
	}
	 
	 @Override
	 public String toString() {
		return this.identificador + " - " + this.nome + " - " + this.ramal;
		}
	 
	 
	
}
