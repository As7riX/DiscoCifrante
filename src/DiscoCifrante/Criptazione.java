package DiscoCifrante;

import java.util.Random;

public class Criptazione {
    DiscoCifrante tabella;  // Roba del Garibaldi
    private char chiave;  // Chiave per la Criptazione

    public String Cripta(String Input) {
        chiave = DiscoCifrante.getRandKey();
        tabella = new DiscoCifrante(chiave);
        int j = 0;    // contatore di quanti elementi dello string ho inserito fino ad ora

        Random rand = new Random();          // serve a generare un numero randomico per la dimensione sell'array di char
        int dimensioneMassimaDisco = 4; // Modifica a seconda della tua logica
        int Dimensione = rand.nextInt(dimensioneMassimaDisco) + 1; // 1-4
        int size = Input.length();                // manda in Output La lunghezza dello string
        char[] arrayChar = new char[size + Dimensione + 2];   // creo un array di char di dimensione string + numero randomico

        arrayChar[0] = chiave;
        arrayChar[1] = tabella.getRandIndex();
        tabella.setIndex(arrayChar[1]);

        // Numero di volte che numeroCasuale deve essere settato a 1
        int volteSettatoA1 = Math.min(size, dimensioneMassimaDisco);

        for (int i = 2; i < size + Dimensione + 2; i++) {
            int numeroCasuale;

            if (volteSettatoA1 > 0) {
                numeroCasuale = 1;
                volteSettatoA1--;
            } else {
                numeroCasuale = 0;
            }

            if (numeroCasuale == 0) {
                // Qui inserisco i numeri casuali da 1-4, li trasformo in char, li cripto e lo inserisco nel array di char
                int randomic = rand.nextInt(4) + 49;
                char c = (char) randomic;

                arrayChar[i] = tabella.getCript(c);
                tabella.setIndex(arrayChar[i]);
            } else {
                // Prende un elemento di Input con charat con indice j, lo cripta e poi lo inserisce nell'array e incrementa il contatore
                char c = Input.charAt(j);

                arrayChar[i] = tabella.getCript(c);
                j++;
            }
        }

        String str = new String(arrayChar);

        System.out.println(str);  // Puoi rimuovere questa stampa una volta completato il debug

        return str;
    }
}
