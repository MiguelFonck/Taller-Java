package Ejercicio_4;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private String grupo;

    public Contacto(String pNombre, String pTelefono, String pEmail, String pGrupo) {
        nombre = pNombre;
        telefono = pTelefono;
        email = pEmail;
        grupo = pGrupo;
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getGrupo() {
        return grupo;
    }

    // setters
    public void setNombre(String pNombre) {
        nombre = pNombre;
    }

    public void setTelefono(String pTelefono) {
        telefono = pTelefono;
    }

    public void setEmail(String pEmail) {
        email = pEmail;
    }

    public void setGrupo(String pGrupo) {
        grupo = pGrupo;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " | Telefono: " + telefono
                + " | Email: " + email + " | Grupo: " + grupo);
    }
}