import dominio.Empleado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Introduce la contraseña: ");
        String contraseña = scanner.nextLine();

        // Creamos el objeto Empleado con los datos introducidos
        Empleado empleado = new Empleado(usuario, contraseña);

        // Validamos el acceso
        boolean correcto = empleado.login();

        // Repetimos mientras el acceso no sea correcto
        while (!correcto) {
            System.out.println("ACCESO DENEGADO. Inténtalo de nuevo.");
            // Pedimos nuevamente los datos del usuario
            System.out.print("Introduce el usuario: ");
            usuario = scanner.nextLine();
            System.out.print("Introduce la contraseña: ");
            contraseña = scanner.nextLine();

            // Actualizamos los datos del empleado
            empleado.setUsuario(usuario);
            empleado.setContraseña(contraseña);

            // Verificamos nuevamente el acceso
            correcto = empleado.login(); // Actualizamos correcto con el nuevo resultado
        }

        System.out.println("ACCESO PERMITIDO");
        scanner.close();
    }
}