package hilosadivinadores;

import java.util.Random;


public class NumeroSecreto {
    private final int numeroSecreto;
    private boolean adivinado = false;

    public NumeroSecreto() {
        Random random = new Random();
        this.numeroSecreto = random.nextInt(101);
        System.out.println("Número secreto: " + this.numeroSecreto);
    }

    // Método sincronizado para intentar adivinar el número
    public synchronized int intentarAdivinar(int numeroPropuesto) {
        if (adivinado) {
            return -1; // Ya fue adivinado
        } else if (numeroPropuesto == numeroSecreto) {
            adivinado = true;
            return 1; // Adivinó correctamente
        } else {
            return 0; // No es el número correcto
        }
    }
}

