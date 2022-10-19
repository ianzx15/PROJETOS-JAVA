package lab2;


public class RegistroResumos {
	private String[] resumos;
	private String[] temas;
	private int contador = 0;
	private String stringTemas = "";
	
	public RegistroResumos(int numeroDeResumos) {
		this.resumos = new String[numeroDeResumos];
		this.temas = new String[numeroDeResumos];
	}
	
	public void adiciona(String tema, String resumo) {
		if (contador >= resumos.length) {
			this.contador = 0;
		}
		
		this.temas[contador] = tema;
		this.resumos[contador] = resumo;
		contador ++;
	}
	
	public String[] pegaResumos(){
		String[] uniaoResumoTema = new String[resumos.length];
		for (int i = 0; i < contador; i++) {
			uniaoResumoTema[i] = temas[i] + ": " + resumos[i];
		}
		return uniaoResumoTema;
	}
	
	public String imprimeResumos() {
		for (int i = 0; i < contador; i++) {
			if (i < contador -1 ) {
			stringTemas += temas[i] + " | "; 
				
			} else { stringTemas += temas[i]; }
		}
		return "- " + contador + " resumo(s) cadastrados(s) \n- " + stringTemas ; 
	}
	
	public int conta() {
		return ;
	}
	
//	public boolean temResumo(String tema) {
//		for (int i = 0; i < contador; i++) {
//			if (tema.equals(temas[i])) {
//				
//			}
//		}
//	}
//	
	public static void main(String[] args) {
		
		 RegistroResumos meusResumos = new RegistroResumos(100);  // 100 resumos
	     
	      meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
	      meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");
	 
	      String[] resumos = meusResumos.pegaResumos();
	 
	      for (int i = 0; i < meusResumos.conta(); i++) {
	          System.out.println(resumos[i]);
	      }
	 
	      System.out.println();
	      System.out.println("Resumos: ");
	      System.out.println(meusResumos.imprimeResumos());

	}
}
