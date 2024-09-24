package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

	
    public static int escribirNumeroEntero( String mensaje) {
   	 Scanner sc = new Scanner(System.in);
    	int opcion =0;
    	boolean seguir = false;
        do {
            try {
                System.out.println(mensaje);
                 opcion = sc.nextInt();
                seguir = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.err.println("Debe introducir números enteros");

            }
        } while (seguir == false);
        return opcion;
    }

    public static double escribirNumeroDecimal(String mensaje) {
    	double opcion=0.0; 
    	Scanner sc = new Scanner(System.in);
    	boolean seguir = false;
        do {
            try {
                System.out.println(mensaje);
                opcion = sc.nextDouble();
                seguir = true;
            } catch (InputMismatchException e) {
            	sc.nextLine();
                System.err.println("Debe introducir números decimales");

            }
        } while (seguir == false);
        return opcion;
    }
    
    public static boolean compruebaDni(String dni) {
   
    
        return dni.matches("^[0-9]{8}[A-Z]$");
           
    }
   public static boolean compruebaNombre (String nombre) {
        
        return nombre.matches("^([A-Z]{1}[a-z]+[ ]?){3}$");
    }
    
}
