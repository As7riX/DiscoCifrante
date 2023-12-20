package DiscoCifrante;

import java.util.Random;

public class Criptazione {
	
	 DiscoCifrante tabella;  //Cifrazione
	 private char chiave='k';
	 
	 public Criptazione () {
		 
	 }
	 
	 public String Cripta (String Input)  {
		 int j=0;    //contatore di quanti elementi dello string ho inserito fino ad ora

	      Random rand = new Random();          //serve a generare un numero randomico per la dimensione sell'array di char
	      int Dimensione = rand.nextInt(100);       //0-99 
	      int size = Input.length();
		  char[] arrayChar = new char[size+Dimensione];   //creo un array di char di dimensione string + numero randomico
		 
		 
		 
		  char randomizedCharacter = (char) (rand.nextInt(26) + 'A');
		    arrayChar[0]=randomizedCharacter;
			 tabella.setIndex(arrayChar[0]);

		 

		 for(int i=1;i<(size + Dimensione);i++) {  //Tutto serve a Piazzare i vari char sparsi in ordine nel array 
			 int randomic;

			 
			 if(j<size) {
				  int pesoNumero1 = (i*(100/size + Dimensione)); 
			      int pesoNumero2 = ((size + Dimensione)-pesoNumero1);
			      int numeroCasuale;
			      
				 if (rand.nextInt(pesoNumero1+pesoNumero2) < pesoNumero1) {
			            numeroCasuale = 1; // Genera il primo numero con probabilità pesoNumero1
			            
			        } else {
			            numeroCasuale = 0; // Genera il secondo numero con probabilità pesoNumero2
			        }
				 
				 if(numeroCasuale==0) {
					 
					 do {
							randomic = rand.nextInt(5);
					 }while((randomic>=1)||(randomic<=4));
					 
					    char c = (char) randomic;

						arrayChar[i]=tabella.getCript(c);
						tabella.setIndex(arrayChar[i]);

				 }else {
					 
						arrayChar[i]=tabella.getCript(chiave);
						j++;
					 
				 }
				 
			 }else {
				 
				 do {
						randomic = rand.nextInt(5);
				 }while((randomic>=1)||(randomic<=4));
				 
				    char c = (char) randomic;

					arrayChar[i]=tabella.getCript(c);
					tabella.setIndex(arrayChar[i]);
			 }

		 }
		 
	        String str = new String(arrayChar);
		 return str;
		 
	 }

	
	 
	
	
}
