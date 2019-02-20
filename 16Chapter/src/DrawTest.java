public class DrawTest {
    public static void main(String[] args){
        //创建一个账户
        Account acct = new Account("1234567",1000);
        //模拟两个线程对同一账户取钱
        new DrawThread("甲",acct,800).start();
        new DrawThread("乙",acct,800).start();
        new DrawThread("丙",acct,800).start();
        new DrawThread("丁",acct,800).start();
        new DrawThread("戊",acct,800).start();
        new DrawThread("戌",acct,800).start();
    }
}
