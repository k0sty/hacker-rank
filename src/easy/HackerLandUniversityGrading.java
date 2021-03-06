package easy;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class HackerLandUniversityGradingResult {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> ret = new LinkedList<>();

        for (Integer curr : grades) {
            if (curr < 38) {
                ret.add(curr);
                continue;
            }
            int modFive = curr % 5;
            if (modFive >=3) {
                ret.add (curr + 5 - modFive);
            } else {
                ret.add(curr);
            }

        }

        return ret;

    }

}

public class HackerLandUniversityGrading {
    public static void main(String[] args) throws IOException {
        List<Integer> result =
                HackerLandUniversityGradingResult.gradingStudents(
                        Arrays.asList(new Integer[] {73,
                                67,
                                38,
                                33}));
        System.out.print(result);
    }
}
