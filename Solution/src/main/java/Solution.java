
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Solution} class contains various utility methods to solve
 * different types of problems, such as reversing words in a character array,
 * finding indices that sum to a target, and generating the FizzBuzz sequence.
 */
class Solution {

    /**
     * The main method to test the functionalities of the {@code Solution}
     * class.
     *
     * @param args command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println("Run reverseWords()");
        String str = "the sky is blue";
        char[] str2 = str.toCharArray();
        solution.reverseWords(str2);
        System.out.println(str2);

        System.out.println("Run getIndices()");
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.getIndices(nums, target);
        System.out.println(Arrays.toString(result));

        System.out.println("Run twoSum()");
        result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
        
        System.out.println("Run fizzBuzz()");
        solution.fizzBuzz();

    }

    /**
     * Reverses the words in the given character array. Words are sequences of
     * characters separated by spaces. The entire array is modified in place.
     *
     * @param str the character array containing the words to reverse
     */
    public void reverseWords(char[] str) {
        int len = str.length;
        if (len == 0) {
            return;
        }
        
        this.reverse(str, 0, len - 1);

        int start = 0;
        int end = 0;
        for (; end < len; end++) {
            while (end < len && str[end] != ' ') {
                end++;
            }
            if (end < len) {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
        reverse(str, start, end - 2);
    }
    
    /**
     * Reverses the words in the given character array. Words are sequences of
     * characters separated by spaces. The entire array is modified in place.
     * Same as reverseWords but using a different algorithm.
     *
     * @param str the character array containing the words to reverse
     */
    public void reverseWordsCustom(char[] str) {
        int len = str.length;
        if (len == 0) {
            return;
        }
        
        // Reverse the entire string
        this.reverse(str, 0, len - 1);

        // Reverse individual words
        for (int start = 0; start < len; start++) {
            if (str[start] == ' ') {
                for (int end = start + 1; end < len; end++) {
                    if (str[end] == ' ') {
                        this.reverse(str, start, end);
                        start = end - 1;
                        break;
                    }
                }
            }
        }

        // Reverse first word
        for (int end = 0; end < len; end++) {
            if (str[end] == ' ') {
                this.reverse(str, 0, end - 1);
                break;
            }
        }

        // Reverse last word
        for (int start = len - 1; start >= 0; start--) {
            if (str[start] == ' ') {
                this.reverse(str, start + 1, len - 1);
                break;
            }
        }
        
        // ToDo switch leading and trailing spaces, update jdoc
    }

    /**
     * Reverses the characters in the specified range of a character array.
     *
     * @param str the character array to reverse
     * @param start the starting index of the range to reverse (inclusive)
     * @param end the ending index of the range to reverse (inclusive)
     */
    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start++] = str[end];
            str[end--] = tmp;
        }
    }

    /**
     * Finds two indices in the array such that their values sum to the target.
     * This method uses a brute-force approach with a nested loop to check all
     * pairs.
     *
     * @param nums the array of integers
     * @param target the target sum
     * @return an array containing the two indices, or an empty array if no
     * solution is found
     */
    public int[] getIndices(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * Finds two indices in the array such that their values sum to the target.
     * This method uses a HashMap to store previously visited elements and their
     * indices for efficient lookup.
     *
     * @param nums the array of integers
     * @param target the target sum
     * @return an array containing the two indices, or {@code null} if no
     * solution is found
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        if (len <= 0) {
            return null;
        }
        for (int i = 0; i < len; i++) {
            int remainder = target - nums[i];
            if (map.containsKey(remainder)) {
                return new int[]{map.get(remainder), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    /**
     * Prints the FizzBuzz sequence for numbers from 1 to 100. For multiples of
     * 3, prints "Fizz". For multiples of 5, prints "Buzz". For multiples of
     * both 3 and 5, prints "FizzBuzz". Otherwise, prints the number itself.
     */
    public void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            System.out.println((getFizz(i) && getBuzz(i)) ? "FizzBuzz" : (getFizz(i) ? "Fizz" : (getBuzz(i) ? "Buzz" : i)));
        }
    }

    /**
     * Checks if a number is divisible by 3 (Fizz condition).
     *
     * @param num the number to check
     * @return {@code true} if the number is divisible by 3, {@code false}
     * otherwise
     */
    private Boolean getFizz(int num) {
        return (num % 3 == 0);
    }

    /**
     * Checks if a number is divisible by 5 (Buzz condition).
     *
     * @param num the number to check
     * @return {@code true} if the number is divisible by 5, {@code false}
     * otherwise
     */
    private Boolean getBuzz(int num) {
        return (num % 5 == 0);
    }
}

