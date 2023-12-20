package DiscoCifrante;
 
public class Decriptazione{
	private DiscoCifrante tabella;
	private char chiave;
	
	public Decriptazione() {

	}
	
	public String decripta(String messaggio, char chiave) {
		tabella = new DiscoCifrante(chiave);
		this.chiave = chiave;
		char[] mescript = messaggio.toCharArray();
		char[] mesdec = new char[mescript.length];
		tabella.setIndex(mescript[0]);
		mesdec[0]=' ';
		
		for(int i=1;i<mescript.length;i++) {
			if(tabella.getChiaro(mescript[i]) == '1' || tabella.getChiaro(mescript[i]) == '2' 
				|| tabella.getChiaro(mescript[i]) == '3' || tabella.getChiaro(mescript[i]) == '4'){
				
				tabella.setIndex(mescript[i]);
				mesdec[i]=' ';
			}else {
				mesdec[i]=tabella.getChiaro(mescript[i]);
			}
		}
		String messfin = new String(mesdec);
		messfin = messfin.replaceAll("\\s+", "");
		return messfin;
	}
}
