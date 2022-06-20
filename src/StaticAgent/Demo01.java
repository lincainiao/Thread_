package StaticAgent;
//静态代理

//代理和真是对象都要实现一个接口
//代理对象要代理真是角色
//好处，代理对象可以做很多真实对象做不了的事情；真实对象可以专注做自己的事
public class Demo01 {
    public static void main(String[] args) {
        //真实对象
        You you = new You();
        //代理
        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.work();

    }
}
