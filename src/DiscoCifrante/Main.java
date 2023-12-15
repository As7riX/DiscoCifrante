package DiscoCifrante;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int Menu_Input;

        do {
            System.out.println("Menu del Il disco cifrante di Leon Battista Alberti ");
            System.out.println();
            System.out.println("1) Inserisci il Messaggio tutto in MAIUSCOLO PLS (senza i caratteri accentati e H, K J, U, W, Y e Numeri ");
            System.out.println("2) ottieni messaggio criptato");
            System.out.println("3) decripta messaggio criptato");
            System.out.println("0) Esci");

            Scanner sc = new Scanner(System.in);
            Menu_Input = sc.nextInt();
            
            String msg;
            String cript;
            char key;
            
            switch(Menu_Input) {
            
            case 1: 
            	msg = sc.nextString();
            	break;
            case 2:
            	break;
            case 3:
            	System.out.println("inserisci messaggio criptato:");
            	cript = sc.nextString();
            	System.out.println("inserisci chiave di decriptazione:");
            	key = sc.nextString();
            	break;
            default:
            		break;


            }


        }while(Menu_Input!=0);


    }

}
