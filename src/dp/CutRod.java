package dp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CutRodResult {

    public static int cutRod(int length, Map<Integer, Integer> map, List<Integer> lengths, List<Integer> prices) {
        if (length <= 0) {
            return 0;
        } else if (map.containsKey(length)) {
            return map.get(length);
        }

        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < lengths.size(); i++) {
            if (length >= lengths.get(i)) {
                ret = Math.max(ret, prices.get(i) + cutRod(length - lengths.get(i), map, lengths, prices));
            }
        }
        int currVal = map.getOrDefault(length, Integer.MIN_VALUE);
        if (currVal < ret) {
            map.put(length, ret);
        }
        return ret;
    }

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
        long before = System.currentTimeMillis();
        System.out.println(CutRodResult.cutRod(8, List.of(1,   2,   3,   4,   5,   6,   7,  8),
                List.of(1,   5,   8,   9,  10,  17,  17,  20)));
        long after = System.currentTimeMillis();
        System.out.println(after - before);

        before = System.currentTimeMillis();
        System.out.println(CutRodResult.cutRod(4, List.of(1,   2,   3,   4,   5,   6,   7,  8, 9, 10),
                List.of(1,   5,   8,   9,  10,  17,  17,  20, 24, 30)));
        after = System.currentTimeMillis();
        System.out.println(after - before);

        before = System.currentTimeMillis();
        System.out.println(CutRodResult.cutRod(8, new HashMap<>(), List.of(1,   2,   3,   4,   5,   6,   7,  8),
                List.of(1,   5,   8,   9,  10,  17,  17,  20)));
        after = System.currentTimeMillis();
        System.out.println(after - before);

        before = System.currentTimeMillis();
        System.out.println(CutRodResult.cutRod(4, new HashMap<>(), List.of(1,   2,   3,   4,   5,   6,   7,  8, 9, 10),
                List.of(1,   5,   8,   9,  10,  17,  17,  20, 24, 30)));
        after = System.currentTimeMillis();
        System.out.println(after - before);

    }
}
