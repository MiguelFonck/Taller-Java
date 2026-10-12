package Ejercicio_3;

public class Cliente {
    private String nombre;
    private String email;

    public Cliente(String pNombre, String pEmail) {
        nombre = pNombre;
        email = pEmail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}