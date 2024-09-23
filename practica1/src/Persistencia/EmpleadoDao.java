package Persistencia;

import dominio.Empleado;

import java.io.*;

public class EmpleadoDao {

    public boolean login(Empleado empleado) {
        String rutaUsuario = "usuarios.txt";
        String rutaContraseña = "contraseñas.txt";
        boolean encontradoUsuario = false;
        boolean encontradaContraseña = false;
        boolean acceso = false;

            //USUARIO
            try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
                String lineaUsuario;
                int j = 0;
                while ((lineaUsuario = br.readLine()) != null) {
                    j++;
                    if (lineaUsuario.equalsIgnoreCase(empleado.getUsuario())) {
                        encontradoUsuario = true;
                        break;
                    }
                }
                //CONTRASEÑA
                try (BufferedReader brContraseña = new BufferedReader(new FileReader("contraseñas.txt"))) {
                    String lineaContraseña;
                    int i = 0;
                    while ((lineaContraseña = brContraseña.readLine()) != null) {
                        i++;
                        if (lineaContraseña.equalsIgnoreCase(empleado.getContraseña())) {
                            if(i==j){
                                encontradaContraseña = true;
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }

            if(encontradaContraseña && encontradoUsuario){
                acceso = true;
            }
        return acceso;
    }
}