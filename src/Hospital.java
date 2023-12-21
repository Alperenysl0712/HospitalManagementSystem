import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String name;
    private String address;
    private String phone;
    private List<Department> departments;


    public Hospital(String name, String address, String phone, List<Department> departments) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.departments = departments;
    }

    public void makeAnAppointment(Appointment appointment){
        List<Appointment> Papp = appointment.getPatient().getAppointments() != null ? appointment.getPatient().getAppointments() : new ArrayList<>();
        Papp.add(appointment);
        List<Appointment> Dapp = appointment.getDoctor().getAppointments() != null ? appointment.getDoctor().getAppointments() : new ArrayList<>();
        Dapp.add(appointment);
        appointment.getPatient().setAppointments(Papp);
        appointment.getDoctor().setAppointments(Dapp);
    }

    public void createAnMedicalRecord(MedicalRecord medicalRecord){
        List<MedicalRecord> Pmr = medicalRecord.getPatient().getMedicalRecords() != null ? medicalRecord.getPatient().getMedicalRecords() : new ArrayList<>();
        Pmr.add(medicalRecord);
        medicalRecord.getPatient().setMedicalRecords(Pmr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
