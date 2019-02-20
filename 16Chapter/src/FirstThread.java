public class FirstThread extends Thread{
    private int i;
    //重写run()方法
    public void run(){
        for(;i < 100; i ++)
            System.out.println(getName() + " " + i);
    }
    public static void main(String[] args){
        for(int i = 0; i < 100; i ++){
            //调用Thread的CurrentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName()+ "" + i);
            if(i == 20){
                // 创建并启动第一个线程
                new FirstThread().start();
                //创建并启动第二个线程
                new FirstThread().start();
            }
        }
    }
}
