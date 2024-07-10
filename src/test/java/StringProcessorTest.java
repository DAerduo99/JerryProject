import org.example.StringProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProcessorTest {

    @Test
    public void testRemoveConsecutiveDuplicates() {
        StringProcessor processor = new StringProcessor();
        assertEquals("d", processor.processString("aabcccbbad", true));
    }

    @Test
    public void testReplaceConsecutiveDuplicates() {
        StringProcessor processor = new StringProcessor();
        assertEquals("d", processor.processString("abcccbad", false));
    }
}