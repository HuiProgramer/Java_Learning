public class SecondThread implements Runnable{
    private int i ;
    //实现run()方法
    public void run(){
        for(;i < 100;i ++)
            System.out.println(Thread.currentThread().getName() + " " + i);
    }
    public static void main(String[] args){
        for(int i = 0; i < 100; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                SecondThread st = new SecondThread();
                new Thread(st,"新线程 1").start();
                new Thread(st,"新线程 2").start();
                try {
                    //使主线程休息5s，用于鉴别线程1和2是否运行
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

