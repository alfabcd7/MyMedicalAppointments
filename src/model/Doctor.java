package model;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private String speciality ;



    //metodos // comportamientos //methods
   public Doctor(String name , String email , String phoneNumber){
        super(name,email,phoneNumber);  // se declara el m2etodo constructor de la clase model.Doctor

        System.out.println("Construyendo el Objeto model.Doctor : "); // rutina que realizara cada que se cree el objeto
       //id++; // al instanciar el objeto el id sera incrementado.

    }



    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    ArrayList <availableAppointment>  availableAppointments = new ArrayList<>(); //aqui indico que tendre una coleccion de objetos de tipo availableAppointments(los q cree la subclase)
    public void addAvailableAppointment(Date date, String time){ //metodo q añade nuevas citas
        availableAppointments.add(new availableAppointment(date,time)); //añade al array dinamico un nuevo objeto creado de la subclase availableAppointment cuyo constructor recibe las variables del metodo.

    }

    public ArrayList<availableAppointment> getAvailableAppointments(){ //metodo q devuelve una coleccion de objetos de tipo availableAppointments en este caso los almacenados en el array con nombre  availableAppointments
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nspeciality='" + speciality + "\nAvailable: " +  availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital :" + "");
        System.out.println(""+ "");
        System.out.println(""+"");

    }

    //available appointment
    public static class availableAppointment{
        private int id;
        private Date date;
        private String time;

        public availableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "availableAppointment\n" + ", date= " + this.date + "\ntime= " + this.time ;
        }
    }



}
