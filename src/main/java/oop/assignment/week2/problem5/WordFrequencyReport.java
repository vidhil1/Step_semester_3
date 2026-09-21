import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(
            String feedback) {

        Set<String> stopWords =
                new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        String cleanedText =
                feedback
                        .toLowerCase()
                        .replace(".", "")
                        .replace(",", "");

        String[] words =
                cleanedText.split("\\s+");

        Map<String, Integer> frequency =
                new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
            );
        }

        frequency.entrySet()
                .stream()
                .sorted(
                        (entry1, entry2) ->
                                entry2.getValue()
                                        .compareTo(
                                                entry1.getValue()
                                        )
                )
                .forEach(
                        entry ->
                                System.out.println(
                                        entry.getKey()
                                        + ": "
                                        + entry.getValue()
                                )
                );
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, "
                + "the session was great "
                + "and clear.";

        printFilteredWordFrequency(
                feedback
        );
    }
}
