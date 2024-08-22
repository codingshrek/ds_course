package info.ds.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums, int len) {


        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[len];

        for(int i = len-1;i>=0;i--){
            int n = nums[i];
            if(stack.empty()) {
                stack.push(n);
                ans[i]=-1;
                continue;
            }
            while( !stack.empty() && n>=stack.peek()){
                stack.pop();
            }
            if(!stack.empty()) ans[i] = stack.peek();
            else ans[i] = -1;
            stack.push(n);
        }
        return ans;
    }
}
