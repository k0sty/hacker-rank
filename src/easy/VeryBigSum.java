package easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class VeryBigSumResult {

    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static long aVeryBigSum(List<Long> ar) {
        long ret = 0l;
        for (long l : ar) {
            ret+=l;
        }
        return ret;
    }

}

public class VeryBigSum {
    public static void main(String[] args) throws IOException {
        List<Long> list = Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        System.out.println(VeryBigSumResult.aVeryBigSum(list));
    }
}
