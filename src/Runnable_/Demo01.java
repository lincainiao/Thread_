package Runnable_;
//直线Runnable接口，重写run方法，执行线程需要丢入runnable接口的实现类
public class Demo01 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("think Zhao-------");
        }
    }

    public static void main(String[] args) {
        //创建Runnable实现类
        Demo01 demo01 = new Demo01();
        //创建线程对象，通过线程对象开启线程，代理
        Thread thread = new Thread(demo01);
        //调用start方法
        thread.start();
        //主线程
        for (int i = 0; i < 100; i++) {
            System.out.println("think Lin>>>>>>");
        }
    }
}
