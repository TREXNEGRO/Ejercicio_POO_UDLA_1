public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();

        // Prueba de ingreso de carros
        System.out.println("Ingresando carros...");
        parqueadero.ingresarCarro("ABC123");
        parqueadero.ingresarCarro("XYZ789");

        // Prueba de consulta de puestos disponibles
        System.out.println("\nPuestos disponibles: " + parqueadero.darPuestosDisponibles());

        // Prueba de consulta de ingresos
        System.out.println("Ingresos hasta el momento: $" + parqueadero.darIngresos());

        // Prueba de salida de carro
        System.out.println("\nSaliendo carro ABC123...");
        parqueadero.sacarCarro("ABC123");

        // Prueba de cambio de tarifa
        System.out.println("\nCambiando tarifa a $1500...");
        parqueadero.cambiarTarifa(1500);

        // Prueba de avanzar reloj
        System.out.println("\nAvanzando reloj...");
        for (int i = 0; i < 5; i++) {
            parqueadero.avanzarReloj();
            System.out.println("Hora actual: " + parqueadero.darHoraActual());
        }

        // Prueba de consulta de puestos disponibles luego de avanzar el reloj
        System.out.println("\nPuestos disponibles después de avanzar el reloj: " + parqueadero.darPuestosDisponibles());
    }
}
