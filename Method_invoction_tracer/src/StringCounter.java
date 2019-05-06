import java.util.HashMap;
import java.util.Map;

class StringCounter {

    private static Map<String, Integer> stringOccurrence = new HashMap<>();


    /**
     * @param input String to save
     */
    void add(String input) {
        if (stringOccurrence.containsKey(input)) {
            stringOccurrence.replace(input, stringOccurrence.get(input) + 1);
        } else {
            stringOccurrence.put(input, 1);
        }
    }

    /**
     * @param input String to retrieve information about
     * @return number of passed @param occurrences
     */
    int count(String input) {
        return stringOccurrence.getOrDefault(input, 0);
    }

    static Map<String, Integer> getStringOccurrence() {
        return stringOccurrence;
    }

    static void setStringOccurrence(Map<String, Integer> stringOccurrence) {
        StringCounter.stringOccurrence = stringOccurrence;
    }
}
