import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {
    static class TestCase {
        int[] nums;
        int k;
        int[] expected;

        public TestCase(int[] nums, int k, int[] expected) {
            this.nums = nums;
            this.k = k;
            this.expected = expected;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1
            new TestCase(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                // Example 2
                new TestCase(new int[]{1}, 1, new int[]{1}),
                // Empty Array
                new TestCase(new int[]{}, 0, new int[]{}),
                new TestCase(new int[]{1, 1, 2, 3, 3, 3, 4, 4, 4, 4}, 3, new int[]{1, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void topKFrequent(TestCase tc) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] actual = solution.topKFrequent(tc.nums, tc.k);
        sort(actual);
        assertArrayEquals(tc.expected, actual);
    }
}