import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ScannerFileTest {
    public static void main(String[] args) throws FileNotFoundException {
        //将一个File对象作为Scanner的构造器参数，Scanner读取文件内容
        try {
            Scanner sc = new Scanner(new File("props.txt"));
            System.out.println("props.txt文件内容如下：");
            while (sc.hasNextLine()) {
                //输出文件中的下一行
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("没有找到文件");
        }

    }
}