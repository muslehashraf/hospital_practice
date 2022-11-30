import java.util.ArrayList;
import java.util.List;

public class Hospital {

    public static void main(String[] args) {

        /**
         * 1. Create 3 patients
         * 2. Assign 3 doctors according to their problems
         * 3. Print out the patient
         * 4. Print out the doctor of the patient
         */
        System.out.println(QuestionsAndMessages.welcomeMessage);

        List<Patient> patients = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Patient currentPatient = Patient.createPatient();

            patients.add(currentPatient);
            patients.get(i).patientDoctor = Doctor.getDoctor(patients.get(i).problem);
            patients.get(i).patientDoctor.isAvailable = false;
            System.out.println(QuestionsAndMessages.doctorMessage);
        }

        for (Patient patient : patients) {
            System.out.println(patient);
            System.out.println(patient.patientDoctor);
            System.out.println(QuestionsAndMessages.goodByeMessage);
        }



    }
}