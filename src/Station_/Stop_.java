package Station_;

import jdk.jshell.spi.ExecutionControl;

//测试stop停止线程
//1、减一线程正常停止，利用次数，不建议死循环
//2、减一使用标志位，设置标志位
//3、 不要使用stop方法或destroy方法等过时或jdk不建议使用的方法
public class Stop_ implements Runnable{
    //设置标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run----thread"+i++);
        }
    }

    //设置公开的方法转换标志位，停止线程
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        Stop_ stop_ = new Stop_();
        new Thread(stop_).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main--"+i);
            if (i == 900) {
                //调用stop方法转换标志位，让线程停止
                stop_.stop();
                System.out.println("is time to stop~");
            }
        }
    }
}
