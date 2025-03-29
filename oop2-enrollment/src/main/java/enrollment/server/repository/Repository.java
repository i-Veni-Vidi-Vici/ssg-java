package enrollment.server.repository;

import enrollment.server.constants.Major;
import enrollment.server.constants.Status;
import enrollment.server.model.course.Course;
import enrollment.server.model.course.Courses;
import enrollment.server.model.course.EnrolledCourses;
import enrollment.server.model.course.Prerequisite;
import enrollment.server.model.student.Student;
import enrollment.server.model.student.Students;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Repository implements Serializable{
    public Repository() {
        write("Students",createStudents());
        write("Courses",createCourses());
    }

    private Students createStudents() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(22001, 6, "홍길동", new EnrolledCourses(new HashMap<>() {
                    {
                        put("2022-1", new Courses(new ArrayList<>(Arrays.asList(
                                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                                new Course(1102, 30, 3, "자료구조", "김민정", new Prerequisite(List.of()), Major.COMPUTER, 20)
                        ))));
                    }{
                        put("2022-2", new Courses(new ArrayList<>(Arrays.asList(
                                new Course(1101, 30, 3, "프로그래밍 응용", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                                new Course(1102, 30, 3, "자료구조", "김민정", new Prerequisite(List.of()), Major.COMPUTER, 20)
                        ))));
                    }
                }), Major.COMPUTER, Status.ENROLLED),
                new Student(23002, 6, "김동현", new EnrolledCourses(new HashMap<>() {{
                    put("2024-1",
                            new Courses(new ArrayList<>(Arrays.asList(
                                    new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                                    new Course(1102, 30, 3, "자료구조", "김민정", new Prerequisite(List.of()), Major.COMPUTER, 20)
                            ))));
                }}), Major.COMPUTER, Status.ENROLLED)
        ));

        return new Students(students);
    }

    private Courses createCourses() {
        List<Course> courses = new ArrayList<>(Arrays.asList(
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25),
                new Course(1101, 30, 3, "프로그래밍 기초", "배수지", new Prerequisite(List.of()), Major.COMPUTER, 25)
        ));

        return new Courses(courses);
    }

    public <T> void write(String name, T students) { // 매개변수로 students객체배열을 받는다. Enrollment에서도 이 메소드를 호출할 수 있다.
        File file = new File("src/main/java/enrollment/server/repository/", name+".ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> T read(String name) {
        File file = new File("src/main/java/enrollment/server/repository/", name+".ser");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            return (T) obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public void coursesToFile(Courses courses) {
//        File file = new File("src/main/java/enrollment/server/repository/", "courseslist.ser");
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
//            oos.writeObject(courses);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public Courses fileToCourses() {
//        File file = new File("src/main/java/enrollment/server/repository/", "courseslist.ser");
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//            Object obj = ois.readObject();
//            return (Courses) obj;
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    // enrollment에서 가져올 학생 정보
//    public Student findStudent(int id) {
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getId() == id) {
//                return students.get(i);
//            }
//        }
//        return null;
//    }
    // enrollment에서 가져올 수업 정보
//    public Course findCourse(int id) {
//        for (int i = 0; i < courses.size(); i++) {
//            if (courses.get(i).getId() == id) {
//                return courses.get(i);
//            }
//        }
//        return null;
//    }
}
