import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    @Test
    public void testExample1() {
        TwoSum solution = new TwoSum();
        int[] expected = new int[]{0, 1};
        int[] actual = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        TwoSum solution = new TwoSum();
        int[] expected = new int[]{1, 2};
        int[] actual = solution.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        TwoSum solution = new TwoSum();
        int[] expected = new int[]{0, 1};
        int[] actual = solution.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(expected, actual);
    }
}