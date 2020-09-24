/*
OBSERVACIONES : Cosas para agregar a futuro.
1.- La fecha se repite , Ya no deberia pedirle si en algun momento ya la hemos seleccionado.
2.- Falta validacion de informacion ingresada.

 */

package ui;
import model.Doctor;
import static ui.UiMenu.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UiDoctorMenu {

    public static ArrayList <Doctor> doctorsAvailableAppointments = new ArrayList<>(); // se almacenara lista de doctores q tengan citas disponible (agenda disponible).



    public static void showDoctorMenu(){ //Este metodo se encarga de mostrar la logica de opciones para el doctor logeado
        int response = 0;
        do { // imprime el menu de Doctor.
            System.out.println("\n\n");
            System.out.println("Doctor");
            /* A continuacion llama la variable publica y estatica de la clase UiMenu "doctorLogged" (q es donde se contruyo el objeto Doctor en especifico),
            Ademas de asignada a la variable mencionada para que pueda ser consumida en esta clase en especifico.*/
            System.out.println("Welcome " + doctorLogged.getName());
            /*
            A continuacion esta Opcion permite al Doctor especificar las fechas en la que el esta disponible.
            Para hacerlo llama al metodo de esta misma clase llamado : showAddAvailableAppointmentsMenu() [Ver codigo abajo.]
             */
            System.out.println("1. add available Appointment");
            System.out.println("2. My scheduled appointments"); //Esta Opcion permite al Doctor permite ver el calendario fijado por cada paciente , en los horarios disponibles.
            System.out.println("0. Logout");// deslogear.

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2 :
                    break;
                case 0:
                    showMenu(); // llama al metodo showMenu() de la clase UiMenu.
                    break;
            }


        }while (response != 0); // si la respuesta es diferente a cero , repite.
    }
 private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {// imprime el menu de opciones de [1. add available Appointment] "
            System.out.println();
            System.out.println(":: add Available Appoinments"); // Impresion de titulo.
            System.out.println(" :: Select a Month");// impresion de instrucciones

               for (int i = 0; i < 12 ; i++) { // recorre 12 poscisiones , correspondiente a los 12 meses del año.
                    int j = i + 1; // aumenta la numeracion en +1 , ya que este correspondera al indice que se imprimira por pantalla. (NO puede empezar en cero.)
                    System.out.println(j + "." + MONTHS[i]);
               }
            System.out.println("0. Return"); // Ingresa 0 para retornar al menu anterior.
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine()); //recibe numero enteros.
                if (response > 0 && response < 13){
                    int monthSelected = response; //Asigno la respuesta en una variable cuyo nombre sea mas entendible.
                    System.out.println(monthSelected + "." + MONTHS[monthSelected-1]); // Imprime el mes seleccionado.
                    System.out.println("Insert the date available : [dd/mmm/yyyy]"); //insertar fechas disponibles para mostrar a los pacientes.
                    String date = sc.nextLine(); // captura el String ingresado por terminal.
                    /*
                    EL usuario debe definir si los datos ingresados son correctos o incorrectos.
                    */
                    System.out.println("Your date is : " + date + "\n1. Correct \n2. Change Date");//imprime un menu para validar la informacion ingresada.
                    int responseDate = Integer.valueOf(sc.nextLine()); // crea una nueva variable para capturar la respuesta de tipo entero.
                    if (responseDate == 2 ) continue;//En caso de no ser correcta la fecha vuelve a la condicion expuesta en el ambito del primer "do-while".
                    //--------------------------------------------//---------------------------------------------------------------
                    //Creando variables para almacenar la respuesta de tiempo disponible del doctor.
                    int responseTime = 0;
                    String time = "";
                    do { // En caso la fecha ingresada fue correcta , Imprime el menu para ingresar la "hora".
                        System.out.println("Insert the time available for date " + date + "[16:00]"); // var date [linea 66]
                        time = sc.nextLine(); //captura el string entrante.
                        System.out.println("Your time is: " + time +"\n1. Correct \n2. Change time");
                        responseTime = Integer.valueOf(sc.nextLine()); //recibe el sgte integer.
                    }while (responseTime == 2);//mientras responseTime es igual a 2 , repite.
            doctorLogged.addAvailableAppointment(date,time); //llama a un metodo en clas Doctor el cual agrega a un ArrayList el appointment el cual es una clase interna del mismo Doctor..
            checkDoctorAvailableApppointments(doctorLogged); // Llama al metodo para agregar dentro de un ArrayList q describa una lista de Doctores q tengan citas disponibles.
                    // el nombre del ArrayList es [doctorsAvailableAppointments].
                }else if (response == 0){ // Si se Elijo Return.
                    showDoctorMenu(); //Vuelve a llamar el menu de Doctores.
                }
        }while (response != 0);//Mientras la respuesta sea distinta de cero , repite.
 }
 private static void checkDoctorAvailableApppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){ //Si el Doctor si tiene citas y si no existe en el arreglo doctorsAvailableAppointments
            doctorsAvailableAppointments.add(doctor); //agregar ese doctor.
        }

 }


}
