package easy;

import java.io.*;

import static java.util.stream.Collectors.joining;

class KangarooProblemResult {

    private static float getIntersectionPoint(int b1, int m1, int b2, int m2) {
        float tmpM = m1 - m2;
        float tmpB = b2 - b1;
        return tmpB / tmpM;
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 == v2 && x1 != x2) {
            return "NO";
        }
        final float intersectionPoint = getIntersectionPoint(x1, v1, x2, v2);
        if (Math.ceil(intersectionPoint) != intersectionPoint) {
            return "NO";
        }
        return intersectionPoint > 0 ? "YES" : "NO";

    }

}

public class KangarooProblem {
    public static void main(String[] args) throws IOException {
        System.out.println(KangarooProblemResult.kangaroo(2, 1, 1, 2));
        System.out.println(KangarooProblemResult.kangaroo(0, 2, 5, 3));
        System.out.println(KangarooProblemResult.kangaroo(3, 2, 0, 2));
    }
}
