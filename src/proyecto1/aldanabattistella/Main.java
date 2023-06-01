package proyecto1.aldanabattistella;

public class Main {
    public static Planta MaPlant;
    public static Planta LaPlant;

    public static void main(String[] args) {
        
        MaPlant = new Planta("MA", 14, 1000, 30, 3, 3, 2, 2, 2, 2);
        Interfaz interfaz = new Interfaz(); 
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
    }
        
}
