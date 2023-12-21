package DiscoCifrante;
/**
 * Classe che si occupa della decriptazione del messaggio tramite il disco cifrante
 *
 */
public class Decriptazione{

	/**
	 * Funzione Costruttore
	 */
	public Decriptazione() {
	}
	/**
	 * Funzione che decripta il messaggio
	 * @param messaggio messaggio da decriptare
	 * @param chiave chiave di decriptazione
	 * @return messaggio decriptato
	 */
	public String decripta(String messaggio,char chiave) {
		DiscoCifrante tabella = new DiscoCifrante(chiave);         //creo un oggetto di tipo DiscoCifrante con la chiave
		char[] mescript = messaggio.toCharArray();		   //creo un'arrey di char in cui inserisco il messaggio
		char[] mesdec = new char[mescript.length];		   //creo un'arrey di char in cui inserirò i caratteri decripati
		
		tabella.setIndex(mescript[0]);			           //uso la funzione setindex sul primo char del messaggio per settare il disco cifrato
		mesdec[0]=' ';									   
		
		for(int i=1;i<mescript.length;i++) {
			if(tabella.getChiaro(mescript[i]) == '1' || tabella.getChiaro(mescript[i]) == '2'
			  || tabella.getChiaro(mescript[i]) == '3' || tabella.getChiaro(mescript[i]) == '4'){
				
				tabella.setIndex(mescript[i]);             //setto il disco cifrato al nuovo indice ogni volta che trovo un numero fra i caratteri in chiaro          
				mesdec[i]=' ';
				
			}else {
				mesdec[i]=tabella.getChiaro(mescript[i]);  //decripto il carattere e lo inserisco nell'arrey
			}
		}
		String messfin = new String(mesdec);               //creo una stringa con i caratteri presenti nell'arrey mesdec
		messfin = messfin.replaceAll("\\s+", "");          //elimino gli spazi
		return messfin;
	}
}
