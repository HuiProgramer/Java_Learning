class Account1{
    /*定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量
    每个线程都会保留该变量的一个副本
    * */
    private ThreadLocal<String> name = new ThreadLocal<>();
    //定义一个初始化name成员变量的构造器
    public Account1(String str){
        this.name.set(str);
        //下面代码用于访问当前线程的name副本的值
        System.out.println("---" + this.name.get());
    }
    //name和setter和getter方法
    public String getName(){
        return name.get();
    }
    public void setName(String str){
        this.name.set(str);
    }
}
class MyTest extends Thread{
    //定义一个Account类型的成员变量
    private Account1 account;
    public MyTest(Account1 account,String name){
        super(name);
        this.account = account;
    }
    public void run(){
        //循环10次
        for(int i = 0 ; i < 10 ; i ++){
            //当i==6时输出将账户名替换成当前线程名
            if(i == 6)
                account.setName(getName());
            //输出同一账户的账号名和循环变量
            System.out.println(account.getName() + "账户的i值：" + i);
        }
    }
}
public class ThreadLocalTest {
    public static void main(String[] args){
        //启动两个线程，两个线程共享同一个Account
        Account1 at = new Account1("初始名");
        /*
        * 虽然两个线程共享一个账户，但由于账户名是ThreadLocal类型的，
        * 所以每个线程都完全拥有各自的账户名副本，因此在 i == 6之后，
        * 将看到两个线程访问同一账户时出现不同的账户名
        * */
        new MyTest(at,"线程甲").start();
        new MyTest(at,"线程乙").start();
    }
}
