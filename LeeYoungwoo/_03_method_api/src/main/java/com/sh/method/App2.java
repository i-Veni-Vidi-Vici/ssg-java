package com.sh.method;

/**
 * ssg java 출력
 */
public class App2 {
    public static void main(String[] args) {
        App2 app = new App2();
        app.s();
        app.s();
        app.g();

        System.out.print("\t"); // println()은 개행되어서 출력 // print()는 개행없이 한줄로 출력
                                // \t 한칸 띄어쓰기  // \n 한줄 개행
        app.j();
        app.a();
        app.v();
        app.a();
    }

    public void a(){System.out.print("a");}
    public void g(){System.out.print("g");}
    public void j(){System.out.print("j");}
    public void s(){System.out.print("s");}
    public void v(){System.out.print("v");}
}
