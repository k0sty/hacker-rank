import java.io.IOException;

class StaircaseResult {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < n * n; i++) {
            int lineNum = i / n;
            int columnNum = i % n;
            int numSpaces = n - lineNum - 1;
            if (columnNum < numSpaces) {
                buf.append(" ");
            } else {
                buf.append("#");
            }

            if (columnNum == n-1) {
                buf.append("\n");
            }
        }
        System.out.print(buf.toString());
    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        StaircaseResult.staircase(5);
    }
}
