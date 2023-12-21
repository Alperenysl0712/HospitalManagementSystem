import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    List<Doctor> cardiology, dermatology, neurology, child_health, eye_diseases, doctors;
    List<Patient> patients;
    Appointment appointment;

    Hospital hospital;
    public TestClass() {

        //*************************************** Doctors and Patients *********************************************

        Doctor doctor_1 = new Doctor("Berk Kutay", LocalDate.parse("1980-10-06"), Gender.MAN, "+905369251485", 1111, "dr1", null, Speciality.CARDIOLOGY);
        Doctor doctor_2 = new Doctor("Sarp", LocalDate.parse("1976-10-06"), Gender.MAN, "+905769551445", 2222, "dr2", null, Speciality.CARDIOLOGY);
        Doctor doctor_3 = new Doctor("Doc_3", LocalDate.parse("1985-11-17"), Gender.WOMAN, "+905263659845", 3333, "dr3", null, Speciality.DERMATOLOGY);
        Doctor doctor_4 = new Doctor("Doc_4", LocalDate.parse("1983-05-25"), Gender.MAN, "+902586325896", 4444, "dr4", null, Speciality.NEUROLOGY);
        Doctor doctor_5 = new Doctor("Doc_5", LocalDate.parse("1972-04-01"), Gender.WOMAN, "+901589632574", 5555, "dr5", null, Speciality.CHILD_HEALTH);
        Doctor doctor_6 = new Doctor("Doc_6", LocalDate.parse("1995-07-14"), Gender.WOMAN, "+903579657432", 6666, "dr6", null, Speciality.EYE_DISEASES);

        Patient patient_1 = new Patient("Alperen Burak Yesil", LocalDate.parse("2000-12-07"), Gender.MAN, "+905058126358", 7777, "patient1", null, null);


        cardiology = new ArrayList<>();
        dermatology = new ArrayList<>();
        neurology = new ArrayList<>();
        child_health = new ArrayList<>();
        eye_diseases = new ArrayList<>();
        doctors = new ArrayList<>();
        patients = new ArrayList<>();

        cardiology.add(doctor_1);
        cardiology.add(doctor_2);
        dermatology.add(doctor_3);
        neurology.add(doctor_4);
        child_health.add(doctor_5);
        eye_diseases.add(doctor_6);

        doctors.add(doctor_1);
        doctors.add(doctor_2);
        doctors.add(doctor_3);
        doctors.add(doctor_4);
        doctors.add(doctor_5);
        doctors.add(doctor_6);

        patients.add(patient_1);

        //*******************************************************************************************

        Department depDerm = new Department(Speciality.DERMATOLOGY, "Skin Health", dermatology);

        hospital = new Hospital("Şehir Hastanesi", "Eskişehir", "+902261589632", null);

        appointment = new Appointment(patient_1, doctor_1, LocalDate.parse("2023-06-12"), LocalTime.parse("11:25"), Speciality.CARDIOLOGY);

        hospital.makeAnAppointment(appointment);


        Treatment treatment_1 = new Treatment("Patient will use Antibyotic. He will a diet", LocalDate.parse("2023-06-12"));

        hospital.createAnMedicalRecord(new MedicalRecord(doctor_1, patient_1, "Patient has a heart disease.", treatment_1));


    }
}
