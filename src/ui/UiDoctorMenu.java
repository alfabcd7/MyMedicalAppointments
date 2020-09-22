package ui;


import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UiDoctorMenu {

    public static ArrayList <Doctor> doctorsAvailableAppointments = new ArrayList<>(); // se almacenara lista de doctores q tengan citas disponible (agenda disponible).



    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UiMenu.doctorLogged.getName());
            System.out.println("1. add available Appointment");
            System.out.println("2. My scheduled appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2 :
                    break;
                case 0:
                    break;
            }


        }while (response != 0);
    }
 private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println(":: add Available Appoinments");
            System.out.println(" :: Select a Month");

            for (int i = 0; i < 3 ; i++) {
                int j = i + 1;
                System.out.println(j + "." + UiMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                int monthSelected = response;
                System.out.println(monthSelected + "." + UiMenu.MONTHS[monthSelected-1]);

                System.out.println("Insert the date available : [dd/mmm/yyyy]");
                String date = sc.nextLine();
                System.out.println("Your date is : " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2 ) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date " + date + "[16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time+"\n1. Correct \n2. Change time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime == 2);
                UiMenu.doctorLogged.addAvailableAppointment(date,time);
                checkDoctorAvailableApppointments(UiMenu.doctorLogged);
            }else if (response == 0){
                showDoctorMenu();
            }
        }while (response != 0);
 }
 private static void checkDoctorAvailableApppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }

 }


}
