package Services;

import Entities.Nurse;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utiles.Constant;
import Utiles.HelperUtils;
import Utiles.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService extends Base implements Manageable, Searchable {

    private static  Scanner scanner = new Scanner(System.in);

    private static  List<Nurse> nurses = new ArrayList<>();

    public void addNurse() {
        System.out.println("********** Add New Nurse **********");

        System.out.print("Enter Nurse ID: ");
        String nurseId = scanner.nextLine().trim();

        if (HelperUtils.isNotNull(getNurseById(nurseId))) {
            System.out.println("A nurse with this ID already exists.");
            return;
        }

        String firstName = InputHandler.getStringInput("Enter First Name");
        String lastName = InputHandler.getStringInput("Enter Last Name");

        LocalDate dob = InputHandler.getDateInput("Enter Date of Birth");

        String gender = InputHandler.getStringInput("Enter Gender");
        String phone = InputHandler.getStringInput("Enter Phone Number");
        String email = InputHandler.getStringInput("Enter Email");
        String address = InputHandler.getStringInput("Enter Address");


        String deptId = InputHandler.getStringInput("Enter Department ID");
        String shift = InputHandler.getStringInput("Enter Shift (Morning/Evening/Night)");
        String qualification = InputHandler.getStringInput("Enter Qualification");

        List<String> assignedPatients = new ArrayList<>();

        Nurse newNurse = new Nurse(
                nurseId, firstName, lastName, dob, gender, phone, email, address,
                "Nursing", qualification, 0, deptId, 0.0, new ArrayList<>(), assignedPatients,
                nurseId, deptId, shift, qualification, assignedPatients
        );

        nurses.add(newNurse);
        System.out.println(Constant.NURSE_ADDED_SUCCESSFULLY);
    }

    public Nurse getNurseById(String nurseId) {
        for (Nurse n : nurses) {
            if (HelperUtils.isNotNull(n) && n.getNurseId().equals(nurseId)) {
                return n;
            }
        }
        return null;
    }

    public void editNurse(String nurseId) {
        Nurse n = getNurseById(nurseId);
        if (HelperUtils.isNull(n)) {
            System.out.println("Nurse with ID " + nurseId + " not found.");
            return;
        }

        System.out.println("Editing Nurse: " + nurseId);

        n.setFirstName(InputHandler.getStringInput("Enter updated First Name"));
        n.setLastName(InputHandler.getStringInput("Enter updated Last Name"));
        n.setShift(InputHandler.getStringInput("Enter updated Shift"));
        n.setDepartmentId(InputHandler.getStringInput("Enter updated Department ID"));
        n.setQualification(InputHandler.getStringInput("Enter updated Qualification"));

        System.out.println(Constant.NURSE_UPDATED_SUCCESSFULLY);
    }

    public void removeNurse(String nurseId) {
        if (!HelperUtils.isNotNull(nurseId)) {
            System.out.println("Invalid Nurse ID provided.");
            return;
        }

        Nurse n = getNurseById(nurseId);
        if (HelperUtils.isNotNull(n)) {
            nurses.remove(n);
            System.out.println(Constant.NURSE_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Nurse with ID " + nurseId + " not found.");
        }
    }

    public void displayAllNurses() {
        if (nurses.isEmpty()) {
            System.out.println("No nurses registered in the system.");
            return;
        }
        System.out.println("Total Registered Nurses: " + nurses.size());
        for (Nurse n : nurses) {
            if (HelperUtils.isNotNull(n)) {
                n.displayInfo();
            }
        }
    }

    // Additional Task Requirements
    public void getNursesByDepartment(String deptId) {
        boolean found = false;
        for (Nurse n : nurses) {
            if (HelperUtils.isNotNull(n) && n.getDepartmentId().equalsIgnoreCase(deptId)) {
                n.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No nurses found in department: " + deptId);
    }

    public void getNursesByShift(String shift) {
        boolean found = false;
        for (Nurse n : nurses) {
            if (HelperUtils.isNotNull(n) && n.getShift().equalsIgnoreCase(shift)) {                n.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No nurses found working the " + shift + " shift.");
    }

    public void  AssignNursetoPatient(){

        String nurseId = InputHandler.getStringInput("Enter Nurse ID: ");
        Nurse nurse = getNurseById(nurseId);

        if (HelperUtils.isNotNull(nurse)) {
            String patientId = InputHandler.getStringInput("Enter Patient ID to assign: ");

            nurse.getAssignedPatients().add(patientId);
            System.out.println("Success: Patient " + patientId + " assigned to Nurse " + nurse.getLastName());
        } else {
            System.out.println("Error: Nurse not found.");
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Nurse) {
            Nurse n = (Nurse) entity;
            nurses.add(n);
            System.out.println("Nurse added: " + n.getFirstName());
        } else {
            System.out.println("Invalid entity type. Expected a Nurse object.");
        }
    }

    @Override
    public void remove(String id) {
        removeNurse(id);
    }

    @Override
    public void getAll() {
        displayAllNurses();

    }

    @Override
    public void search(String keyword) {
        boolean found = false;
        for (Nurse n : nurses) {
            if (HelperUtils.isNotNull(n)) {
            if (n.getFirstName().equalsIgnoreCase(keyword)
                    || n.getLastName().equalsIgnoreCase(keyword)
                    || n.getNurseId().equalsIgnoreCase(keyword)
                    || n.getDepartmentId().equalsIgnoreCase(keyword)
                    || n.getShift().equalsIgnoreCase(keyword)) {
                n.displayInfo();
                found = true;
            }
        }
    }
        if (!found) {
            System.out.println("No nurses found matching: " + keyword);
        }
    }

    @Override
    public void searchById(String id) {
        Nurse n = getNurseById(id);
        if (HelperUtils.isNotNull(n)) {
            n.displayInfo();
        } else {
            System.out.println("No nurse found with ID: " + id);
        }
    }

    public Boolean handleNurseMenu(Integer option) {
        switch (option) {
            case 1 -> addNurse();
            case 2 -> displayAllNurses();
            case 3 -> {
                String deptId = InputHandler.getStringInput("Enter Department ID to filter");
                getNursesByDepartment(deptId);
            }
            case 4 -> {
                String shift = InputHandler.getStringInput("Enter Shift (Morning/Evening/Night) to filter");
                getNursesByShift(shift);
            }
            case 5 -> {
                System.out.print("Enter Shift to filter: ");
                getNursesByShift(scanner.nextLine().trim());
            }
            case 6 -> displayAllNurses();

            case 7 -> {
                String idToRemove = InputHandler.getStringInput("Enter Nurse ID to remove");
                removeNurse(idToRemove);
             }
            case 8 -> {
                return false;
            }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }

}