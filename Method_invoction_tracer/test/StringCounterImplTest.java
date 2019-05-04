import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class StringCounterImplTest {

    @Test
    public void add() {
        StringCounterImpl stringCounter = new StringCounterImpl();
        String emptyString = "";

        assertEquals(0, StringCounterImpl.getStringOccurrence().size());

        stringCounter.add(emptyString);
        assertEquals(1, StringCounterImpl.getStringOccurrence().size());
        assertEquals(1, StringCounterImpl.getStringOccurrence().get(emptyString).intValue());


        stringCounter.add(emptyString);
        assertEquals(1, StringCounterImpl.getStringOccurrence().size());
        assertEquals(2, StringCounterImpl.getStringOccurrence().get(emptyString).intValue());

        stringCounter.add(null);
        assertEquals(2, StringCounterImpl.getStringOccurrence().size());
        assertEquals(1, StringCounterImpl.getStringOccurrence().get(null).intValue());

        assertTrue(StringCounterImpl.getStringOccurrence().containsKey(emptyString) && StringCounterImpl.getStringOccurrence().containsKey(null));
    }

    @Test
    public void count() {
        StringCounterImpl stringCounter = new StringCounterImpl();
        String emptyString = "";
        String catString = "cat";

        assertEquals(0, stringCounter.count(null));
        assertEquals(0, stringCounter.count(null));
        assertEquals(0, stringCounter.count(emptyString));
        stringCounter.add(catString);
        assertEquals(1, stringCounter.count(catString));

        stringCounter.add(emptyString);
        assertEquals(1, stringCounter.count(catString));

        stringCounter.add(catString);
        assertEquals(2, stringCounter.count(catString));
    }
}
