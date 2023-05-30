package proyecto1.aldanabattistella;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Thread {
    private int salary;
    private long dayDuration;
    private Planta planta;

    public Manager(int salary, long dayDuration, Planta planta){
        this.salary = salary; 
        this.dayDuration = dayDuration; 
        this.planta = planta; 
    }
    
    @Override 
    public void run(){
        
    }
}