
public class Particular extends Vehiculo {

    private static final double MONTO_PEAJE = 100;

    public Particular(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }

    public String getTipo() {
        return "particular";
    }
}
