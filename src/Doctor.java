public class Doctor {
    static int id = 0; // autoincrement // el primer valor de id sera 0
    // si la variable id no fuera estatica , cada vez que se inicilize Doctor el id se reiniciaria en cero
    //Al ser estatica el valor de la variable prevalece mas alla de la instaciacion del objeto.
    String name;
    String speciality;

    //metodos // comportamientos //methods
    Doctor(){  // se declara el metodo constructor de la clase Doctor
        System.out.println("Construyendo el Objeto Doctor : "); // rutina que realizara cada que se cree el objeto
        id++; // al instanciar el objeto el id sera incrementado.

    }
    public void showName (){
        System.out.println(name);

    }
    public void showId(){ // metodo para imprimir el Id del Doctor
        System.out.println("Id Doctor : " + id); // La variable "id" al vivir dentro de la clase Doctor no necesito hacer la clasica referencia de Doctor.id

    }
}
