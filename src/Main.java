import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] test = {6,6,6,7,7};
        System.out.println(new Solution().majorityElement(test));
    }
}

// this works with 24 second run time beatinng 9% in speed, 78% in space
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap();
        int majorityElementFrequency = 1;
        int majorityElement = -1;
        if (nums.length == 1){
           return nums[0];
        }

        for (int num : nums) {
            if (!m.containsKey(num)) {
                m.put(num, 1);
            } else if (m.containsKey(num)) {
                m.put(num, m.get(num) + 1);
                if (m.get(num)>majorityElementFrequency){
                    majorityElementFrequency = m.get(num);
                    majorityElement = num;
                }
            }
        }
        return majorityElement;
    }
}

// option B assuming not the most frequent occuring element among many, but the majority of only 2 elements. Dropped 1 ms soing this. still not the best.
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap();
        if (nums.length == 1){
            return nums[0];
        }

        for (int num : nums) {
            if (!m.containsKey(num)) {
                m.put(num, 1);
            } else if (m.containsKey(num)) {
                m.put(num, m.get(num) + 1);
                if (m.get(num)> (nums.length/2)){
                    return num;
                }
            }
        }
        return -1;
    }
}

//top solution
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, maxElement = 0;
        for(int num: nums) {
            if(count == 0) {
                maxElement = num;
            }
            if(num == maxElement) {
                count++;
            } else {
                count--;
            }
        }

        return maxElement;
    }
}


// loop thrrough an array, each nenw item, add to map if it doesn't exist or incrrease value if it does. consider
// trying out that addofdefault meethod maybe? a counter is insufficient. we can either have a counter plus a variable
// to store both the value and frequency or could create a second single item map that has valuee and frequency, trouble
// is you can get a value at a key, not a key at a value. i think two variables is the better choice. start with
// counter = 0 and majorityElement empty.