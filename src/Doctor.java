import java.util.Date;

public class Doctor extends User {




    private String speciality ;


    //available appointment

    //metodos // comportamientos //methods
    Doctor(String name , String email , String phoneNumber){
        super(name,email,phoneNumber);  // se declara el m2etodo constructor de la clase Doctor

        System.out.println("Construyendo el Objeto Doctor : "); // rutina que realizara cada que se cree el objeto
       //id++; // al instanciar el objeto el id sera incrementado.

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
