package co.edu.uptc.component;

public class Car {
    private String plate;
    private int model;
    private String color;
    private String typeCar;
    
    public Car(String plate, int model, String color, String typeCar) {
        this.plate = plate;
        this.model = model;
        this.color = color;
        this.typeCar = typeCar;
    }
    public String getTypeCar() {
        return typeCar;
    }
    public String getColor() {
        return color;
    }
    public String getPlate() {
        return plate;
    }
    public int getModel() {
        return model;
    }
    
    @Override
    public String toString() {
        return "Plate:" + plate + ", model:" + model + ", color:" + color + ", typeCar:" + typeCar;
    }

}
