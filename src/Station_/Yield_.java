package Station_;
//测试线程礼让，礼让不一定成功，看cpu心情
public class Yield_ {

    public static void main(String[] args) {
//        Yield_ yield_ = new Yield_();
        MyYield m1 = new MyYield();
        MyYield m2 = new MyYield();
        new Thread(m1,"lin").start();
        new Thread(m2,"yq").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is start-");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+" is over");
    }
}
