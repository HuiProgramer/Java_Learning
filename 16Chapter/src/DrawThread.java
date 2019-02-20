public class DrawThread extends Thread{
    //模拟用户账户
    private Account account;
    //当前取钱线程所希望的取钱
    private double drawAmount;
    public DrawThread(String name, Account account,double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    //当多个线程修改同一个共享数据时，将涉及数据安全问题
    public void run(){
//        //账户余额大于取钱数目
//        //使用account作为同步监视器，任何线程进入下面同步代码块之前
//        //必须先获得对account账户的锁定---其他线程无法获得锁，也就无法修改它
//        //这种做法符合: "加锁 -> 修改 -> 释放锁"的逻辑
//        synchronized(account){
//            if(account.getBalance() >= drawAmount){
//                System.out.println(getName()+"取钱成功！吐出钞票："+drawAmount);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                //修改余额
//                account.setBalance(account.getBalance() - drawAmount);
//                System.out.println("\t余额为："+account.getBalance());
//            }
//            else
//                System.out.println(getName()+"取钱失败! 余额不足！");
//        }
        //直接调用account对象的draw()方法执行取钱操作
        account.draw(drawAmount);
    }
}
