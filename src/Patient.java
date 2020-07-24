import javax.swing.*;

public class Patient extends User {
    private String blood;
    private double weight;
    private double height;

    Patient(String name, String email , String phoneNumber) {
        super(name ,email,phoneNumber);

    }

    public void setWeight(double weight) {

        this.weight = weight;
    }

    // kg String
    public String getWeight() {
        return this.weight + "Kg.";
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

