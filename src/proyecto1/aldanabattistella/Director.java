package proyecto1.aldanabattistella;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Director extends Thread {
    private int salary;
    private long money;
    private long horaRandom;
    private long dayDuration;
    private long esperar25;
    private boolean vigilando;
    private boolean enviando;
    private boolean trabajando;
    private Planta planta;
    Interfaz i;
    
    public Director(int salary, long duration, Planta planta, Interfaz i){
        this.salary = salary;
        this.planta = planta;
        this.dayDuration = duration;
        this.esperar25 = ((2*duration)/120);
        this.money = 0;
        this.vigilando = false;
        this.trabajando = true;
        this.enviando = false;
        this.i = i;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                this.horaRandom = (int) (Math.random()*(this.dayDuration - 50));
                sleep(this.horaRandom);
                this.vigilando = true;
                this.trabajando = false;
                this.enviando = false;
                this.i.dirUpdate(vigilando, trabajando, enviando, this.planta);
                
                if(!(planta.gerente.vigilado(this.vigilando))){
                    sleep(this.esperar25);
                    planta.gerente.vigilado(this.vigilando);
                }else{
                    sleep(this.esperar25);
                }
                
                this.vigilando = false;
                this.trabajando = true;
                this.enviando = false;
                this.i.dirUpdate(vigilando, trabajando, enviando, this.planta);
                
                sleep(this.dayDuration-this.horaRandom-this.esperar25);
                
                this.money += this.salary;
                if(planta.diasRestantes == 0){
                    this.vigilando = false;
                    this.trabajando = false;
                    this.enviando = true;
                    this.i.dirUpdate(vigilando, trabajando, enviando, this.planta);
                    enviarVehiculos();
                }                
            }
            catch(InterruptedException ex){
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void enviarVehiculos(){
        try{
            planta.mutex.acquire();
            planta.almacen.sendCars(planta.name);
            planta.mutex.release();
            planta.diasRestantes = planta.diasEntrega;
            sleep(this.dayDuration);
            this.vigilando = false;
            this.trabajando = true;
            this.enviando = false;
        }
        catch(InterruptedException ex){
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}