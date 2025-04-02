package cuenta;

public class Persona {
    private String nombre;
    private String apellido;
    private String NIF;
    
    public Persona(String nombre, String apellido, String nIF) {
        this.nombre = nombre;
        this.apellido = apellido;
        NIF = nIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String nIF) {
        NIF = nIF;
    }

    @Override
    public String toString() {
        return  nombre + apellido + ", NIF=" + NIF;
    }

    
    
}
