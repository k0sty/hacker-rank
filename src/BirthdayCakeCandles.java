import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BirthdayCakeCandlesResult {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        int currMax = Integer.MIN_VALUE;
        int currCount = 0;

        for (Integer curr : candles) {
            if (curr > currMax) {
                currMax = curr;
                currCount = 1;
            } else if (curr == currMax) {
                currCount++;
            }
        }

        return currCount;

    }

}

public class BirthdayCakeCandles {
    public static void main(String[] args) throws IOException {

        int result = BirthdayCakeCandlesResult.birthdayCakeCandles(Arrays.asList(4, 4, 1, 3));
        System.out.println(result);
    }
}
