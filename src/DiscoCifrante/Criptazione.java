package DiscoCifrante;

import java.util.Random;

public class Criptazione {
    private DiscoCifrante tabella;
    private char chiave;

    public String Cripta(String input) {
        chiave = DiscoCifrante.getRandKey();  //Genera la chiave grazie alla static metod di Disco Rotante
        tabella = new DiscoCifrante();    
        tabella.DiscoCifrante(chiave);   
        int j = input.length();    // j=lunghezza dello string input
        int J=0;    //contatore dei caratteri inseriti

        Random rand = new Random();
        int dimensione = rand.nextInt(5) + 1;    //genera da 1-5 che vervirà a stabilire quanti numeri inserire nel messaggio criptato
        int lunghezza = input.length() + dimensione + 2;       //creo un int che servirà a stabilire la dimensione del messaggio criptato = dimensio dello string + numeri da inserire + la chiave di deCriptazione + la prima lettera roba bho lo sai tu
        char[] arrayChar = new char[lunghezza];    //Instanzio l'array 

        arrayChar[0] = chiave;    //inserisco la chiave come primo elemento dell'array

        arrayChar[1] = tabella.getRandIndex();    //inserisco il coso  come secondo elemento dell'array


        tabella.setIndex(arrayChar[1]);  //setto per la prima volta la ruota chaive = chiave generata   nimuscola = secondo elemento dell'array char


        for (int i = 2; i < lunghezza; i++) {  //ora inserisco i numeri e i char nell'array parto da 2 perchè i primi 2 slot sono occupati 
            int numeroCasuale;  //servirà per l'if

            int peso1 = rand.nextInt(101) * j;  //serve a decidere se mettere un numero o una lettera è pseudo casuale visto che i numeri generati vengono influenzati da quante voltè è stato inserito un numero o una lettera 
            int peso2 = rand.nextInt(101) * dimensione;    //la moltiplicazione per il contatore dei numeri e caratteri serve a bilanciare perchè le probabilità andranno a favore dell'elemento meno inserito
            //es caratteri inseriti 0  numeri inseriti 2    dimensione è stato sottratto a 1 2 volte perchè ha fatto la condizione numeroCasuale=0 2 volte quindi anche se in totale i numeri da inserire sono 
           // 5 (totali)- 2 già inseriti mentre i caratteri da inserire sono 6 anche in una situaione dove il numero generato randomicamente è 70 per carattere = peso1   mentre 80 per numero =pesa2 andrà a inserire nel array
            //un carattere perchè 70*j = 420 (j=6) che è maggiore di 240 di peso 2. e se ho finito di inserire uno dei 2 elementi qualsiasi numero moltiplicato per 0 fa 0; 
            

            if (peso1 >= peso2) {  //assegna il valore di numeroCasuale = 1 se peso1 (che va a favore di char ) è uguale o maggiore di peso 2 (che "tifa" per i numeri)
                numeroCasuale = 1; 
            } else {
                numeroCasuale = 0;
            }

            if (numeroCasuale == 0) {
                int randomic = rand.nextInt(4) + 49;  //questo genera numeri da 49-53 che corrispondiono da 1-4 nella tabella ascii
                char c = (char) randomic;  //converto il numero int generato randomicamente in char sulla base della tabella ascii

                arrayChar[i] = tabella.getCript(c);
                                dimensione--;   //ho inserito un numero nella tabella quindi riduco il valore dimensione = quantità di numeri da inserire di 1

                tabella.setIndex(arrayChar[i]);   //sposto la ruota inferiore un base al carattere vomitato da get cript cioè il numero criptato
            } else {
                char c = input.charAt(J);    //qui estraggo un carattere dall'string cioè l'input dell'utente  J è il contatore e parte da 0
                J++;  //prossima volta prenderà l'elemento successivo

                arrayChar[i] = tabella.getCript(c);  //cripta la lettera presa dalla stringa e lo inserisce nell'array
                j--;  //diminuisco le probabilità che debba inserire un carattere nell'array 
            }


        }

        String str = new String(arrayChar);  //converto la'array di char in una stringa
        

        return str; //mando come  output il messaggio criptato
    }
}
