package newThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//Thread，实现多线程同步下载图片
public class Demo02 extends Thread{
    private String url;//图片路径
    private String fileName;//保存的文件名
    public Demo02 (String url,String fileName){
        this.fileName = fileName;
        this.url = url;
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

    //线程执行体
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,fileName);
        System.out.println("下载了文件："+fileName);
    }

    public static void main(String[] args) {
        Demo02 demo1 = new Demo02("https://i.bohexi.com/2022/01/0202201207546.jpg","1.jpg");
//        Demo02 demo2 = new Demo02("https://img2.baidu.com/it/u=2548333279,4114384196&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750","2.jpg");
//        Demo02 demo3 = new Demo02("https://img2.baidu.com/it/u=2548333279,4114384196&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750","3.jpg");

        demo1.start();
//        demo2.start();
//        demo3.start();
    }
}
