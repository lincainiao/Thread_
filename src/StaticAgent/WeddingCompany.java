package StaticAgent;

//代理角色，帮助你结婚
class WeddingCompany implements Marry{
    //结婚对象，代理的真实角色
    private Marry target;
    //构造方法
    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void marryHappy() {
        this.target.marryHappy();
    }

    @Override
    public void toast() {
        this.target.toast();
    }

    //代理对象要做的事
    public void work(){
        before();
        marryHappy();
        toast();
        after();
    }

    public void before() {
        System.out.println("charging.");
    }
    public void after(){
        System.out.println("sweeping.");
    }
}
