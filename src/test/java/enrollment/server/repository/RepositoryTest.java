package enrollment.server.repository;


import static org.junit.jupiter.api.Assertions.*;

import enrollment.server.constants.Major;
import enrollment.server.constants.Status;
import enrollment.server.model.course.EnrolledCourses;
import enrollment.server.model.student.Student;
import enrollment.server.model.student.Students;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

class RepositoryTest {

    @DisplayName("파일에 저장")
    @Test
    void write() {
        // given, when
        Repository repository = new Repository();

        // then
         Students students = repository.read("Students");
        assertDoesNotThrow(()->students.getStudent(22001));

        repository.write("Students", new Students(Arrays.asList(new Student(1, 0, "변성일",
                        new EnrolledCourses(new HashMap<>()), Major.COMPUTER, Status.ENROLLED),
                new Student(2, 0, "김홍현", new EnrolledCourses(new HashMap<>()), Major.CHEMISTRY,
                        Status.DROPPING_OUT))));

    }

    @DisplayName("파일 읽기")
    @Test
    void read() {

    }
}