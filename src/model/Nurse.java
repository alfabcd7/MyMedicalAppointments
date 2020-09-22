package model;

public class Nurse extends User {
    private String speciality;


    public Nurse(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital :" + "");
        System.out.println(""+ "");
        System.out.println(""+"");
    }


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
