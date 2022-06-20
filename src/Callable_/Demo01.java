package Callable_;


import newThread.Demo02;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//Callable接口实现
public class Demo01 implements Callable {
    private String url;
    private String fileName;
    //构造
    public Demo01 (String url,String fileName){
        this.fileName = fileName;
        this.url = url;
    }
    //重写call方法
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,fileName);
        System.out.println("下载了文件："+fileName);
        return true;
    }

    class WebDownloader{
        //下载方法
        public void downloader(String url, String fileName){
            try {
                FileUtils.copyURLToFile(new URL(url),new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("downloader方法异常");
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Demo01 demo1 = new Demo01("https://img2.baidu.com/it/u=2548333279,4114384196&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750","1.jpg");
        Demo01 demo2 = new Demo01("https://img2.baidu.com/it/u=2548333279,4114384196&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750","2.jpg");
        Demo01 demo3 = new Demo01("https://img2.baidu.com/it/u=2548333279,4114384196&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750","3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(demo1);
        Future<Boolean> r2 = ser.submit(demo2);
        Future<Boolean> r3 = ser.submit(demo3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        //关闭服务
        ser.shutdownNow();
    }
}
