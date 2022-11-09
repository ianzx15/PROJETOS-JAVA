package lula;

import java.util.ArrayList;

public class CAD_LOCAL {

	
	private String nome;
	private String identificador;
	private int ramal;
	private ArrayList<CAD_COMITIVA> visitas;
	
	public CAD_LOCAL(String identificador, String nome, int ramal) {
		this.identificador = identificador;
		this.nome = nome;
		this.ramal = ramal;
		this.visitas = new ArrayList<CAD_COMITIVA>();
		}
	
	public ArrayList<CAD_COMITIVA> getListaVisitas() {
		return this.visitas;
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
		return this.identificador + " - " + this.nome + " - " + this.ramal + "\n";
		}
	 
	
}
