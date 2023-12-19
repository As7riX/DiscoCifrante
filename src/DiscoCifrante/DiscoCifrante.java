package DiscoCifrante;

public class DiscoCifrante {

    private final char[] caratteriChiaro = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z',  '1', '2', '3', '4'};
    private final char[] caratteriCriptati = {'m', 'o', 'e', 'b', 'k', 'x', 'i', 'h', 'c', 'n', 'z', 'u', 'r', 'y', 'p', 'a', 'g', 'q', 'l', 'd', 'f', 't', 's', '&'};
    private int index;
    private int key;

    /**
     * Funzione costruttore
     * @param key carattere chiave decriptazione
     */
    public DiscoCifrante(char key){

        int i = 0;
        boolean trovato = false;

        while (i < 24 && !trovato) {
            if (key == caratteriChiaro[i]) {
                this.key = i;
                trovato = true;
            }
            i++;
        }

        index = 0;

    }

    /**
     * Imposta l'indice (Lettera Maiuscola) in modo che coincida con la chiave.
     * @param index carattere indice
     */
    public void setIndex(char index){
        int i = 0;
        boolean trovato = false;

        while (i < 24 && !trovato) {
            if (index == caratteriCriptati[i]) {
                this.index = i;
                trovato = true;
            }
            i++;
        }
    }

    /**
     * Funzione che decifra un carattere in base ai valori della chiave e dell'indice
     * @param carattere char - Carattere da decifrare
     * @return char - Carattere decifrare
     */
    public char getChiaro(char carattere){
        char r = '\n';

        for (int i = 0; i < 24; i++)
            if (caratteriCriptati[i] == carattere)
                r = caratteriChiaro[getPosChiaro(i)];

        return r;
    }

    /**
     * Funzione che cripta un carattere in base ai valori della chiave e dell'indice
     * @param carattere char - carattere da criptare
     * @return char - carattere criptato
     */
    public char getCript(char carattere){
        char r = '\n';
        int i = 0;
        boolean trovato = false;

        while(i < 24 && !trovato){
            if (caratteriChiaro[i] == carattere) {
                r = caratteriCriptati[getPosCript(i)];
                trovato = true;
            }
            i++;
        }



        return r;
    }

    private int getPosCript(int pos){
        int r = pos - (index - key);

        if (r >= 24) r = r%24;
        if (r < 0) r += 24;

        return r;
    }

    private int getPosChiaro(int pos){
        int r = pos + (index - key);

        if (r >= 24) r = r%24;
        if (r < 0) r += 24;

        return r;
    }

}

