import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpuTest {
    @Test
    public void test1() {
        // i7-7700
        Cpu i7 = new Cpu("Core i7 7700", 7, 4, 8, 4200, 14);
        assertEquals(15443f, i7.totalScore(), 1f, "Score should be 15433");
    }
    @Test
    void testModernCpus() {
        // i3-10100
        Cpu i3 = new Cpu("Core i3 10100", 10, 4, 8, 4300, 14);
        assertEquals(18897f, i3.totalScore(), 1f, "i3-10100 score mismatch");

        // i7-12700K
        Cpu i7 = new Cpu("Core i7 12700K", 12, 12, 20, 5000, 10);
        assertEquals(78872f, i7.totalScore(), 1f, "i7-12700K score mismatch");
    }
    @Test
    void testSingleThreadedCpus() {
        // i5-6400
        Cpu i5 = new Cpu("Core i5", 6, 4, 4, 3600, 14);
        assertEquals(9427f, i5.totalScore(), 1f, "i5-6400 score mismatch");
    }
}
