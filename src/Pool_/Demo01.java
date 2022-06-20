package Pool_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池
 */
public class Demo01 implements Runnable{
    public static void main(String[] args) {
        //创建线程池
        //参数为10的线程池大小
        ExecutorService service = Executors.newFixedThreadPool(10);
        Demo01 demo01 = new Demo01();
        Thread thread = new Thread(demo01,"lin");

        //执行
        service.execute(thread);
        service.execute(new Demo01());
        service.execute(new Demo01());
        service.execute(new Demo01());

        //关闭连接
        service.shutdownNow();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
