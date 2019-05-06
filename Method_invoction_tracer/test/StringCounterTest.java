import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class StringCounterTest {

    @Before
    public void resetStringOccurrences() {
        StringCounter.setStringOccurrence(new HashMap<>());
    }

    @Test
    public void add() {
        StringCounter stringCounter = new StringCounter();
        StringCounter stringCounter2 = new StringCounter();
        String nullValue = null;
        String emptyString = "";
        String catString = "cat";

        stringCounter.add(emptyString);
        assertEquals(1, StringCounter.getStringOccurrence().size());
        assertEquals(1, StringCounter.getStringOccurrence().get(emptyString).intValue());


        stringCounter.add(emptyString);
        assertEquals(1, StringCounter.getStringOccurrence().size());
        assertEquals(2, StringCounter.getStringOccurrence().get(emptyString).intValue());

        stringCounter2.add(nullValue);
        assertEquals(2, StringCounter.getStringOccurrence().size());
        assertEquals(1, StringCounter.getStringOccurrence().get(nullValue).intValue());

        stringCounter2.add(catString);
        stringCounter.add(catString);
        assertEquals(2, StringCounter.getStringOccurrence().get(catString).intValue());


        assertTrue(StringCounter.getStringOccurrence().containsKey(emptyString) && StringCounter.getStringOccurrence().containsKey(nullValue) && StringCounter.getStringOccurrence().containsKey(catString));
    }

    @Test
    public void count() {
        StringCounter stringCounter = new StringCounter();
        StringCounter stringCounter2 = new StringCounter();
        String emptyString = "";
        String catString = "cat";

        assertEquals(0, stringCounter.count(null));
        assertEquals(0, stringCounter.count(emptyString));

        StringCounter.getStringOccurrence().put(catString, 1);
        assertEquals(1, stringCounter.count(catString));
        assertEquals(0, stringCounter.count(null));

        StringCounter.getStringOccurrence().put(emptyString, 1);
        assertEquals(1, stringCounter2.count(catString));

        StringCounter.getStringOccurrence().put(catString, 2);
        assertEquals(2, stringCounter.count(catString));
    }
}
