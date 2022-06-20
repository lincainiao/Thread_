package newThread;
//创建线程方式1，继承Thread类，重写run()方法，调用start开启线程
//线程开启不一定立即执行，由cpu调度
public class Demo01 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.println("learning"+"----");
        }
    }
    public static void main(String[] args) {
        //创建线程对象，调用start方法开启线程
        Demo01 demo01 = new Demo01();
        demo01.start();//和主线程交替执行
//        demo01.run();//先执行run方法，在执行主线程
        //main线程，主线程
        for (int i = 0; i < 2000; i++) {
            System.out.println("thinking"+i);
        }

    }
}
