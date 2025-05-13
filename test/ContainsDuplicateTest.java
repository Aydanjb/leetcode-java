import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    static class TestCase {
        int[] nums;
        boolean expected;

        TestCase(int[] nums, boolean expected) {
            this.nums = nums;
            this.expected = expected;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1
                new TestCase(new int[]{1, 2, 3, 1}, true),
                // Example 2
                new TestCase(new int[]{1, 2, 3, 4}, false),
                // Example 3
                new TestCase(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true),
                // Empty array
                new TestCase(new int[]{}, false),
                // Single element
                new TestCase(new int[]{1}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testContainsDuplicate(TestCase tc) {
        ContainsDuplicate solution = new ContainsDuplicate();
        assertEquals(tc.expected, solution.containsDuplicate(tc.nums));
    }
}
