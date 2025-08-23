import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {
    static class TestCase {
        int[] nums;
        int expected;

        public TestCase(int[] nums, int expected) {
            this.nums = nums;
            this.expected = expected;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new int[]{100, 4, 200, 1, 3, 2}, 4),
                new TestCase(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9),
                new TestCase(new int[]{1, 0, 1, 2}, 3),
                new TestCase(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void longestConsecutive(TestCase tc) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int actual = solution.longestConsecutive(tc.nums);
        assertEquals(tc.expected, actual);
    }
}