package Lessons;

public class Car {
     String type;
     String model;

    Car(String type,String model){
        this.type = type;
        this.model = model;

    }

    public String getType(){
        return  type;
    }

    public  String getModel(){
        return model;
    }

    @Override
    public String toString() {
        return  "Модель='" + model;
    }
}
