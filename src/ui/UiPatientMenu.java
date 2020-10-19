package ui;


import model.Doctor;
import static ui.UiDoctorMenu.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static ui.UiMenu.*;

public class UiPatientMenu {

   public static void showPatientMenu(){
       int response = 0;
       do {// imprime el menu Patient.
           System.out.println("\n\n");
           System.out.println("Welcome Mr/Ms.: " + patientLogged.getName()  + " Please,Choose one of the following options."); //toma el valor del patient logeado definido desde la clase uiMenu
           System.out.println(">1.Show Book an appointment Doctor Available"); //libros de citas definidas por los doctores
           System.out.println(">2.Show My Appointments");//citas disponibles del usuario.
           System.out.println(">0.Logout");
           //..
           Scanner sc = new Scanner(System.in);
           response = Integer.valueOf(sc.nextLine());
           //..
           switch (response){ // respuesta de menu Patient.
               case 1:
                   showBookAppointMenu();
                   break;
               case 2:
                   showPatientMyAppointments();
                   break;
               case 0:
                   do { //Bucle para Opciones de Logout
                       System.out.println("::¿Are you sure that do you want to logout?");
                       System.out.println("\n>1.-Yes \n>2.-No");
                       response = Integer.valueOf(sc.nextLine());
                       System.out.println("\n");
                       if (response == 1) { //SI la Respuesta es SI deseo salir
                           System.out.println("\n ::Thank you For your Visit,Mr/Ms.: " + patientLogged.getName() + ",See you later \n\n");
                           showMenu(); // llama al metodo showMenu() de la clase UiMenu.
                       } else if (response == 2) { //Si es NO , Sale del Bucle Y vuelve al anterior Bucle de Menu Doctor
                           System.out.println("::¡¡I Got iT!!\n\n");
                       } else {
                           System.out.println("::Error,That is not an Available Option,Try Again");
                       }
                   }while (response != 2) ; // Mientras sea diferente de 2 , repite.
                   break;
               default:
                   System.out.println("::Error,That is not an Available Option,Try Again");
                   break;
           }
       }while(response != 0);
   }
private static void showBookAppointMenu(){ // metodo que muestra libros de citas definidas por los doctores , las disponibles.
       int response = 0;
       do {
           System.out.println("::Book an appointment");
           System.out.println("::Select date: ");
           //primer key numeracion de lista de fechas en el primer Integer
           //
           // el segundo key Indice sera la fechas
           // .
           // [Doctors]
           //1.- doctors1
                //1.- fecha1
                //2.- fecha2
           //2.- doctors2
           //3.- doctors3
           Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>(); // crea un Map del tipo Treemap con una Key que desencadena otro TreeMap Anidado.
           int k = 0; //Captura los primeros numeros de indice , la idea es que pueda perdurar en ambos For dando un Scope mas alto.
           for (int i = 0; i < doctorsAvailableAppointments.size() ; i++) { // Mientras i Sea menor al numero de elementos contenidos en "doctorsAvailableAppointments", Produce Una iteracion.
               ArrayList<Doctor.availableAppointment> availableAppointments = doctorsAvailableAppointments.get(i).getAvailableAppointments();//En cada Iteracion se crea y obtiene el ArrayList "availableAppointments" de un doctor en particular en la presente clase.
               Map<Integer,Doctor> doctorAppointments = new TreeMap<>(); // Se crea un TreeMap con el nombre "doctorAppointments".
               for (int j = 0; j < availableAppointments.size() ; j++) { // For dedicado a iterar el ArrayList "availableAppointments" del doctor especificado en la aun presente iteracion por parte de "i".
                   System.out.println(">"+ ++k + "." + availableAppointments.get(j).getDate());//Imprime por terminal una lista de fechas disponibles en orden el cual fueron agregadas las citas.
                   doctorAppointments.put(Integer.valueOf(j), doctorsAvailableAppointments.get(i));//Ingresa en el treemap "doctorAppoinments" en primer la clave con el valor de "j" y el doctor seleccionado por la iteracion "i" como su correspondiente valor a dicha clave.
                   doctors.put(k, doctorAppointments);//Ingresa en el treemap "doctors" en primer la clave con el valor de "k" y como valor el treemap "doctorAppoinments"
               }
           }
         Scanner sc = new Scanner(System.in);
           int responseDateSelected = Integer.valueOf(sc.nextLine());
           Map<Integer,Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
           Integer indexDate = 0;
           Doctor doctorSelected = new Doctor("","","");
           for (Map.Entry<Integer,Doctor> doc : doctorAvailableSelected.entrySet()){
               indexDate = doc.getKey();
               doctorSelected = doc.getValue();
           }
           System.out.printf(doctorSelected.getName() +
                   ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate()
                   +". Time: "+ doctorSelected.getAvailableAppointments().get(indexDate).getTime() );
           System.out.println("confirm you appointment : \n 1.yes \n 2. Change Data");
           response = Integer.valueOf(sc.nextLine());


       }while (response != 0);

}
private static void showPatientMyAppointments(){
       int response = 0;
       do {
           System.out.println("::My Appointments");
           if (patientLogged.getAppoinmentDoctors().size() == 0){
               System.out.printf("Don`t have Appointments");
               break; // se sale del bucle
           }
           for (int i = 0; i < patientLogged.getAppoinmentDoctors().size() ; i++) {
               int j = i + 1;
               System.out.println(j + ". " + "Date: " + patientLogged.getAppoinmentDoctors().get(i).getDate() +
                       ". Time : " + patientLogged.getAppoinmentDoctors().get(i).getTime() +
                       "\n Doctor: " + patientLogged.getAppoinmentDoctors().get(i).getDoctor());
           }
           System.out.println("0 . Return");
       }while (response != 0);
}




}


