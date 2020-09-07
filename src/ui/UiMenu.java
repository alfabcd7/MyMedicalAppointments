package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {
    // final permite que su valor nunk sea reasignado
    public static final String [] MONTHS = {"Enero" ,"Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    // showMenu Methods
    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("model.Doctor");
                    authUser(1);
                    break;
                case 2:
                    System.out.println("model.Patient");
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }


    private static void authUser(int userType){
        //userTye = 1 : Doctor
        //userType = 2 Patient

        ArrayList <Doctor> doctors  = new ArrayList<>();
        doctors.add(new Doctor("Carlos Alfredo Soria Escalante" , "alfredo.soria@gmail.com" , "71696273"));
        doctors.add(new Doctor("Jorge Babdour" , " " , " "));
        doctors.add(new Doctor("Karen Sosa" , "Kare@gmail.com" , " "));

        ArrayList<Patient> patients = new ArrayList <> ();

        patients.add(new Patient("Carlos Alfredo Soria Añez" , "carlos.alfredo.soria@gmail.com" , "77047779"));
        patients.add(new Patient("Gloria Añez Ribera" , "laprofegloria@gmail.com " , "72600448"));
        patients.add(new Patient("Rosa Maria Montaño Del Alcazar" , "montanorosi@gmail.com" , "75024644"));

        boolean emailCorrect = false ;
       do {
           System.out.println("Insert your email: [a@a.com]");
           Scanner sc = new Scanner(System.in);
           String email = sc.nextLine();
           if(userType == 1){
                   for (Doctor d: doctors){
                       if (d.getEmail().equals(email)){
                           emailCorrect = true;
                           //obtener el usuario logeado
                           doctorLogged = d;
                           //showdoctorMenu
                       }
                   }
           }
           else if (userType == 2){
               for (Patient p: patients){
                   if (p.getEmail().equals(email)){
                       emailCorrect = true;
                       //obtener el usuario logeado
                       patientLogged = p;
                       //showdoctorMenu
                   }
               }

           }
       }while (!emailCorrect);
    }


    // showPatientMenu Methods

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 4 ; i++) {
                        System.out.println(i + "." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }


}
