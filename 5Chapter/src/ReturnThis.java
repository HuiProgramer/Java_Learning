public class ReturnThis {
   private int age;
   public ReturnThis grow(){
       age++;
       return this;
   }
    public static void main(String[] args){
        ReturnThis rt = new  ReturnThis();
        rt.grow().grow().grow();
        System.out.print(rt.age);
    }
}
