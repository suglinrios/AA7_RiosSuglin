import java.util.ArrayList;

public abstract class Tour {
    private static final String PREFIJO_CODIGO = "TOUR-";
    private static final int PRIMER_CODIGO = 1;
    private static final int PRIMER_NUMERO_RESERVA = 1;
    private static final int UNA_PERSONA = 1;

    private static int siguienteCodigo = PRIMER_CODIGO;
    private static int cantidadTours = 0;

    private String codigo;
    private String nombre;
    protected double precioBase;
    private int cupoMaximo;
    private Guia guia;
    protected ArrayList<Atractivo> atractivos;
    private ArrayList<Reserva> reservas;
    private int siguienteNumeroReserva;

    public Tour(String pNombre, double pPrecioBase, int pCupoMaximo,
            Guia pGuia) {
        codigo = PREFIJO_CODIGO + siguienteCodigo;
        siguienteCodigo++;
        cantidadTours++;

        nombre = pNombre;
        precioBase = pPrecioBase;
        cupoMaximo = pCupoMaximo;
        guia = pGuia;

        atractivos = new ArrayList<Atractivo>();
        reservas = new ArrayList<Reserva>();
        siguienteNumeroReserva = PRIMER_NUMERO_RESERVA;
    }

    public abstract double calcularPrecioPorPersona();

    public abstract String getTipo();

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String consultarNombreGuia() {
        return guia.getNombreCompleto();
    }

    public void cambiarGuia(Guia pGuia) {
        guia = pGuia;
    }

    public void agregarAtractivo(Atractivo pAtractivo) {
        if (!yaIncluyeAtractivo(pAtractivo)) {
            atractivos.add(pAtractivo);
        }
    }

    private boolean yaIncluyeAtractivo(Atractivo pAtractivo) {
        int i;

        for (i = 0; i < atractivos.size(); i++) {
            if (atractivos.get(i).getCodigo().equals(pAtractivo.getCodigo())) {
                return true;
            }
        }

        return false;
    }

    public String consultarNombresAtractivos() {
        String nombres = "";
        int i;

        for (i = 0; i < atractivos.size(); i++) {
            if (i > 0) {
                nombres = nombres + ", ";
            }
            nombres = nombres + atractivos.get(i).getNombre();
        }

        return nombres;
    }

    public void registrarReserva(Cliente pCliente) {
        registrarReserva(pCliente, UNA_PERSONA);
    }

    public void registrarReserva(Cliente pCliente, int pCantidadPersonas) {
        int cuposDisponibles;

        cuposDisponibles = consultarCuposDisponibles();

        if (pCantidadPersonas > 0 && pCantidadPersonas <= cuposDisponibles) {
            Reserva nuevaReserva = new Reserva(siguienteNumeroReserva,
                    pCliente, pCantidadPersonas, calcularPrecioPorPersona());

            reservas.add(nuevaReserva);
            siguienteNumeroReserva++;
        }
    }

    private int calcularPersonasReservadas() {
        int total = 0;
        int i;

        for (i = 0; i < reservas.size(); i++) {
            total = total + reservas.get(i).getCantidadPersonas();
        }

        return total;
    }

    public int consultarCuposDisponibles() {
        return cupoMaximo - calcularPersonasReservadas();
    }

    public final double calcularIngresoTotal() {
        double total = 0;
        int i;

        for (i = 0; i < reservas.size(); i++) {
            total = total + reservas.get(i).getMonto();
        }

        return total;
    }

    public static int getCantidadTours() {
        return cantidadTours;
    }

    public String toString() {
        String estadoReservas = "";
        int i;

        for (i = 0; i < reservas.size(); i++) {
            estadoReservas = estadoReservas + reservas.get(i).toString() + "\n";
        }

        if (reservas.size() == 0) {
            estadoReservas = "No hay reservas registradas.\n";
        }

        return "Código: " + codigo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Guía: " + consultarNombreGuia() + "\n" +
                "Precio base: " + precioBase + "\n" +
                "Precio por persona: " + calcularPrecioPorPersona() + "\n" +
                "Cupo máximo: " + cupoMaximo + "\n" +
                "Cupos disponibles: " + consultarCuposDisponibles() + "\n" +
                "Atractivos: " + consultarNombresAtractivos() + "\n" +
                "Reservas:\n" + estadoReservas +
                "Ingreso total: " + calcularIngresoTotal() + "\n" +
                "Tipo: " + getTipo();
    }
}
