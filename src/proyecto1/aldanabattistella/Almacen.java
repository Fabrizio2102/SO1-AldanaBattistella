package proyecto1.aldanabattistella;

public class Almacen {
    public int chasis, carrocerias, motores, ruedas, accesorios, vehiculos;
    public int maxChasis, maxCarrocerias, maxMotores, maxRuedas, maxAccesorios;
    
    public Almacen(int maxChasis, int maxCarrocerias, int maxMotores, int maxRuedas, int maxAccesorios){
        this.chasis = 0;
        this.carrocerias = 0;
        this.motores = 0;
        this.ruedas = 0;
        this.accesorios = 0;
        this.vehiculos = 0;
        
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
                    this.motores += parts;
                    System.out.println("Motores: " + this.motores);
                }
                break;
                
            case "rueda":
                
                if (this.ruedas < this.maxRuedas){
                    this.ruedas += parts;
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
                
                this.vehiculos += parts;
                deleteParts(name);
                System.out.println("Vehiculos: " + this.vehiculos);
                break;
        }
    }
    
    public void deleteParts(String marca){
        switch(marca){
            case "MA":
                this.chasis--;
                this.carrocerias--;
                this.motores -= 2;
                this.ruedas -= 4;
                break;
                
            case "LA":
                this.chasis -= 2;
                this.carrocerias--;
                this.motores -= 6;
                this.ruedas -= 5;
                break;
        }
    }
}
