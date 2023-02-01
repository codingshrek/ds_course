package info.ds.recursion;

public class Summation {

    /**
     * Uses parameters
     */
    public static int printSumOfNaturalNumberAscend(int i,int n,int sum) {
        if(i==n){
            sum+=i;
            return sum;
        }
        sum+=i;
        return printSumOfNaturalNumberAscend(i+1,n,sum);
    }

    /**
     * Does not use parameters (It is functional).
     * The idea is if n=3 ; f(3) = 3 + f(2) => f(2) = 2+f(1) => f(1) = 1+f(0) and we know f(0) = 0
     */
    public static int sumOfNaturalNumberAscend(int n) {
       if(n==0){
           return 0;
       }
       return n+sumOfNaturalNumberAscend(n-1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfNaturalNumberAscend(4));
    }

}
