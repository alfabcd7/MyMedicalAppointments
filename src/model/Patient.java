package model;


import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    private String blood;
    private double weight;
    private double height;
    private ArrayList<AppoinmentDoctor> appoinmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public  Patient(String name, String email , String phoneNumber) {
        super(name ,email,phoneNumber);

    }

    @Override
    public void showDataUser() {
        System.out.println(":" + "");
        System.out.println(""+ "");
        System.out.println(""+"");
    }

    public ArrayList<AppoinmentDoctor> getAppoinmentDoctors() {
        return appoinmentDoctors;
    }

    public void addAppoinmentDoctors(Doctor doctor , Date date , String time) {
        AppoinmentDoctor appoinmentDoctor = new AppoinmentDoctor(this,doctor);
        appoinmentDoctor.schedule(date,time);
        appoinmentDoctors.add(appoinmentDoctor);


    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
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

