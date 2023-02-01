package info.ds.recursion;

public class Recursion {


    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void fibonacci(int a , int b , int n){
        if(n==0){
            return ;
        }
        int c=a+b;
        System.out.println(c);
        fibonacci(b,c,n-1);

    }


    public static int printSumOfNaturalNumberDescend(int n) {
        if (n == 0) {
            return 0;
        }
        return n + printSumOfNaturalNumberDescend(n - 1);
    }


    /*
     To implement Tower Of Hanoi
     */



    public static void printFirstLastIndex(String input,char s,Integer f,Integer l,int index){
        if(index==input.length()){
            System.out.println("First "+(f+1)+" Last "+(l+1));
            return;
        }
        Character t = input.charAt(index);
        if(t==s){
            if(f==null){
                f=index;
            }
            else{
                l=index;
            }
        }
        printFirstLastIndex( input,s,f,l, index+1);
    }



}
