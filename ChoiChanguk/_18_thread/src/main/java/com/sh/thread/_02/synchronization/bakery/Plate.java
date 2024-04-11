package com.sh.thread._02.synchronization.bakery;

public class Plate {
    //여기가 임계영역이다
    private int breadNo;//생성한 빵 번호
    private boolean plateEmpty =true; // 접시가 비었는지 여부
    /**
     * 손님쓰레드용 메소드
     */
    public synchronized void eatBread() {
        // 접시가 비어있다면, 요리사가 빵을 만들길 기다려야 한다.
        while(this.plateEmpty) {//처음엔 true니깐 요리사가 notify오기전까지 wait한다
            try {
                wait(); // 블럭이 된다 = 다음줄로 넘어가지 않고 기다린다.
                //이제 요리사가 빵을 만들었다면 notify로 알려준다
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //이것도 가능하다
//        if(this.empty) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        //위에꺼를 왜 써도 되냐면 어차피 wait하고 빠져나오고 this.empty가 바뀐다
        //그러니 접근을 하지 않는다
        System.out.println("손님 : "+breadNo +"번 빵을 먹었습니다");
        this.plateEmpty =true; // 손님이 빵을 먹었으니 접시가 비어있다 라고 표시한다
        notify(); // 그리고는 waiting중인 요리사 쓰레드에게 알림
        /*
        이 notify는 지금 임계영역에 손님, 요리사만 있기 때문에 손님이나 요리사한테간다
        만약 임계영역을 써야 하는 쓰레드가 여러개 있다면 그 중 하나에게 간다
        저수준에서는 특정 쓰레드한테 notify를 못한다
        고수준에서는 순서관리를 해서 알려준다 (FIFO, LIFO 같은 관리)
        */
    }

    /**
     * 요리사쓰레드용 메소드
     */
    public synchronized void makeBread(int breadNo) {
        //접시가 비어있지 않은 경우, 손님이 빵을 먹기를 기다려야 합니다
        /*
        처음에는 true로 비어 있으니 여기는 안들어가고 바로 while문 진입을 안하고
        빵을 만들었다는 표시를 하고  plateEmpty=false = 뭔가 있다라고 바꾸고, notify를 한다
        * */
        while(!this.plateEmpty)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("요리사 : " + breadNo + "번 빵을 만들었습니다");
        this.breadNo = breadNo;
        this.plateEmpty = false;
        notify();//빵을 기다리는 손님쓰레드를 위해서 notify
        // -> 현재객체의 대기실에 있는 임의의 쓰레드에게 알림처리 한다
    }
}
