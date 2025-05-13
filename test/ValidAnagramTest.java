import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {
    static class TestCase {
        String s;
        String t;
        boolean expected;

        public TestCase(String s, String t, boolean expected) {
            this.s = s;
            this.t = t;
            this.expected = expected;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1
                new TestCase("anagram", "nagaram", true),
                // Example 2
                new TestCase("rat", "car", false),
                // Empty strings
                new TestCase("", "", true),
                // Same characters, but different frequencies
                new TestCase("aab", "ab", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testIsAnagram(TestCase tc) {
        ValidAnagram solution = new ValidAnagram();
        assertEquals(tc.expected, solution.isAnagram(tc.s, tc.t));
    }
}