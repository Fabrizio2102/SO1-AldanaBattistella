package proyecto1.aldanabattistella;

/**
 *
 * @author batti
 */
public class Almacen {
    public int chasis, carrocerias, motores, ruedas, accesorios;
    public int maxChasis, maxCarrocerias, maxMotores, maxRuedas, maxAccesorios;
    
    public Almacen(int maxChasis, int maxCarrocerias, int maxMotores, int maxRuedas, int maxAccesorios){
        this.chasis = 0;
        this.carrocerias = 0;
        this.motores = 0;
        this.ruedas = 0;
        this.accesorios = 0;
        
        this.maxChasis = maxChasis;
        this.maxCarrocerias = maxCarrocerias;
        this.maxMotores = maxMotores;
        this.maxRuedas = maxRuedas;
        this.maxAccesorios = maxAccesorios;
    }
    
    public void addParts(String type, int parts){
        switch(type){
            
            case "chasis":
                
                if (this.chasis < this.maxChasis){
                    this.chasis += parts;
//                    System.out.println("Chasis: " + this.chasis);
                }
                break;
            
            case "carroceria":
                
                if (this.carrocerias < this.maxCarrocerias){
                    this.carrocerias += parts;
                }
                break;
                
            case "motor":
                
                if (this.motores < this.maxMotores){
                    this.motores += parts;
                }
                break;
                
            case "rueda":
                
                if (this.ruedas < this.maxRuedas){
                    this.ruedas += parts;
                }
                break;
                
            case "accesorio":
                
                if (this.accesorios < this.maxAccesorios){
                    this.accesorios += parts;
                }
                break;
        }
    }
}
