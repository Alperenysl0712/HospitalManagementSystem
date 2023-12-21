import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;

    private Speciality speciality;

    public Appointment(Patient patient, Doctor doctor, LocalDate date, LocalTime time, Speciality speciality) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.speciality = speciality;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
}
