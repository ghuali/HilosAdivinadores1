package hilosadivinadores;

public class main {

    private static final int NUMERO_HILOS = 10;

    public static void main(String[] args) {
        NumeroSecreto numeroSecreto = new NumeroSecreto();

        // Crear un arreglo de hilos para los adivinadores
        Thread[] hilosAdivinadores = new Thread[NUMERO_HILOS];
        for (int i = 0; i < NUMERO_HILOS; i++) {
            Thread hilo = new Thread(new HiloAdivinador("Hilo " + (i + 1), numeroSecreto));
            hilosAdivinadores[i] = hilo;
        }

        // Iniciar los hilos
        for (Thread hilo : hilosAdivinadores) {
            hilo.start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilosAdivinadores) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Todos los hilos han terminado.");
    }
}

