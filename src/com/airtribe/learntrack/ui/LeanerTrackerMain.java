package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;
import java.util.Scanner;

public class LeanerTrackerMain {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StudentService studentService = new StudentService();
            CourseService corseservice=  new CourseService();
            EnrollmentService enrollement =  new EnrollmentService();

            while (true) {
                System.out.println("\n==== LearnTrack Menu ====");
                System.out.println("A. Student Management");
                System.out.println("B. Course Management");
                System.out.println("C. Enrollement Management");
                System.out.print("Enter option: ");

                String mainChoice = sc.nextLine();

                if (mainChoice.equalsIgnoreCase("A")) {
                    studentMenu(sc, studentService);
                }
                else if (mainChoice.equalsIgnoreCase("B")) {
                    courseMenu(sc, corseservice);
                }else if (mainChoice.equalsIgnoreCase("C")) {
                    enrollmentMenu(sc, studentService,corseservice,enrollement);
                }
                else if (mainChoice.equalsIgnoreCase("D")) {
                    System.out.println("Exiting application...");
                    break;
                }
                else {
                    System.out.println("Invalid option");
                }
            }
        }
    private static void studentMenu(Scanner sc, StudentService service) {
            while (true) {
                System.out.println("\n--- Student Management ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Back");

                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 1) {
                    System.out.print("First Name: ");
                    String firstName= sc.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
//                    System.out.print("Batch: ");
//                    String batch = sc.nextLine();

                    Student student = new Student(IdGenerator.nextId(), firstName, lastName, email);
                    service.addStudent(student);
                    System.out.println("Student Added");
                }
                else if (choice == 2) {
                    for (Student s : service.getAllStudents()) {
                        System.out.println(s.getDisplayName());
                        break;
                    }
                }
                else if (choice == 3) {
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    Student student = null;
                    try {
                        student = service.getStudent(id);
                    } catch (EntityNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Found: " + student.getDisplayName());

                }
                else {
                    break;
                }
            }
        }
private static void courseMenu(Scanner sc, CourseService courseService){
    while (true) {
        System.out.println("\n--- Course Management ---");
        System.out.println("1. Add Course");
        System.out.println("2. View Course");
        System.out.println("3. Search Course by ID");
        System.out.println("4. Back");


        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            System.out.print("Course Name: ");
            String corseName= sc.nextLine();


//            String email = sc.nextLine();
//                    System.out.print("Batch: ");
//                    String batch = sc.nextLine();

            Course course = new Course(IdGenerator.nextId(),corseName);
            courseService.addCourse(course);
            System.out.println("Corse Added");
        }
        else if (choice == 2) {
        for (Course c : courseService.getAllCorse()) {
            System.out.println(
                    "ID: " + c.getId() +
                            ", Name: " + c.getDisplayCorseName() +
                            ", Active: " + c.isActive()
            );
        }
    }
        else if (choice == 3) {
            System.out.print("Enter Corse ID: ");
            int id = Integer.parseInt(sc.nextLine());

            Course course = null;
            try {
                course = courseService.getCourse(id);
            } catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Found: " + course.getDisplayCorseName());

        }
        else {
            break;
        }
    }
}
    // ---------------- ENROLLMENT MENU ----------------
    private static void enrollmentMenu(
            Scanner sc,
            StudentService studentService,
            CourseService courseService,
            EnrollmentService enrollmentService) {

        while (true) {
            System.out.println("\n--- Enrollment Menu ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments by Student");
            System.out.println("3. Back");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                if (choice == 1) {
                    System.out.print("Student ID: ");
                    int studentId = Integer.parseInt(sc.nextLine());
                    studentService.getStudent(studentId); // validation

                    System.out.print("Course ID: ");
                    int courseId = Integer.parseInt(sc.nextLine());
                    courseService.getCourse(courseId); // validation

                    Enrollment e = new Enrollment(
                            IdGenerator.nextId(), studentId, courseId);
                    enrollmentService.enrollStudent(e);

                    System.out.println("Student enrolled successfully");

                } else if (choice == 2) {
                    System.out.print("Student ID: ");
                    int studentId = Integer.parseInt(sc.nextLine());

                    List<Enrollment> list =
                            enrollmentService.getEnrollmentsForStudent(studentId);

                    if (list.isEmpty()) {
                        System.out.println("No enrollments found");
                    } else {
                        for (Enrollment e : list) {
                            System.out.println(
                                    "Course ID: " + e.getCourseId() +
                                            ", Status: " + e.getStatus());
                        }
                    }
                } else {
                    return;
                }
            } catch (EntityNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}

