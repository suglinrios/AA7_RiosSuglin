
public class Guia {
    private String identificacion;
    private String nombreCompleto;

    public Guia(String pIdentificacion, String pNombreCompleto) {
        identificacion = pIdentificacion;
        nombreCompleto = pNombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String toString() {
        return "Identificación: " + identificacion + "\n" +
                "Nombre completo: " + nombreCompleto;
    }
}
