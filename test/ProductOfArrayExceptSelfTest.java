import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {
    static class TestCase {
        int[] nums;
        int[] expected;


        public TestCase(int[] nums, int[] expected) {
            this.nums = nums;
            this.expected = expected;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1
                new TestCase(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                // Example 2
                new TestCase(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}),
                // Empty Array
                new TestCase(new int[]{}, new int[]{}),
                // Single Element
                new TestCase(new int[]{1}, new int[]{1})
        );
    }


    @ParameterizedTest
    @MethodSource("testCases")
    public void productExceptSelf(TestCase tc) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        assertArrayEquals(tc.expected, solution.productExceptSelf(tc.nums));
    }
}