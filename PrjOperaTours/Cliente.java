
public class Cliente {
    public static final String CONDICION_NACIONAL = "nacional";
    public static final String CONDICION_EXTRANJERO = "extranjero";

    private String nombre;
    private String condicion;

    public Cliente(String pNombre, String pCondicion) {
        nombre = pNombre;
        condicion = pCondicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCondicion() {
        return condicion;
    }

    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Condición: " + condicion;
    }
}
