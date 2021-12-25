import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class MinMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        long totalSum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer curr : arr) {
            totalSum += curr;
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }

        System.out.println((totalSum - max) + " " + (totalSum - min));
    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        MinMaxSumResult.miniMaxSum(Arrays.asList(1, -1, -3, 0, -5,10));

    }
}
