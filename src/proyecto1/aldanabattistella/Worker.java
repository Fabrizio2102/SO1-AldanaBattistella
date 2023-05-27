package proyecto1.aldanabattistella;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker extends Thread {
    private String msg;
    private String tipo;
    private float produxday;
    private float count;
    private int salary;
    private long money;
    private Semaphore mutex;
    
    public Worker(String text, Semaphore mutex, String type, Float production, int salary){
        this.msg = text;
        this.mutex = mutex;
        this.tipo = type;
        this.count = 0;
        this.produxday = production;
        this.money = 0;
        this.salary = salary;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire();
                
                money+=salary;
                count+=this.produxday;
                
                System.out.println(msg + count + " y lleva: $" + money);
                sleep(500);
                mutex.release();
                sleep(1000);
                
            }
            catch(InterruptedException ex){
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
