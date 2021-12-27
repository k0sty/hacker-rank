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

class BetweenTwoSetsResult {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    private static boolean isNumberDivisibleByAllOfList(int number, List<Integer> list) {
        for (Integer curr: list) {
            if (number % curr != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean areAllNumbersDivisiblebyDivisor(int divisor, List<Integer> list) {
        for (Integer curr: list) {
            if (curr % divisor != 0) {
                return false;
            }
        }
        return true;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        List<Integer> divisors = new LinkedList<>();
        // generate the potential numbers
        for (int i = a.get(a.size()-1); i <= b.get(0); i++ ) {
            if (isNumberDivisibleByAllOfList(i, a)) {
                divisors.add(i);
            }
        }
        int ret = 0;
        for (Integer curr : divisors) {
            if (areAllNumbersDivisiblebyDivisor(curr, b)) {
                ret++;
            }
        }
        return ret;
    }

}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {


        System.out.println(BetweenTwoSetsResult.getTotalX(Arrays.asList(2, 6),
                Arrays.asList(24, 36)));
        System.out.println(BetweenTwoSetsResult.getTotalX(Arrays.asList(2, 4),
                Arrays.asList(16, 32, 96)));
    }
}
