package ProductAndConsume;

/**
 * 生产者消费者问题，信号灯法，利用标志位解决
 */
public class PAC02 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//消费者-观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//生产者-演员
class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0){
                this.tv.play("games");
            }else {
                this.tv.play("xxoo");
            }
        }
    }
}

//产品-节目
class TV{
    //演员表演，观众等待
    //观众观看，演员等待
    String show;//节目
    boolean playing = true;

    //表演
    public synchronized void play(String show){
        //如果不在表演，表示观众正在观看
        if(!playing){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the Players play "+show);
        //通知观众观看
        this.notifyAll();
        this.show = show;
        this.playing = !this.playing;
    }

    //观看
    public synchronized void watch(){
        //判断是否正在表演
        if (playing){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //不在表演
        System.out.println("watcher watch "+show);
        //通知演员表演
        this.notifyAll();
        this.playing = !this.playing;
    }
}