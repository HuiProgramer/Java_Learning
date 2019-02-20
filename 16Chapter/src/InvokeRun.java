public class InvokeRun extends Thread{
    private int i;
    //重写run()方法，run()方法的方法体就是线程执行体
    public void run(){
        for(; i < 100; i++){
            //直接调用run()方法时，Thread的this.getName()返回的是该对象的名字
            //而不是当前线程的名字
            //使用Thread.currentThread().getName()总是获取当前线程的名字
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    public static void main(String[] args){
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                //直接调用run()方法，系统会将该方法当成普通方法
                new InvokeRun().run();
                new InvokeRun().run();
            }
        }

    }
}
