/**
 * Esta clase representa un puesto en el parqueadero.
 */
public class Puesto {
    // Atributos
    private Carro carro; // Eventual carro en el puesto. Si no hay ninguno, carro == null.
    private int numeroPuesto; // Número del puesto dentro del parqueadero.

    // Constructor
    /**
     * Crea un puesto vacío.
     * @param pPuesto Número de puesto.
     */
    public Puesto(int pPuesto) {
        carro = null;
        numeroPuesto = pPuesto;
    }

    // Métodos
    /**
     * Retorna el carro del puesto. Si no hay ningún carro retorna null.
     * @return El carro que ocupa el puesto.
     */
    public Carro darCarro() {
        return carro;
    }

    /**
     * Indica si el puesto está ocupado.
     * @return Retorna true si el puesto está ocupado. Retorna false en caso contrario.
     */
    public boolean estaOcupado() {
        return carro != null;
    }

    /**
     * Parquea un carro en el puesto.
     * @param pCarro Carro que se está parqueando. pCarro != null.
     */
    public void parquearCarro(Carro pCarro) {
        carro = pCarro;
    }

    /**
     * Saca el carro del puesto.
     */
    public void sacarCarro() {
        carro = null;
    }

    /**
     * Retorna el número del puesto.
     * @return El número asignado al puesto.
     */
    public int darNumeroPuesto() {
        return numeroPuesto;
    }

    /**
     * Indica si el carro tiene la placa recibida.
     * @param pPlaca Placa del carro que ocupa el puesto.
     * @return Retorna true si tiene la placa, false en caso contrario.
     */
    public boolean tieneCarroConPlaca(String pPlaca) {
        return carro != null && carro.tienePlaca(pPlaca);
    }
}
