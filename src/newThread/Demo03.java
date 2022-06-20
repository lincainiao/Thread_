package newThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Demo03 implements Runnable{
    private String url;
    private String fileName;
    public Demo03(String url,String fileName){
        this.fileName = fileName;
        this.url = url;
    }

    @Override
    public void run(){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo03 d1 = new Demo03("https://img2.baidu.com/it/u=2548333279,4114384196&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750","1.jpg");
        Demo03 d2 = new Demo03("https://img2.baidu.com/it/u=2548333279,4114384196&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750","2.jpg");
        Demo03 d3 = new Demo03("https://img2.baidu.com/it/u=2548333279,4114384196&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750","3.jpg");

        Thread t1 = new Thread(d1);
        t1.start();

        new Thread(d2).start();
    }
}
