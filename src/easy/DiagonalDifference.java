package easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class DiagonalDifferenceResult {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int rToL = 0;
        int lToR = 0;

        for (int i = 0; i < arr.get(0).size(); i++) {
            rToL += arr.get(i).get(i);
            lToR += arr.get(i).get(arr.get(0).size() - (i+1));
        }
        return Math.abs(rToL - lToR);
    }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        List<Integer> rowOne = Arrays.asList(11, 2, 4);
        List<Integer> rowTwo = Arrays.asList(4, 5, 6);
        List<Integer> rowThree = Arrays.asList(10, 8, -12);

        List<List<Integer>> list = List.of(rowOne, rowTwo, rowThree);
        System.out.println(DiagonalDifferenceResult.diagonalDifference(list));
    }
}
