package DeadLock_;

/**
 * 死锁，多个线程互相拥有对方需要的资源，形成僵持
 */
public class Demo01 {
    public static void main(String[] args) {
        Makeup zhao = new Makeup(0, "zhao");
        Makeup yq = new Makeup(1, "yq");

        zhao.start();
        yq.start();
    }
}


//化妆需要的口红
class Lipstick{

}

//化妆需要的镜子
class Mirror{

}

//化妆
class Makeup extends Thread{
    //需要的资源只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String name;//需要化妆的人
    public Makeup(int choice,String name){
        this.choice = choice;
        this.name = name;
    }
    @Override
    public void run(){
        //化妆
        try {
            makeup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //化妆，互相有对方的所，就是需要对方的资源
    public void makeup() throws Exception{
        if (choice == 0){
            //获得口红的锁
            synchronized (lipstick){
                System.out.println(this.name+" get lipstick");
                Thread.sleep(1000);
            }
            //一秒后，想获得镜子
            synchronized (mirror){
                System.out.println(this.name+" get mirror");
            }
        }
        else {
            //获得镜子的锁
            synchronized (mirror){
                System.out.println(this.name+" get mirror");
                Thread.sleep(2000);
            }
            //两秒后，想获得镜子
            synchronized (lipstick){
                System.out.println(this.name+" get lipstick");
            }
        }
    }
}