/*
OBSERVACIONES : Cosas para agregar a futuro.
1.- La fecha se repite , Ya no deberia pedirle si en algun momento ya la hemos seleccionado.
2.- Falta validacion de informacion ingresada.

 */

package ui;
import model.Doctor;
import static ui.UiMenu.*;

import java.sql.SQLOutput;
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
            //Se consume doctorLogged llamando al metodo q obtiene el atributo name del doctor en especifico.// doctorLogged es llamado desde ui.Menu
            System.out.println("Welcome Dr " + doctorLogged.getName() + " Please , Choose an option.");
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
 private static void showAddAvailableAppointmentsMenu() {
     boolean selectionMonth = false;
     int response = 0;
     String [] text = new String [10] ;
     text[0] = "::You have chosen the following Option ::";
     text[1] = "\n  >1. Correct \n  >2. No , I want to Change \n  >3. I want to go back to the month selection menu";
     text[2] = "\n::Backing to the Doctor Menu";
     text[3] = "      >I got you!!,Selection confirmed, So lets move on!!\n";
     text[4] = "    >Ok , No Problem , You can change it!!";
     text[5] = ">!Ok¡ , No Problem , Lest Go To the month selection menu!!";
     text[6] = "\n:: Error , that is not an Correct Option , Try Again" ;
     do {// Incio "Do - while" de Selection Month.
         boolean   confirmationTime = false , insertionDate = false , insertionTime = false , confirmationDate = false ;
         selectionMonth = false;
         System.out.println();
         System.out.println("::Welcome to add Available Appoinment option Menu"); // Impresion de titulo.
         System.out.println("::Please , Select a Month");// impresion de instrucciones
         //...
         for (int i = 0; i < 12; i++) { // recorre 12 poscisiones que corresponden a los 12 meses del año.
             int j = i + 1; // aumenta la numeracion en +1 , corresponde al indice que se imprime por pantalla. (NO puede empezar en cero.)
             System.out.println("    >" + j + "." + MONTHS[i]); // Imprime los dos meses.
         }
         System.out.println(">0. Return"); // Opcion para retornar al menu.
         //..
         Scanner sc = new Scanner(System.in); // Clase Scanner.
         response = Integer.valueOf(sc.nextLine()); //Variable que recibe la respuesta.
         //...
         if (response > 0 && response < 13) { // Si response es entre 1 y 12 ...Entra al bucle.
             int monthSelected = response; //Asigno la respuesta en una variable cuyo nombre sea mas entendible.
             do {// Inicio de "Do-While" de Insertion Date
                 insertionDate = false;
                 System.out.println(text[0] + monthSelected + "." + MONTHS[monthSelected - 1]); // Imprime el mes seleccionado.
                 System.out.println("::You have confirmated the Month , so...We are going to Insert a date now.");
                 System.out.println("::Please , Insert the date available to " + MONTHS[monthSelected - 1] + " Example --> [dd/mm/yyyy]"); //insertar fechas disponibles para mostrar a los pacientes.
                 String dateStringCatch = sc.nextLine(); // captura el String ingresado por terminal.
                 do { // Inicio de "Do-While" de Confirmation Date
                     /* el usuario debe definir si los datos ingresados son correctos o incorrectos.*/
                     confirmationDate = false;
                     System.out.println(text[0] + " date : " + dateStringCatch + text[1]);//imprime un menu para validar la informacion ingresada.
                     response = Integer.valueOf(sc.nextLine()); // vuelve a capturar la respuesta en la misma variable response.
                     switch (response) { // Inicio de "Switch" de Confirmation Date
                         case 1:
                             int responseTime = 0;
                             String timeStringCatch = "";
                             System.out.println(text[3]); //"      I got you!!,Selection confirmed, So lets move on!!\n"
                             do { // Inicio de "Do-while" de Insertion Time
                                 insertionTime = false;
                                 System.out.println("::Insert the time available to the following date : " + dateStringCatch + " Format Example -->[16:00]");
                                 timeStringCatch = sc.nextLine(); //captura el string entrante.
                                 do { // Inicio de "Do-while" de Confirmation Time
                                     confirmationTime = false;
                                     System.out.println(text[0] + " time : " + timeStringCatch + text[1] + "\n  4.- I want to Choose Another date.");
                                     responseTime = Integer.valueOf(sc.nextLine()); //recibe el sgte integer.
                                     switch (responseTime) { // Inicio de "Switch" de Confirmation Time
                                         case 1:
                                             System.out.println(text[3]); //"      I got you!!,Selection confirmed, So lets move on!!\n"
                                             doctorLogged.addAvailableAppointment(dateStringCatch, timeStringCatch); //llama a un metodo en clas Doctor el cual agrega a un ArrayList el appointment el cual es una clase interna del mismo Doctor..
                                             checkDoctorAvailableApppointments(doctorLogged); // Llama al metodo para agregar dentro de un ArrayList q describa una lista de Doctores q tengan citas disponibles.
                                             // el nombre del ArrayList es [doctorsAvailableAppointments].
                                             System.out.println("::Appointment Doctor Date available Registered");
                                             do {
                                                 System.out.println("::Do you want add another Date Month or finished Menu an back to Doctor Menu?¿");
                                                 System.out.println("\n >1.- Add another time\n >2.- Add another Date\n >3.- Choose another Month\n >4.- Back to Doctor Menu");
                                                 response = Integer.valueOf(sc.nextLine());
                                                 switch (response) { // Inicio Switch
                                                     case 1:
                                                         confirmationTime = true;
                                                         break;
                                                     case 2:
                                                         confirmationTime = true;
                                                         insertionTime = true;
                                                         confirmationDate = true;
                                                         break;
                                                     case 3:
                                                         confirmationTime = true;
                                                         insertionTime = true;
                                                         confirmationDate = true;
                                                         insertionDate = true;
                                                         break;
                                                     case 4:
                                                         confirmationTime = true;
                                                         insertionTime = true;
                                                         confirmationDate = true;
                                                         insertionDate = true;
                                                         selectionMonth = true;
                                                         break;
                                                     default:
                                                         System.out.println(text[6]);
                                                         break;
                                                 }//final switch
                                             }while (response > 5 );
                                             break;
                                         case 2:
                                             System.out.println(text[4]);
                                             confirmationTime = true; // repetir
                                             break;
                                         case 3:
                                             System.out.println(text[5]);
                                          confirmationTime = true;
                                          insertionTime = true ;
                                          confirmationDate = true;
                                          insertionDate = true;
                                             break;
                                         case 4:
                                             System.out.println(text[4]);
                                             confirmationTime = true;
                                             insertionTime = true ;
                                             confirmationDate = true;
                                             break;
                                         default:
                                             System.out.println(text[6]);
                                             confirmationTime = false;
                                             break;
                                     } // Fin de "Switch" de Confirmation Time
                                 } while (!confirmationTime); // fin de "Do - while" de confirmation Time
                             }while (!insertionTime);// Fin de "Do-while" de Insertion Time
                             break;
                         case 2:
                             System.out.println(text[4]);
                             confirmationDate = true;
                             break;
                         case 3:
                             System.out.println(text[5]);
                             confirmationDate = true;
                             insertionDate = true;
                             break;
                         default:
                             System.out.println(text[6]);
                             confirmationDate = false;
                             break;
                     }// Fin de "Switch" de Confirmation Date
                 } while (!confirmationDate); //fin de "Do-while" de Confirmation Date.
             }while(!insertionDate); //fin de "Do-while" de Insertion Date.
         }else if(response == 0) { // Si se Elijo Return.
             System.out.println(text[2]);
             selectionMonth = true ;
         } else {
             System.out.println(text[6]);
             selectionMonth = true;
         }
     }while (!selectionMonth); // Fin "Do - while" de Selection Month.
     showDoctorMenu(); //Vuelve a llamar el menu de Doctores.
}
 private static void checkDoctorAvailableApppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){ //Si el Doctor si tiene citas y si no existe en el arreglo doctorsAvailableAppointments
            doctorsAvailableAppointments.add(doctor); //agregar ese doctor.
        }

 }
 private void printConfirmationDateTime(boolean date , boolean time , int response){
        /* date = true , Tomara encuenta los textos para date.
        *  date = false ,No Tomara encuenta los textos para date.
        *time = true , Tomara encuenta los textos para time.
        * time = false , No Tomara encuenta los textos para time.
        *  */



     if (date == true && time == false) {


     }


 }


}
