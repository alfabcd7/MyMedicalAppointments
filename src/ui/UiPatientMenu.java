package ui;


import java.util.Scanner;

public class UiPatientMenu {

   public static void showPatientMenu(){
       int response = 0;
       do {
           System.out.println("\n\n");
           System.out.println("Patient");
           System.out.println("Welcome: " + UiMenu.patientLogged);
           System.out.println("1. Book an appointment");
           System.out.println("2. My Appointments");
           System.out.println("0. Logout");

           Scanner sc = new Scanner(System.in);
           response = Integer.valueOf(sc.nextLine());

           switch (response){
               case 1:
                   break;
               case 2:
                   break;
               case 0:
                   UiMenu.showMenu();
                   break;
           }


       }while(response != 0);


   }
private static void showBookAppointMenu(){
       int response = 0;
       do {
           System.out.println(":: Book an appointment");
           System.out.println(":: Select date: ");
           //numeracion de lista de fechas en el primer Integer
           // Indice fecha seleccionada.
           // [Doctors]
           //1.- doctors1
                //1.- fecha1
                //2.- fecha2
           //2.- doctors2
           //3.- doctors3


       }while (response != 0);

}




}
