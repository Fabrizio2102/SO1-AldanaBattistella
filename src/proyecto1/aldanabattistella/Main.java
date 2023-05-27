package proyecto1.aldanabattistella;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        
        Semaphore mainMutex = new Semaphore(1);
        
        Worker chasis = new Worker("Chasis producidos: ", mainMutex, "chasis", 0.34f, 240);
        Worker carroceria = new Worker("Carrocerías producidas: ", mainMutex, "carroceria", 0.34f, 312);
        Worker motor = new Worker("Motores producidos: ", mainMutex, "motor", 2f, 480);
        Worker ruedas = new Worker("Ruedas producidas: ", mainMutex, "rueda", 3f, 192);
        Worker accesorios = new Worker("Accesorios producidos: ", mainMutex, "accesorio", 0.34f, 408);
        Worker ensamblador = new Worker("Vehículos ensamblados: ", mainMutex, "ensamblador", 0.5f, 600);
        
        chasis.start();
        carroceria.start();
        motor.start();
        ruedas.start();
        accesorios.start();
        ensamblador.start();
    }
        
}
