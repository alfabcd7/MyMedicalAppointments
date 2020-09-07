
import model.Doctor;
import model.Patient;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
       Patient patient1 = new Patient("Alfredo Soria Añez" , "carlos.alfredo.soria@gmail.com" , "77047779");
       Doctor myDoctor = new Doctor("Alfredo Soria ", "alfredo.soria@gmail.com","71696273");
       myDoctor.addAvailableAppointment(new Date(),"4 pm");


        /*
          for (model.Doctor.availableAppointment aA: myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate() + " "+ aA.getTime());
        }

         */
        System.out.println(myDoctor);
     /*
      model.Doctor myDoctor ;
      myDoctor = new model.Doctor();
      myDoctor.name = "Carlos Alfredo Soria Escalante";
      myDoctor.speciality = "Cirujano CardioVascular";
      myDoctor.showName();
      myDoctor.showId();
        System.out.println(myDoctor.id);
    // Siempre que se cree un objeto del tipo doctor se defina un nuevo identificador
        model.Doctor helpDoctor = new model.Doctor();
        helpDoctor.name = "Alfredo Soria Añez";
        myDoctor.showName();
        myDoctor.showId();
        System.out.println(helpDoctor.id);
    */
      //showMenu(); // metodo estatico que esta siendo llamado desde el import de uiMenu (declarado en la cabecera)
      // el import de mienbros estaticos es importante ya que me ahorra el estar instanciando un objeto solo para utilizar  un metodo estatico
       // System.out.println(patient1.toString());



    }


}
