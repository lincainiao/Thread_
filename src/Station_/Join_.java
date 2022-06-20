package Station_;

public class Join_ implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("线程vip is coming-"+i);
        }
    }

    public static void main(String[] args) {
        Join_ join_ = new Join_();
        Thread thread = new Thread(join_);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if (i == 200) {
                try {
                    thread.join();//插队
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


