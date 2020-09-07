package model;

public abstract class User {
    //Atributos de SuperClase model.User.
    private static int id; // autoincrement // el primer valor de id sera 0
    // si la variable id no fuera estatica , cada vez que se inicilize model.Doctor el id se reiniciaria en cero
    //Al ser estatica el valor de la variable prevalece mas alla de la instaciacion del objeto.
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthday;

    //constructor.
    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    //Getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 8) {
            System.out.println("El numero telefonico debe ser de 8 digitos");
        }
        else if (getPhoneNumber().length() == 8) {
            this.phoneNumber = phoneNumber;
        }

    }
    //polimorfismo
    /*
    Sobreescribiendo el metodo toString() proveniene de la clase object.
     */
    @Override // con la anotacion @override yo se que es un metodo que no es propio de la clase user sino es un metodo extraido de la superclase object
    public String toString() {
        return "model.User: " + this.name + ", Email: " + this.email + "\nAddress: " + this.address + ". Phone: " + this.phoneNumber;
    }
    //abstract
    public abstract void showDataUser();
}
