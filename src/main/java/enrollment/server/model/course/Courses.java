package enrollment.server.model.course;

import java.io.Serializable;
import java.util.List;

public class Courses implements Serializable {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCourse(int courseId) {
        Course foundCourse =null;
        for (Course course : courses) {
            if (course.getId() == courseId) {
                foundCourse= course;
            }
        }
        return foundCourse;


    }

    public List<Course> getCourses() {
        return courses;
    }

    public void printTest(){
        for(Course course : courses){
            System.out.println(course.toString());
        }
    }

}
