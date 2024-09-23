package Menu.metodos;

import java.io.*;

public class MenuUtil {
    public static boolean login {
        String nombreIntroducido = "";
        String ContraseñaIntroducida = "";
        String rutaUsuario = "usuarios.txt";
        String rutaContraseña = "contraseñas.txt";
        boolean encontradoUsuario = false;
        boolean encontradaContraseña = false;
        boolean acceso = false;
        while (!acceso) {
            //USUARIO
            try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
                String lineaUsuario;
                while ((lineaUsuario = br.readLine()) != null) {
                    if (lineaUsuario.equalsIgnoreCase(nombreIntroducido)) {
                        encontradoUsuario = true;
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }

            //CONTRASEÑA
            try (BufferedReader br = new BufferedReader(new FileReader("contraseñas.txt"))) {
                String lineaContraseña;
                while ((lineaContraseña = br.readLine()) != null) {
                    if (lineaContraseña.equalsIgnoreCase(ContraseñaIntroducida)) {
                        encontradaContraseña = true;
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
            if(encontradaContraseña && encontradoUsuario){
                acceso = true;
            }
        }
        return acceso;
    }
}