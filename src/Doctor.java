public class Doctor {
    static int id = 0; // autoincrement
    String name;
    String speciality;

    //metodos // comportamientos //methods
    Doctor(){
        System.out.println("Construyendo el Objeto Doctor : ");
        id++;

    }
    public void showName (){
        System.out.println(name);

    }
    public void showId(){
        System.out.println("Id Doctor : " + id);

    }
}
