public class User {
    //Atributos de SuperClase User.
    private static int id; // autoincrement // el primer valor de id sera 0
    // si la variable id no fuera estatica , cada vez que se inicilize Doctor el id se reiniciaria en cero
    //Al ser estatica el valor de la variable prevalece mas alla de la instaciacion del objeto.
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthday;

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 8) {
            System.out.println("El numero telefonico debe ser de 8 digitos");
        }
        else if (getPhoneNumber().length() == 8) {
            this.phoneNumber = phoneNumber;
        }

    }

    @Override // con la anotacion @override yo se que es un metodo que no es propio de la clase user sino es un metodo extraido de la superclase object
    public String toString() {
        return "User: " + name + ", Email: " + email + "\nAddress: " + address + ". Phone: " + phoneNumber;
    }
}
