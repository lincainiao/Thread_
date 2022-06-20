package Runnable_;

import java.util.GregorianCalendar;

//模拟龟兔赛跑
public class Race implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子睡觉，当兔子跑到99步时，兔子睡觉
            if (Thread.currentThread().getName().equals("rabbit") && (i==99))
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断比赛是否结束
            if (gameOver(i)) break;
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
    }

    //判断是否完成比赛，即跑了100步
    private boolean gameOver(int steps){
        //判断是否有胜利者，如果已经有胜利者，另外一个进程即可退出循环，即退出比赛
        if (winner != null)
            return true;
        else {
            //如果是第100步，对胜利者赋值
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner: "+winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"rabbit").start();
        new Thread(race,"turtle").start();
    }
}
