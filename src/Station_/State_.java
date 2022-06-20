package Station_;
//观察测试线程的状态
public class State_ {
    public static void main(String[] args){
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//NEW
        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);//RUN
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState();
            System.out.println(state);
        }
    }
}
