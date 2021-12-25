import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CompareTripletsResult {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> ret = new ArrayList<Integer> (2);
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i< 3; i++) {
            aliceScore += a.get(i).compareTo(b.get(i)) > 0 ? 1 : 0;
            bobScore += b.get(i).compareTo(a.get(i)) > 0 ? 1 : 0;
        }

        ret.add(aliceScore);
        ret.add(bobScore);
        return ret;
    }

}

public class CompareTriplets {
    public static void main(String[] args) throws IOException {
        List<Integer> aliceScores = Arrays.asList(new Integer[] {5, 2, 3});
        List<Integer> bobScores = Arrays.asList(new Integer[] {5, 8, 3});

        System.out.println(CompareTripletsResult.compareTriplets(aliceScores, bobScores));


    }
}
