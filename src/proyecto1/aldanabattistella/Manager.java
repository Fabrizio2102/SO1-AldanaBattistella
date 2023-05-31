package proyecto1.aldanabattistella;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Thread {
    private int salary;
    private long money;
    private long dayDuration;
    private boolean carreras;
    private Planta planta;

    public Manager(int salary, long dayDuration, Planta planta){
        this.salary = salary; 
        this.dayDuration = dayDuration;
        this.planta = planta;
        this.money = 0;
        this.carreras = false;
    }
    
    @Override 
    public void run(){
        while(true){
            try{
                sleep(this.dayDuration);
                this.money += this.salary;
                proceso();
            }
            catch(InterruptedException ex){
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void proceso(){
        planta.diasRestantes--;
        System.out.println("Los dias restantes son: " + planta.diasRestantes);
    }
}