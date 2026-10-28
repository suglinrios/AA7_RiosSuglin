
public class Reserva {
    private static final double DESCUENTO_NACIONAL = 0.20;

    private int numero;
    private String nombreCliente;
    private int cantidadPersonas;
    private double monto;

    public Reserva(int pNumero, Cliente pCliente, int pCantidadPersonas,
            double pPrecioPorPersona) {
        numero = pNumero;
        nombreCliente = pCliente.getNombre();
        cantidadPersonas = pCantidadPersonas;

        monto = pPrecioPorPersona * cantidadPersonas;

        if (pCliente.getCondicion().equals(Cliente.CONDICION_NACIONAL)) {
            monto = monto - monto * DESCUENTO_NACIONAL;
        }
    }

    public double getMonto() {
        return monto;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public String toString() {
        return "Reserva número: " + numero + "\n" +
                "Cliente: " + nombreCliente + "\n" +
                "Cantidad de personas: " + cantidadPersonas + "\n" +
                "Monto: " + monto;
    }
}
