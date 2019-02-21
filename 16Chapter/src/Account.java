import java.util.concurrent.locks.ReentrantLock;

public class Account {
    //定义锁对象
    private final ReentrantLock lock = new ReentrantLock();
    //封装账号编号、账户余额的两个成员变量
    private String accountNo;
    private double balance;
    public Account(){}
    //构造器
    public Account(String accountNo, double balance ){
        this.accountNo = accountNo;
        this.balance = balance;
    }
    //
    public String getAccountNo(){
        return accountNo;
    }
    public void setAccountNo(String accountNo){
        this.accountNo = accountNo;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    //将draw()方法写为同步方法
//    public synchronized void draw(double drawAmount){
//        if(balance >= drawAmount){
//            System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //修改余额
//            balance -= drawAmount;
//            System.out.println("\t余额为："+balance);
//        }
//        else
//            System.out.println(Thread.currentThread().getName()+"取钱失败! 余额不足！");
//    }
    //使用同步锁
    public void draw(double drawAmount){
        lock.lock();
        try{
            if(balance >= drawAmount){
                System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改余额
                balance -= drawAmount;
                System.out.println("\t余额为："+balance);
            }
            else
                System.out.println(Thread.currentThread().getName()+"取钱失败! 余额不足！");
        }
        finally{
            //修改完成，释放锁
            lock.unlock();
        }
    }
    public int hashCode(){
        return accountNo.hashCode();
    }
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if (obj != null && obj.getClass() == Account.class){
            Account target = (Account)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
