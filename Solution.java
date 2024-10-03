import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		/*String str = "the sky is blue";
		char[] str2 = str.toCharArray();
		solution.reverseWords(str2);
		System.out.println(str2);*/
		
		/*int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		int[] result = solution.getIndices(nums, target);
		System.out.println(Arrays.toString(result));
		
		result = solution.twoSum(nums, target);
		System.out.println(Arrays.toString(result));*/
		
		solution.fizzBuzz();
		
	}
	
	public void reverseWords(char[] str) {
		int len = str.length;
		if (len == 0) return;
		
		/*
		this.reverse(str, 0, len-1);
		
		int start = 0;
		int end = 0;
		for (; end < len; end++) {
			while (end < len && str[end] != ' ') end++;
			if (end < len) {
				reverse(str, start, end-1);
				start = end + 1;
			}
		}
		reverse(str, start, end-2);*/
		
		this.reverse(str, 0, len-1);
		for (int start = 0; start < len; start++) {
			if (str[start] == ' ') {
				for (int end = start+1; end < len; end++) {
					if (str[end] == ' ') {
						this.reverse(str, start, end);
						start = end-1;
						break;
					}
				}
			}
		}
		
		// Reverse first word
		for (int end = 0; end < len; end++) {
			if (str[end] == ' ') {
				this.reverse(str, 0, end-1);
				break;
			}
		}
		
		// Reverse last word
		for (int start = len-1; start >= 0; start--) {
			if (str[start] == ' ') {
				this.reverse(str, start+1, len-1);
				break;
			}
		}
	}
	
	private void reverse(char[] str, int start, int end) {
		while (start < end) {
			char tmp = str[start];
			str[start++] = str[end];
			str[end--] = tmp;
		}
		return;
	}
	
	public int[] getIndices(int[] nums, int target) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{};
	}
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = nums.length;
		if (len <= 0) return null;
		for (int i = 0; i < len; i++) {
			int remainder = target - nums[i];
			if (map.containsKey(remainder))
				return new int[]{map.get(remainder), i};
			else
				map.put(nums[i], i);
		}
		return null;
	}
	
	public void fizzBuzz() {
		for(int i = 1; i <= 100; i++) {
			System.out.println((getFizz(i) && getBuzz(i)) ? "FizzBuzz" : (getFizz(i) ? "Fizz" : (getBuzz(i) ? "Buzz" : i)));
		}
	}
	
	private Boolean getFizz(int num) {
		return (num%3 == 0);
	}
	
	private Boolean getBuzz(int num) {
		return (num%5 == 0);
	}
}

// blue is the sky
