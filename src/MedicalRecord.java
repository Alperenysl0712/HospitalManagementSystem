import java.util.List;

public class MedicalRecord {
    private Doctor doctor;
    private Patient patient;
    private String diagnosis;
    private Treatment treatments;

    public MedicalRecord(Doctor doctor, Patient patient, String diagnosis, Treatment treatments) {
        this.doctor = doctor;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatments = treatments;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Treatment getTreatments() {
        return treatments;
    }

    public void setTreatments(Treatment treatments) {
        this.treatments = treatments;
    }

    @Override
    public String toString() {

        String out = "Diagnosis: " + diagnosis + "\n" +
                "Doctor: " + doctor.getName() + " (" + doctor.getSpeciality() + ")\n" +
                " Treatment; ";

        out += "\n" + treatments ;

        return out;
    }
}
