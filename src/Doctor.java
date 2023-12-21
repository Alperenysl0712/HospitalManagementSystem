import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Doctor extends User{
    private Speciality speciality;
    public Doctor(String name, LocalDate dateOfBirth, Gender gender, String contactInfo, int ID, String Password, List<Appointment> appointments, Speciality speciality) {
        super(name, dateOfBirth, gender, contactInfo, ID, Password, appointments);
        this.speciality = speciality;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}

enum Speciality{
    CARDIOLOGY,
    CHILD_HEALTH,
    NEUROLOGY,
    EYE_DISEASES,
    DERMATOLOGY;


    public String toString() {
        return switch (this) {
            case CARDIOLOGY -> "Cardiology";
            case CHILD_HEALTH -> "Child Health";
            case NEUROLOGY -> "Neurology";
            case EYE_DISEASES -> "Eye Diseases";
            case DERMATOLOGY -> "Dermatology";
            default -> null;
        };
    }
}
