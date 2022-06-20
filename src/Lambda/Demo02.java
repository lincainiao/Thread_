package Lambda;
//带参数的lambda
public class Demo02 {
    public static void main(String[] args) {
//        ISay iSay = new Say();
//        iSay.say("where are you?");

        //简化1、不需要参数类型
        ISay iSay1 = (saying)->{
            System.out.println(saying);
        };
        iSay1.say("how are you?");

        //简化2、简化括号，变量名也不需要和接口的一样
        ISay iSay2 = sth -> {
            System.out.println(sth);
        };
        iSay2.say("hope you are fine.");

        //简化3、简化花括号，只能有一个语句，不能有多行
        ISay iSay3 = so -> System.out.println(so);
        iSay3.say("I miss you.");
    }
}


//定义接口
interface ISay{
    void say(String saying);
}

//实现接口的类
//class Say implements ISay{
//
//    @Override
//    public void say(String saying) {
//        System.out.println(saying);
//    }
//}