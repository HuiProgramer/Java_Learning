import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread{
    private BlockingQueue<String> bq;
    public Producer(BlockingQueue<String> bq){
        this.bq = bq;
    }
    public void run(){
        String[] strArr = new String[]{
                "Java",
                "Struts",
                "Spring"
        };
        for(int i = 0; i < 9999999; i++){
            System.out.println(getName() + "生产者准备生产集合元素！");
            try{
                Thread.sleep(200);
                //尝试放入元素，如果队列已满，则线程被阻塞
                bq.put(strArr[i % 3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "生产完成："+ bq);
        }
    }
}
class Consumer extends Thread{
    private BlockingQueue<String> bq;
    public Consumer(BlockingQueue<String> bq){
        this.bq = bq;
    }
    public void run(){
        while(true){
            System.out.println(getName()+ "消费者准备消费的集合元素！");
            try{
                Thread.sleep(200);
                //尝试取出元素，如果队列已空，则线程被阻塞
                bq.take();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"消费完成：" + bq);
        }
    }
}
public class BlockingQueueTest2 {
    public static void main(String[] args){
        //创建容量为1的BlockingQueue
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        //启动三个生产者线程
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();
        //再启动一个消费者线程
        new Consumer(bq).start();
    }
}
