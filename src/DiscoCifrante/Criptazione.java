package DiscoCifrante;

import java.util.Random;

public class Criptazione {
    private DiscoCifrante tabella;
    private char chiave;

    public String Cripta(String input) {
        chiave = DiscoCifrante.getRandKey();
        tabella = new DiscoCifrante();
        tabella.DiscoCifrante(chiave);
        int j = input.length();
        int J=0;

        Random rand = new Random();
        int dimensione = rand.nextInt(5) + 1;
        int lunghezza = input.length() + dimensione + 2;
        char[] arrayChar = new char[lunghezza];

        arrayChar[0] = chiave;
        System.out.println(arrayChar[0]);

        arrayChar[1] = tabella.getRandIndex();
        System.out.println(arrayChar[1]);

        tabella.setIndex(arrayChar[1]);

        for (int i = 2; i < lunghezza; i++) {
            int numeroCasuale;

            int peso1 = rand.nextInt(101) * j;
            int peso2 = rand.nextInt(101) * dimensione;

            if (peso1 >= peso2) {
                numeroCasuale = 1;
            } else {
                numeroCasuale = 0;
            }

            if (numeroCasuale == 0) {
                int randomic = rand.nextInt(4) + 49;
                char c = (char) randomic;
                System.out.println(c);
                dimensione--;

                arrayChar[i] = tabella.getCript(c);
                tabella.setIndex(arrayChar[i]);
            } else {
                char c = input.charAt(J);
                System.out.println(c);
                J++;

                arrayChar[i] = tabella.getCript(c);
                j--;
            }

            System.out.println(arrayChar[i]);
            System.out.println();
        }

        String str = new String(arrayChar);
        System.out.println(str);

        return str;
    }
}
