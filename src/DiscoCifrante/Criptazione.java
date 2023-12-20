package DiscoCifrante;

public class Criptazione {
    DiscoCifrante tabella;  // Roba del Garibaldi
    private char chiave;  // Chiave per la Criptazione

    public String Cripta(String Input) {
        chiave = DiscoCifrante.getRandKey();
        tabella = new DiscoCifrante(chiave);
        int j = 0;    // contatore di quanti elementi dello string ho inserito fino ad ora

        Random rand = new Random();          // serve a generare un numero randomico per la dimensione sell'array di char
        int Dimensione = rand.nextInt(100);       // 0-99
        int size = Input.length();                // manda in Output La lunghezza dello string
        char[] arrayChar = new char[size + Dimensione];   // creo un array di char di dimensione string + numero randomico

        int randomic;  // per contenere i numeri randomici
        char c; // dichiara c all'inizio del metodo

        arrayChar[0] = chiave;
        // Questo for serve per Criptare numeri e elementi dello string
        // il i scorre per l'array di char creato e alla fine lo converte in string e lo manda in output
        // @ i= indice dell'array di char
        int somma = size + Dimensione;

        // Numero di volte che numeroCasuale deve essere settato a 1
        int volteSettatoA1 = size;

        for (int i = 1; i < somma; i++) {
            int numeroCasuale;

            if (volteSettatoA1 > 0) {
                numeroCasuale = 1;
                volteSettatoA1--;
            } else {
                numeroCasuale = 0;
            }

            if (numeroCasuale == 0) {   // Qui inserisco i numeri casuali da 1-4, li trasformo in char, li cripto e lo inserisco nel array di char
                do {
                    randomic = rand.nextInt(5);
                } while ((randomic >= 1) && (randomic <= 4));

                c = (char) randomic;

                arrayChar[i] = tabella.getCript(c);
                tabella.setIndex(arrayChar[i]);

            } else {  // prende un elemento di Input con charat con indice j, lo cripta e poi lo inserisce nell'array e incrementa il contatore
                c = Input.charAt(j);
                arrayChar[i] = tabella.getCript(c);
                j++;
            }

        }

        String str = new String(arrayChar);

        System.out.println(str);

        return str;
    }
}

	 
	
	
}
