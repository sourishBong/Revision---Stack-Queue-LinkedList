package medium;

import java.util.Arrays;
import java.util.Stack;

public class SumofSubarrayMinimums {

    public static void main(String args[]){
        int arr[]={3,1,2,4};
        int ans=sumSubarrayMins(arr);
        System.out.println(ans);
    }

    private static int sumSubarrayMins(int[] arr) {
        Stack<Integer> helper=new Stack<>();
        int right[]=new int[arr.length];
        int left[]=new int[arr.length];

        Arrays.fill(right,arr.length);
        Arrays.fill(left,-1);

        for(int i=0;i<arr.length;i++){
            int element=arr[i];
            if(!helper.isEmpty() && arr[helper.peek()]>=element){
                helper.pop();
            }

            if(!helper.isEmpty()){
                left[i]=helper.peek();
            }
            helper.push(i);
        }

        helper.clear();

        for(int i=arr.length-1;i>=0;i--){
            int element=arr[i];
            if(!helper.isEmpty() && arr[helper.peek()]>element){
                helper.pop();
            }
            if(!helper.isEmpty()){
                right[i]=helper.peek();
            }
            helper.push(i);
        }

        int mod=(int) 1e9 + 7;
        long answer=0;

        for(int i=0;i<arr.length;i++){
            answer+=(long) (i-left[i])*(right[i]-i)%mod * arr[i] % mod;
            answer%=mod;
        }
            return (int) answer;
    }
}
