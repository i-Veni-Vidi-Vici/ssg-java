package enrollment.server.model.student;

import java.io.Serializable;
import java.util.List;

public class Students implements Serializable {
    private final List<Student> students;

    public Students(List<Student> students) {
        this.students = students;
    }

    public Student getStudent(int studentId) {
        Student foundStudent = null;
        for (Student student : students) {
            if (student.getId() == studentId) {
                foundStudent = student;
            }
        }
        return foundStudent;
    }

    public void printTest(){
        for(Student student : students){
            System.out.println(student.toString());
        }
    }
}
