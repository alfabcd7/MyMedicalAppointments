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
           System.out.println("Patient");
           System.out.println("Welcome: " + patientLogged.getName()); //toma el valor del patient logeado definido desde la clase uiMenu
           System.out.println("1. Book an appointment"); //libros de citas definidas por los doctores
           System.out.println("2. My Appointments");//citas disponibles del usuario.
           System.out.println("0. Logout");

           Scanner sc = new Scanner(System.in);
           response = Integer.valueOf(sc.nextLine());

           switch (response){ // respuesta de menu Patient.
               case 1:
                   showBookAppointMenu();
                   break;
               case 2:
                   break;
               case 0:
                   showMenu();
                   break;
           }


       }while(response != 0);


   }
private static void showBookAppointMenu(){ // metodo que muestra libros de citas definidas por los doctores , las disponibles.
       int response = 0;
       do {
           System.out.println(":: Book an appointment");
           System.out.println(":: Select date: ");
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
           Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>();
           int k = 0; //Captura los primeros numeros de indice , la idea es que pueda perdurar en ambos For dando un Scope mas alto.
           for (int i = 0; i < doctorsAvailableAppointments.size() ; i++) {
               ArrayList<Doctor.availableAppointment> availableAppointments = doctorsAvailableAppointments.get(i).getAvailableAppointments();
               Map<Integer,Doctor> doctorAppointments = new TreeMap<>();
               for (int j = 0; j < availableAppointments.size() ; j++) {
                   System.out.println(k + "." + availableAppointments.get(j).getDate());
                   doctorAppointments.put(Integer.valueOf(j), doctorsAvailableAppointments.get(i));
                   doctors.put(k, doctorAppointments);
               }
           }
         Scanner sc = new Scanner(System.in);
           int responseDateSelected = Integer.valueOf(sc.nextLine());

       }while (response != 0);

}




}


