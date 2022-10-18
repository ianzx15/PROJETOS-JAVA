package lab2;

public class RegistroResumos {
	private String conteudo;
	private int numeroDeResumos;
	public RegistroResumos(int numeroDeResumos) {
		this.numeroDeResumos = numeroDeResumos;
		System.out.println(numeroDeResumos);
	}
	
//	public void adiciona(String tema, String resumo) {
//		
//	}
//	
//	public String[] pegaResumos(){
//		return;
//	}
//	
//	public String imprimeResumos() {
//		return;
//	}
//	
//	public int conta() {
//		return;
//	}
//	
//	public boolean temResumo(String tema) {
//		return;
//	}
	
	public static void main(String[] args) {
		RegistroResumos a = new RegistroResumos(10);
	}
}
