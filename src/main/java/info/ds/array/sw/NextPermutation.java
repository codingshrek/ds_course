package info.ds.array.sw;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int bp =-1;

        for(int i=n-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                bp = i-1;
                break;
            }
        }
        System.out.println("bp : "+bp);
        if(bp == -1){
            reverse(nums,0,n-1);
            return;
        }

        for(int  i =n-1;i>bp;i--){
            if(nums[i]>nums[bp]){
                swap(nums,i,bp);
                break;
            }
        }
        reverse(nums,bp+1,n-1);
    }


    private void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums,int to,int with){
        int temp = nums[to];
        nums[to]=nums[with];
        nums[with]=temp;
    }

}
