import static ui.UiMenu.*;


public class Main {
    public static void main(String[] args) {
       Patient patient = new Patient("Alfredo Soria Añez" , "carlos.alfredo.soria@gmail.com" , "77047779");

     /*
      Doctor myDoctor ;
      myDoctor = new Doctor();
      myDoctor.name = "Carlos Alfredo Soria Escalante";
      myDoctor.speciality = "Cirujano CardioVascular";
      myDoctor.showName();
      myDoctor.showId();
        System.out.println(myDoctor.id);
    // Siempre que se cree un objeto del tipo doctor se defina un nuevo identificador
        Doctor helpDoctor = new Doctor();
        helpDoctor.name = "Alfredo Soria Añez";
        myDoctor.showName();
        myDoctor.showId();
        System.out.println(helpDoctor.id);
    */
      showMenu(); // metodo estatico que esta siendo llamado desde el import de uiMenu (declarado en la cabecera)
      // el import de mienbros estaticos es importante ya que me ahorra el estar instanciando un objeto solo para utilizar  un metodo estatico

    }


}
