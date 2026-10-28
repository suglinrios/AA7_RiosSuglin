
public class Atractivo {
    private String codigo;
    private String nombre;
    private double montoEntrada;

    public Atractivo(String pCodigo, String pNombre, double pMontoEntrada) {
        codigo = pCodigo;
        nombre = pNombre;
        montoEntrada = pMontoEntrada;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMontoEntrada() {
        return montoEntrada;
    }

    public String toString() {
        return "Código: " + codigo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Monto de entrada: " + montoEntrada;
    }
}
