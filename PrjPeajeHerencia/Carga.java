
public class Carga extends Vehiculo {

    private static final double MONTO_PEAJE = 500;

    public Carga(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }

    public String getTipo() {
        return "carga";
    }
}
