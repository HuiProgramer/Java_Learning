public class YieldTest extends Thread {
    public YieldTest(String name){
        super(name);
    }
    //定义run()方法作为线程执行体
    public void run(){
        for( int i = 0; i< 50; i++){
            System.out.println(getName() + " " + i);
            if( i == 20)
                //线程让步
                Thread.yield();
        }
    }
    public static void main(String[] atgs){
        //启动两个线程
        YieldTest yt1 = new YieldTest("高级");
        //将yt1线程设置为最高优先级
        yt1.setPriority(5);
        YieldTest yt2 = new YieldTest("低级");
        //将yt2线程设置为最低优先级
        yt2.setPriority(6);
        yt2.start();
        yt1.start();
    }
}
