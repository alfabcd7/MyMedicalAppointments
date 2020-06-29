import static ui.UiMenu.*;


public class Main {
    public static void main(String[] args) {
      Doctor myDoctor = new Doctor();
      myDoctor.name = "Carlos Alfredo Soria Escalante";
      myDoctor.speciality = "Cirujano CardioVascular";
      myDoctor.showName();
      myDoctor.showId();
        System.out.println(myDoctor.id);

        Doctor helpDoctor = new Doctor();
        helpDoctor.name = "Alfredo Soria Añez";
        myDoctor.showName();
        myDoctor.showId();
        System.out.println(helpDoctor.id);
    }


}
