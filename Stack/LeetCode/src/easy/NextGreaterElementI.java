package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElementI {

    public static void main(String args[]){
        int nums1[]={4,1,2};
        int nums2[]={1,3,4,2};
        int answer[]=nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> helper=new Stack<>();
        Map<Integer,Integer> nextGreater=new HashMap<>();

        for(int i=nums2.length-1;i>=0;i--){
            if(helper.isEmpty()){
                helper.push(nums2[i]);
                nextGreater.put(nums2[i],-1);
            }

            if(helper.peek()>nums2[i]){
                helper.push(nums2[i]);
                nextGreater.put(nums2[i],helper.peek());
            }

            while(!helper.isEmpty() && helper.peek()<=nums2[i]){
                helper.pop();
            }

            if(!helper.isEmpty()){
                nextGreater.put(nums2[i],helper.peek());
            }else{
                nextGreater.put(nums2[i],-1);
            }

            helper.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=nextGreater.get(nums1[i]);
        }
        return nums1;
    }
}
