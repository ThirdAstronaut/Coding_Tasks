import java.util.HashMap;
import java.util.Map;

public class StringCounterImpl implements StringCounter {

    private static Map<String, Integer> stringOccurrence = new HashMap<>();

    public static Map<String, Integer> getStringOccurrence() {
        return stringOccurrence;
    }

    public void add(String input) {
        if (stringOccurrence.containsKey(input)) {
            stringOccurrence.replace(input, stringOccurrence.get(input) + 1);
        } else {
            stringOccurrence.put(input, 1);
        }
    }

    public int count(String input) {
        return stringOccurrence.getOrDefault(input, 0);
    }

}
