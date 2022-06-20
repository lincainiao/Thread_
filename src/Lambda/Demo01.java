package Lambda;

//推导lambda表达式
public class Demo01 {
    public static void main(String[] args) {
        //匿名内部类
        ILike like1 = new ILike() {
            @Override
            public void lamda() {
                System.out.println("this is annoy");
            }
        };
        like1.lamda();

        //用lambda简化
        ILike like2 = ()->{
            System.out.println("this is lambda");
        };
        like2.lamda();
    }
}

//定义接口
interface ILike{
    void lamda();
}