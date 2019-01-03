import java.util.Scanner;

public class palindrome {
    public static void main(String[] args){
        System.out.println("请输入一个数字");
            String value = new Scanner(System.in).next();
            try{
                Integer.parseInt(value);
            }
            catch (Exception e){
                System.out.println("请输入数字");
                return;
            }
            System.out.println(new palindrome().judge(value)?"该数是一个回文数":"该数不是一个回文数");
    }
    private boolean judge(String value){
        char[] arrays = value.toCharArray();
        int [] num = new int[arrays.length];
        for(int i = 0;i < arrays.length;i++)
            num[i] = arrays[i] - '0';
        for(int i = 0;i<= num.length/2-1;i++){
            if(num[i] == num[num.length-i-1])
                continue;
            else
                return false;
        }
        return true;
    }
}
