package Station_;
//模拟网络延时 : 方法问题的发生性
public class Sleep_01 implements Runnable{
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) break;
            try {
                //模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿了第"+ticketNums--+"张");
        }
    }


    public static void main(String[] args) {
        Sleep_01 s1 = new Sleep_01();
        Thread t1 = new Thread(s1,"lin");
        Thread t2 = new Thread(s1,"zhao");
        Thread t3 = new Thread(s1,"yq");
        t1.start();
        t2.start();
        t3.start();
    }
}
