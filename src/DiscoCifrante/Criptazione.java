package DiscoCifrante;

import java.util.Random;

public class Criptazione {
	
	 DiscoCifrante tabella;  // Roba del Garibaldi
	 private char chiave;  //Chiave per la Criptazione
	 
	 public Criptazione () {
		 
	 }
	 
	 public String cripta(String Input)  {
		 int j=0;    //contatore di quanti elementi dello string ho inserito fino ad ora

	      Random rand = new Random();          //serve a generare un numero randomico per la dimensione sell'array di char
	      int Dimensione = rand.nextInt(100);       //0-99 
	      int size = Input.length();                //manda in Output La lunghezza dello string
		  char[] arrayChar = new char[size+Dimensione];   //creo un array di char di dimensione string + numero randomico
		 
		 
		 

	    	//Questo for serve per Criptare numeri e elementi dello string
		  //il i scorre per l'array di char creato e alla fine lo converte in string e lo manda in output
		  //@ i= indice dell'array di char

		 for(int i=1;i<(size + Dimensione);i++) {
			 int randomic;  //per contenere i numeri randomici

			 
			 if(j<size) {  //Questo for serve a decidere se mettere un numero o elemento della cifra
				  int pesoNumero1 = (i*(100/size + Dimensione)); 
			      int pesoNumero2 = ((size + Dimensione)-pesoNumero1);
			      int numeroCasuale;
			      
				 if (rand.nextInt(pesoNumero1+pesoNumero2) < pesoNumero1) {
			            numeroCasuale = 1; // Genera il primo numero con probabilità pesoNumero1
			            
			        } else {
			            numeroCasuale = 0; // Genera il secondo numero con probabilità pesoNumero2
			        }
				 
				 if(numeroCasuale==0) {   //Qui inserisco i numeri casuali da 1-4, li trasformo in char, li cripto e lo inserisco nel array di char
					 do {
							randomic = rand.nextInt(5);
					 }while((randomic>=1)||(randomic<=4));
					 
					    char c = (char) randomic;

						arrayChar[i]=tabella.getCript(c);
						tabella.setIndex(arrayChar[i]);

				 }else {  //prende un elemento di Input con charat con indice j, lo cripta e poi lo inserische nell'array e incrementa il contatore
					 
					    char c = Input.charAt(j);
						arrayChar[i]=tabella.getCript(c);
						j++;
					 
				 }
				 
			 }else {
				 
				 do {    //stessa cosa di prima se era nel caso 0
						randomic = rand.nextInt(5);
				 }while((randomic>=1)||(randomic<=4));
				 
				    char c = (char) randomic;

					arrayChar[i]=tabella.getCript(c);
					tabella.setIndex(arrayChar[i]);
			 }

		 }
		 
	        String str = new String(arrayChar);  //trasforma l'array di char in string
		 return str;
		 
	 }

	
	 
	
	
}
