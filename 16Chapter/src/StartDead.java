public class StartDead extends Thread{
    private int i;
    //重写run()方法
    public void run(){
        for(;i < 100; i ++)
            System.out.println(getName() + " " + i);
    }
    public static void main(String[] args){
        StartDead sd = new StartDead();
        for(int i = 0; i < 100; i ++){
            //调用Thread的CurrentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName()+ "" + i);
            if(i == 20){
                //启动线程
                //设置为后台线程
                sd.setDaemon(true);
                sd.start();
                //判断启动后线程的isAlive()值，输出true
                System.out.println(sd.isAlive());
            }
            if(i > 20 && !sd.isAlive())
                sd.start();//死亡状态尝试再次启动线程
        }
    }
}
