package Station_;

import javax.xml.crypto.Data;
import java.sql.DataTruncation;
import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class Sleep02 {
    public void tenDown(){
        int nums = 10;
        while (true) {
            System.out.println(nums--);
            if (nums < 0) break;
            try {
                //休眠一秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Sleep02 sleep02 = new Sleep02();
//        sleep02.tenDown();

        //打印当前系统时间
        Date startDate = null;
        while (true) {
            //更新当前时间
            startDate = new Date(System.currentTimeMillis());
            //格式化时间
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startDate));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
