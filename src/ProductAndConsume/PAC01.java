package ProductAndConsume;

import java.util.zip.CheckedOutputStream;

/**
 * 测试生产者和消费者，-->利用缓冲区解决：管程法
 */
public class PAC01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Producer extends Thread{
    //生产者需要往容器中放入产品
    SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }
    @Override
    public void run(){
        //生产产品
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("the producer produce the "+i+" chicken");
        }
    }
}

//消费者
class Consumer extends Thread{
    //消费者需要从容器中取出产品
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }
    @Override
    public void run(){
        //消费者消费
        for (int i = 0; i < 100; i++) {
            System.out.println("the consumer consume the "+container.pop().id+" chicken ");
        }
    }
}

//产品
class Chicken{
    int id;//产品编号
    public Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;
    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，等待消费者消费；否则放入产品
        if (count == chickens.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，就需要放容器里丢入产品
        chickens[count] = chicken;
        count++;
        //通知消费者消费
        this.notify();
    }
    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if (count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];
        //通知生产者生产
        this.notify();
        //查看吃了哪只鸡
        return chicken;
    }
}