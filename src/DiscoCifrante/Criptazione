package DiscoCifrante;

import java.util.Random;

public class Criptazione {
	
	 Cifrazione tabella;  //Cifrazione
	 private char chiave='k';
	 
	 public Criptazione () {
		 
	 }
	 
	 public string Cripta (string Input)  {
	 	int Piazzamento;
		 int j=0;

	      Random rand = new Random();          //serve a generare un numero randomico per la dimensione sell'array di char
	      int Dimensione = rand.nextInt(100);       //0-99 
		 int size = length(Input);              //Vado a analizzare la dimnsione dello string in entrata
		 char[] arrayChar = new char[size+Dimensione];   //creo un array di char di dimensione string + numero randomico
		 

		 for(int i=0;i<(size + Dimensione);i++) {  //Tutto serve a Piazzare i vari char sparsi in ordine nel array 
			 
			 if(j<size) {
				 int random;
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
							random = rand.nextInt(5);
					 }while((random>=1)||(random<=4));
					 
						arrayChar[i]=//ROBA DEL GARIBALDI;

				 }else {
					 
						arrayChar[i]=// ROBA DEL GARIBALDI;
						j++;
					 
				 }
				 
			 }else {
				 
				 do {
						random = rand.nextInt(5);
				 }while((random>=1)||(random<=4));
				 
					arrayChar[i]=//ROBA DEL GARIBALDI

			 }

		 }
		 
	        String str = new String(arrayChar);
		 return str;
		 
	 }

	
	 
	
	
}
