import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Patient extends User {

    private List<MedicalRecord> medicalRecords;

    public Patient(String name, LocalDate dateOfBirth, Gender gender, String contactInfo, int ID, String Password, List<Appointment> appointments, List<MedicalRecord> medicalRecords) {
        super(name, dateOfBirth, gender, contactInfo, ID, Password, appointments);
        this.medicalRecords = medicalRecords;
    }


    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
