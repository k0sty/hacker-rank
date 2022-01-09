package hard;

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
import static java.util.stream.Collectors.toConcurrentMap;
import static java.util.stream.Collectors.toList;

/*

6
a b c aa d b
1 2 3 4 5 6
3
1 5 caaab
0 4 xyz
2 4 bcdybc

6
a b c aa d b
1 2 3 4 5 6
1
1 5 caaab

6
a b c aa d b
1 2 3 4 5 6
1
0 4 xyz

0 294570874
 */

class TrieLevel {
    private final Map<Character, TrieLevel> trieLevelMap;
    private boolean isWord;
    private int value = 0;

    TrieLevel () {
        this.trieLevelMap = new HashMap<>();
    }

    TrieLevel (boolean isWord, int value) {
        this();
        this.isWord = isWord;
        this.value = value;
    }

    Map<Character, TrieLevel> getTrieLevelMap() {
        return trieLevelMap;
    }

    void setIsWord(boolean isWord, int value) {
        if (!this.isWord) {
            this.isWord = isWord;
        }
        if (isWord) {
            this.value += value;
        }
    }

    boolean isWord() {
        return isWord;
    }

    int getValue() {
        return value;
    }
}

class Pair {
    private final String gene;
    private final int score;

    Pair(String gene, int score) {
        this.gene = gene;
        this.score = score;
    }

    String getGene() {
        return gene;
    }

    int getScore() {
        return score;
    }
}

class Trie {
    private TrieLevel rootTrieLevel;

    Trie() {
        rootTrieLevel = new TrieLevel();
    }

    void addWord(String word, int value) {


        TrieLevel currentLevel = rootTrieLevel;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            boolean isWord = (i == word.length()-1);
            final Map<Character, TrieLevel> currentMap = currentLevel.getTrieLevelMap();
            if (currentMap.containsKey(curr)) {
                final TrieLevel trieLevel = currentMap.get(curr);
                trieLevel.setIsWord(isWord, value);
                currentLevel = trieLevel;
            } else {
                TrieLevel newLevel = isWord? new TrieLevel(isWord, value) : new TrieLevel();
                currentMap.put(curr, newLevel);
                currentLevel = newLevel;
            }
        }
    }

    private Pair getNextGene(String geneSequence) {
        StringBuilder builder = new StringBuilder();

        TrieLevel currentLevel = rootTrieLevel;

        for (Character curr : geneSequence.toCharArray()) {
            if (currentLevel.getTrieLevelMap().containsKey(curr)) {
                builder.append(curr);
                final TrieLevel level = currentLevel.getTrieLevelMap().get(curr);
                if (level.isWord()) {
                    return new Pair(builder.toString(), level.getValue());
                }
                currentLevel = level;
            } else {
                break;
            }
        }

        return null;
    }

    int getScore(String gene) {
        int ret = 0;

        for (int i = 0; i < gene.length(); i++) {
            final String substring = gene.substring(i, gene.length());
            Pair pair = getNextGene(substring);
            if (pair != null) {
                ret += pair.getScore();
            }
        }

        return ret;
    }

    private void printAllWordsHelper(StringBuilder builder, TrieLevel currentLevel) {

        if (currentLevel.isWord()) {
            System.out.println(builder.toString() + " " + currentLevel.getValue());
        }
        for (Character curr : currentLevel.getTrieLevelMap().keySet()) {
            printAllWordsHelper(builder.append(curr), currentLevel.getTrieLevelMap().get(curr));
        }
    }
}

public class DeterminingDnaHealth {
    public static void main(String[] args) throws IOException {
        System.out.println(System.currentTimeMillis());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());



        int s = Integer.parseInt(bufferedReader.readLine().trim());
        final SortedSet<Integer> sortedSet = new TreeSet<>();
        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];
                Trie trie = new Trie();
                for (int i = first; i <=last; i++) {
                    trie.addWord(genes.get(i), health.get(i));
                }

                sortedSet.add(trie.getScore(d));

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        });

        System.out.println(sortedSet.first() + " " + sortedSet.last());
        System.out.println(System.currentTimeMillis());
        bufferedReader.close();
    }
}

