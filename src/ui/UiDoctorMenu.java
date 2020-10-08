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
    /* 1.-Variables Globales A la clase :*/
          /* 1.1.- Variables Estaticas.
          *     1.1.1.- ArrayList*/
                public static ArrayList <Doctor> doctorsAvailableAppointments = new ArrayList<>(); // Lista donde se almacenara doctores q tengan citas disponible
                // (Confirmaron Fechas y Figuran con agendas disponibles).
    /*
    Metodos Estaticos / Static Methods*/
               //showDoctorMenu() //Este metodo se encarga de mostrar las opciones para el doctor logeado y derivar la logica a otros metodos.
    public static void showDoctorMenu() {
        int response = 0;
        do { // Inicio del "do" cuyo cuerpo estara encargado de imprimir el "menu Doctor".
            System.out.println("\n\n");
            System.out.println("Doctor");
            //Se consume doctorLogged llamando al metodo q obtiene el atributo name del doctor en especifico.// doctorLogged es llamado desde ui.Menu
            System.out.println("Welcome " + doctorLogged.getName());
            System.out.println("1. add available Appointment"); // Opcion para llamar al metodo "showAddAvailableAppointmentsMenu"
            System.out.println("2. My scheduled appointments"); //Opcion permite al Doctor permite ver el calendario fijado por cada paciente , en los horarios disponibles.
            System.out.println("0. Logout");// salir de la sesion

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    do { //Bucle para Opciones de Logout
                        System.out.println(":: Are you sure , do you want to logout?");
                        System.out.println("\n 1.- Yes \n 2.- No");
                        response = Integer.valueOf(sc.nextLine());
                        System.out.println("\n");
                        if (response == 1) { //SI la Respuesta es SI deseo salir
                            System.out.println("\n :: Thank you For your Visit, Dr " + doctorLogged.getName() + " , See you later \n\n");
                            showMenu(); // llama al metodo showMenu() de la clase UiMenu.
                        } else if (response == 2) { //Si es NO , Sale del Bucle Y vuelve al anterior Bucle de Menu Doctor
                            System.out.println("::Catch it \n\n");
                        } else {
                            System.out.println(":: Error , that is not an Correct Option , Try Again");
                        }
                    }while (response != 2) ; // Mientras sea diferente de 2 , repite.
                    break;
            }
        }while (response != 0) ; // si la respuesta es diferente a cero , repite.
    }
 private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {// imprime el menu de opciones de [1. add available Appointment] "
            System.out.println();
            System.out.println(":: Welcome to add Available Appoinment option Menu"); // Impresion de titulo.
            System.out.println(":: Please , Select a Month");// impresion de instrucciones

            for (int i = 0; i < 12; i++) { // recorre 12 poscisiones , correspondiente a los 12 meses del año.
                int j = i + 1; // aumenta la numeracion en +1 , ya que este correspondera al indice que se imprimira por pantalla. (NO puede empezar en cero.)
                System.out.println(j + "." + MONTHS[i]);
            }

            System.out.println("0. Return"); // Ingresa 0 para retornar al menu anterior.

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine()); //recibe numero enteros.

            if (response > 0 && response < 13) { // La respuesta esta dada entre 1 y 12.
                int monthSelected = response; //Asigno la respuesta en una variable cuyo nombre sea mas entendible.

                System.out.println("::You have choosen " + monthSelected + "." + MONTHS[monthSelected - 1]); // Imprime el mes seleccionado.
                do {
                    System.out.println("   1.- I screwed up , I want to Choose another Month.");
                    System.out.println("   2.- Yes , That is it ,So I want to Insert an Available date to receipt Patients");

                    response = Integer.valueOf(sc.nextLine());

                    switch (response) {
                        case 1:
                            break;
                        case 2:
                            do{
                            System.out.println(":: Please , Insert the date available to " + " : [dd/mm/yyyy]"); //insertar fechas disponibles para mostrar a los pacientes.
                            String dateStringReceipt = sc.nextLine(); // captura el String ingresado por terminal.
                             /*
                             el usuario debe definir si los datos ingresados son correctos o incorrectos.
                             */
                            System.out.println("Your date is : " + dateStringReceipt + "\n  1. Correct \n  2. Change Date \n 3. I want to go back to the month selection menu");//imprime un menu para validar la informacion ingresada.
                            int responseDate = Integer.valueOf(sc.nextLine()); // crea una nueva variable para capturar la respuesta de tipo entero.
                            switch(responseDate){
                                case 1 :
                                    break;
                                case 2:
                                    break;
                                case 3 :
                                    break;
                                default :
                                    break;
                                }
                                if (responseDate == 2)
                                continue;//En caso de no ser correcta la fecha vuelve a la condicion expuesta en el ambito del primer "do-while"

                            while (responseDate != 1)
                            //--------------------------------------------//---------------------------------------------------------------
                            //Creando variables para almacenar la respuesta de tiempo disponible del doctor.
                            int responseTime = 0;
                            String time = "";
                            do { // En caso la fecha ingresada fue correcta , Imprime el menu para ingresar la "hora".
                                System.out.println("Insert the time available for date " + dateStringReceipt + "[16:00]"); // var date [linea 66]
                                time = sc.nextLine(); //captura el string entrante.
                                System.out.println("Your time is: " + time + "\n1. Correct \n2. Change time");
                                responseTime = Integer.valueOf(sc.nextLine()); //recibe el sgte integer.
                            } while (responseTime == 2);//mientras responseTime es igual a 2 , repite.
                            doctorLogged.addAvailableAppointment(dateStringReceipt, time); //llama a un metodo en clas Doctor el cual agrega a un ArrayList el appointment el cual es una clase interna del mismo Doctor..
                            checkDoctorAvailableApppointments(doctorLogged); // Llama al metodo para agregar dentro de un ArrayList q describa una lista de Doctores q tengan citas disponibles.
                            // el nombre del ArrayList es [doctorsAvailableAppointments].
                    }else if (response == 0) { // Si se Elijo Return.
                        showDoctorMenu(); //Vuelve a llamar el menu de Doctores.
                        System.out.println("y luego?");
                    } else {
                        System.out.println("\n:: Error , that is not an Correct Option , Try Again\n");
                    }
                    break;
                    case
                    default:
                        break;

                 }while(response != 0) ;

              }
           }

        }while (response != 0);//Mientras la respuesta sea distinta de cero , repite.
 }
 private static void checkDoctorAvailableApppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){ //Si el Doctor si tiene citas y si no existe en el arreglo doctorsAvailableAppointments
            doctorsAvailableAppointments.add(doctor); //agregar ese doctor.
        }

 }


}
