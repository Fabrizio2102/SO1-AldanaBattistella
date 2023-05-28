package proyecto1.aldanabattistella;

import java.util.concurrent.Semaphore;

public class Planta {
    public String name;
    private int maxWorkers;
    private long dayDuration;
    private Worker[] workers;
    public Almacen almacen;
    public Semaphore mutex;
    
    public Planta(String name, int max, long duration){
        this.name = name;
        this.maxWorkers = max;
        this.dayDuration = duration;
        this.workers = new Worker[maxWorkers];
        this.almacen = new Almacen(25, 20, 55, 35, 10);
        this.mutex = new Semaphore(1);
        
        createWorkers();
    }
    
    public void createWorkers(){
        Worker chasis = new Worker(240, "chasis", 0.34f, this.dayDuration, this);
        chasis.start();
        Worker carroceria = new Worker(312, "carroceria", 0.34f, this.dayDuration, this);
        carroceria.start();
        Worker motor = new Worker(480, "motor", 2f, this.dayDuration, this);
        motor.start();
        Worker ruedas = new Worker(192, "rueda", 3f, this.dayDuration, this);
        ruedas.start();
        Worker accesorios = new Worker(408, "accesorio", 0.34f, this.dayDuration, this);
        accesorios.start();
        Worker vehiculo = new Worker(600, "vehiculo", 0.5f, this.dayDuration, this);
        vehiculo.start();
    }
}
