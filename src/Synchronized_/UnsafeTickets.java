package Synchronized_;

/**
 * 线程同步
 * 不安全的买票
 */
public class UnsafeTickets implements Runnable{
    private int ticketNums = 10;
    private boolean hasTicket = true;
    @Override
    public void run() {
        //如果有票，则买票
       while (hasTicket){
           buyTicket();
       }
    }

    public synchronized void buyTicket() {
        //判断是否有票
        if (ticketNums <= 0) {
            hasTicket = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" get ticket "+ticketNums--);
    }

    public static void main(String[] args) {
        UnsafeTickets demo01 = new UnsafeTickets();
        Thread t1 = new Thread(demo01,"lin");
        Thread t2 = new Thread(demo01,"zhao");
        Thread t3 = new Thread(demo01,"yq");

        t1.start();
        t2.start();
        t3.start();
    }
}
