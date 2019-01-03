import java.util.Arrays;
public class array{
    public static void main(String[] args)
    {
        int[] array1 = new int[5];
        int[] array2 = new int[5];
        int index1 = 1;
        int index2 = 0;
        for (int i = 0; i < 5; i++)
        {
            array1[i] = index1;
            index1 += 2;
            System.out.println(array1[i]);
        }
        for (int i = 0; i < 5; i++)
        {
            array2[i] = index2;
            index2 += 2;
            System.out.println(array2[i]);
        }
        int[] gradeCount = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, gradeCount, 0, array1.length);
        System.arraycopy(array2, 0, gradeCount, array1.length, array2.length);
        Arrays.sort(gradeCount);
        for (int i = 0; i < 10; i++)
            System.out.print(gradeCount[i]);
    }
}
