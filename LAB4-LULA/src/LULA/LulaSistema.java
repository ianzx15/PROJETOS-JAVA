package LULA;

import java.util.ArrayList;

public class LulaSistema {
	private ArrayList<CAD_LOCAL> locais;
	private ArrayList<CAD_COMITIVA> comitivas;
	
	
	public LulaSistema(){
		this.locais = new ArrayList<>();
		this.comitivas = new ArrayList<>();
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
	
	public void cadastraComitiva(CAD_COMITIVA comitiva) {
		if (comitiva.verificaIdIgual(this.comitivas)) {
			return;
		} if (comitiva.getId() > 99 || comitiva.getId() < 0) {
			throw new IndexOutOfBoundsException();
		}
		this.comitivas.add(comitiva);
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
	
	
	public static void main(String[] args) {
		CAD_LOCAL local = new CAD_LOCAL("ic", "introducao", 1111);
		CAD_LOCAL local2 = new CAD_LOCAL("ac", "introducao", 1111);
		LulaSistema lula = new LulaSistema();
		lula.cadastraLocal(local);
		lula.cadastraLocal(local2);
		System.out.println(lula.getLocal("ic").toString());
		System.out.println(lula.getLocal("ac").toString());
		
		CAD_COMITIVA comi = new CAD_COMITIVA(0, "aaa", 15, 11111);
		lula.cadastraComitiva(comi);
		
		CAD_COMITIVA comi2 = new CAD_COMITIVA(0, "bbb", 15, 11111);
		lula.cadastraComitiva(comi2);
		System.out.println(lula.getComitiva(0).toString());
		System.out.println(lula.getComitiva(0).toString());

		
	}
}
