package info.ds.recursion;

public class CheckSortedArray {
    static boolean result = false;
    public static boolean checkIncSortedArray(int input[],int index){
        if(index==input.length-1){
            return true;
        }
        if(input[index]<=input[index+1]){
            return checkIncSortedArray(input,index+1);
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5,7,1};
        System.out.println(checkIncSortedArray(arr,0));
    }
}
