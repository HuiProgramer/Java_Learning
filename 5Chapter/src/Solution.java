import java.util.Scanner;

public class Solution {

    public String longestPalidrome(String s){
        char temp;
        char[] strCopy = s.toCharArray();
        for(int i = 0;i <= strCopy.length/2-1;i++){
            temp = strCopy[i];
            strCopy[i] = strCopy[strCopy.length-1-i];
            strCopy[strCopy.length-i-1] = temp;
        }
        System.out.print(iQueryMaxCommString(s,new String(strCopy)));

        return s;
    }
    public static String iQueryMaxCommString(String stringA, String stringB) {

        if(stringA==null || stringB==null){
            return null;
        }
        if(stringA.length()<1 || stringB.length()<1){
            return "";
        }
        if (stringA.contains(stringB)) {
            char temp;
//            int flag = 0;
            char[] strCopy =stringB.toCharArray();
            for(int i = 0;i <= strCopy.length/2-1;i++){
                temp = strCopy[i];
                strCopy[i] = strCopy[strCopy.length-1-i];
                strCopy[strCopy.length-i-1] = temp;
            }
            if((new String(strCopy)).equals(stringB))
                return stringB;
//            if(stringA.indexOf(stringB) == (new String(strCopy)).indexOf(stringB)){
//                char[] arrays = stringB.toCharArray();
//                for(int i = 0;i<= arrays.length/2-1;i++){
//                    if(arrays[i] == arrays[arrays.length-i-1])
//                        continue;
//                    else
//                        flag = 1;
//                }
//                if(flag != 1) return stringB;
//            }

        }
        else if (stringB.length() == 1) {
            return "";
        }

        String leftSerach = iQueryMaxCommString(stringA, stringB.substring(0, stringB.length() - 1));
        String rightSerach = iQueryMaxCommString(stringA, stringB.substring(1, stringB.length()));
        return leftSerach.length() >= rightSerach.length() ? leftSerach : rightSerach;
    }
    public static void main(String[] args){
        System.out.print("请输入一个字符串:");
        String value = new Scanner(System.in).next();
        new Solution().longestPalidrome(value);
    }
}
