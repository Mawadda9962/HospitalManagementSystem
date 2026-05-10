package Entities;

import java.util.List;

public class Doctor extends Person {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;

    public Doctor(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List availableSlots, List assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("--- Doctor Specific Details ---");
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Department: " + departmentId);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("Assigned Patients: " + assignedPatients);
        System.out.println("--------------------------------");

    }

    public void assignPatient(String patientId){
        if (assignedPatients != null){
            assignedPatients.add(patientId);
            System.out.println("Patient " + patientId + "assigned to Dr. " + getLastName());
        }

    }

    public void removePatient(String patientId){
        if (assignedPatients != null){
            assignedPatients.remove(patientId);
            System.out.println("Patient" +patientId + "Removed");
        }else{
            System.out.println("Patient not found in assigned list");
        }

    }

    public void updateAvailability(String newSlot){
        if (availableSlots != null){
            availableSlots.add(newSlot);
            System.out.println("New availability slot added: ");
        }


    }

}
