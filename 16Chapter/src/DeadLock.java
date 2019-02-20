class A{
    public synchronized void foo(B b){
        System.out.println("当前线程名："+ Thread.currentThread().getName()+" 进入了实例A的foo()方法");
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("当前线程名："+ Thread.currentThread().getName()+" 企图进入实例B的last()方法");
        b.last();
    }
    public synchronized void last(){
        System.out.println("成功进入实例A的内部");
    }
}
class B{
    public synchronized void bar(A a){
        System.out.println("当前线程名："+ Thread.currentThread().getName()+" 进入了实例B的bar()方法");
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("当前线程名："+ Thread.currentThread().getName()+" 企图进入实例A的last()方法");
        a.last();
    }
    public synchronized void last(){
        System.out.println("成功进入实例B的内部");
    }
}
public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();
    public void init(){
        Thread.currentThread().setName("主线程");
        //调用a对象里的foo()方法
        a.foo(b);
        System.out.println("进入主线程之后");
    }
    public void run(){
        Thread.currentThread().setName("副线程");
        //调用a对象里的foo()方法
        b.bar(a);
        System.out.println("进入副线程之后");
    }
    public static void main(String[] args){
        DeadLock d1 = new DeadLock();
        //以d1为target启动新线程
        new Thread(d1).start();
        //调用init()方法
        d1.init();
    }
}
