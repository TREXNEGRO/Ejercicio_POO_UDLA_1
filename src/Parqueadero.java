public class Parqueadero {
    // Constantes
    public static final int TAMANO = 40;
    public static final int NO_HAY_PUESTO = -1;
    public static final int PARQUEADERO_CERRADO = -2;
    public static final int CARRO_NO_EXISTE = -3;
    public static final int CARRO_YA_EXISTE = -4;
    public static final int HORA_INICIAL = 6;
    public static final int HORA_CIERRE = 20;
    public static final int TARIFA_INICIAL = 1200;

    // Atributos
    private Puesto[] puestos;
    private int tarifa;
    private int caja;
    private int horaActual;
    private boolean abierto;

    // Constructor
    public Parqueadero() {
        horaActual = HORA_INICIAL;
        abierto = true;
        tarifa = TARIFA_INICIAL;
        caja = 0;
        puestos = new Puesto[TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            puestos[i] = new Puesto(i);
        }
    }

    // Métodos
    public int darHoraActual() {
        return horaActual;
    }

    public int darPuestoCarro(String placa) {
        int puesto = -1;
        for (int i = 0; i < TAMANO; i++) {
            if (puestos[i].tieneCarroConPlaca(placa)) {
                puesto = puestos[i].darNumeroPuesto();
                break;
            }
        }
        return puesto;
    }

    public boolean ingresarCarro(String placa) {
        if (!abierto) {
            System.out.println("El parqueadero está cerrado.");
            return false;
        }

        int puestoLibre = buscarPuestoLibre();
        if (puestoLibre == -1) {
            System.out.println("No hay puestos disponibles.");
            return false;
        }

        Carro nuevoCarro = new Carro(placa, horaActual);
        puestos[puestoLibre].parquearCarro(nuevoCarro);
        System.out.println("Carro con placa " + placa + " parqueado en puesto " + puestoLibre + ".");
        return true;
    }

    public int sacarCarro(String placa) {
        if (!abierto) {
            System.out.println("El parqueadero está cerrado.");
            return PARQUEADERO_CERRADO;
        }

        int puesto = darPuestoCarro(placa);
        if (puesto == NO_HAY_PUESTO) {
            System.out.println("El carro no se encuentra en el parqueadero.");
            return CARRO_NO_EXISTE;
        }

        Carro carroSalida = puestos[puesto].darCarro();
        int tiempoEnParqueadero = carroSalida.darTiempoEnParqueadero(horaActual);
        int costo = tiempoEnParqueadero * tarifa;
        caja += costo;
        puestos[puesto].sacarCarro();
        System.out.println("Carro con placa " + placa + " salió del parqueadero. Cobro: " + costo);
        return costo;
    }

    public int darIngresos() {
        return caja;
    }

    public int darPuestosDisponibles() {
        int disponibles = 0;
        for (Puesto puesto : puestos) {
            if (!puesto.estaOcupado()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public void avanzarReloj() {
        if (horaActual < HORA_CIERRE) {
            horaActual++;
        } else {
            abierto = false;
        }
    }

    public void cambiarTarifa(int nuevaTarifa) {
        tarifa = nuevaTarifa;
    }

    private int buscarPuestoLibre() {
        for (int i = 0; i < TAMANO; i++) {
            if (!puestos[i].estaOcupado()) {
                return i;
            }
        }
        return NO_HAY_PUESTO;
    }
}
