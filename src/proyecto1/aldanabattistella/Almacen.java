package proyecto1.aldanabattistella;

public class Almacen {
    public int chasis, carrocerias, motores, ruedas, accesorios, vehiculosE, vehiculosA;
    public int maxChasis, maxCarrocerias, maxMotores, maxRuedas, maxAccesorios;
    
    public Almacen(int maxChasis, int maxCarrocerias, int maxMotores, int maxRuedas, int maxAccesorios){
        this.chasis = 0;
        this.carrocerias = 0;
        this.motores = 0;
        this.ruedas = 0;
        this.accesorios = 0;
        this.vehiculosE = 0;
        this.vehiculosA = 0;
        
        this.maxChasis = maxChasis;
        this.maxCarrocerias = maxCarrocerias;
        this.maxMotores = maxMotores;
        this.maxRuedas = maxRuedas;
        this.maxAccesorios = maxAccesorios;
    }
    
    public void addParts(String type, int parts, String name){
        switch(type){
            
            case "chasis":
                
                if (this.chasis < this.maxChasis){
                    this.chasis += parts;
                    System.out.println("Chasis: " + this.chasis);
                }
                break;
            
            case "carroceria":
                
                if (this.carrocerias < this.maxCarrocerias){
                    this.carrocerias += parts;
                    System.out.println("Carrocerias: " + this.carrocerias);
                }
                break;
                
            case "motor":
                
                if (this.motores < this.maxMotores){
                    if((this.motores + parts) > this.maxMotores){
                        this.motores = this.maxMotores;
                    }else{
                        this.motores += parts;
                    }
                    System.out.println("Motores: " + this.motores);
                }
                break;
                
            case "rueda":
                
                if (this.ruedas < this.maxRuedas){
                    if((this.ruedas + parts) > this.maxRuedas){
                        this.ruedas = this.maxRuedas;
                    }else{
                        this.ruedas += parts;
                    }
                    System.out.println("Ruedas: " + this.ruedas);
                }
                break;
                
            case "accesorio":
                
                if (this.accesorios < this.maxAccesorios){
                    this.accesorios += parts;
                    System.out.println("Accesorios: " + this.accesorios);
                }
                break;
                
            case "vehiculo":
                switch(name){
                    case "MA":
                        if((this.carrocerias>=1) && (this.chasis>=1) && (this.motores>=2) && (this.ruedas>=4)){
                            if(this.vehiculosE == (this.vehiculosA*2)){
                                this.vehiculosE += parts;
                                deleteParts(name, false);
                                System.out.println("Vehículos estándar: " + this.vehiculosE);
                            }else if((this.vehiculosE % 2 == 0)){
                                if(this.accesorios>=3){
                                    this.vehiculosA += parts;
                                    deleteParts(name, true);
                                    System.out.println("Vehículos con accesorios: " + this.vehiculosA);
                                }
                            }else{
                                this.vehiculosE += parts;
                                deleteParts(name, false);
                                System.out.println("Vehículos estándar: " + this.vehiculosE);
                            }
                        }
                        break;
                        
                    case "LA":
                        if((this.carrocerias>=1) && (this.chasis>=2) && (this.motores>=6) && (this.ruedas>=5)){
                            if(this.vehiculosE == (this.vehiculosA*3)){
                                this.vehiculosE += parts;
                                deleteParts(name, false);
                                System.out.println("Vehículos estándar: " + this.vehiculosE);
                            }else if((this.vehiculosE % 3 == 0)){
                                if(this.accesorios>=1){
                                    this.vehiculosA += parts;
                                    deleteParts(name, true);
                                    System.out.println("Vehículos con accesorios: " + this.vehiculosA);
                                }
                            }else{
                                this.vehiculosE += parts;
                                deleteParts(name, false);
                                System.out.println("Vehículos estándar: " + this.vehiculosE);
                            }
                        }
                        break;
                }
                break;
        }
    }
    
    public void deleteParts(String marca, boolean tipo){
        switch(marca){
            case "MA":
                this.chasis--;
                this.carrocerias--;
                this.motores -= 2;
                this.ruedas -= 4;
                
                if(tipo){
                    this.accesorios -= 3;
                }
                break;
                
            case "LA":
                this.chasis -= 2;
                this.carrocerias--;
                this.motores -= 6;
                this.ruedas -= 5;
                
                if(tipo){
                    this.accesorios--;
                }
                break;
        }
    }
    
    public void sendCars(){
        this.vehiculosA = 0;
        this.vehiculosE = 0;
    }
}
