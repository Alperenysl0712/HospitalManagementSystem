import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Test {
    static TestClass testClass = new TestClass();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        while (true){

            User activeUser = Login();

            if (activeUser == null){
                System.out.println("There is no this type user");
                continue;
            }

            int status = Options(activeUser);

            if (status == -1){
                System.out.println("Have a good day " + activeUser.getName());
                return;
            }

        }
    }

    public static User Login(){

        System.out.println("******************* Hospital Management System *******************");
        System.out.print("ID: ");
        int ID = input.nextInt();
        System.out.print("Password: ");
        String Password = input.next();
        System.out.println("******************************************************************");


        for (Doctor doctor : testClass.doctors){
            if (doctor.status(ID, Password)){
                System.out.println("---------- Dr." + doctor.getName() + " - " + doctor.getSpeciality() + " - " + LocalDate.now() + " ----------");
                return doctor;
            }
        }

        for (Patient patient : testClass.patients){
            if (patient.status(ID, Password)){
                System.out.println("---------- " + patient.getName() + " - " + LocalDate.now() + " ----------");
                return patient;
            }
        }

        return null;
    }

    public static int Options(User user){
        String userType = ((Object) user).getClass().getSimpleName();

        int option = 0;
        while (true){
            System.out.println("For logout => 0\nFor exit => -1\n");

            if (userType.equals("Doctor")){
                System.out.println("Options;");
                System.out.println(" 1) Appointments");
                System.out.println(" 2) Show Medical Record of Patients");
                System.out.println(" 3) Create Medical Record");
                System.out.print("Select Option: ");
                option = input.nextInt();

                if (!(-1 <= option && option <= 3)){
                    System.out.println("Please try again");
                    continue;
                }

                else if (option == 1){
                    List<Appointment> docAppointment = user.getAppointments();

                    System.out.println("\n************************************ Appointments ******************************************\n");
                    System.out.println("     Patient        -      " + "Date     -   " + "Time");
                    for (Appointment appointment : docAppointment){
                        String appointmentStr = appointment.getPatient().getName() + "  -  " + appointment.getDate() + "  -  " + appointment.getTime();
                        System.out.println(appointmentStr);
                    }
                    System.out.println("\n********************************************************************************************\n");
                }

                else if (option == 2){
                    queryMedicalRecords("Doctor", user);
                }

                else if (option == 3){
                    createAMedicalRecord(user);
                }
            }

            else if (userType.equals("Patient")){
                System.out.println("Options;");
                System.out.println(" 1) Appointments");
                System.out.println(" 2) Make an Appointment");
                System.out.println(" 3) Medical Records");

                System.out.print("Select Option: ");
                option = input.nextInt();

                if (!(-1 <= option && option <= 3)){
                    System.out.println("Please try again");
                    continue;
                }

                else if (option == 1){
                    List<Appointment> patientAppointment = user.getAppointments();

                    System.out.println("\n************************************ Appointments ******************************************\n");
                    System.out.println("   Doctor    -       " + "Date     -   " + "Time   -  " + "Department");
                    for (Appointment appointment : patientAppointment){
                        String appointmentStr = "Dr." + appointment.getDoctor().getName() + "  -  " + appointment.getDate() + "  -  " + appointment.getTime() + "  -  " + appointment.getSpeciality();
                        System.out.println(appointmentStr);
                    }
                    System.out.println("\n********************************************************************************************\n");

                }

                else if (option == 2){
                    makeAnAppointment(user);
                }

                else if (option == 3){
                    queryMedicalRecords("Patient", user);
                }
            }

            if (option == 0) {
                return 0;
            }

            else if (option == -1){
                return -1;
            }


        }
    }

    private static void createAMedicalRecord(User user) {
        System.out.println("\n*-*-*-*-*- Create a Medical Record -*-*-*-*-*\n");

        while (true){

            List<Appointment> docAppointments = user.getAppointments();
            Dictionary<Integer, Patient> patientDict = new Hashtable<>();

            int index = 1;

            System.out.println("  Patients;");
            for (Appointment appointment: docAppointments){
                System.out.println("   " + index + ") " + appointment.getPatient().getName());
                patientDict.put(index, appointment.getPatient());
                index++;
            }
            System.out.println("For exit => 0\n");

            System.out.print("Which patient: ");
            int Selection = input.nextInt();

            if (Selection == 0){
                return;
            }

            Patient patient = patientDict.get(Selection);  // Patient selected

            System.out.print("\nWhat is the diagnosis: ");
            String diagnosis = input.next();

            System.out.print("\nWhat is the description of treatment: ");
            String description = input.next();

            MedicalRecord new_medicalRecord = new MedicalRecord((Doctor) user, patient, diagnosis, new Treatment(description, LocalDate.now()));

            testClass.hospital.createAnMedicalRecord(new_medicalRecord);

            System.out.print("\nWill you create another Medical Record (Yes or No): ");
            String answer = input.next();

            if (answer.equalsIgnoreCase("yes")){
                continue;
            }
            if (answer.equalsIgnoreCase("no")){
                return;
            }
        }

    }

    private static void queryMedicalRecords(String userType, User user) {
        if (userType.equals("Doctor")){
            while (true){
                List<Appointment> docAppointment = user.getAppointments();
                Dictionary<Integer, Patient> patientDict = new Hashtable<>();

                int index = 1;

                System.out.println("\n  Patients;");
                for (Appointment appointment: docAppointment){
                    System.out.println("   " + index + ") " + appointment.getPatient().getName());
                    patientDict.put(index, appointment.getPatient());
                    index++;
                }
                System.out.println("For exit => 0\n");

                System.out.print("Which patient: ");
                int Selection = input.nextInt();

                if (Selection == 0){
                    return;
                }

                Patient patient = patientDict.get(Selection);

                System.out.println("\n******************** " + patient.getName() + "'s medical records ********************");

                for (MedicalRecord medicalRecord : patient.getMedicalRecords()){
                    System.out.println("------------------------------------------------------------");
                    System.out.println(medicalRecord);
                    System.out.println("------------------------------------------------------------");
                }
                System.out.println("********************************************************************************");

                System.out.print("Will you query another patient (Yes or No): ");
                String answer = input.next();

                if (answer.equalsIgnoreCase("yes")){
                    continue;
                }
                if (answer.equalsIgnoreCase("no")){
                    return;
                }
            }
        }
        else {
            List<MedicalRecord> medicalRecords = ((Patient)user).getMedicalRecords();

            System.out.println("\n***************************** Medical Records ***********************************\n");
            for (MedicalRecord medicalRecord : medicalRecords){
                System.out.println("-------------------------------");
                System.out.println(medicalRecord);
                System.out.println("-------------------------------");
            }
            System.out.println("\n*********************************************************************************");
        }
    }

    public static void makeAnAppointment(User user){

        while (true){
            System.out.println("\n*-*-*-*-*- Make an Appointment -*-*-*-*-*");

            int index = 1;
            for (Speciality spec : Speciality.values()){
                System.out.println(index + ") " + spec);
                index++;
            }

            System.out.println("For exit => 0\n");

            System.out.print("Select Department: ");
            int option = input.nextInt();
            if (option == 0){
                return;
            }

            else if (!(0 <= option && option < index)){
                System.out.println("Please try again");
                continue;
            }

            Speciality speciality = Speciality.values()[option - 1];  //Selected Department

            System.out.println();

            System.out.println(" Doctors;");

            index = 1;
            Dictionary<Integer, Doctor> doctorDict = new Hashtable<>();

            for (Doctor doctor : testClass.doctors){
                if (doctor.getSpeciality().equals(speciality)){
                    System.out.println(index + ") " + doctor.getName());
                    doctorDict.put(index, doctor);  // For find easily
                    index++;
                }
            }
            System.out.println("For exit => 0\n");


            System.out.print("Select Doctor: ");
            option = input.nextInt();

            if (option == 0){
                return;
            }

            else if (!(0 <= option && option < index)){
                System.out.println("Please try again");
                continue;
            }

            Doctor selectedDoctor = doctorDict.get(option); //Selected doctor

            System.out.print("Please enter a Date like (yyyy-mm-dd): ");
            String date = input.next();

            System.out.print("Please enter a Time like (hh:mm): ");
            String time = input.next();

            Appointment newAppointment = new Appointment((Patient) user, selectedDoctor, LocalDate.parse(date), LocalTime.parse(time), speciality);

            testClass.hospital.makeAnAppointment(newAppointment);

            System.out.print("\nNew Appointment created successfully\nWill you make another appointment (Yes or No): ");
            String answer = input.next();

            if (answer.equalsIgnoreCase("yes")){
                continue;
            }
            if (answer.equalsIgnoreCase("no")){
                return;
            }

        }

    }
}
