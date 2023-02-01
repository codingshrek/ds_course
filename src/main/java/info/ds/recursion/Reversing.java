package info.ds.recursion;

public class Reversing {

    public static void stringInReverse(String input){
        if(input.length()==0){
            return;
        }
        System.out.print(input.substring(input.length()-1,input.length()));
        String temp = input.substring(0,input.length()-1);
        stringInReverse(temp);
    }


    public static void reverseArray(int arr[],int index){
        if(index<0){
            return;
        }
        System.out.println(arr[index]);
        reverseArray(arr,index-1);
    }


    // there is one more logic in reversing/palindrome for given array [1,2,3,4,5] . First element will be checked with length-i-1 (5-0-1) =4th position.
    // Second element will be checked with length-i-1 (5-1-1) =3rd position.

    /**
     * A string is palindrome when on reversing produces same String
     */
    public static boolean checkPalindrome(String input,int l,int r){
        if(l==r){
            return true;
        }
        if(input.charAt(l)!=input.charAt(r)){
            return false;
        }
       checkPalindrome(input,l+1,r-1);
        return true;
    }

    /**
     * Palindrome using single variable. Same logic as above , just replacing r with input.length()-1
     */
    public static boolean checkPalindrome(String input,int l){
        if(l>input.length()/2){
            return true;
        }
        if(input.charAt(l)!=input.charAt(input.length()-1)){
            return false;
        }
        checkPalindrome(input,l+1,input.length()-1);
        return true;
    }

    public static void main(String[] args) {
        /*int arr[] = {1,2,3,4,5};
        reverseArray(arr, arr.length-1);*/

        String palindrome = "aba";
        /*System.out.println(checkPalindrome(palindrome,0,palindrome.length()-1));*/
        System.out.println(checkPalindrome(palindrome,0));

    }
}
