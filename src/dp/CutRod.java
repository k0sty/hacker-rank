package dp;

import java.io.IOException;
import java.util.List;

class CutRodResult {

    public static int cutRod(int length, List<Integer> lengths, List<Integer> prices) {

        if (length <= 0) {
            return 0;
        }

        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < lengths.size(); i++) {
            if (length >= lengths.get(i)) {
                ret = Math.max(ret, prices.get(i) + cutRod(length - lengths.get(i), lengths, prices));
            }
        }
        return ret;
    }
}

public class CutRod {

    public static void main(String[] args) throws IOException {
        System.out.println(CutRodResult.cutRod(8, List.of(1,   2,   3,   4,   5,   6,   7,  8),
                List.of(1,   5,   8,   9,  10,  17,  17,  20)));
    }
}
