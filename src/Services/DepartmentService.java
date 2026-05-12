package Services;

import Entities.Department;
import Entities.Doctor;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utiles.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService extends Base implements Manageable, Searchable {

    private static final Scanner scanner = new Scanner(System.in);

    // In-memory list to store all departments
    private static final List<Department> departments = new ArrayList<>();

    public void addDepartment() {
        System.out.println("********** Add New Department **********");

        System.out.print("Enter Department ID: ");
        String id = scanner.nextLine().trim();

        if (getDepartmentById(id) != null) {
            System.out.println("A department with this ID already exists.");
            return;
        }

        System.out.print("Enter Department Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Head Doctor ID: ");
        String headDoctorId = scanner.nextLine().trim();

        System.out.print("Enter Bed Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine().trim());

        // New department starts with all beds available
        int availableBeds = capacity;

        // Initialize empty lists for doctors and nurses
        Department newDept = new Department(
                name,
                id,
                headDoctorId,
                new ArrayList<>(),
                new ArrayList<>(),
                capacity,
                availableBeds
        );

        departments.add(newDept);
        System.out.println("Department added successfully!");
    }

    public Department getDepartmentById(String id) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public void editDepartment(String id) {
        Department d = getDepartmentById(id);
        if (d == null) {
            System.out.println("Department not found.");
            return;
        }

        System.out.println("Editing Department: " + d.getDepartmentName());
        System.out.print("Enter updated Name: ");
        d.setDepartmentName(scanner.nextLine());

        System.out.print("Enter updated Head Doctor ID: ");
        d.setHeadDoctorId(scanner.nextLine());

        System.out.print("Enter updated Bed Capacity: ");
        d.setBedCapacity(Integer.parseInt(scanner.nextLine()));

        System.out.println("Department updated successfully!");
    }

    public void removeDepartment(String id) {
        Department d = getDepartmentById(id);
        if (d != null) {
            departments.remove(d);
            System.out.println("Department removed successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }

    public void displayAllDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No departments registered.");
            return;
        }
        System.out.println("Total Departments: " + departments.size());
        for (Department d : departments) {
            System.out.println("-----------------------------------");
            System.out.println("ID: " + d.getDepartmentId());
            System.out.println("Name: " + d.getDepartmentName());
            System.out.println("Head Doctor: " + d.getHeadDoctorId());
            System.out.println("Beds: " + d.getAvailableBeds() + "/" + d.getBedCapacity());
            System.out.println("Doctors Count: " + d.getDoctors().size());
            System.out.println("Nurses Count: " + d.getNurses().size());
        }
    }

    public void assignDoctorToDepartment(Doctor doctor, String departmentId) {
        Department d = getDepartmentById(departmentId);
        if (d != null && doctor != null) {
            d.assignDoctor(doctor);
        } else {
            System.out.println("Error: Department or Doctor not found.");
        }
    }

    public Boolean handleDepartmentMenu(Integer option) {
        switch (option) {
            case 1 -> addDepartment();
            case 2 -> {
                System.out.print("Enter ID to edit: ");
                editDepartment(scanner.nextLine().trim());
            }
            case 3 -> {
                System.out.print("Enter ID to remove: ");
                removeDepartment(scanner.nextLine().trim());
            }
            case 4 -> displayAllDepartments();
            case 5 -> {
                System.out.print("Enter Department ID to view details: ");
                Department d = getDepartmentById(scanner.nextLine().trim());
                if (d != null) {
                    System.out.println("Found: " + d.getDepartmentName());
                } else {
                    System.out.println("Not found.");
                }
            }
            case 6 -> { return false; }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Department) {
            Department d = (Department) entity;
            departments.add(d);
            System.out.println("Department added: " + d.getDepartmentName());
        } else {
            System.out.println("Invalid entity type. Expected a Department object.");
        }
    }

    @Override
    public void remove(String id) {
        removeDepartment(id);
    }

    @Override
    public void getAll() {

    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public void searchById(String id) {

    }
}