
public class TourAventura extends Tour {
    private static final double PORCENTAJE_SEGURO = 0.15;
    private static final String DIFICULTAD_POR_OMISION = "medio";

    private String nivelDificultad;

    public TourAventura(String pNombre, double pPrecioBase, int pCupoMaximo,
            Guia pGuia, String pNivelDificultad) {
        super(pNombre, pPrecioBase, pCupoMaximo, pGuia);
        nivelDificultad = pNivelDificultad;
    }

    public TourAventura(String pNombre, double pPrecioBase, int pCupoMaximo,
            Guia pGuia) {
        this(pNombre, pPrecioBase, pCupoMaximo, pGuia, DIFICULTAD_POR_OMISION);
    }

    public double calcularPrecioPorPersona() {
        return precioBase + precioBase * PORCENTAJE_SEGURO;
    }

    public String getTipo() {
        return "aventura";
    }

    public String toString() {
        return super.toString() + "\nNivel de dificultad: " + nivelDificultad;
    }
}
