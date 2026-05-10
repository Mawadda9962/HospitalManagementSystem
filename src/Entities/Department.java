package Entities;

import java.util.List;

public class Department {
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


}
