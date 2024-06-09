/**
 * Esta clase representa un carro dentro del parqueadero.
 */
public class Carro {
    // Atributos
    private String placa; // Placa del carro
    private int horaLlegada; // Hora de llegada del carro al parqueadero: valor entre 6 y 20

    // Constructor
    /**
     * Crea un carro con la información básica.
     * @param pPlaca Placa del carro. pPlaca != null.
     * @param pHora Hora de ingreso.
     */
    public Carro(String pPlaca, int pHora) {
        placa = pPlaca;
        horaLlegada = pHora;
    }

    // Métodos
    /**
     * Retorna la placa del carro.
     * @return La placa del carro.
     */
    public String darPlaca() {
        return placa;
    }

    /**
     * Retorna la hora de llegada del carro.
     * @return La hora en la que llegó el carro al parqueadero.
     */
    public int darHoraLlegada() {
        return horaLlegada;
    }

    /**
     * Indica si la placa del carro es igual a la recibida por parámetro.
     * @param pPlaca Placa contra la que se está comparando. pPlaca != null.
     * @return Retorna true si las placas son iguales, false en caso contrario.
     */
    public boolean tienePlaca(String pPlaca) {
        return placa.equalsIgnoreCase(pPlaca);
    }

    /**
     * Calcula el número de horas que debe pagar el carro según el tiempo que lleva el auto en el parqueadero.
     * @param pHoraSalida Hora a la que el carro sale del parqueadero. pHoraSalida >= horaLlegada.
     * @return Tiempo que ha estado en parqueadero.
     */
    public int darTiempoEnParqueadero(int pHoraSalida) {
        return pHoraSalida - horaLlegada + 1;
    }
}
