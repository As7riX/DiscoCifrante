package DiscoCifrante;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
    	
    	Criptazione c = new Criptazione();
    	Decriptazioone d = new Decriptazione();
    	
    	InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
    	
        int Menu_Input;

        do {
            System.out.println("Menu del Il disco cifrante di Leon Battista Alberti ");
            System.out.println();
            System.out.println("1) Inserisci il Messaggio tutto in MAIUSCOLO PLS (senza i caratteri accentati e H, K J, U, W, Y e Numeri ");
            System.out.println("2) ottieni messaggio criptato");
            System.out.println("3) decripta messaggio criptato");
            System.out.println("0) Esci :(");
            
            
           // Scanner sc = new Scanner(System.in);
            
            
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
            	try {
            		msg = tastiera.readLine();
            		
            	}catch(Exception e)
            	{
            		System.out.println("valore non corretto!");
            		return;
            	}
            	
            	break;
            	
            case 2:
            	output = c.cripta(msg);
            	char result = output.charAt(0);
            	System.out.println("Chiave: " + result);
            	String mescript = output.substring(1);
            	System.out.println("Messaggio criptato: " + output);
            	break;
            	
            case 3:
            	System.out.println("inserisci messaggio criptato:");
            	try {
            		cript = tastiera.readLine();
            		
            	}catch(Exception e)
            	{
            		System.out.println("valore non corretto!");
            		return;
            	}
            	
            	System.out.println("inserisci chiave di decriptazione:");
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


        }while(Menu_Input!=0);


    }

}
