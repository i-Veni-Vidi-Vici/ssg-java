package enrollment.server.controller;

import enrollment.server.constants.Period;
import enrollment.server.model.course.Course;
import enrollment.server.model.course.Courses;
import enrollment.server.model.student.Student;
import enrollment.server.model.student.Students;
import enrollment.server.network.TCPServer;


class ClientHandler implements Runnable{
    private final TCPServer tcpServer;
    private final Students studentRepo;
    private final Courses courseRepo;

    public ClientHandler(TCPServer tcpServer, Students students, Courses courses) {
        this.tcpServer = tcpServer;
        this.studentRepo = students;
        //studentRepo.printTest();
        this.courseRepo = courses;
        //courseRepo.printTest();
    }
    @Override
    public void run(){
        int studentID = Integer.parseInt(tcpServer.receive());
        System.out.println("[CONNECTION] From : " + studentID);
        while (true){
            String[] wholeRequest = tcpServer.receive().split("/");
            switch (wholeRequest[0]){
                case "LISTUP":
                    System.out.println("[Request] LISTUP From : " + studentID);
                    handleLISTUP();

                    break;
                case "APPLY":
                    System.out.println("[Request] APPLY From : " + studentID);
                    handleAPPLY(Integer.parseInt(wholeRequest[1]), studentID);
                    break;
                case "CANCEL":
                    System.out.println("[Request] CANCEL From : " + studentID);
                    handleCANCEL(Integer.parseInt(wholeRequest[1]), studentID);
                    break;
                case "MYLIST":
                    System.out.println("[Request] MYLIST From : " + studentID);
                    handleMYLIST(studentID);
                    break;
                default:
                    System.out.println("클라이언트로부터 잘못된 요청이 입력되었습니다.");
            }

        }
    }
    public synchronized void  handleAPPLY(int courseCode, int studentID){
        Course foundCourse = courseRepo.getCourse(courseCode);
        Student student = studentRepo.getStudent(studentID);
        String reply = "";
        boolean isApplied = false;
        if(foundCourse==null){
            reply+="NOCOURSE/\n";
        }
        else{
            /*
            if(!Period.check()){
                reply+="NOPERIOD/\n";
            }
            */

            if(!student.checkCurrentCredits(foundCourse)){
                reply+="OVERCREDIT/\n";
            }
            else if(!student.checkMajor(foundCourse)){
                reply+="NOMAJOR/\n";
            }
            else if(!student.checkPrerequisite(foundCourse)){
                reply+="NOPREREQUISITE/\n";
            }
            else if(!foundCourse.checkCapacity()){
                reply+="OVERCAPACITY/\n";
            }
            else{
                if(student.findEnrolledCourse(courseCode)!=null){
                    reply+="ALREADYAPPLIED\n";
                }
                else{
                    reply+="ACCEPTED/\n";
                    student.increaseCurrentCredits(foundCourse.getCredit());
                    student.getEnrolledCourses().addCourse(foundCourse);
                    foundCourse.increaseCurrentCapacity();
                    isApplied = true;
                }
            }
            if(isApplied){
                System.out.println("[APPROVED] APPLY From : " + studentID + " Course : "+foundCourse.getName());
            }
            else{
                System.out.println("[REJECTED] APPLY From : " + studentID + " Course : "+foundCourse.getName());
            }

        }
        tcpServer.send(reply);
    }
    public void handleCANCEL(int courseCode, int studentID){
        String reply="";
        Student student = studentRepo.getStudent(studentID);
        Course foundCourse = student.findEnrolledCourse(courseCode);
        boolean isApplied = false;
        if(foundCourse==null){
            reply+="NOCOURSE/\n";
        }
        else{
            student.getEnrolledCourses().removeCourse(foundCourse);
            student.reduceCurrentCredits(foundCourse.getCredit());
            foundCourse.reduceCurrentCapacity();
            reply+="ACCEPTED/\n";
            isApplied =true;
        }
        if(isApplied){
            System.out.println("[APPROVED] APPLY From : " + studentID + " Course : "+foundCourse.getName());
        }
        else{
            System.out.println("[REJECTED] APPLY From : " + studentID + " Course : "+foundCourse.getName());
        }
        tcpServer.send(reply);
    }
    public void handleLISTUP(){
        String reply = "LISTUP/";
        String allList = "";
        for(Course course : courseRepo.getCourses()){
            allList+=course.getId()+","+course.getName()+","+course.getCredit()+","+course.getCurrentCapacity()+","+
                    course.getCapacity()+","+course.getProfessor()+","+course.getMajor()+"#";
        }
        tcpServer.send(reply+allList.substring(0,allList.length()-1)+"\n");

    }
    public void handleMYLIST(int studentID){
        String reply = "MYLIST/";
        String myList="";
        Student student = studentRepo.getStudent(studentID);
        for(Course course : student.getEnrolledCourses().getEnrolledCourses().get("2024-1").getCourses()){
            myList+=course.getId()+","+course.getName()+","+course.getCredit()+","+course.getCurrentCapacity()+","+
                    course.getCapacity()+","+course.getProfessor()+","+course.getMajor()+"#";
        }
        tcpServer.send(reply+myList.substring(0,myList.length()-1)+"\n");
    }
    public void sendMsg(String msg){
        tcpServer.send(msg);
    }
    public String receiveMsg(){
        return tcpServer.receive();
    }

}
