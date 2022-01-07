package easy;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

class ResultPlusMinus {

    private static String getRatio(int num, int total) {
        NumberFormat formatter = new DecimalFormat("#0.000000");
        float ratio = (float)num / total;
        return formatter.format(ratio);
    }

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int numNeg = 0;
        int numPos = 0;
        int numZero = 0;

        float ret = 0f;
        for (Integer i : arr) {
            if (i > 0) {
                numPos++;
            } else if (i < 0) {
                numNeg++;
            } else {
                numZero++;
            }
        }
        System.out.println(getRatio(numPos, arr.size()));
        System.out.println(getRatio(numNeg, arr.size()));
        System.out.println(getRatio(numZero, arr.size()));


    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {

        ResultPlusMinus.plusMinus(Arrays.asList(1, -1, -3, 0, -5));

    }
}
