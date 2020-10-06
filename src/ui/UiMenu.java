package ui;

import model.Doctor;
import model.Patient;
import static ui.UiDoctorMenu.*;
import static ui.UiPatientMenu.*;
import java.util.ArrayList;
import java.util.Scanner;


public class UiMenu {
    public static final String [] MONTHS = {"Enero" ,"Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public static Doctor doctorLogged; //Permitira llamar la variable de tipo Doctor(objeto) desde cualquier clase (Static).
    public static Patient patientLogged;//Permitira llamar la variable de tipo Patient(objeto) desde cualquier clase (Static).

    // showMenu Methods
    public static void showMenu(){
        //Saludo//
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");
        int response = 0;
        do { // Despliega opciones
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine()); //captura respuesta
            switch (response){
                /*
                Metodo authUser (Metodo que simulara la autentificacion de Usuario (Es Privado y Estatico).)
                <<Parametros>>
                userTye = 1 : Doctor
                userType = 2 Patient
                 */

                case 1:
                    System.out.println("model.Doctor");
                    authUser(1);
                    break;
                case 2:
                    System.out.println("model.Patient");
                    Patient p = new Patient("Alfredo Soria","carlos.alfredo.soria@gmail.com","77047779");
                    patientLogged = p;
                    showPatientMenu();
                    //authUser(2);
                    break;
                case 0: //Sake de la aplicacion
                    System.out.println("Thank you for you visit");
                    break;
                default: // En caso no sea ni 0 ,1 y 2.
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0); //Mientras no sea cero , Repite.
    }


    private static void authUser(int userType){ //Metodo que simulara la autentificacion de Usuario (Es Privado y Estatico).
        /* Reglas del Metodo , Si:
           1.- UserTye = 1 : Doctor.
           2.- userType = 2 Patient.
         */
        //--------------------------------------------//---------------------------------------------------------------
         //Simulacion de lista de Doctores Registrados.
        ArrayList <Doctor> doctors  = new ArrayList<>(); //lista que recibe datos de tipo "Doctor". (el tamaño es automatico).
        //Ingresando datos a la lista "doctors":
        doctors.add(new Doctor("Carlos Alfredo Soria Escalante" , "alfredo.soria@gmail.com" , "71696273"));
        doctors.add(new Doctor("Jorge Babdour" , " " , " "));
        doctors.add(new Doctor("Karen Sosa" , "Kare@gmail.com" , " "));
        //--------------------------------------------//---------------------------------------------------------------
        //Simulacion de lista de Pacientes Registrados.
        ArrayList<Patient> patients = new ArrayList <> ();//lista que recibe datos de tipo "Patiente". (el tamaño es automatico).
        //Ingresando datos a la lista "patients":
        patients.add(new Patient("Carlos Alfredo Soria Añez" , "carlos.alfredo.soria@gmail.com" , "77047779"));
        patients.add(new Patient("Gloria Añez Ribera" , "laprofegloria@gmail.com " , "72600448"));
        patients.add(new Patient("Rosa Maria Montaño Del Alcazar" , "montanorosi@gmail.com" , "75024644"));
        //Validacion del Email.-----------------------//---------------------------------------------------------------
        boolean emailCorrect = false ; // Variable booleana que identificara si el email ingresa es correcto // por defecto False.
       do {
           System.out.println("Insert your email: Example --> [a@a.com]"); //
           Scanner sc = new Scanner(System.in);
           String email = sc.nextLine(); // Recibe los caracteres de la terminal de Entrada.
           if(userType == 1){ // Si es es un tipo Doctor (la recibe desde el metodo showMenu)
                   for (Doctor d: doctors){ //recorre el ArrayList "doctors".
                       if (d.getEmail().equals(email)){ // si el atributo "email" del objeto Doctor es igual (equals) a el "email" ingresado.
                           emailCorrect = true; // cambia a true (se cumplio).
                           doctorLogged = d; //obtener el usuario logeado. //pasa la referencia de la variable "d" de tipo Doctor proveniente del Arraylist hacia otra var. del mismo tipo.
                           //showdoctorMenu
                        showDoctorMenu(); //llamada al metodo de la clase UiDoctorMenu.
                       }
                   }
           }
           else if (userType == 2){ // Si es es un tipo Patient (la recibe desde el metodo showMenu)
               for (Patient p: patients){  //recorre el ArrayList "patients".
                   if (p.getEmail().equals(email)){ // si el atributo "email" del objeto Patient es igual (equals) a el "email" ingresado.
                       emailCorrect = true;// cambia a true (se cumplio).
                       patientLogged = p; //obtener el usuario logeado. // pasa la referencia de la variable "p" de tipo Patient proveniente del Arraylist hacia otra var. del mismo tipo.
                       //showpatientMenu
                       showPatientMenu();//llamada al metodo de la clase UiPatientMenu.
                   }
               }

           }
       }while (!emailCorrect); //Si email es Falso ; Repite.
    }


    // showPatientMenu Methods
}
