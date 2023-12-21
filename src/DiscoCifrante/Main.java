package DiscoCifrante;

import java.io.*;
/**
 *  Classe Main
 */
public class Main {

	/**
	 * metodo main dove e' presentato il menu' per riuscire a criptare e decriptare un messaggio
	 */
    public static void main(String[] args) {
    	
    	Criptazione c = new Criptazione();
    	Decriptazione d = new Decriptazione();
    	
    	InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
    	
        int Menu_Input;
        System.out.println("Il disco cifrante di Leon Battista Alberti");
        System.out.println();
        
        do {
            System.out.println("-----MENU-----");
            System.out.println("1) Cripta il messaggio");
            System.out.println("2) Decripta il messaggio criptato");
            System.out.println("0) Esci :(");
            
            String lettura;
            String msg;		//messaggio utente in input
            String cript;	// messaggio criptato in input
            char key;		// chiave di lettura in input
            String output;	// messaggio criptato in output
            String original;// messaggio decriptato in output
            
            try {
            	
            	lettura = tastiera.readLine();
            	Menu_Input = Integer.parseInt(lettura);
            	
        		
        	}catch(Exception e)
        	{
        		System.out.println("valore non corretto!");
        		return;
        	}
        
            
            switch(Menu_Input) {
            
            case 1:
            	System.out.println("Inserisci il Messaggio tutto in MAIUSCOLO senza: caratteri accentati, H, K J, U, W, Y e Numeri ");
            	try {
            		msg = tastiera.readLine();
            		
            	}catch(Exception e)
            	{
            		System.out.println("valore non corretto!");
            		return;
            	}
            	output = c.Cripta(msg);
            	char result = output.charAt(0);
            	System.out.println("Chiave: " + result);
            	String mescript = output.substring(1);
            	System.out.println("Messaggio criptato: " + mescript);
            	break;
            	
            case 2:
            	System.out.print("inserisci messaggio criptato: ");
            	try {
            		cript = tastiera.readLine();
            		
            	}catch(Exception e)
            	{
            		System.out.println("valore non corretto!");
            		return;
            	}
            	
            	System.out.print("inserisci chiave di decriptazione: ");
            	try {
            		key = tastiera.readLine().charAt(0);
            		
            	}catch(Exception e)
            	{
            		System.out.println("valore non corretto!");
            		return;
            	}
            	
            	original = d.decripta(cript,key);
            	System.out.println("Messaggio decriptato: " + original);
            	break;
            	
            default:
            		break;


            }

            System.out.println();
        }while(Menu_Input!=0);


    }

}
