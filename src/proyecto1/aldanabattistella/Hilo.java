package proyecto1.aldanabattistella;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread {
    private String msg;
    private int count = 0;
    private Semaphore mutex;
    
    public Hilo(String text, Semaphore mutex){
        this.msg = text;
        this.mutex = mutex;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                
                mutex.acquire();
                count++;
                
                System.out.println(msg + count);
                sleep(500);
                
                mutex.release();
                sleep(1000);
            }
            catch(InterruptedException ex){
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
