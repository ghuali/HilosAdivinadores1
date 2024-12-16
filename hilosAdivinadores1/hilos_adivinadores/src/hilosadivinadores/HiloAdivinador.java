package hilosadivinadores;

import java.util.Random;


public class HiloAdivinador implements Runnable {

    private final String nombreHilo;
    private final NumeroSecreto numeroSecreto;

    public HiloAdivinador(String nombreHilo, NumeroSecreto numeroSecreto) {
        this.nombreHilo = nombreHilo;
        this.numeroSecreto = numeroSecreto;
    }

    @Override
    public void run() {
        Random random = new Random();
        boolean acertado = false;

        while (!acertado) {
            int numeroPropuesto = random.nextInt(101); 
            int resultado = numeroSecreto.intentarAdivinar(numeroPropuesto);

            if (resultado == -1) {
                System.out.println(nombreHilo + " detenido. El número ya fue adivinado.");
                return;
            } else if (resultado == 1) {
                System.out.println(nombreHilo + " adivinó el número secreto. (" + numeroPropuesto + ")");
                acertado = true;
            } else {
                System.out.println(nombreHilo + " dice que es el " + numeroPropuesto + ". Incorrecto.");
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
