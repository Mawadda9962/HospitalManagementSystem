package Services;

import Entities.Nurse;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utiles.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService extends Base implements Manageable, Searchable {

 private static final Scanner scanner = new Scanner(System.in);

 private static final List<Nurse> nurses = new ArrayList<>();

 public void addNurse() {
  System.out.println("********** Add New Nurse **********");

  System.out.print("Enter Nurse ID: ");
  String nurseId = scanner.nextLine().trim();

  if (getNurseById(nurseId) != null) {
   System.out.println("A nurse with this ID already exists.");
   return;
  }

  System.out.print("Enter First Name: ");
  String firstName = scanner.nextLine().trim();

  System.out.print("Enter Last Name: ");
  String lastName = scanner.nextLine().trim();

  System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
  String dob = scanner.nextLine().trim();

  System.out.print("Enter Gender: ");
  String gender = scanner.nextLine().trim();

  System.out.print("Enter Phone Number: ");
  String phone = scanner.nextLine().trim();

  System.out.print("Enter Email: ");
  String email = scanner.nextLine().trim();

  System.out.print("Enter Address: ");
  String address = scanner.nextLine().trim();

  // Nurse Specific Information
  System.out.print("Enter Department ID: ");
  String deptId = scanner.nextLine().trim();

  System.out.print("Enter Shift (Morning/Evening/Night): ");
  String shift = scanner.nextLine().trim();

  System.out.print("Enter Qualification: ");
  String qualification = scanner.nextLine().trim();

  // Initializing lists as empty for a new nurse
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
   if (n.getNurseId().equals(nurseId)) {
    return n;
   }
  }
  return null;
 }

 public void editNurse(String nurseId) {
  Nurse n = getNurseById(nurseId);
  if (n == null) {
   System.out.println("Nurse with ID " + nurseId + " not found.");
   return;
  }

  System.out.println("Editing Nurse: " + nurseId);
  System.out.print("Enter updated First Name: ");
  n.setFirstName(scanner.nextLine());

  System.out.print("Enter updated Last Name: ");
  n.setLastName(scanner.nextLine());

  System.out.print("Enter updated Shift: ");
  n.setShift(scanner.nextLine());

  System.out.print("Enter updated Department ID: ");
  n.setDepartmentId(scanner.nextLine());

  System.out.print("Enter updated Qualification: ");
  n.setQualification(scanner.nextLine());

  System.out.println(Constant.NURSE_UPDATED_SUCCESSFULLY);
 }

 public void removeNurse(String nurseId) {
  Nurse n = getNurseById(nurseId);
  if (n != null) {
   nurses.remove(n);
   System.out.println(Constant.NURSE_REMOVE_SUCCESSFULLY);
  } else {
   System.out.println("Nurse not found.");
  }
 }

 public void displayAllNurses() {
  if (nurses.isEmpty()) {
   System.out.println("No nurses registered in the system.");
   return;
  }
  System.out.println("Total Registered Nurses: " + nurses.size());
  for (Nurse n : nurses) {
   n.displayInfo();
  }
 }

 // Additional Task Requirements
 public void getNursesByDepartment(String deptId) {
  boolean found = false;
  for (Nurse n : nurses) {
   if (n.getDepartmentId().equalsIgnoreCase(deptId)) {
    n.displayInfo();
    found = true;
   }
  }
  if (!found) System.out.println("No nurses found in department: " + deptId);
 }

 public void getNursesByShift(String shift) {
  boolean found = false;
  for (Nurse n : nurses) {
   if (n.getShift().equalsIgnoreCase(shift)) {
    n.displayInfo();
    found = true;
   }
  }
  if (!found) System.out.println("No nurses found working the " + shift + " shift.");
 }

 public Boolean handleNurseMenu(Integer option) {
  switch (option) {
   case 1 -> addNurse();
   case 2 -> {
    System.out.print("Enter Nurse ID to edit: ");
    editNurse(scanner.nextLine().trim());
   }
   case 3 -> {
    System.out.print("Enter Nurse ID to remove: ");
    removeNurse(scanner.nextLine().trim());
   }
   case 4 -> {
    System.out.print("Enter Department ID to filter: ");
    getNursesByDepartment(scanner.nextLine().trim());
   }
   case 5 -> {
    System.out.print("Enter Shift to filter: ");
    getNursesByShift(scanner.nextLine().trim());
   }
   case 6 -> displayAllNurses();
   case 7 -> {
    return false;
   }
   default -> System.out.println("Invalid option.");
  }
  return true;
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
   if (n.getFirstName().equalsIgnoreCase(keyword)
           || n.getLastName().equalsIgnoreCase(keyword)
           || n.getNurseId().equalsIgnoreCase(keyword)
           || n.getDepartmentId().equalsIgnoreCase(keyword)
           || n.getShift().equalsIgnoreCase(keyword)) {
    n.displayInfo();
    found = true;
   }
  }
  if (!found) {
   System.out.println("No nurses found matching: " + keyword);
  }
 }

 @Override
 public void searchById(String id) {
  Nurse n = getNurseById(id);
  if (n != null) {
   n.displayInfo();
  } else {
   System.out.println("No nurse found with ID: " + id);
   }
  }
}