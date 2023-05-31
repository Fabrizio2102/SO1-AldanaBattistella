package proyecto1.aldanabattistella;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Director extends Thread {
    private int salary;
    private long money;
    private long dayDuration;
    private boolean vigilando;
    private boolean enviando;
    private boolean trabajando;
    private Planta planta;
    
    public Director(int salary, long duration, Planta planta){
        this.salary = salary;
        this.planta = planta;
        this.dayDuration = duration;
        this.money = 0;
        this.vigilando = false;
        this.trabajando = true;
        this.enviando = false;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                sleep(this.dayDuration);
                this.money += this.salary;
                if(planta.diasRestantes == 0){
                    this.vigilando = false;
                    this.trabajando = false;
                    this.enviando = true;
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
            planta.almacen.sendCars();
            planta.mutex.release();
            planta.diasRestantes = planta.diasEntrega;
            this.vigilando = false;
            this.trabajando = true;
            this.enviando = false;
        }
        catch(InterruptedException ex){
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}