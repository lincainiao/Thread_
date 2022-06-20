package Priority_;

/**
 * 测试线程优先级
 */
public class Demo01 {

    public static void main(String[] args) {
        //主线程优先级
        System.out.println("default is --> "+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority,"lin");
        Thread thread2 = new Thread(myPriority,"zhao");
        Thread thread3 = new Thread(myPriority,"yq");
        //设置优先级(0-10)，结果不一定
        thread1.setPriority(1);
        thread1.start();
        thread2.setPriority(5);
        thread2.start();
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.start();
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 优先级--> "+Thread.currentThread().getPriority());
    }
}
