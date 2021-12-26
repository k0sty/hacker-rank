import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class AppleAndOrangeResult {



    private static boolean didFruitLandOnHouse(ValueRange range ,
                                               int treeLocation, int currVal) {

        return range.isValidIntValue(treeLocation + currVal);

    }

    public static void countApplesAndOranges(int houseStart, int houseEnd, int appleTreeLocation,
                                             int orangeTreeLocation, List<Integer> apples,
                                             List<Integer> oranges) {
        int numApples = 0;
        int numOranges = 0;

        final ValueRange houseRange = ValueRange.of(houseStart, houseEnd);
        for (Integer apple : apples) {
            if (didFruitLandOnHouse(houseRange, appleTreeLocation, apple)) {
                numApples++;
            }
        }
        for (Integer orange : oranges) {
            if (didFruitLandOnHouse(houseRange, orangeTreeLocation, orange)) {
                numOranges++;
            }
        }

        System.out.println(numApples);
        System.out.println(numOranges);


    }

}

public class AppleAndOrange {
    public static void main(String[] args) throws IOException {
        List<Integer> apples = Arrays.asList(73,
                -2,
                2,
                1);
        List<Integer> oranges = Arrays.asList(73,
                5, -6);

        AppleAndOrangeResult.countApplesAndOranges(7, 11, 5, 15, apples, oranges);

    }
}
