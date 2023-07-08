package expectation;

class SomeObject
{
    SomeObject(String s)
    {
        System.out.println(s);
    }
    SomeObject()
    {
        System.out.println("SomeObject 默认构造函数被调用");
    }
}
class Father
{
    SomeObject s1=new SomeObject("父类 s1 成员初始化");
    Father()
    {
        System.out.println("父类 Father 默认构造函数被调用");
    }
    SomeObject s2=new SomeObject("父类 s2 成员初始化");
}
class Son3 extends Father
{
    Son3()
    {
        System.out.println("子类 Son 默认构造函数被调用");
    }
    SomeObject s1=new SomeObject("子类 s1 成员初始化");
    SomeObject s2=new SomeObject("子类 s2 成员初始化");
    public static void main(String[] args)
    {
        Father a=new Son3();
    }
}