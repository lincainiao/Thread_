package Daemon_;

/**
 * 守护线程
 */
public class Demo01 {
    public static void main(String[] args) {
        God god = new God();
        People people = new People();

        Thread threadGod = new Thread(god);
        threadGod.setDaemon(true);//默认是false，表示用户线程；true表示守护线程
        threadGod.start();

        Thread threadPeople = new Thread(people);
        threadPeople.start();//当用户线程结束之后，守护线程仍执行一段时间
    }
}


//被守护对象
class People implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("living with hope-"+i);
        }
        System.out.println("good luck---");
    }
}

//守护者
class God implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("the god is daemon you>>");
        }
    }
}