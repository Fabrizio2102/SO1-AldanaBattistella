package proyecto1.aldanabattistella;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker extends Thread {
    private String tipo;
    private float produxday;
    private float count;
    private int salary;
    private long money;
    private long dayDuration;
    private Planta planta;
    
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
    }
    
    public void produce(){
        switch(tipo){
            case "vehiculo":
                switch(planta.name){
                    case "MA":
                        if((planta.almacen.chasis >= 1) && (planta.almacen.carrocerias >= 1) && (planta.almacen.motores >= 2) && (planta.almacen.ruedas >= 4)){
                            if(planta.almacen.vehiculosE == (planta.almacen.vehiculosA*2)){
                                this.count += this.produxday;
                            }else if((planta.almacen.vehiculosE > 0) && (planta.almacen.vehiculosE % 2 == 0)){
                                if(planta.almacen.accesorios >= 3){
                                    this.count += this.produxday;
                                }
                            }else{
                                this.count += this.produxday;
                            }                            
                        }
                        break;
                        
                    case "LA":
                        if((planta.almacen.chasis >= 2) && (planta.almacen.carrocerias >= 1) && (planta.almacen.motores >= 6) && (planta.almacen.ruedas >= 5)){
                            this.count += this.produxday;
                        }
                        break;
                }
                break;
            default:
                this.count += this.produxday;
                break;
        }
        
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
