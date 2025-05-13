import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {
    static class TestCase {
        String[] strs;
        List<List<String>> expected;


        public TestCase(String[] strs, List<List<String>> expected) {
            this.strs = strs;
            this.expected = expected;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1
            new TestCase(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, List.of(
                    List.of("eat", "tea", "ate"),
                    List.of("tan", "nat"),
                    List.of("bat")
            )),
                // Example 2
                new TestCase(new String[]{""}, List.of(List.of(""))),
                // Example 3
                new TestCase(new String[]{"a"}, List.of(List.of("a")))
        );
    }

    private boolean equalGroupAnagrams(List<List<String>> a, List<List<String>> b) {
        List<List<String>> sortedA = a.stream()
                .map(inner -> {
                    List<String> copy = new ArrayList<>(inner);
                    Collections.sort(copy);
                    return copy;
                })
                .sorted(Comparator.comparing(Object::toString))
                .toList();

        List<List<String>> sortedB = b.stream()
                .map(inner -> {
                    List<String> copy = new ArrayList<>(inner);
                    Collections.sort(copy);
                    return copy;
                })
                .sorted(Comparator.comparing(Object::toString))
                .toList();

        return sortedA.equals(sortedB);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testGroupAnagrams(TestCase tc) {
        GroupAnagrams solution = new GroupAnagrams();
        assertTrue(equalGroupAnagrams(tc.expected, solution.groupAnagrams(tc.strs)));
    }
}