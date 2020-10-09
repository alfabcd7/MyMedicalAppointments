package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User { //hereda de "user".
    /*Variables Globales A la clase :*/
         //array de fechas disponibles.
         private ArrayList <availableAppointment>  availableAppointments = new ArrayList<>(); //aqui indico que tendre una coleccion de objetos de tipo availableAppointments(los q cree la subclase)
    //Atributos :
    private String speciality ;
    //constructor
    public Doctor(String name , String email , String phoneNumber){
        super(name,email,phoneNumber);  // se declara el metodo constructor de la clase Doctor el cual esta llamando al constructor de "user".
    }



    //getters.
    public String getSpeciality() {
        return speciality;
    }
    //Setters.
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    //metodos // comportamientos //methods
    public void addAvailableAppointment(String date, String time){ //metodo q añade nuevas citas desde un objeto tipo Doctor.
        availableAppointments.add(new availableAppointment(date,time)); //añade al array dinamico un nuevo objeto creado de la subclase availableAppointment cuyo constructor recibe las variables del metodo.
    }
    public ArrayList<availableAppointment> getAvailableAppointments() { //metodo q devuelve una coleccion de objetos de tipo availableAppointments en este caso los almacenados en el array con nombre  availableAppointments
        return availableAppointments;
    }
    //sobreescrituras//implementaciones.
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

    //--------------------------------------------//---------------------------------------------------------------
    //Clases Internas.
      //available appointment
    public static class availableAppointment{
        //Atributos Clase Interna :
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy"); // clase para formatear fechas.
        //constructor Clase Interna :
        public availableAppointment(String date, String time) {
            try { // Si se utilizan transformacion de datos , Se solicita que se manejen prevenciones y se usen excepciones.
                /*el metodo parse(String source) --> Date : recibe un string y lo transforma a un date
                * metodo format(Date date) --> String : Recibe un Date y transforma a String*/
            this.date = format.parse(date);
            }catch (ParseException e){
                e.printStackTrace();
            }
            this.time = time;
        }
        //getters.
        public int getId() {
            return id;
        }
        public String getTime() {
            return time;
        }
           //SobreCargar Getters.
                // "GetDate" :
                    public Date getDate() {
                    return date;
                    }
                    public String getDate(String DATE) { // el parametro de este metodo simplemente servira como "bandera" , para identificar q es un getdate que devuelve un String.
                    return format.format(date);
                    }
        //Setters.
        public void setId(int id) {
            this.id = id;
        }
        public void setDate(Date date) {
            this.date = date;
        }
        public void setTime(String time) {
            this.time = time;
        }
        //sobreescrituras//implementaciones :
        @Override
        public String toString() {
            return "availableAppointment\n" + ", date= " + this.date + "\ntime= " + this.time ;
        }
    }



}
