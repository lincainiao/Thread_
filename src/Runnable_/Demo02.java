package Runnable_;
//实现多个线程操作同一个对象
//买火车票的例子
//多个线程操作同一个资源时，线程不安全，资源紊乱
public class Demo02 implements Runnable{

    //火车票数量
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums < 1) break;
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        Demo02 ticket = new Demo02();
        new Thread(ticket,"Lin").start();
        new Thread(ticket,"Zhao").start();
        new Thread(ticket,"Yan").start();
    }
}
