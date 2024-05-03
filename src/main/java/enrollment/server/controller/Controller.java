package enrollment.server.controller;

import enrollment.server.model.course.Courses;
import enrollment.server.model.student.Students;
import enrollment.server.network.TCPServer;
import enrollment.server.repository.Repository;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {
    ClientHandler clientHandler;
    ExecutorService executorService;
    ServerSocket serverSocket;
    public Controller(){
        try{
            this.serverSocket = new ServerSocket(9999);
            executorService = Executors.newFixedThreadPool(10);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void run(){
        Repository repository = new Repository();
        Students students = repository.createStudents();
        Courses courses = repository.createCourses();
        while (true) {
            try {
                Socket newSocket = serverSocket.accept();
                this.clientHandler = new ClientHandler(new TCPServer(newSocket), students, courses);
                executorService.submit(clientHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
