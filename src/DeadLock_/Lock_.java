package DeadLock_;

import com.sun.source.tree.NewArrayTree;

import java.util.concurrent.locks.ReentrantLock;

public class Lock_ {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Thread zhao = new Thread(tickets,"zhao");
        Thread lin = new Thread(tickets,"lin");
        Thread yq = new Thread(tickets,"yq");

        zhao.start();
        lin.start();
        yq.start();
    }
}

class Tickets implements Runnable{
    private int ticketNums = 10;
    private boolean hasTickets = true;
    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run(){
        while (true) {
            try {
                lock.lock();
                if (ticketNums > 0){
                    System.out.println(ticketNums--);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else break;
            } finally {
                lock.unlock();
            }
        }
    }
}