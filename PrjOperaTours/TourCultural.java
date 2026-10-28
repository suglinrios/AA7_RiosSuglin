
public class TourCultural extends Tour {
    private String idioma;

    public TourCultural(String pNombre, double pPrecioBase, int pCupoMaximo,
            Guia pGuia, String pIdioma) {
        super(pNombre, pPrecioBase, pCupoMaximo, pGuia);
        idioma = pIdioma;
    }

    public double calcularPrecioPorPersona() {
        double precio = precioBase;
        int i;

        for (i = 0; i < atractivos.size(); i++) {
            precio = precio + atractivos.get(i).getMontoEntrada();
        }

        return precio;
    }

    public String getTipo() {
        return "cultural";
    }

    public String toString() {
        return super.toString() + "\nIdioma: " + idioma;
    }
}
