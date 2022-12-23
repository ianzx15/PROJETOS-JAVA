package documin;

public class Atalho extends ElementosAbstract{
	
	private Documento doc;
		
	public Atalho(Documento doc) {
		super(doc.getTitulo(), doc.getMediaElementos());
	}
	@Override
	public String pegarRepresentacaoCompleta() {
		return null;
	}

	@Override
	public String pegarRepresentacaoResumida() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	


}
