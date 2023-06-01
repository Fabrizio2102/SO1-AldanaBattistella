package proyecto1.aldanabattistella;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Thread {
    private int salary;
    private int faltas;
    private int descontado;
    private long money;
    private long dayDuration;
    private long esperar30;
    private boolean carreras;
    private Planta planta;
    Interfaz i;

    public Manager(int salary, long dayDuration, Planta planta, Interfaz i){
        this.salary = salary; 
        this.dayDuration = dayDuration;
        this.planta = planta;
        this.esperar30 = (dayDuration/48);
        this.money = 0;
        this.descontado = 0;
        this.faltas = 0;
        this.carreras = false; 
        this.i = i;
    }
    
    @Override 
    public void run(){
        while(true){
            try{
                for(int i=0; i<16; i++){
                    sleep(this.esperar30);
                    this.carreras = true;
                    
                    this.i.gerUpdate(this.carreras, this.planta);
                    sleep(this.esperar30);             
                    this.carreras = false;
                    this.i.gerUpdate(this.carreras, this.planta);
                }
                sleep(this.dayDuration - (this.esperar30 * 32));
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
    }
    
    public boolean vigilado(boolean director){
        if(this.carreras){
            this.faltas++;
            this.descontado+=50;
            this.money -= 50;
            this.i.caught(this.planta, this.faltas, this.descontado);
            return true;
            
        }else{
            return false;
        }
    }
}