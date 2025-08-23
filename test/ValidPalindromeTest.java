import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    static class TestCase {
        String s;
        boolean expected;

        TestCase(String s, boolean expected) {
            this.s = s;
            this.expected = expected;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("race a car", false),
                new TestCase("Racecar", true),
                new TestCase("abc", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testValidPalindrome(TestCase tc) {
        ValidPalindrome solution = new ValidPalindrome();
        assertEquals(tc.expected, solution.isPalindrome(tc.s));
    }
}
