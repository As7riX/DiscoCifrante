package DiscoCifrante;

import java.util.Random;

/**
 * Classe che rappresenta il Disco Cifrante di Leon Battista Alberti.
 * Informazioni: <a href="https://it.wikipedia.org/wiki/Disco_cifrante">Wikipedia.org</a> <a href="http://www.crittologia.eu/storia/storia.html">Crittologia.eu</a>
 *
 */
public class DiscoCifrante {
    static Random random = new Random();
    /**
     * Array di char che rappresentano i caratteri della ruota esterna.
     */
    private final static char[] caratteriChiaro = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z',  '1', '2', '3', '4'};
    /**
     * Array di char che rappresentano i caratteri della ruota interna.
     */
    private final static char[] caratteriCriptati = {'m', 'o', 'e', 'b', 'k', 'x', 'i', 'h', 'c', 'n', 'z', 'u', 'r', 'y', 'p', 'a', 'g', 'q', 'l', 'd', 'f', 't', 's', '&'};

    /**
     * Indice interno.
     */
    private int index;

    /**
     * Indice esterno.
     */
    private int key;

    /**
     * Funzione costruttore.
     * @param key chiave decriptazione.
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
     * Imposta l'indice in modo che coincida con la chiave.
     * @param index indice (Lettera Minuscola).
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
     * Funzione che decifra un carattere in base ai valori della chiave e dell'indice.
     * @param carattere Carattere da decifrare.
     * @return Carattere decifrarato.
     */
    public char getChiaro(char carattere){
        char r = '\n';
        int i = 0;
        boolean trovato = false;

        while(i < 24 && !trovato){
            if (caratteriCriptati[i] == carattere) {
                r = caratteriChiaro[getPosChiaro(i)];
                trovato = true;
            }
            i++;
        }

        return r;
    }

    /**
     * Funzione che cripta un carattere in base ai valori della chiave e dell'indice.
     * @param carattere carattere da criptare.
     * @return carattere criptato.
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


    /**
     * Funzione che restituiesce una chiave random
     * @return Chiave random
     */
    public static char getRandKey(){
        return caratteriChiaro[random.nextInt(24)];
    }


    /**
     * Funzione che restituisce un index random
     * @return Index random (carattere minuscolo)
     */
    public static char getRandIndex(){
        return caratteriCriptati[random.nextInt(24)];
    }

    /**
     * Funzione che restituisce la posizione di un carattere in base all'indice e alla key.
     * @param pos Posizione parziale dell'elemento
     * @return Posizione reale dell'elemento
     */
    private int getPosCript(int pos){
        int r = pos - (index - key);

        if (r >= 24) r = r%24;
        if (r < 0) r += 24;

        return r;
    }

    /**
     * Funzione che restituisce la posizione di un carattere in base all'indice e alla key.
     * @param pos Posizione parziale dell'elemento
     * @return Posizione reale dell'elemento
     */
    private int getPosChiaro(int pos){
        int r = pos + (index - key);

        if (r >= 24) r = r%24;
        if (r < 0) r += 24;

        return r;
    }

}

