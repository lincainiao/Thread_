package StaticAgent;

//真实对象，你结婚
class You implements Marry{
    @Override
    public void marryHappy() {
        System.out.println("I'm married!");
    }

    @Override
    public void toast() {
        System.out.println("I'm not drunk~~");
    }
}
