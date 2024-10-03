import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    /**
     * Test the reverseWords function.
     */
    @Test
    void testReverseWords1() {
        // Case 1: Regular sentence with spaces
        char[] input = "the sky is blue".toCharArray();
        char[] expected = "blue is sky the".toCharArray();
        solution.reverseWords(input);
        assertArrayEquals(expected, input);
    }
    
    /**
     * Test the reverseWords function.
     */
    @Test
    void testReverseWords2() {
        // Case 2: Sentence with extra spaces
        char[] input = "  hello world  ".toCharArray();
        char[] expected = "world hello  ".toCharArray(); // Two spaces should remain at the end
        solution.reverseWords(input);
        assertArrayEquals(expected, input);
    }

    /**
     * Test the getIndices function (brute-force method).
     */
    @Test
    void testGetIndices() {
        // Case 1: Regular input
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.getIndices(nums, target);
        int[] expected = {0, 1};
        assertArrayEquals(expected, result);

        // Case 2: No solution
        nums = new int[]{1, 2, 3};
        target = 6;
        result = solution.getIndices(nums, target);
        expected = new int[]{};
        assertArrayEquals(expected, result);
    }

    /**
     * Test the twoSum function (optimized method with HashMap).
     */
    @Test
    void testTwoSum() {
        // Case 1: Regular input
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        int[] expected = {0, 1};
        assertArrayEquals(expected, result);

        // Case 2: No solution
        nums = new int[]{1, 2, 3};
        target = 6;
        result = solution.twoSum(nums, target);
        assertNull(result);
    }
}
