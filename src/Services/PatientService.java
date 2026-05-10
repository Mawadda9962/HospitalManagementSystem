package Services;

import Entities.patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
        Scanner scanner = new Scanner(System.in);
        static List <patient> patients = new ArrayList<>();


        public void addPatient(){
            System.out.println("****** ADD NEW PATIENT ********");
            System.out.println("Enter patient id: ");
            String id = scanner.nextLine();

            patient p = getPatientId(id);




    }

}
