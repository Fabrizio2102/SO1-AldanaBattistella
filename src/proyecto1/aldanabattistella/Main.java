package proyecto1.aldanabattistella;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        
        Semaphore mainMutex = new Semaphore(1);
        Hilo chasis = new Hilo("Chasis producidos: ", mainMutex);
        Hilo carroceria = new Hilo("Carrocerías producidas: ", mainMutex);
        Hilo motor = new Hilo("Motores producidos: ", mainMutex);
        Hilo ruedas = new Hilo("Ruedas producidas: ", mainMutex);
        Hilo accesorios = new Hilo("Accesorios producidos: ", mainMutex);
        Hilo ensamblador = new Hilo("Vehículos ensamblados: ", mainMutex);
        Hilo gerente = new Hilo("Días transcurridos: ", mainMutex);
        Hilo director = new Hilo("Días restantes: ", mainMutex);
        
        chasis.start();
        carroceria.start();
        motor.start();
        ruedas.start();
        accesorios.start();
        ensamblador.start();
        gerente.start();
        director.start();
    }
        
}
