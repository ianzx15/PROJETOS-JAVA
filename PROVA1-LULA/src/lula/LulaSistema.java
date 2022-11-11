package lula;

import java.util.ArrayList;

public class LulaSistema {
	private ArrayList<CAD_LOCAL> locais;
	private ArrayList<CAD_COMITIVA> comitivas;
	
	
	public LulaSistema(){
		this.locais = new ArrayList<>();
		this.comitivas = new ArrayList<>();
	}
	
	
	public int contaVisita(String idLocal) {
		CAD_LOCAL local = this.getLocal(idLocal);
		ArrayList<CAD_COMITIVA> visitas = local.getListaVisitas();
		int total = 0;
		for (CAD_COMITIVA elemento : visitas ) {
			if(elemento != null) {
			total += elemento.getNumPessoas();
			}
		}
		return total;
	}
	
	public void registraVisita(String idLocal, int idComitiva) {
		CAD_LOCAL local = this.getLocal(idLocal);
		ArrayList<CAD_COMITIVA> visitas = local.getListaVisitas();
		if (visitas.size() < 100) {
			visitas.add(this.getComitiva(idComitiva));
		}
	}
	
	public String listaVisita(String idLocal) {
		String lista = "";
		CAD_LOCAL local = this.getLocal(idLocal);
		ArrayList<CAD_COMITIVA> visitas = local.getListaVisitas();
		
		for (CAD_COMITIVA elemento : visitas) {
			 if (elemento != null) {
				 lista += elemento.toString();
			 }
		 }
		 return lista;
		
	}
	
	public String exibeLocal(String id) {
		 return this.getLocal(id).toString();
	}
	
	public ArrayList<CAD_LOCAL> getListaLocais() {
		return this.locais;
	}
	
	public CAD_LOCAL getLocal(String id){
		for (CAD_LOCAL elemento : this.getListaLocais()) {
			if (elemento.getIdentificador().equals(id)) {
				return elemento;
			}
		}
		return null;
	}

	
	public void cadastraLocal(CAD_LOCAL local) {
		if (local.verificaIdentificadorIgual(this.locais)) {
			return;
		}
		this.locais.add(local);
	}
	
	public String listarLocais() {
		 String lista = "";
		 for (CAD_LOCAL elemento : this.getListaLocais()) {
			 if (elemento != null) {
				 lista += elemento.toString();
			 }
		 }
		 return lista;
	 }
	
	public void cadastraComitiva(CAD_COMITIVA comitiva) {
		if (comitiva.verificaIdIgual(this.comitivas)) {
			return;
		} if (comitiva.getId() > 99 || comitiva.getId() < 0) {
			throw new IndexOutOfBoundsException();
		}
		this.comitivas.add(comitiva);
	}
	
	public String exibeComitiva(int id) {
		 return this.getComitiva(id).toString();
	}
	
	public ArrayList<CAD_COMITIVA> getListaComitivas() {
		return this.comitivas;
	}
	
	public CAD_COMITIVA getComitiva(int id){
		for (CAD_COMITIVA elemento : this.getListaComitivas()) {
			if (elemento.getId() == id) {
				return elemento;
			}
		}
		return null;
	}
	
	public String listarComitivas() {
		 String lista = "";
		 for (CAD_COMITIVA elemento : this.getListaComitivas()) {
			 if (elemento != null) {
				 lista += elemento.toString();
			 }
		 }
		 return lista;
	 }
}
