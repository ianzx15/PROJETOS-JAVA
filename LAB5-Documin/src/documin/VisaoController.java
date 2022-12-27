package documin;


public class VisaoController {
	private Visao visao = new Visao();
	
	public int criarVisaoCompleta(Documento doc) {
		return visao.criarVisaoCompleta(doc);
	}
	
	public int criarVisaoResumida(Documento doc) {
		return visao.criarVisaoResumida(doc);
	}
	
	public int criarVisaoPrioritaria(Documento doc, int prioridade) {
		return visao.criarVisaoPrioritaria(doc, prioridade);
	}
	
	public int criarVisaoTitulo(Documento doc) {
		return visao.criarVisaoTitulo(doc);
	}
	
	public String[] exibirVisao(int visaoId) {
		return this.visao.exibirVisao(visaoId);
	}
	
}
