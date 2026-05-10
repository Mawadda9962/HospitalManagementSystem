package Services;

import Entities.patient;
import Utiles.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PatientService {

    //List to store all patients
    private static List<patient> patients = new ArrayList<>();

    //Adding a new patient to the list
    public void addPatient(patient p){
        if (p != null) {
            patients.add(p);
            System.out.println(Constant.PATIENT_ADDED_SUCCESSFULLY + p.getFirstName());
        }

    }

    public patient getPatientById(String patientId){
        for (patient p : patients){
            if (p.getPatientId().equals(patientId)){
                return p;
            }
        }
        System.out.println();
    }






}
