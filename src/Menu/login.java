package Menu;

import java.util.Scanner;

public class login {
    Scanner scanner = new Scanner(System.in);
    boolean acceso = false;
    public void login(){
        while(acceso == false){
            System.out.println("USUARIO ");
            String usuario = scanner.next();
            System.out.println("CONTRASEÑA ");
            String contraseña = scanner.next();
            if(usuario.contains("eduardo")){
                if(contraseña.contains("1234")){
                    System.out.println("BIENVENIDO, " + usuario);
                    acceso = true;
                }
                else{
                    System.out.println("USUARIO INCORRECTO. INTENTELO DE NUEVO");
                    acceso = false;
                }
            }
            else{
                System.out.println("USUARIO INCORRECTO. INTENTELO DE NUEVO");
                acceso = false;
            }
        }
        scanner.close();
    }
}
