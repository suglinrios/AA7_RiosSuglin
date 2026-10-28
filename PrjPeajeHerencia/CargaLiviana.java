
public class CargaLiviana extends Vehiculo {

    private static final double MONTO_PEAJE = 200;

    public CargaLiviana(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }

    public String getTipo() {
        return "carga liviana";
    }
}
