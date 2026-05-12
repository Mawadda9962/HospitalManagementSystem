package Entities;

import Interfaces.Displayable;

import java.util.List;

public class Department implements Displayable {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<Doctor> doctors;
    private List<Nurse> nurses;
    private int bedCapacity;
    private int availableBeds;

    public Department(String departmentName, String departmentId, String headDoctorId, List<Doctor> doctors, List<Nurse> nurses, int bedCapacity, int availableBeds) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
        this.headDoctorId = headDoctorId;
        this.doctors = doctors;
        this.nurses = nurses;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    public void assignDoctor(Doctor doctor){
        if (doctor != null){
            doctors.add(doctor);
            System.out.println("Dr. " + doctor.getLastName() + " assigned to " + departmentName);
        }

    }
    public void  assignNurse(Nurse nurse){
        if (nurses != null){
            nurses.add(nurse);
            System.out.println("Nurse " + nurse.getLastName() + " assigned to " + departmentName);
        }

    }
    public void updateBedAvailability(int occupiedBeds){
        if (occupiedBeds <= bedCapacity) {
        this.availableBeds = bedCapacity - occupiedBeds;
        System.out.println("Beds updated in " + departmentName + ". Available: " + availableBeds);
    } else {
        System.out.println("Error: Occupied beds exceed total capacity!");
          }
    }


    @Override
    public void displayInfo() {
        System.out.println("************* Department Details *************");
        System.out.println("ID        : " + departmentId);
        System.out.println("Name      : " + departmentName);
        System.out.println("Head MD ID: " + headDoctorId);
        System.out.println("Capacity  : " + bedCapacity + " beds");
        System.out.println("Available : " + availableBeds + " beds");
    }

    @Override
    public void displaySummary() {
        System.out.println("Name      : " + departmentName);
        System.out.println("Capacity  : " + bedCapacity + " beds");
        System.out.println("Available : " + availableBeds + " beds");
    }
}
