package proyecto1.aldanabattistella;

import java.util.concurrent.Semaphore;

public class Planta {
    public String name;
    public int diasEntrega, diasRestantes;
    private int maxWorkers, chasisI, carroceriaI, motorI, ruedasI, accesoriosI, ensambladoresI;
    private long dayDuration;
    private Worker[] workers;
    public Almacen almacen;
    public Director director;
    public Manager gerente;
    public Semaphore mutex;
    
    public Planta(String name, int max, long duration, int dias, int ch, int ca, int mo, int ru, int ac, int en){
        this.name = name;
        this.diasEntrega = dias;
        this.diasRestantes = dias;
        this.maxWorkers = max;
        this.dayDuration = duration;
        this.workers = new Worker[maxWorkers];
        this.almacen = new Almacen(25, 20, 55, 35, 10);
        this.mutex = new Semaphore(1);
        
        this.chasisI = ch;
        this.carroceriaI = ca;
        this.motorI = mo;
        this.ruedasI = ru;
        this.accesoriosI = ac;
        this.ensambladoresI = en;
        
        createWorkers();
    }
    
    public void createWorkers(){
        for(int i = 0; i<this.chasisI; i++){
            Worker worker = new Worker(240, "chasis", 0.34f, this.dayDuration, this);
            worker.start();
            workers[i] = worker;
        }
        
        for(int i = 0; i<this.carroceriaI; i++){
            Worker worker = new Worker(312, "carroceria", 0.34f, this.dayDuration, this);
            worker.start();
            workers[i+this.chasisI] = worker;
        }
        
        for(int i = 0; i<this.motorI; i++){
            Worker worker = new Worker(480, "motor", 2f, this.dayDuration, this);
            worker.start();
            workers[i+this.chasisI+this.carroceriaI] = worker;
        }
        
        for(int i = 0; i<this.ruedasI; i++){
            Worker worker = new Worker(192, "rueda", 3f, this.dayDuration, this);
            worker.start();
            workers[i+this.chasisI+this.carroceriaI+this.motorI] = worker;
        }
        
        for(int i = 0; i<this.accesoriosI; i++){
            Worker worker = new Worker(408, "accesorio", 0.34f, this.dayDuration, this);
            worker.start();
            workers[i+this.chasisI+this.carroceriaI+this.motorI+this.ruedasI] = worker;
        }
        
        for(int i = 0; i<this.ensambladoresI; i++){
            Worker worker = new Worker(600, "vehiculo", 0.5f, this.dayDuration, this);
            worker.start();
            workers[i+this.chasisI+this.carroceriaI+this.motorI+this.ruedasI+this.accesoriosI] = worker;
        }
        
        gerente = new Manager(480, this.dayDuration, this);
        gerente.start();
        director = new Director(720, this.dayDuration, this);
        director.start();
    }
}
