package DiscoCifrante;
/**
 *
 * @author Riccardo Lazzari
 * classe che serve per decriptare che
 * ha per parametri la chiave di decriptazione
 * e la tabella di tipo DiscoCifrante
 *
 */
public class Decriptazione{

	/**
	 * costruttore
	 */
	public Decriptazione() {
	}
	/**
	 * funzione che decripta prendendo in ingresso il messaggio e la chiave e restituendo il messaggio decriptato
	 * @param messaggio
	 * @param chiave
	 * @return messfin
	 */
	public String decripta(String messaggio,char chiave) {
		DiscoCifrante tabella = new DiscoCifrante(chiave);
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