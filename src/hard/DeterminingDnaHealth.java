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



 */

//class TrieTuple {
//    final char character;
//    boolean isWord;
//
//    public TrieTuple(char character, boolean isWord) {
//        this.character = character;
//        this.isWord = isWord;
//    }
//
//    public char getCharacter() {
//        return character;
//    }
//
//    public boolean isWord() {
//        return isWord;
//    }
//
//    public void setWord(boolean word) {
//        isWord = word;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof TrieTuple)) return false;
//        TrieTuple trieTuple = (TrieTuple) o;
//        return getCharacter() == trieTuple.getCharacter();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getCharacter());
//    }
//}

class TrieLevel {
    private final Map<Character, TrieLevel> trieLevelMap;
    private final char character;
    private boolean isWord;
    private int value = 0;

    TrieLevel (char character) {
        this.trieLevelMap = new HashMap<>();
        this.character = character;
    }

    TrieLevel (char character, boolean isWord, int value) {
        this(character);
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

    char getCharacter() {
        return character;
    }

    int getValue() {
        return value;
    }
}

class Trie {
    private TrieLevel rootTrieLevel;

    Trie() {
        rootTrieLevel = new TrieLevel('');
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
                TrieLevel newLevel = isWord? new TrieLevel(curr, isWord, value) : new TrieLevel(curr);
                currentMap.put(curr, newLevel);
                currentLevel = newLevel;
            }
        }
    }

    SortedSet<Integer> getScoreForGene(String gene) {
        SortedSet<Integer> sortedSet = new TreeSet<>();

        sortedSet.addAll(getScoreForGeneHelper(new HashSet<Integer>(), 0, gene, rootTrieLevel));

        return sortedSet;
    }

    Set<Integer> getScoreForGeneHelper(Set<Integer> scores, int currentScore,
                                       String remainingGene, TrieLevel currentTrieLevel) {
        if (currentTrieLevel.isWord()) {
            currentScore += currentTrieLevel.getValue();
        }

        if (remainingGene.isEmpty()) {
            scores.add(currentScore);
            return scores;
        }

        final Map<Character, TrieLevel> currTrieLevelMap = currentTrieLevel.getTrieLevelMap();
        final char currChar = remainingGene.charAt(0);
        if (currTrieLevelMap.containsKey(currChar)) {
            return getScoreForGeneHelper(scores, currentScore,
                    remainingGene.substring(1, remainingGene.length()-1),
                    currTrieLevelMap.get(currChar));
        }
        return new HashSet<>();
    }


    void printAllWords() {
        TrieLevel currentLevel = rootTrieLevel;
        for (Character curr: currentLevel.getTrieLevelMap().keySet()) {
            printAllWordsHelper(new StringBuilder(), currentLevel.getTrieLevelMap().get(curr));
        }
    }

    private void printAllWordsHelper(StringBuilder builder, TrieLevel currentLevel) {
        builder.append(currentLevel.getCharacter());
        if (currentLevel.isWord()) {
            System.out.println(builder.toString() + " " + currentLevel.getValue());
        }
        for (Character curr : currentLevel.getTrieLevelMap().keySet()) {
            printAllWordsHelper(builder, currentLevel.getTrieLevelMap().get(curr));
        }
    }
}

public class DeterminingDnaHealth {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());



        int s = Integer.parseInt(bufferedReader.readLine().trim());

        int minScore = Integer.MIN_VALUE;
        int maxScore = Integer.MAX_VALUE;

        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];
                System.out.println(d + ":");
                Trie trie = new Trie();
                for (int i = first; i <=last; i++) {
                    trie.addWord(genes.get(i), health.get(i));
                }
                trie.printAllWords();
                System.out.println();

                //System.out.println(trie.getScoreForGene(d));

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

