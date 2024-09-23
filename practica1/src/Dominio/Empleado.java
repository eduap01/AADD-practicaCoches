package dominio;

import Persistencia.EmpleadoDao;

public class Empleado {
    private String usuario;
    private String contraseña;
    private EmpleadoDao empleadodao;
    private boolean acceso;


    public Empleado(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        empleadodao = new EmpleadoDao();
        this.acceso = acceso;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean login() {
            return empleadodao.login(this);

     }
}