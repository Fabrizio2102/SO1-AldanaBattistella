package proyecto1.aldanabattistella;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker extends Thread {
    public String tipo;
    private float produxday;
    private float count;
    public int salary;
    private long money;
    private long dayDuration;
    public Planta planta;
    
    
    public Worker(int salary, String type, float production, long duration, Planta plant){
        this.tipo = type;
        this.produxday = production;
        this.salary = salary;
        this.dayDuration = duration;
        this.planta = plant;
        this.count = 0;
        this.money = 0;
        
       
    }
    
    @Override
    public void run(){
        
        while(true){
            try{
                sleep(this.dayDuration);
                this.money += this.salary;
                produce();
            }
            catch(InterruptedException ex){
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void produce(){
        this.count += this.produxday;
        
        if(this.count >= 1){
            try{
                planta.mutex.acquire();
                planta.almacen.addParts(this.tipo, (int) this.count, planta.name);
                planta.mutex.release();
            }
            catch(InterruptedException ex){
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.count = 0;            
        }
    }

}
