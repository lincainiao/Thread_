package Synchronized_;

public class UnsafeMoney {
    public static void main(String[] args) {
        Account account = new Account(200,"基金");
        Draw draw1 = new Draw(account,20,"lin");
        Draw draw2 = new Draw(account,100,"zhao");

        draw2.start();
        draw1.start();
    }
}


//账户
class Account{
    int nowAccountMoney;//余额
    String accountName;//卡名

    public Account(int money, String name) {
        this.nowAccountMoney = money;
        this.accountName = name;
    }
}
//模拟银行取款
class Draw extends Thread{
    Account account;//账户
    //取了多少钱
    int drawMoney;
    //剩余多少钱
    int nowMoney;
    //取钱的人
    String drawName;
    public Draw(Account account, int drawMoney, String drawName){
        this.account = account;
        this.drawMoney = drawMoney;
        this.drawName = drawName;
    }
    @Override
    public void run(){
        //同步块
        //由于操作的是account对象，对account同步，锁的对象就是需要改变的量
        synchronized (account){
            //判断是否有钱
            if (drawMoney > account.nowAccountMoney || account.nowAccountMoney<0){
                System.out.println("sorry "+drawName+"~, you don't have enough money, the account is "+account.nowAccountMoney+" left");
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额 = 余额 - 取的钱
            account.nowAccountMoney = account.nowAccountMoney - drawMoney;
            System.out.println(drawName+"取走了"+drawMoney+"元, 账户"+account.accountName+"还剩余"+account.nowAccountMoney+"元");
        }
    }
}