import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class User {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String contactInfo;
    private int ID;
    private String Password;
    private List<Appointment> appointments;

    public User(String name, LocalDate dateOfBirth, Gender gender, String contactInfo, int ID, String Password, List<Appointment> appointments) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.ID = ID;
        this.Password = Password;
        this.appointments = appointments;
    }

    public boolean status(int ID, String Password){
        return this.ID == ID && this.Password.equals(Password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public int getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }
}

enum Gender{
    MAN,
    WOMAN;

    public String toString(){
        return switch (this) {
            case MAN -> "Man";
            case WOMAN -> "Woman";
            default -> null;
        };
    }
}
