package DiscoCifrante;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
    	Criptazione c = new Criptazione();
    	Decriptazioone d = Decriptazione();
    	
        int Menu_Input;

        do {
            System.out.println("Menu del Il disco cifrante di Leon Battista Alberti ");
            System.out.println();
            System.out.println("1) Inserisci il Messaggio tutto in MAIUSCOLO PLS (senza i caratteri accentati e H, K J, U, W, Y e Numeri ");
            System.out.println("2) ottieni messaggio criptato");
            System.out.println("3) decripta messaggio criptato");
            System.out.println("0) Esci :(");

            Scanner sc = new Scanner(System.in);
            Menu_Input = sc.nextInt();
            
            String msg;		//messaggio utente in input
            String cript;	// messaggio criptato in input
            //char key;		// chiave di lettura in input
            String output;	// messaggio criptato in output
            String original;// messaggio decriptato in output
            
            
            switch(Menu_Input) {
            
            case 1: 
            	msg = sc.nextLine();
            	break;
            	
            case 2:
            	output = c.cripta(msg);
            	System.out.println("Messaggio criptato: " + output);
            	break;
            	
            case 3:
            	System.out.println("inserisci messaggio criptato:");
            	cript = sc.nextLine();
            	//System.out.println("inserisci chiave di decriptazione:");
            	//key = sc.next().charAt(0);
            	original = d.decripta(cript);
            	System.out.println("Messaggio decriptato: " + original);
            	break;
            	
            default:
            		break;


            }


        }while(Menu_Input!=0);


    }

}

