import java.util.Arrays;
public class record {
    public static void main(String[] args)
    {
        int[] record = {1, 2, 2, 3, 9, 9, 5, 5, 8, 8};
        int[] recordRecovery = new int[10];
        /********** Begin ********/
        int num = 0;
        for (int i = 0; i < 10; i ++)
        {
            boolean istrue = true;
            for ( int j = i + 1; j < 10; j++)
                if (record[i] == record[j])
                {
                    istrue = false;
                    break;
                }

            if (istrue)
            {
                recordRecovery[num] = record[i];
                num ++;
            }

        }
        int[] array1 = new int[10];
        Arrays.sort(recordRecovery);
        for (int i = 0, j = 0; i < 10; i ++)
            if (recordRecovery[i] != 0)
            {
                array1[j] = recordRecovery[i];
                j++;
            }
        for (int i = 0; i < 10;i++)
            recordRecovery[i] = array1[i];

        /********** End *********/
        for (int i = 0; i < num; i++) {
            System.out.print(recordRecovery[i]);
            if (i != num - 1) {
                System.out.print(' ');
            }
        }
    }
    }
